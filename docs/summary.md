
<!-- TOC -->

- [1. 总结](#1-总结)
    - [1.1. 算法建模](#11-算法建模)
    - [1.2. java语法基础](#12-java语法基础)
    - [1.3. 排序](#13-排序)
        - [1.3.1. 归并](#131-归并)
        - [1.3.2. 堆排序](#132-堆排序)
    - [1.4. 查找](#14-查找)
        - [1.4.1. 二分查找](#141-二分查找)
    - [1.5. 双指针](#15-双指针)
    - [1.6. 二叉树](#16-二叉树)
        - [1.6.1. BFS](#161-bfs)
        - [1.6.2. DFS](#162-dfs)

<!-- /TOC -->

# 1. 总结
## 1.1. 算法建模
<!-- 


西法的刷题秘籍 2.0
https://mp.weixin.qq.com/s/oL8x6cxL4WGicnhi1hZkVQ
我推荐大家直接使用在线版 + latex Chrome 插件在线观看，不仅阅读体验好，而且可以享受自动更新的服务。在线地址：https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/

latex 插件我用的是 tex-all-the-things。地址：https://chrome.google.com/webstore/detail/tex-all-the-things/cbimabofgmfdkicghcadidpemeenbffn

-->
&emsp;  一个中心 --- 画图，即梳理算法逻辑。  

&emsp; 数据结构是门特大的学问  

&emsp; 算法的好坏：时间复杂度、空间复杂度。  

&emsp; 可以空间换时间，时间换空间。  
&emsp; 对于数据很大，内存加载不完时，需要使用一些复杂的数据结构，可能算法更复杂，可能需要丢失精度。这类数据结构有Bitmap、HyperLogLog以及BloomFilter......  
&emsp; 基本数据结构结合又会形成一些复杂的数据结构，例如SkipList......  

----

1. 什么是变量？为什么需要变量？使用什么样的变量(全局、成员、局部)？  
2. 流程控制  

 
1. 是否需要额外空间？或者使用额外的数据结构能帮助运算。  
2. 算法建模：构建算法流程。  
3. 构造算法流程可以 ~~想象~~


**<font color = "clime">写算法，写不下去了，脑海中想的实现不了。可能缺东西，发现少参数，那就补参数。</font>**   
**<font color = "clime">好习惯：每个方法都有输出</font>**


----------------

1. 基本：
    1. 变量。
    2. 流程操作。
2. 数据结构
    1. 选择什么样的数据结构
    2. 数据结构的操作：
        1. 数组：1.选择起始位置；2.正序还是反序；

数据结构和算法更多是用作程序员的工具，它们作为构思算法的辅助工具，而不是完全的数据存储工具。  

## 1.2. java语法基础

```java
int index = 0;//遍历字符串中字符的位置

for (; index < length; ++index) {  // todo for循环里的计数，可以提前定义
    
}
```

```text
System.out.println('A'-'A');   0
System.out.println('B'-'A');   1
```

## 1.3. 排序

|排序算法|	平均时间复杂度|	最好|	最坏|	空间复杂度|	稳定性|
|---|---|---|---|---|---|
|冒泡排序|	O(n^2)	|O(n)|	O(n^2)	| O(1)	| 稳定 |
|快速排序|	O(nlogn)|	O(nlogn)|	O(n^2)	|O(logn)|	不稳定|
|插入排序|	O(n^2)|	O(n)|	O(n^2)	|O(1)	|稳定|
|希尔排序|	O(n^1.3)|	O(n)|	O(n^2)	|O(1)	|不稳定|
|选择排序|	O(n^2)|	O(n^2)	|O(n^2)	|O(1)	|不稳定|
|堆排序	|O(nlogn)|	O(nlogn)	|O(nlogn)|	O(1)|	不稳定|
|归并排序|	O(nlogn)|	O(nlogn)|	O(nlogn)	|O(n)	|稳定|
|桶排序	|O(n+k)	|O(n+k)	|O(n+k)	|O(n+k)	|稳定|
|计数排序|	O(n+k)|	O(n+k)|	O(n+k)	|O(k)	|稳定|
|基数排序|	O(n*k)|	O(n*k)|	O(n*k)	|O(n+k)|	稳定|

&emsp; 快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后序遍历。  

### 1.3.1. 归并  

```java
import java.util.Arrays;

/**
 * 归并排序
 * todo 二分 + 递归
 * todo 1. 先分再合
 * todo 2. 合的时候，设置移动指针，合并“两个待排序数组”
 * todo 2. 1). 双指针同时移动比较， 2). 若左边还有剩余
 */
public class eMergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array,int left,int right){

        if (left >= right){  // todo 递归的标准步骤
            return;
        }

        int mid = (left+right)/2;
        mergeSort(array,left,mid);        //todo 先分再合
        mergeSort(array,mid+1,right);

        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[array.length];
        merge(array,left,mid,right,temp); //todo 两数组合并

        return;
    }


    /**
     * 两数组合并
     * @param arr
     * @param left //todo 固定位置
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        // todo 定义可移动的指针
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针


        while (i<=mid && j<=right){  //todo 两个数组合并，同时移动指针
            if (arr[i]>=arr[j]){
                temp[t] = arr[j];
                j++;
            }else {
                temp[t] = arr[i];
                i++;
            }
            t++;
        }

/*        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }*/


        while(i<=mid){             //todo 若左边还有剩余，将左边剩余元素填充进temp中
            //temp[t++] = arr[i++];
            temp[t] = arr[i];
            t++;
            i++;

        }

        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t] = arr[j];
            t++;
            j++;
        }


        t = 0;
        //todo 将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    ////////////////////////////////////////////////////////////////////////
    // https://www.cnblogs.com/sheeva/p/6600666.html
    //todo 迭代解题
    private static int count = 0;
    public int[] sort(int[] data) {
        return sort(data, 0, data.length - 1);
    }

    private int[] sort(int[] data, int low, int high) {
        if (low == high) {
            return new int[] { data[low] };
        }
        int mid = (low + high) >> 1;
        int[] left = sort(data, low, mid); //(1)
        int[] right = sort(data, mid + 1, high); //(2)

        int[] result = new int[high - low + 1];
        int i = 0, k = 0;
        //(3)
        for (int j = 0; j < result.length; j++) {
            count++;
            if (i == left.length) {
                result[j] = right[k++];
            } else if (k == right.length) {
                result[j] = left[i++];
            } else {
                if (left[i] <= right[k]) {
                    result[j] = left[i++];
                } else {
                    result[j] = right[k++];
                }
            }
        }
        return result;
    }


    ////////////////////////////////////////////////////////////////////////////

    public static void mergeSort1(int[] array, int start, int end){
        if(start < end){
            //折半成两个小集合，分别进行递归
            int mid=(start+end)/2;
            mergeSort1(array, start, mid);
            mergeSort1(array, mid+1, end);
            //把两个有序小集合，归并成一个大集合
            merge1(array, start, mid, end);
        }
    }

    private static void merge1(int[] array, int start, int mid, int end){

        //开辟额外大集合，设置指针
        int[] tempArray = new int[end-start+1];
        int p1=start, p2=mid+1, p=0;
        //比较两个小集合的元素，依次放入大集合
        while(p1<=mid && p2<=end){
            if(array[p1]<=array[p2]){
                tempArray[p++]=array[p1++];
            }
            else{
                tempArray[p++]=array[p2++];
            }
        }
        //左侧小集合还有剩余，依次放入大集合尾部
        while(p1<=mid){
            tempArray[p++]=array[p1++];
        }
        //右侧小集合还有剩余，依次放入大集合尾部
        while(p2<=end){
            tempArray[p++]=array[p2++];
        }

        //把大集合的元素复制回原数组
        for (int i=0; i<tempArray.length; i++){
            array[i+start]=tempArray[i];
        }
    }


}

```

### 1.3.2. 堆排序

```java
import java.util.Arrays;

/**
 * 最大堆排序
 */
public class hHeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // todo https://www.cnblogs.com/chengxiao/p/6129630.html
    // https://www.cnblogs.com/jingmoxukong/p/4303826.html#%E7%AE%97%E6%B3%95%E5%88%86%E6%9E%90
    /**
     * 堆排序(升序)
     * todo 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * todo 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     * 1. 从最后一个非叶子结点开始（叶结点自然不用调整，第一个非叶子结点 arr.length/2-1=5/2-1=1），从左至右，从下至上进行调整。
     * @param array 待调整的堆
     */
    public static void heapSort(int[] array) {

        // todo 1. 把无序数组构建成最大堆。
        for (int i = (array.length-2)/2; i >= 0; i--) {  //第一个非叶子结点 arr.length/2-1
            //从第一个非叶子结点从下至上，从右至左调整结构
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));

        // 2. 循环交换集合尾部元素到堆顶，并调节堆产生新的堆顶。
        //  进行n-1次循环，完成排序
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * todo 写法简单
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i]; //先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){ //从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){ //处理左节点还是右节点？如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){ //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;  // todo 直接结束for循环
            }
        }
        arr[i] = temp; //将temp值放到最终的位置

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * todo 容易理解
     * todo https://www.cnblogs.com/jingmoxukong/p/4303826.html#%E7%AE%97%E6%B3%95%E5%88%86%E6%9E%90
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];

        int childIndex = 2 * parentIndex + 1; // 先获得左孩子
        while (childIndex < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则定位到右孩子结点
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于等于任何一个孩子的值，直接结束
            if (temp >= array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            // 把孩子结点的值赋给父结点
            array[parentIndex] = array[childIndex];

            //todo 选取孩子结点的左孩子结点，继续向下筛选
            //todo 对比for循环的区别，while循环此处要编码修改指针
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }

        array[parentIndex] = temp;
    }


}
```

## 1.4. 查找

### 1.4.1. 二分查找
&emsp; `一般在有序数组中查找。`  
&emsp; 迭代解二分查找，双指针  

```java
/**
 * todo 二分查找，前提条件是数据必须是有序的
 * todo 迭代解二分查找，双指针
 */
public class aBinarySearchOfIteration {

    /**
     * 非递归实现，while循环
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int []array,int target){

        //查找范围起点
        int start=0;
        //查找范围终点
        int end=array.length-1;
        //查找范围中位数
        int mid;

        while(start<=end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]<target){
                start=mid+1; // todo mid+1，非mid
            }else{
                end=mid-1;
            }
        }
        return -1;
    }


}
```

&emsp; 递归解二分查找  

```java
/**
 * todo 递归解二分查找
 * todo 关键点：相撞指针到同一个中点，然后返回中点。
 * todo todo todo
 *
 * 二分查找，将一个集合分成三部分
 */
public class bBinarySearchOfRecursion {

    public static void main(String[] args) {

        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(recursionBinarySearch(array, 0,array.length,173));
    }

    /**
     * 递归实现
     * @param array
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int recursionBinarySearch(int[] array,int start,int end,int target){

        if (start > end){
            return -1;
        }

        int mid=start+(end-start)/2;
        if (target == array[mid]) {
            return mid;
        } else if (target < array[mid]) { //比关键字大则关键字在左区域
            return recursionBinarySearch(array, start, mid - 1, target);
        } else { //比关键字小则关键字在右区域
            return recursionBinarySearch(array, mid + 1, end, target);
        }

    }

}
```

## 1.5. 双指针
&emsp; `双重for循环可以使用相向指针 + 单循环，替代。`  


## 1.6. 二叉树

### 1.6.1. BFS


### 1.6.2. DFS



