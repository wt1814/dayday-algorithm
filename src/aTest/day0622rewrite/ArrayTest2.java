package aTest.day0622rewrite;

import java.util.Date;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: ArrayTest2
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/22/21 2:02 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class ArrayTest2 {

    final static int SIZE = 20000;
    static int[][] matrix = new int[SIZE][SIZE];

    public static void main(String[] args){
        Long beginTime = new Date().getTime();

        for (int j = 0;j<SIZE;j++){
            for (int i = 0;i<SIZE;i++){
                matrix[i][j] = new java.util.Random().nextInt(10);
            }
        }
        System.out.println(new Date().getTime()-beginTime);
    }
}
