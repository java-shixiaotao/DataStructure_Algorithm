package com.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int temp = 0;
        boolean flag = true;
        int beforeCount = 0;
        int afterCount = 0;
        //冒泡排序的时间复杂度O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                afterCount++;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
             //       flag = false;
                }
            }
            /*if (flag) {
                break;
            }*/
        }
        System.out.println("-----+++------" + Arrays.toString(array));
        System.out.println("比较了多少次"+ afterCount);
    }
}
