package com.atguitu;


/**
 * 二分查找
 */
public class BinartSearch {

    /**
     * 使用循环的方式
     *
     * @param nums
     * @param key
     * @return
     */
    public static int binartSearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        if (key < nums[low] || key > nums[high]) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key > nums[mid]) { //如果中间值,大于要找的值,则找右边
                low = mid + 1;
            } else if (key < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 采用递归的方式解决二分查找(JAVA)
     * @param nums
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static int binartSearchDG(int[] nums, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (key > nums[mid]) {
            return binartSearchDG(nums, mid + 1, right, key);
        } else if (key < nums[mid]) {
            return binartSearchDG(nums, left, mid - 1, key);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 7;
        System.out.println(BinartSearch.binartSearch(arr, key));

        int left = 0;
        int right = arr.length - 1;
        System.out.println(BinartSearch.binartSearchDG(arr, left, right, key));
    }
}
