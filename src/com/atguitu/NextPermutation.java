package com.atguitu;

import java.util.Arrays;

/**
 *
 *  实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *  必须 原地 修改，只允许使用额外常数空间。
 *
 *
 * 求下一个数:  题目解析:一个数组,根据每个元素上的值,得出一个数,求出这个数的按照升序的求出下一个值.例如{1,2,3}下一个值就是{1,3,2}
 *             思路解析:1.从数组的后面开始找出后一个数(n)比前一个数(n-1)大的时候,说明可以交换,变成更大的值.
 *                      2.然后从前一个数(n-1)开始,找出后面比当前值大的唯一值,放如n-1的索引的位置
 *                      3.然后再将从n开始后面的所有数排序
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {9,8,7,5,6,4,1,3,1};
        NextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void nextPermutation(int[] nums){
        int length = nums.length;
       //倒序查找
        for (int i = length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]){
                //找出除了当前数后面的所有最小值
                int k = nums[i]; //标记好值
                int l = i; //标记好索引
                for (int j = i;j < length; j++){
                    if (nums[j] < k && nums[j] > nums[i-1]){
                        k = nums[j];
                        l = j;
                    }
                }
                //然后交换值
                int temp = nums[i-1];
                nums[i-1] = nums[l];
                nums[l] = temp;
                //然后将后面的数(从i开始的后面的数)正序排序
                for (int m = i;m < length; m++){
                    for (int n = i +1; n < length;n++){
                        if(nums[m] > nums[n]){
                            temp = nums[m];
                            nums[m] = nums[n];
                            nums[n] = temp;
                        }
                    }
                }
            return;
            }
        }
        //如果到了这一步,说明是最大的数组序列了
        //希尔排序
        for(int gap = nums.length/2; gap > 0; gap /= nums.length/2){
            //里面使用插入排序法,来使分组排序
            for(int i = gap; i < nums.length; i++){
                int j = i;
                int temp1 = nums[i];
                while ( j - gap >= 0 && temp1 < nums[j - gap]){
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = temp1;
            }
        }
    }

}
