package com.atguitu;

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
public class NextPermutation2 {

    public static void main(String[] args) {
        int[] nums = {2,1,3,3,1};
        getNextPer(nums);
        for (int num :nums){
            System.out.print(num + "\t");
        }
    }

    private static void getNextPer(int[] nums){
        //获取数组的长度
        int le = nums.length;
        //1.从数组的后面开始找获取到后一个数比前一个数大说明可以交换
        int k = le - 2;
        while ( k >= 0 && nums[k] >= nums[k+1])
                k--;
        //2.然后从n-2开始，找出第一个比k的位置的值小的位置
        int i = k + 2;
        while ( i < le && nums[i] > nums[k])
            i++;
        //3.获取到的i-1表示该位置是比k的位置最近且比k大的数，然后将两个位置掉个
        int temp = nums[k];
        nums[k] = nums[i-1];
        nums[i-1] = temp;
        //4.将索引k后面的数组升序排列，通过指针法
        int start = k + 1;
        int end = le - 1;
        while (start > end)
        {
            int temp1 = nums[start];
            nums[start] = nums[end];
            nums[end] = temp1;
            start++;
            end--;
        }

    }
}
