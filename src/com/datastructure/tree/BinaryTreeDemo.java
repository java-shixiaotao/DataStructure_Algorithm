package com.datastructure.tree;

/**
 * 二叉树的三种遍历
 *
 * 前序遍历: 先输出本节点,然后再输出左子节点.判断左子节点的左右子节点是否为null,如果不为null再进入左子节点,如此循环.
 * 中序遍历: 先输出左子节点,然后输出母子节点,再输出右子节点.
 * 后序遍历: 显示出左子节点,再输出右子节点,最后输出母子节点.
 *
 *
 * 前序查找:1.比较当前结点是否相等  2.判断左子节点是否为null,如果不为空,则递归向左,如果没有找到.则判断右子节点是否为null,如果不为null则向右前序递归查找
 * 中序查找:1.先判断左子节点是否为null,如果不为空,则递归向左查找. 2.判断当前节点是否相等,如果不想等则返回. 3.再判断右子节点是否为null,如果不为null,递归向右中序查找
 * 后序查找:1.先判断左子节点是否为null,如果不为空,则递归向左查找. 2.判断当前节点是否相等,如果不想等则返回.
 *
 *
 * 二叉树的删除:
 * 要求: 1).如果要删除的节点是叶子节点,则删除该节点
 *       2).如果删除的节点时非叶子节点,则删除该子树
 *       3).测试,删除掉5号叶子节点 和 3 号叶子节点
 * 思路分析: 1.首先先处理是否是空数的root,如果只有一个root节点,则等价将二叉树置空.
 *          2.然后,因为我们的二叉树是单向的,所以我们是判断当前节点的子节点是否需要删除节点,而不能取判断当前这个几点是不是需要删除的节点.
 *          3.如果是当前节点的左子节点不为空,并且左子节点是当前要删除的节点,则将左子节点置空,并且返回.
 *          4.如果当前节点的右子节点不为空,并且右子节点是当前要删除的节点,则将右子节点置空,并且返回.
 *          5.如果第三步和第四步都没有删除节点,那么我们就需要向左递归删除,
 *          6.如果第五步也没有删除节点,那么我们就需要向右递归删除.
 *
 *
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
    HeroNode root = new HeroNode(1,"AAA");
    HeroNode heroNode2 = new HeroNode(2,"BBB");
    HeroNode heroNode3 = new HeroNode(3,"CCC");
    HeroNode heroNode4 = new HeroNode(4,"DDD");
    HeroNode heroNode5 = new HeroNode(5,"EEE");
    HeroNode heroNode6 = new HeroNode(6,"FFF");
    HeroNode heroNode7 = new HeroNode(7,"GGG");
    HeroNode heroNode8 = new HeroNode(8,"HHH");
    HeroNode heroNode9 = new HeroNode(9,"III");
    HeroNode heroNode10 = new HeroNode(10,"JJJ");
    HeroNode heroNode11 = new HeroNode(11,"KKK");

    BinaryTree binaryTree = new BinaryTree();

    //设置二叉树
    binaryTree.setHead(root);
    root.setLeft(heroNode2);
    root.setRight(heroNode3);
    heroNode3.setLeft(heroNode5);
    heroNode3.setRight(heroNode4);
    heroNode2.setLeft(heroNode6);
    heroNode2.setRight(heroNode7);
    heroNode6.setLeft(heroNode8);
    heroNode6.setRight(heroNode9);
    heroNode4.setLeft(heroNode10);
    heroNode4.setRight(heroNode11);

    //前序遍历
   // binaryTree.preOrder();//1 2 3 5 4
    //后序遍历
   //binaryTree.postOrder();  // 2 5 4 3 1
    //后序遍历
   // binaryTree.mid();  // 2 1 5 3 4
/*
    //前序查找
    HeroNode heroNode = binaryTree.preOrderSearch(5);
    if (heroNode != null){
        System.out.printf("找到了,信息为 no = %d name = %s", heroNode.getNo(), heroNode.getName());
        System.out.println();
        System.out.println(heroNode.count);
    }else {
        System.out.printf("没有找到 no = %d 的英雄", 15);
    }*/

   /* //中序查找
    HeroNode heroNode = binaryTree.midOrderSearch(5);
    if (heroNode != null){
        System.out.printf("找到了,信息为 no = %d name = %s", heroNode.getNo(), heroNode.getName());
        System.out.println();
        System.out.println(heroNode.count);
    }else {
        System.out.printf("没有找到 no = %d 的英雄", 15);
    }*/

    /*//后序查找
    HeroNode heroNode = binaryTree.postOrderSearch(5);
    if (heroNode != null){
        System.out.printf("找到了,信息为 no = %d name = %s", heroNode.getNo(), heroNode.getName());
        System.out.println();
        System.out.println(heroNode.count);
    }else {
        System.out.printf("没有找到 no = %d 的英雄", 15);
    }*/
        //前序遍历
        System.out.println("删除前的前序遍历~~~~~~~~~~~~~~~~~~~~");
        binaryTree.preOrder();//1 2 3 5 4
        System.out.println("删除后的遍历~~~~~~~~~~~~~~~~~~~~~");
        binaryTree.delNode(8);
        binaryTree.preOrder();



    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public static int count = 0;

    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        //向左子树遍历
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void mid(){
        if (this.left != null){
            this.left.mid();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.mid();
        }
    }

    //右序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找:1.比较当前结点是否相等  2.判断左子节点是否为null,如果不为空,则递归向左,如果没有找到.则判断右子节点是否为null,如果不为null则向右前序递归查找
    public HeroNode preOrerSerarch(int no){
        System.out.println("***********开始前序查找了");
        count++;
        if (this.no == no){ //当前节点就是要查找的节点
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.preOrerSerarch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null){
            heroNode = this.right.preOrerSerarch(no);
        }
        return heroNode;
    }

    //中序查找:1.先判断左子节点是否为null,如果不为空,则递归向左查找. 2.判断当前节点是否相等,如果不想等则返回. 3.再判断右子节点是否为null,如果不为null,递归向右中序查找
    public HeroNode midOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.midOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        //再判断本节点是否相等
        System.out.println("***********开始中序查找了");
        count++;
        if (this.no == no){
            return this;
        }
        //判断右子节点
        if (this.right != null){
            heroNode = this.right.midOrderSearch(no);
        }
        return heroNode;
    }


    //后序查找:1.先判断左子节点是否为null,如果不为空,则递归向左查找. 2.判断当前节点是否相等,如果不想等则返回.
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        //判断右子节点
        if (this.right != null){
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        //再判断本节点是否相等
        System.out.println("***********开始后序查找了");
        count++;
        if (this.no == no){
            return this;
        }
        return heroNode;
    }

    //删除节点
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }



}


