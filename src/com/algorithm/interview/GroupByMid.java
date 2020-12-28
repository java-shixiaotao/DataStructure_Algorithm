package com.algorithm.interview;
import java.util.Arrays;
/**
 /**
 *  建立一个MOVE,不进行排序,将数组中小于平均值的元素放到数组的左边,大于平均值的元素放到数组的右边.(一道算法题)
 */


public class GroupByMid {
    public static void main(String[] args) {
        float[] array = {1.3F, 6.2F, 3, 9.1F, 4.8F, 7.4F, 5.6F, 9.2F, 2.3F};
        MOVE move = new MOVE(array,array.length);
        move.average();
        System.out.println(11111);
    }
}

class MOVE{
    private float[] array;
    private int n;

    public MOVE(float[] array,int n){
        this.array = array;
        this.n = n;
    }


    public void average(){
        float num = 0;
        for (int i = 0; i <array.length; i++ ){
            num += array[i];
        }
        System.out.println("平均数numn = " + num / array.length);
        float average = num / array.length;
        int privo = array.length / 2;
        int j = 0;
        float[] array2 = new float[array.length];
        for (int i = 0; i <array.length; i++ ){
            if (average >= array[i]){
                array2[j] = array[i];
                j ++;
            }else {
                array2[privo] = array[i];
                privo ++;
            }
        }
        System.out.println("打印出数组 = " +  Arrays.toString(array2));
    }
}