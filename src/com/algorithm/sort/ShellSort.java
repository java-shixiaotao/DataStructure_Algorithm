package com.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[]  arr = {109,32,1,101,21,69,56,32,1,25,66};
        int temp = 0;

/*
        // 交换法(耗费性能,不适用)
        for (int gap = arr.length/2; gap > 0;  gap /= 2){
            for (int i = gap; i < arr.length; i++){
                for (int j = i-gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
*/


        //移位法
        for(int gap = arr.length/2; gap > 0; gap /= arr.length/2){
            //里面使用插入排序法,来使分组排序
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp1 = arr[i];
                while ( j - gap >= 0 && temp1 < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp1;
            }
            System.out.println(Arrays.toString(arr));
        }


    }




}
