package com.algorithm.search;

import java.util.Arrays;

/**
 * 斐波那契(黄金分割查找)法(前提:数组是有序的)
 */
public class FibonaciSearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 9, 56, 478, 588};
        int index = fibSearch(arr, 9);
        System.out.println("index = " + index);
    }

    //获取到斐波那契数列
    public static int[] fibArray() {
        int[] fibArray = new int[20];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //斐波那契数列的k值
        int mid = 0;  //查找的中间值
        int[] fib = fibArray(); //斐波那契数列
        //找出k的值
        while (high > fib[k] - 1) {
            k++;
        }
        // 如果数组的长度不够,补充数组的长度
        int[] temp = Arrays.copyOf(arr, fib[k]);
        //因为是0补充的,所以让后面的值等于最大值
        for (int i = high; i < temp.length; i++) {
            temp[high + 1] = arr[high];
        }
        //然后处理查找下表
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key > temp[mid]) {//查找的值大于中间值,表示值在右边
                low = mid + 1;
                k -= 2;
            } else if (key < temp[mid]) { //查找的值小于中间值,表示查找的值在中间值的左边,向左查找
                high = mid - 1;
                k -= 1;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }


}
