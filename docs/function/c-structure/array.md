
<!-- TOC -->

- [1. 数组](#1-数组)
    - [1.1. 数组基本操作](#11-数组基本操作)
    - [1.2. 二维数组](#12-二维数组)

<!-- /TOC -->



# 1. 数组  
&emsp; **<font color = "red">arr.length，length是数组的属性；list.size()，size()是链表的方法。</font>**   

## 1.1. 数组基本操作

```java
/**
 * 删除指定位置的元素
 * @param index
 * @param array
 * @return
 */
public int[] delete2(int index, int array[]) {
    //todo 数组的删除其实就是覆盖前一位
    int[] arrNew = new int[array.length - 1];
    for (int i = 0; i < array.length - 1; i++) {
        if (i < index) {
            arrNew[i] = array[i];
        } else {
            arrNew[i] = array[i + 1];
        }
    }
    return arrNew;
}
```

## 1.2. 二维数组

    二维数组定义
        int[] pre = pre(root);
        int[] in = in(root);
        int[] post = post(root);
        int[][] result = new int[][]{pre,in,post};

&emsp; 这里讲解下二维数组。二维数组是一个元素为一维数组的数组。  

&emsp; 二维数组定义：数据类型[][] 变量名=new 数据类型[m][n]。m表示这个二维数组有多少个数组；n表示每一个一维数组的元素个数。  
    
    举例： 
    int[][] arr=new int[3][2];定义了一个二维数组arr。
    这个二维数组有3个一维数组，名称是ar[0]，arr[1]，arr[2]；每个一维数组有2个元素，可以通过arr[m][n]来获取。

&emsp; 二维数组基本操作：遍历一个行列变化的二维数组。  

```java
/*
* 遍历一个行列变化的数组
*/
public class bianlishuzu2 {
    public static void main(String[] args) {
        int [][] arr = { {1，2，3}，{4，5}，{6} };
        printArray(arr);
    }
    public static void printArray(int[][] arr){
        for(int x=0;x<arr.length;x++){
            for(int y=0;y<arr[x].length;y++){
                System.out.print(arr[x][y]);
            }
            System.out.println();
        }
    }
}
```


```java
// todo 二维数组遍历
public static void main(String []args){
	//把以上的数据用二维数组来表示
	int [][] nums={{22,66,44},{100,150,180},{300,240,180},{11,33,19}};
	//遍历二维数组
	int sum = 0;
	//外循环遍历有多少个一维数组
	for(int i =0;i <nums.length;i++){
		//内循环遍历每一个一维数组的元素
		for(int j = 0;j<nums[i].length,j++){
				sum+=nums[i][j];		//依次相加到sum中
			}
		}
		System.out.println("西蒙公司年销售总额为:"+sum);
	}
}
```
