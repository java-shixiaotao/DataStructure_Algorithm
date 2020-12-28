package com.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {564,23,89,0,56,78};
        RadixSort(arr);
    }

    public static void RadixSort(int[] arr){
        //找到数组中最大数
        int max = arr[0];
        for (int m = 1; m < arr.length; m++){
            if (arr[m] > max){
                max = arr[m];
            }
        }
        //算出最大数的位数
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length]; //新建二维数组当作桶
        int[] bucketElementCounts = new int[10]; //用于表示在第几个桶中存放了几个数
        //外层循环,根据数组中的位数排序
        for (int i = 0,t = 1; i <= maxLength; i++,t*=10){
            //内层循环
            for (int j = 0; j < arr.length; j++){
                int digitOfElement = arr[j] / t % 10;//算数对应的位数的值,从个位数依次向上
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] =  arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            //然后将桶中的数据取出来,放到新的数组中去
            for (int k = 0; k < bucketElementCounts.length; k++ ){ //循环十个桶
                if (bucketElementCounts[k] != 0){
                    for (int s = 0; s < bucketElementCounts[k]; s++){ //循环每个桶中的数据
                        arr[index] = bucket[k][s];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }
            System.out.println("第"+ (i+1) + "轮的循环结果为:"  + Arrays.toString(arr));
        }

    }

}
