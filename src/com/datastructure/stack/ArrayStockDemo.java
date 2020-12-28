package com.datastructure.stack;

import java.util.Scanner;

/**
 * 用代码写出栈存储数据结构
 */
public class ArrayStockDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 表示退出栈");
            System.out.println("pop: 表示取出栈数据");
            System.out.println("push: 表示添加栈数据");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.showStack();
                    break;
                case "push":
                    try {
                        System.out.println("请输入一个数");
                        int next = scanner.nextInt();
                        arrayStack.push(next);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println("取出的数据为" + pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:break;
            }
        }
    }
}

class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack;
    private int top = -1; //栈顶,初始化的时候栈为null,所以栈顶的值为-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack =  new int[this.maxSize];
    }

    //判断是否栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //判断是否栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //pop取出栈中数据
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空,无法取出数据");
        }
        int i = stack[top];
        top--;
        return i;
    }

    //push给栈中添加数据
    public void push(int num){
        if (isFull()){
            System.out.println("栈满,无法添加数据");
            return;
        }
        top++;
        stack[top] = num;
    }

    //遍历栈,栈的遍历应该从最后一个开始,先进后出
    public void showStack(){
        if (isEmpty()){
            System.out.println("栈空,无法取出数据");
        }
        for (int i = top; i > -1; i--){
            System.out.println(stack[i]);
        }
    }

}
