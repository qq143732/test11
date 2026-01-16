package com.heima.util;

/**
 * 数字进制转换工具类
 */
public class NumberConverter {

    /**
     * 十进制转换为指定进制
     * @param decimal 十进制数字
     * @param radix 目标进制(2-36)
     * @return 转换后的字符串
     */
    public static String decimalToRadix(int decimal, int radix) {
        if (radix < 2 || radix > 36) {
            throw new IllegalArgumentException("进制必须在2-36之间");
        }
        return Integer.toString(decimal, radix);
    }

    /**
     * 指定进制转换为十进制
     * @param number 待转换的数字字符串
     * @param radix 当前进制(2-36)
     * @return 十进制数字
     */
    public static int radixToDecimal(String number, int radix) {
        if (radix < 2 || radix > 36) {
            throw new IllegalArgumentException("进制必须在2-36之间");
        }
        return Integer.parseInt(number, radix);
    }

    /**
     * 任意进制转换为任意进制
     * @param number 待转换的数字字符串
     * @param fromRadix 源进制(2-36)
     * @param toRadix 目标进制(2-36)
     * @return 转换后的字符串
     */
    public static String convertRadix(String number, int fromRadix, int toRadix) {
        // 先转换为十进制
        int decimal = radixToDecimal(number, fromRadix);
        // 再转换为目标进制
        return decimalToRadix(decimal, toRadix);
    }

    /**
     * 十进制转二进制
     * @param decimal 十进制数字
     * @return 二进制字符串
     */
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    /**
     * 十进制转八进制
     * @param decimal 十进制数字
     * @return 八进制字符串
     */
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    /**
     * 十进制转十六进制
     * @param decimal 十进制数字
     * @return 十六进制字符串
     */
    public static String decimalToHex(int decimal) {
        return Integer.toHexString(decimal);
    }

    /**
     * 二进制转十进制
     * @param binary 二进制字符串
     * @return 十进制数字
     */
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    /**
     * 八进制转十进制
     * @param octal 八进制字符串
     * @return 十进制数字
     */
    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    /**
     * 十六进制转十进制
     * @param hex 十六进制字符串
     * @return 十进制数字
     */
    public static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}
