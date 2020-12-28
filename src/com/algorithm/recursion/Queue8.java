package com.algorithm.recursion;

import static sun.misc.Version.print;

/**
 * 用递归算法解决8皇后问题
 */
public class Queue8 {
    int max = 8; //定义最大放几个皇后
    int[] array = new int[max]; //定义一个数组放皇后
    static int count = 0;



    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    //打印皇后
    public void show() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    /**
     * 判断是否冲突,(是否在同一列和在同一斜线上
     * @param n 代表第几个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[n] == array[i]  判断是否在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断是否在同一斜线上
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 然后写8皇后的方法
     * @param n 代表从第几个皇后开始
     */
    public void check(int n) {
        if (n == max) {
            show();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            //然后判断是否冲突
            if (judge(n)) { //如果不冲突,进行下一皇后
                check(n + 1);
            }//如果冲突,将皇后放到下一列.
        }
    }


}