class BinaryTree{
  private HeroNode head;

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //前序遍历
    public void preOrder(){
        if (this.head != null){
            this.head.preOrder();
        } else {
            System.out.println("当前二叉树为null,无法遍历");
        }
    }

    public void mid(){
        if (this.head != null){
            this.head.mid();
        }else {
            System.out.println("当前二叉树为null,无法遍历");
        }
    }

    public void postOrder(){
        if (this.head != null){
            this.head.postOrder();
        }else {
            System.out.println("当前二叉树为null,无法遍历");
        }
    }


    //前序查找
    public HeroNode preOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.head != null){
            heroNode = this.head.preOrerSerarch(no);
        }else {
            System.out.println("当前二叉树为null,无法查找");
        }
        return heroNode;
    }

    //中序查找
    public HeroNode midOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.head != null){
            heroNode = this.head.midOrderSearch(no);
        }else {
            System.out.println("当前二叉树为null,无法查找");
        }
        return heroNode;
    }


    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode = null;
        if (this.head != null){
            heroNode = this.head.postOrderSearch(no);
        }else {
            System.out.println("当前二叉树为null,无法查找");
        }
        return heroNode;
    }

    //删除节点
    public void delNode(int no){
        if (head != null) {
            if (head.getNo() == no){
                head = null;
            }else {
                this.head.delNode(no);
            }
        }else {
            System.out.println("为空树,无法删除~~~");
        }
    }




}
