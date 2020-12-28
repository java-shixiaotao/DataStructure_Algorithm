package com.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr,int left, int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }


    /**
     *  合并的代码
     * @param arr  原始数组
     * @param left 左边的下标
     * @param mid 中间的下标值
     * @param right 右边的下标值
     * @param temp 临时数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
            //第一步开始,将分开的数组的值放到临时数组中,直到一边的值放完.
            while(i <= mid && j <= right){
                if(arr[i] <= arr[j]){
                    temp[t] = arr[i];
                    i++;
                    t++;
                } else {
                    temp[t] = arr[j];
                    j++;
                    t++;
                }
            }
            //第二步,将没放完的数组的值依次放到临时数组中
        if(i <= mid ){
            while(i <= mid){
                temp[t] = arr[i];
                t++;
                i++;
            }
        }
        if(j <= right){
            while( j <= right){
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
            //第三步,将临时数组的值放到原来的数组中
         t = 0;
         int tempLeft = left;
         while (tempLeft <= right){
             arr[tempLeft] = temp[t];
             t++;
             tempLeft++;
         }
        }

}
