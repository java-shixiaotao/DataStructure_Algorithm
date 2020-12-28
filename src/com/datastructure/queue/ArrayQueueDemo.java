package com.datastructure.queue;

/**
 * 队列结构
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}


class ArrayQueru {
    private int maxSize;  //数组长度
    private int front;    //队列头
    private int rear;     //队列尾
    private int[] arr;     //数组,用于存放队列

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public ArrayQueru(int maxSize, int front, int rear, int[] arr) {
        this.maxSize = maxSize;
        this.front = front;
        this.rear = rear;
        this.arr = arr;
    }

    //给队列中添加数据
    public ArrayQueru addQueue(ArrayQueru arrayQueru, int a) throws Exception {
        //先判断该队列是否满了
        if (arrayQueru.getMaxSize() == arrayQueru.getArr().length) {
            //队列已满返回失败
            throw new Exception("队列已满");
        } else {
            arrayQueru.setRear(arrayQueru.getRear() + 1); //队列尾部+1
            arrayQueru.getArr()[arrayQueru.getRear()] = a;
        }
        return arrayQueru;
    }

    //取出队列中的数据
    public int getQueue(ArrayQueru arrayQueru, int index) throws Exception {
        if (arrayQueru.getFront() == arrayQueru.getRear()) {
            throw new Exception("队列位空");
        } else {
            //取出第一条的数据
            int i = arrayQueru.getArr()[0];
            //然后将原来的值依次赋值到前面的位置
            for (int j = 0; j < arrayQueru.getArr().length - 1; j++) {
                arrayQueru.getArr()[j] = arrayQueru.getArr()[j + 1];
            }
            arrayQueru.setRear(arrayQueru.getRear() - 1);
            return i;
        }
    }


}


