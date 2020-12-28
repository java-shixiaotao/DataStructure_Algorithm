package com.datastructure.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
      //  int[] arr = {1,2,3,4,5,6};
        ArrBinaryTree.preOrder(0);
    }


}

class ArrBinaryTree{
    private static int[] arr = {1,2,3,4,5,6,7};
    public static void preOrder(int index){
        if (arr.length < 1){
            System.out.println("数组为null,无法转为二叉树");
            return;
        }
        if (2 * index + 1 < arr.length){
            preOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if (2 * index + 2 < arr.length){
            preOrder(2 * index + 2);
        }

    }

}

