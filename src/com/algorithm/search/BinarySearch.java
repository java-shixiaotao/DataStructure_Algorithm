package com.algorithm.search;

import java.util.ArrayList;

/**
 * 二分查找(前提:数组时有序的)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,3};
        int i = binarySearch(arr, 0, arr.length-1, 1);
       // System.out.println(i);
        ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 2);
        System.out.println("所有的值为:" + integers);

    }

    /**
     *  二分查找的一个值
     * @param arr 原数组
     * @param left 左下标
     * @param right 右下标
     * @param value 要查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right,int value){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;

        if (value > arr[mid]){ //如果值大于中间值,向右递归
           return binarySearch(arr,mid+1,right,value);
        } else if (value < arr[mid]){ //如果值小于中间值,向左递归
           return binarySearch(arr,left,mid -1,value);
        } else {
            return mid;
        }
    }


    /**
     *  二分查找找出所有的值
     * @param arr 原数组
     * @param left 左下标
     * @param right 右下标
     * @param value 要查找的值
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right,int value){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;

        if (value > arr[mid]){ //如果值大于中间值,向右递归
            return binarySearch2(arr,mid+1,right,value);
        } else if (value < arr[mid]){ //如果值小于中间值,向左递归
            return binarySearch2(arr,left,mid -1,value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();

            //二分查找向左递归查询
            int temp = mid - 1;
            while(true){
                if (temp < 0 || arr[temp] != value){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            //二分查找向右递归查询
            temp = mid + 1;
            while(true){
                if (temp > arr.length -1 || arr[temp] != value){
                    break;
                }
                list.add(temp);
                temp+=1;
            }

            return list;
        }
    }





}
