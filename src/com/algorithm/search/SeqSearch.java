package com.algorithm.search;

/**
 * 线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[]  arr = {109,32,1,101,21,69};
        int i = seqSearch(arr, 32);
        if (i == -1){
            System.out.println("数组中没有找到需要查找的值");
        }else {
            System.out.println("值为:" + arr[i]);
        }
    }

    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
