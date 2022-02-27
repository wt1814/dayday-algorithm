
<!-- TOC -->

- [1. 优先级队列](#1-优先级队列)
    - [1.1. 什么是优先级队列？](#11-什么是优先级队列)
    - [1.2. API](#12-api)
    - [1.3. 构建大/小顶堆](#13-构建大小顶堆)
    - [1.4. 优先级队列使用](#14-优先级队列使用)

<!-- /TOC -->


# 1. 优先级队列

<!--

https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc
实现PriorityQueue的关键在于提供的UserComparator对象
https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152
https://www.jianshu.com/p/c577796e537a
Java中PriorityQueue的排序，堆排序
https://blog.csdn.net/cyp331203/article/details/25310733
-->

## 1.1. 什么是优先级队列？  
&emsp; 什么是优先级队列呢？  
&emsp; 其实就是一个披着队列外衣的堆，因为优先级队列对外接口只是从队头取元素，从队尾添加元素，再无其他取元素的方式，看起来就是一个队列。  
&emsp; 而且优先级队列内部元素是自动依照元素的权值排列。那么它是如何有序排列的呢？  
&emsp; 缺省情况下priority_queue利用max-heap（大顶堆）完成对元素的排序，这个大顶堆是以vector为表现形式的complete binary tree（完全二叉树）。  


## 1.2. API
&emsp; （1）add：插入一个元素，不成功会抛出异常。    
&emsp; （2）offer：插入一个元素，不能被立即执行的情况下会返回一个特殊的值（true 或者 false）。    
&emsp; （3）remove：删除一个元素，如果不成功会返回false。  
&emsp; （4）poll：删除一个元素，并返回删除的元素。    
&emsp; （5）peek：查询队顶元素。  


## 1.3. 构建大/小顶堆
<!-- 
https://blog.csdn.net/weixin_30363263/article/details/80862578
-->

&emsp; `PriorityQueue默认是一个小顶堆`，然而可以通过传入自定义的Comparator函数来实现大顶堆。如下代码实现了一个初始大小为11的大顶堆。这里只是简单的传入一个自定义的Comparator函数，就可以实现大顶堆了。  

```java
PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>((o1, o2) -> o1-o2);
```

```java
/**
 * 大顶堆
 * PriorityQueue(int initialCapacity,
 *                          Comparator<? super E> comparator)
 */
PriorityQueue<Integer> maxHeap1=new PriorityQueue<Integer>(Integer.MAX_VALUE, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
});
```


## 1.4. 优先级队列使用
1. 股票交易  
&emsp; 我们的股票屏幕上总是给出最好或者是表现最差的那些股票。就可以基于优先级队列。方法其实是和找出前K个最大最小的元素方法类似。可以类比到股票中。  
&emsp; 这只是给出了一个案例，你可以把股票交易的这样的使用场景类比到其他的场景中去。  
2. 会员项目  
&emsp; 会员的优先级总是比普通会员高，因此我们就可以使用优先级队列保存会员的优先级。   
&emsp; 这里只给出俩。其他的各位同僚自己体会吧，我自己曾经使用优先级队列来保存无人机的各种状态信息。所以也可以保存各种状态信息。  

