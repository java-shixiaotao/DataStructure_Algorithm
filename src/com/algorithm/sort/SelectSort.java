package com.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {

        int[]  arr = {109,32,1,101,64,89};
        int temp = 0;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++){
            for (int j = i +1; j < arr.length;j++){
                count++;
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第"+ (i + 1) + "轮以后的数组" + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
}
