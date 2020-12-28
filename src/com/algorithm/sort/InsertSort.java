package com.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[]  arr = {109,32,1,101,21,69};
        int count = 0;

        for (int i = 1;i < arr.length; i++){
            int temp = arr[i];
            int index = i -1;
            while (index >= 0 && temp < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = temp;
            System.out.println("第"+ (i) + "轮以后的数组" + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
   /*
        //第一次,比较第2个和前1个元素
        for(int j = 0; j >= 0; j-- ){
            if (arr[1] < arr[j]){
                temp = arr[1];
                arr[1] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

        //第二次,比较第3个和2两个元素

        for (int j = 1; j >= 0; j--){
            if (arr[2] < arr[j]){
                temp = arr[1];
                arr[1] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

        //第二次,比较第4个和前3个元素
        for (int j = 2; j >= 0; j--){
            if (arr[3] < arr[j]){
                temp = arr[1];
                arr[1] = arr[j];
                arr[j] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }*/


    }
}
