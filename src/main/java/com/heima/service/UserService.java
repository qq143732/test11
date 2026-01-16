package com.heima.service;

import com.heima.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 用户服务类
 * 
 * @author heima
 * @date 2026/1/16
 */
public class UserService {

    /**
     * 模拟用户数据存储
     */
    private List<User> userList = new ArrayList<>();

    /**
     * 用户ID生成器
     */
    private Long idGenerator = 1L;

    /**
     * 创建用户
     * 
     * @param user 用户对象
     * @return 创建成功的用户
     */
    public User createUser(User user) {
        user.setId(idGenerator++);
        user.setStatus(1); // 默认状态为正常
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userList.add(user);
        System.out.println("用户创建成功：" + user);
        return user;
    }

    /**
     * 根据ID查询用户
     * 
     * @param id 用户ID
     * @return 用户对象，如果不存在返回null
     */
    public User getUserById(Long id) {
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        return userOptional.orElse(null);
    }

    /**
     * 根据用户名查询用户
     * 
     * @param username 用户名
     * @return 用户对象，如果不存在返回null
     */
    public User getUserByUsername(String username) {
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
        return userOptional.orElse(null);
    }

    /**
     * 更新用户信息
     * 
     * @param user 用户对象
     * @return 更新后的用户对象，如果用户不存在返回null
     */
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            // 更新用户信息
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setNickname(user.getNickname());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setGender(user.getGender());
            existingUser.setAvatar(user.getAvatar());
            existingUser.setStatus(user.getStatus());
            existingUser.setUpdateTime(LocalDateTime.now());
            System.out.println("用户更新成功：" + existingUser);
            return existingUser;
        }
        System.out.println("用户不存在，ID：" + user.getId());
        return null;
    }

    /**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 删除成功返回true，失败返回false
     */
    public boolean deleteUser(Long id) {
        boolean removed = userList.removeIf(user -> user.getId().equals(id));
        if (removed) {
            System.out.println("用户删除成功，ID：" + id);
        } else {
            System.out.println("用户不存在，ID：" + id);
        }
        return removed;
    }

    /**
     * 获取所有用户
     * 
     * @return 用户列表
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    /**
     * 禁用用户
     * 
     * @param id 用户ID
     * @return 操作成功返回true，失败返回false
     */
    public boolean disableUser(Long id) {
        User user = getUserById(id);
        if (user != null) {
            user.setStatus(0);
            user.setUpdateTime(LocalDateTime.now());
            System.out.println("用户已禁用，ID：" + id);
            return true;
        }
        System.out.println("用户不存在，ID：" + id);
        return false;
    }

    /**
     * 启用用户
     * 
     * @param id 用户ID
     * @return 操作成功返回true，失败返回false
     */
    public boolean enableUser(Long id) {
        User user = getUserById(id);
        if (user != null) {
            user.setStatus(1);
            user.setUpdateTime(LocalDateTime.now());
            System.out.println("用户已启用，ID：" + id);
            return true;
        }
        System.out.println("用户不存在，ID：" + id);
        return false;
    }

    /**
     * 验证用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * @return 验证成功返回用户对象，失败返回null
     */
    public User login(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            if (user.getStatus() == 1) {
                System.out.println("登录成功：" + username);
                return user;
            } else {
                System.out.println("账号已被禁用：" + username);
                return null;
            }
        }
        System.out.println("用户名或密码错误");
        return null;
    }
}
