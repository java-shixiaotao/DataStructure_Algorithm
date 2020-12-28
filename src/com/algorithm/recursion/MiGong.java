package com.algorithm.recursion;

/**
 * 用递归算法解决迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组创建地图,使用1表示墙0代表可以走的地方
        int[][] temp = new int[8][7];
        //设置第一行和第八行为1
        for (int i = 0; i < 7; i++){
           temp[0][i] = 1;
           temp[7][i] = 1;
        }
        //设置第一列和第七列为1
        for (int i = 0; i < 8; i++ ){
            temp[i][0] = 1;
            temp[i][6] = 1;
        }
        temp[3][1] = 1;
        temp[3][2] = 1;
        temp[2][3] = 1;
        for (int i = 0; i < 8 ; i++){
            for (int j=0; j < 7; j++){
                System.out.print(temp[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------");
        setWay(temp,1,1);
        for (int i = 0; i < 8 ; i++){
            for (int j=0; j < 7; j++){
                System.out.print(temp[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }


    //使用小球递归回溯给小球找路
    //temp 表示题图
    // 如果小球找到tep[6][5]的点代表找到了路线
    // i  j  表示地图的那个位置出发
    // 约定: 当temp[i][j] 为0时表示该点没有走过,当为1时代表为墙,为2代表通路可以走,3代表该路不通
    // 在走迷宫的时候,需要确定一个策略,下--右--上--左,如果该点不通.再回溯
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5]  == 2){//首先如果再tep[6][5]处为2则代表走通了,下一步.
            return true;
        }else {  //如果没有走通按照定好的策略走,先要设置该点为2,后期如果没有通再设置为3
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                } else if (setWay(map,i,j+1)){
                    return true;
                } else if(setWay(map,i-1,j)){
                    return true;
                } else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }




}
