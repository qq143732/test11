package com.heima.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * NumberConverter工具类测试
 */
public class NumberConverterTest {

    @Test
    public void testDecimalToBinary() {
        System.out.println("=== 测试十进制转二进制 ===");
        assertEquals("1010", NumberConverter.decimalToBinary(10));
        assertEquals("11111111", NumberConverter.decimalToBinary(255));
        assertEquals("0", NumberConverter.decimalToBinary(0));
        System.out.println("十进制10 -> 二进制: " + NumberConverter.decimalToBinary(10));
        System.out.println("十进制255 -> 二进制: " + NumberConverter.decimalToBinary(255));
    }

    @Test
    public void testDecimalToOctal() {
        System.out.println("\n=== 测试十进制转八进制 ===");
        assertEquals("12", NumberConverter.decimalToOctal(10));
        assertEquals("377", NumberConverter.decimalToOctal(255));
        System.out.println("十进制10 -> 八进制: " + NumberConverter.decimalToOctal(10));
        System.out.println("十进制255 -> 八进制: " + NumberConverter.decimalToOctal(255));
    }

    @Test
    public void testDecimalToHex() {
        System.out.println("\n=== 测试十进制转十六进制 ===");
        assertEquals("a", NumberConverter.decimalToHex(10));
        assertEquals("ff", NumberConverter.decimalToHex(255));
        assertEquals("100", NumberConverter.decimalToHex(256));
        System.out.println("十进制10 -> 十六进制: " + NumberConverter.decimalToHex(10));
        System.out.println("十进制255 -> 十六进制: " + NumberConverter.decimalToHex(255));
    }

    @Test
    public void testBinaryToDecimal() {
        System.out.println("\n=== 测试二进制转十进制 ===");
        assertEquals(10, NumberConverter.binaryToDecimal("1010"));
        assertEquals(255, NumberConverter.binaryToDecimal("11111111"));
        assertEquals(0, NumberConverter.binaryToDecimal("0"));
        System.out.println("二进制1010 -> 十进制: " + NumberConverter.binaryToDecimal("1010"));
        System.out.println("二进制11111111 -> 十进制: " + NumberConverter.binaryToDecimal("11111111"));
    }

    @Test
    public void testOctalToDecimal() {
        System.out.println("\n=== 测试八进制转十进制 ===");
        assertEquals(10, NumberConverter.octalToDecimal("12"));
        assertEquals(255, NumberConverter.octalToDecimal("377"));
        System.out.println("八进制12 -> 十进制: " + NumberConverter.octalToDecimal("12"));
        System.out.println("八进制377 -> 十进制: " + NumberConverter.octalToDecimal("377"));
    }

    @Test
    public void testHexToDecimal() {
        System.out.println("\n=== 测试十六进制转十进制 ===");
        assertEquals(10, NumberConverter.hexToDecimal("a"));
        assertEquals(255, NumberConverter.hexToDecimal("ff"));
        assertEquals(256, NumberConverter.hexToDecimal("100"));
        System.out.println("十六进制a -> 十进制: " + NumberConverter.hexToDecimal("a"));
        System.out.println("十六进制ff -> 十进制: " + NumberConverter.hexToDecimal("ff"));
    }

    @Test
    public void testDecimalToRadix() {
        System.out.println("\n=== 测试十进制转任意进制 ===");
        assertEquals("1010", NumberConverter.decimalToRadix(10, 2));
        assertEquals("a", NumberConverter.decimalToRadix(10, 16));
        assertEquals("10", NumberConverter.decimalToRadix(36, 36));
        System.out.println("十进制10 -> 2进制: " + NumberConverter.decimalToRadix(10, 2));
        System.out.println("十进制10 -> 16进制: " + NumberConverter.decimalToRadix(10, 16));
        System.out.println("十进制36 -> 36进制: " + NumberConverter.decimalToRadix(36, 36));
    }

    @Test
    public void testRadixToDecimal() {
        System.out.println("\n=== 测试任意进制转十进制 ===");
        assertEquals(10, NumberConverter.radixToDecimal("1010", 2));
        assertEquals(10, NumberConverter.radixToDecimal("a", 16));
        assertEquals(36, NumberConverter.radixToDecimal("10", 36));
        System.out.println("2进制1010 -> 十进制: " + NumberConverter.radixToDecimal("1010", 2));
        System.out.println("16进制a -> 十进制: " + NumberConverter.radixToDecimal("a", 16));
    }

    @Test
    public void testConvertRadix() {
        System.out.println("\n=== 测试任意进制互转 ===");
        // 二进制转十六进制
        assertEquals("ff", NumberConverter.convertRadix("11111111", 2, 16));
        // 八进制转二进制
        assertEquals("1010", NumberConverter.convertRadix("12", 8, 2));
        // 十六进制转八进制
        assertEquals("377", NumberConverter.convertRadix("ff", 16, 8));
        System.out.println("二进制11111111 -> 十六进制: " + NumberConverter.convertRadix("11111111", 2, 16));
        System.out.println("八进制12 -> 二进制: " + NumberConverter.convertRadix("12", 8, 2));
        System.out.println("十六进制ff -> 八进制: " + NumberConverter.convertRadix("ff", 16, 8));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRadix() {
        System.out.println("\n=== 测试非法进制（应该抛出异常） ===");
        NumberConverter.decimalToRadix(10, 1); // 进制小于2，应该抛出异常
    }

    @Test
    public void testComprehensive() {
        System.out.println("\n=== 综合测试 ===");
        int testNumber = 100;
        System.out.println("测试数字: " + testNumber);
        System.out.println("转二进制: " + NumberConverter.decimalToBinary(testNumber));
        System.out.println("转八进制: " + NumberConverter.decimalToOctal(testNumber));
        System.out.println("转十六进制: " + NumberConverter.decimalToHex(testNumber));
        
        String binary = NumberConverter.decimalToBinary(testNumber);
        System.out.println("\n二进制 " + binary + " 转回十进制: " + NumberConverter.binaryToDecimal(binary));
        
        String hex = NumberConverter.decimalToHex(testNumber);
        System.out.println("十六进制 " + hex + " 转回十进制: " + NumberConverter.hexToDecimal(hex));
    }
}
