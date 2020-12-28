package com.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {109,32,1,101,21,69,56,32,1,25,66};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int L,int R){
        if (L >= R)
            return;
        int left = L;
        int right = R;
        int piovt = arr[L];

        while(left < right){
            //从右边开始,如果有右边的值大于中间值,则ringt--
            while (left < right && arr[right] >= piovt){
                right--;
            }
            //跳出上面的循环说明,左边的标大于等于右边的下标,或者右边的值小于了中间值
            //当右边的值小于中间值的时候并且 右边的值小于中间的时候
            if (left < right){
                arr[left] = arr[right];
            }
            //然后遍历左边的值,如果左边的值小于等于中间值,则left++
            while(left < right && arr[left] <= piovt){
                left++;
            }
            //跳出循环说明,右边的标小于等于左边的膘,或者左边的值大于中间值
            //如果,左边的标小于右边的标,并且左边的值大于中间值,交换位置
            if(left < right){
                arr[right] = arr[left];
            }
            //如果左右下标相遇,则将中间值赋给相遇的中间位置
            if(left >= right){
                arr[left] = piovt;
            }
        }
        //递归调用自己,然后通过right和left将数组在下标的位置分开
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }


}
