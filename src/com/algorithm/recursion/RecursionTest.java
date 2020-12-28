package com.algorithm.recursion;

/**
 * 递归算法
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(test2(4));
    }
    //打印问题
    public static void test(int n){
        if (n > 2){
            test(n-1);
        }
        System.out.println(n);
    }
    //阶乘问题
    public static int test2(int n){
        if (n == 1){
            return 1;
        }else {
            return n*test2(n -1);
        }
    }
}
