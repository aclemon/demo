package com.example.test;

import lombok.Data;

@Data
public class GenericMethodTest<T> {
    private T t;

    // 泛型方法 printArray
    public <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();

        String a = "我爱你他";
    }

    public static void main(String[] args) {
//        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        GenericMethodTest<String> stringGenericMethodTest = new GenericMethodTest<>();
        System.out.println("整型数组元素为:");
        stringGenericMethodTest.printArray(intArray); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");
        stringGenericMethodTest.printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");
        stringGenericMethodTest.printArray(charArray); // 传递一个字符型数组
    }
}
