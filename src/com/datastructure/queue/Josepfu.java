package com.datastructure.queue;

/**
 * 环形链表
 */
public class Josepfu {
    public static void main(String[] args) {
                CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
                circleSingleLinkedList.addBoy(500);
               // circleSingleLinkedList.showBoy();
                circleSingleLinkedList.Josepfu(10,20,500);
    }
}


//新建一个环形链表
class CircleSingleLinkedList {
    //创建一个首节点
    private Boy first = null;

    //添加节点.构成环形链表
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("添加的节点不能小于1");
            return;
        }
        Boy curBoy = null;// 定义一个辅助节点
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            //定义个首节点
            if (i == 1) { //如果为首节点
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else { //如果不是第二个节点,需要将第一个节点的next设置为下一个节点,再将curboy设置为新节点,再将新节点的next设置为first
                curBoy.setNext(boy);
                curBoy = boy;
                curBoy.setNext(first);
            }
        }
    }

    //遍历节点
    public void showBoy(){
        if (first == null ){
            System.out.println("节点为null");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("该节点的编号为: " + curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //与瑟夫出圈

    /**
     *
     * @param startNo 表示在第几个开始
     * @param countNum 数几下
     * @param nums 有几个小孩
     */
    public void Josepfu(int startNo,int countNum, int nums){
        if(first == null || startNo < 1 || startNo > nums ){
            System.out.println("参数输入有误,请重新输入" );
            return;
        }
        //创建辅助指针,让helper指向第一个节点的前一个
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){ //
                break;
            }
            helper = helper.getNext();
        }

        //指定第几个节点开始的时候,设置helper和first指向
        for (int i = 0; i < startNo - 1; i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //开始扔出小孩,是个循环
        while (true){
            //如果只剩下一个节点停止
            if (first == helper){
                System.out.println("小孩都扔出去了");
                break;
            }
            for (int j = 0; j < countNum - 1; j++ ){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("要出圈的小孩: "+ first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个小孩的名字是:" + first.getNo());

    }


}

//节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}