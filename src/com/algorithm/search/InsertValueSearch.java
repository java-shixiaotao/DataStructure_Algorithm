package com.algorithm.search;

import java.util.Arrays;

/**
 * 插值查找(前提:有序的数组)
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println("index = " + index);

    }



    public  static int insertValueSearch(int[] arr, int left, int right,int value){
        System.out.println("hello");
        if (left > right || value < arr[left] || value > arr[right]){
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);

        if (value > arr[mid]){ //如果值大于中间值,向右递归
            return insertValueSearch(arr,mid+1,right,value);
        } else if (value < arr[mid]){ //如果值小于中间值,向左递归
            return insertValueSearch(arr,left,mid -1,value);
        } else {
            return mid;
        }
    }

}
