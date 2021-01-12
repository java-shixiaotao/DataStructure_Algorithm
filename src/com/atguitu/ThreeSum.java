package com.atguitu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和: 1.先排序.2.选择一个核心数,一个左边得数,一个右边的数.核心数要小于等于0(?????)
 * 3.核心数从左边开始遍历,然后,左护法从左边开始,右护法从右边开始.三个数相加,如果小于0说明还是小,因为最大的数不能变了所以只能移动左护法,然后再判断; 直到左护法和右护法相撞
 * 如果大于0,说明总数大了,因为左护法最小了,所以只能移动右护法.然后再判断.直到右护法和左护法相撞.
 * 如果等于0,将结果集存到集合中去.然后左护法和右护法同时移动.然后再判断.直到右护法跑到左护法的左边.
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {

    public static void main(String[] args) {
       int[] nums = {-1,0,1,2,-1,-4};
       int[] nums1 = {-4,-1,-1,0,1,2};
        List<List<Integer>> lists = ThreeSum.threeSum(nums);
        System.out.println(lists);
    }

    //双指针法
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //1.先排序
        Arrays.sort(nums);
        //2.遍历数组,从左到右i作为核心数
        int length = nums.length;
        int left = 0; //左护法
        int right = 0; //右护法
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                }
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left],nums[i],nums[right]));
                    left++;
                    right--;
                    while (left > right && nums[left] == nums[left-1])left++;
                    while (left > right && nums[right] == nums[left+1])right--;
                }
                if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}


