package aTest.day0622rewrite;

import java.util.Date;

/**
 * @ProjectName：dayday-algorithm
 * @ClassName: ArrayTest
 * @Description: TODO  
 * @Author: wt 
 * @CreateDate: 6/22/21 1:57 PM
 * @UpdateUser: 
 * @UpdateDate:   
 * @UpdateRemark:
 * @Version: V1.0
 **/
public class ArrayTest {

    final static int SIZE = 20000;
    static int[][] matrix = new int[SIZE][SIZE];



    public static void main(String[] args){
        Long beginTime = new Date().getTime();

        for (int i = 0;i<SIZE;i++){
            for (int j = 0;j<SIZE;j++){
                matrix[i][j] = new java.util.Random().nextInt(10);
            }
        }
        System.out.println(new Date().getTime()-beginTime);
    }

}
