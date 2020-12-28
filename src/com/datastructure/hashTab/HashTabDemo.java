package com.datastructure.hashTab;

import java.util.Scanner;

/**
 * 建立一个哈希表示例
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTabList hashTabList = new HashTabList(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 遍历雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入Id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTabList.add(emp);
                    break;
                case "list":
                    hashTabList.list();
                    break;
                case "find":
                    System.out.println("输入Id");
                    id = scanner.nextInt();
                    hashTabList.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:break;
                }

        }
    }
}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class EmpLinkedList {
    private Emp head;



    //链表里面添加节点,假设每次都是给节点的最后面添加
    public void add(Emp emp) {
        if (head == null) { //头节点为null,链表为null
            head = emp;
            return;
        }
        Emp curEmp = head; //定义一个指针
        while (true) {  //循环内,每次让指针等于下一条数据,如果下一条数据为null了说明是最后的节点了,添加数据
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }


    //遍历链表的节点数据
    public void list(int i) {
        if (head == null) {
            System.out.println("第"+ (i + 1) + "链表的节点为null!");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.print("第"+ (i + 1) + "链表的节点的id = " + curEmp.id + "名字 = " + curEmp.name);
            System.out.println();
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //根据Id查找链表的数据
    public Emp findEmpById(int id){
        if (head == null){
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                System.out.println("没有找到这条数据,请重新输入!");
                return null;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }


}

//哈希表,里面存储的是一个一个linkedList
class HashTabList {
    private EmpLinkedList[] empLinkedListArray;
    public int size;

    //构造器
    public HashTabList(int size) {
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        //需要初始化每一条链表
        for (int i = 0; i < empLinkedListArray.length; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //给哈希表中添加数据
    public void add(Emp emp) {
        int i = fun(emp.id);
        EmpLinkedList empLinkedList = empLinkedListArray[i];
        empLinkedList.add(emp);
    }

    //遍历哈希表
    public void list() {
        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据Id查找链表的数据
    public void findEmpById(int id){
        int i = fun(id); //找到在第几条链表
        Emp empById = empLinkedListArray[i].findEmpById(id);
        if (empById == null){
            System.out.println("没有找到该条数据");
        } else {
            System.out.println("在第" + (i+1)+  "条链表上,找到该条数据,id = " + empById.id + "姓名 = " + empById.name);
        }
    }


    //需要通过散列函数来确定给那个链表上添加数据
    public int fun(int id) {
        return id % size;
    }

}

