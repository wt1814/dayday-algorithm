package gSort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class cSelectionSort {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        int[] ints = selectionSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {

        // 如果数组长度为0或者1，都是不用排序直接返回
        if (array.length == 0 || array.length == 1 ){
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;                    //todo 保存索引信息
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;

    }


    /**
     * 选择排序改进版
     * @param array
     */
    public static void selectionSort_improvement(int[] array){
        int minPoint;  //存储最小元素的下标
        int maxPoint;  //存储最大元素的下标
        int len = array.length;
        int temp;
        int counter = 1;

        for(int i=0;i<len/2;i++){
            minPoint= i;
            maxPoint= i;
            for(int j=i+1;j<=len-1-i;j++){  //每完成一轮排序，就确定了两个最值，下一轮排序时比较范围减少两个元素
                if(array[j]<array[minPoint]){  //如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                    minPoint= j;
                    continue;
                }else if(array[j]>array[maxPoint]){  //如果待排数组中的某个元素比当前元素大，maxPoint指向该元素的下标
                    maxPoint= j;
                }
            }

            if(minPoint!=i){  //如果发现了更小的元素，与第一个元素交换位置
                temp= array[i];
                array[i]= array[minPoint];
                array[minPoint]= temp;

                //原来的第一个元素已经与下标为minPoint的元素交换了位置
                //如果之前maxPoint指向的是第一个元素，那么需要将maxPoint重新指向array[minPoint]
                //因为现在array[minPoint]存放的才是之前第一个元素中的数据
                if(maxPoint== i){
                    maxPoint= minPoint;
                }

            }

            if(maxPoint!=len-1-i){  //如果发现了更大的元素，与最后一个元素交换位置
                temp= array[len-1-i];
                array[len-1-i]= array[maxPoint];
                array[maxPoint]= temp;
            }
            System.out.print("第"+counter+"轮排序结果：");
            System.out.println(Arrays.toString(array));
            counter++;
        }
    }

}
