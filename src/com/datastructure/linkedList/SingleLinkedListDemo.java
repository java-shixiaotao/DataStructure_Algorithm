package com.datastructure.linkedList;

/**
 * 链表结构
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode  node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode  node2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode  node3 = new HeroNode(3,"吴用","智多星");
        HeroNode  node4 = new HeroNode(4,"林冲","豹子头");

      /*  //添加数据
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        //遍历显示
        singleLinkedList.list();*/

        //添加数据
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.orderAdd(node1);
        singleLinkedList.orderAdd(node3);

        singleLinkedList.orderAdd(node2);
        singleLinkedList.orderAdd(node4);
        singleLinkedList.orderAdd(node3);
        //遍历显示
        singleLinkedList.list();


    }
}

class SingleLinkedList{
    //初始化头节点
    private HeroNode node = new HeroNode(0,"","");

    //给链表添加节点
    //①判断是否有链表,如果有则创建节点,如果没有则添加数据
    public void add(HeroNode heroNode){
        //定义一个临时的节点,来循环查询
        HeroNode temp = node;
        //循环查询next为nul的节点,表示该节点为最后的节点
        while (true){
            if (temp.next == null){
                break;
            }
            //如果不为null,则将temp指向下个节点的数据
            temp = temp.next;
        }
        //将原来的最后的节点的next添加上新添加的一条节点数据指向最新的节点
        temp.next = heroNode;
    }

    //顺序给链表添加节点
    public void orderAdd(HeroNode heroNode){
        //先遍历查找数据
        //添加数据
        HeroNode temp = node;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            //如果下个节点的的编号大于添加节点的编号则表示添加的位置
            if(temp.next.no > heroNode.no){
                //找到
                break;
            }
            //如果编号相等则代表已经存在编号不能添加
            else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("已经存在编号,不能添加\n",heroNode.no);
        }
        //将原来节点的next数据赋值到新添加的节点
        heroNode.next = temp.next;
        //然后将上面节点的next数据赋值上新添加的数据
        temp.next = heroNode;

    }




    public void list(){
        //判断链表是否为空
        if(node.next == null){
            //为空则表示为空链表
            System.out.println("链表为空");
            return;
        }
        //如果不为空,则表示显示下一条
        HeroNode temp = node.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


//定义列表的节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return String.format("HeroNode{no=%d, name='%s', nickname='%s'}", no, name, nickname);
    }
}
