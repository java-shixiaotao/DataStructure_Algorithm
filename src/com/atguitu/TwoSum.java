package com.atguitu;

import java.util.HashMap;
import java.util.Map;

/**
 *   两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum.
 * 两种解法:1.双重循环暴力解法. 2.使用map解决
 */
public class TwoSum {

    public static void main(String[] args) throws Exception {
        int[] ints = {1,2,2,5,6,7};
        int target = 4;
        int[] twoSum = TwoSum.getTwoSum(ints, target);
        System.out.println( "" + twoSum[0] + twoSum[1]  );
    }


    public static int[] getTwoSum(int[] ints,int target) throws Exception {
        //使用map解决
        int n = ints.length;
        Map<Integer,Integer> map = new HashMap<>();
        //1.将数组中的值放入map中去
        for (int i = 0;i < n;i++){
            map.put(ints[i],i);
        }
        //2.再遍历数据,通过比较key与目标值与当前值的差来找出值得索引
        for (int i = 0;i < n;i++){
            //3.求出目标值与当前值得差值
            int thatNum = target - ints[i];
            if (map.containsKey(thatNum) && map.get(thatNum) != i/*这一步是不让差值不等于当前的值*/ ){
                return new int[]{i,map.get(thatNum)};
            }
        }
        throw new Exception("nun found");
    }
}
