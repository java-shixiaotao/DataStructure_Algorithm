package com.datastructure.stack;

import sun.awt.geom.AreaOp;

public class Calculator {
    public static void main(String[] args) {
        String key = "700+2*6-4";
        //定义两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//获取到的值
        String keepNum = "";
        //取出值
        while (true) {
            ch = key.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) { //如果是符号
                if (operStack.isEmpty()) { //如果符号栈为空
                    operStack.push(ch);
                } else { //如果符号栈不为空
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) { //如果优先级`小于等于
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
            } else { //如果为数字
                keepNum += ch;
                if (index == key.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(key.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符,则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= key.length()) {
                break;
            }
        }

        //当表达式扫描结束后需要将数字拿出来计算
        while (true) {
            if (operStack.isEmpty()) {
                System.out.println("代表结束");
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(key + "的结果是:" + numStack.pop());


    }
}

class ArrayStack2 {
    private int maxSize; //栈的大小
    private int[] stack;
    private int top = -1; //栈顶,初始化的时候栈为null,所以栈顶的值为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //从栈中取出最后一个值
    public int peek() {
        return stack[top];
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断是否栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //pop取出栈中数据
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法取出数据");
        }
        int i = stack[top];
        top--;
        return i;
    }

    //push给栈中添加数据
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满,无法添加数据");
            return;
        }
        top++;
        stack[top] = num;
    }

    //遍历栈,栈的遍历应该从最后一个开始,先进后出
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空,无法取出数据");
        }
        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }


    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }


    public boolean isOper(char oper) {
        return '+' == oper || '-' == oper || '*' == oper || '/' == oper;
    }

    public int cal(int num1, int num2, int oper) {
        int val = 0;
        switch (oper) {
            case '*':
                val = num1 * num2;
                break;
            case '/':
                val = num2 / num1;
                break;
            case '+':
                val = num2 + num1;
                break;
            case '-':
                val = num2 - num1;
                break;
            default:
                break;
        }
        return val;
    }


}







