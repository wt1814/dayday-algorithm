<!-- TOC -->

- [1. 递归](#1-递归)
    - [1.1. 什么是递归](#11-什么是递归)
    - [1.2. ★★★递归的特点(满足递归的题型)](#12-★★★递归的特点满足递归的题型)
    - [1.3. ★★★递归算法通用解决思路](#13-★★★递归算法通用解决思路)
    - [1.4. 递归题型](#14-递归题型)
        - [1.4.1. 递归解排列组合](#141-递归解排列组合)
            - [排列](#排列)
            - [组合](#组合)
        - [1.4.2. 链表反转](#142-链表反转)
        - [1.4.3. 斐波那契数列，递归计算型，并列计算](#143-斐波那契数列递归计算型并列计算)

<!-- /TOC -->
&emsp; **<font color = "red">总结：</font>**  
1. **<font color = "clime">递归有以下两个特点：</font>**  
    1. 一个问题可以分解成具有相同解决思路的子问题，子子问题，换句话说这些问题都能调用同一个函数。  
    2. 经过层层分解的子问题最后一定是有一个不能再分解的固定值的(即终止条件)，如果没有的话，就无穷无尽地分解子问题了，问题显然是无解的。  
2. 代码debug模式下，先计算子问题。  
3. **<font color = "blue">递归算法的时间复杂度 = 递归函数调用的次数 x 递归函数本身的复杂度</font>**


# 1. 递归  
&emsp; **`递归 就是继承`**  

&emsp; 递归算法时间复杂度：递归函数调用次数 * 递归函数本身的复杂度。  
<!-- 
找出函数的等价关系式 https://www.zhihu.com/question/31412436
第三要素就是，我们要不断缩小参数的范围，缩小之后，我们可以通过一些辅助的变量或者操作，使原函数的结果不变。

从分治到递归
&emsp; **动态规划与分治：**  
&emsp; 分治策略：将原问题分解为若干个规模较小但类似于原问题的子问题(Divide)，递归的求解这些子问题(Conquer)，然后再合并这些子问题的解来建立原问题的解。  
&emsp; 因为在求解大问题时，需要递归的求小问题，因此一般用递归的方法实现，即自顶向下。  
&emsp; 动态规划：动态规划其实和分治策略是类似的，也是将一个原问题分解为若干个规模较小的子问题，递归的求解这些子问题，然后合并子问题的解得到原问题的解。  
&emsp; <font color = "red">动态规划和分治策略的区别在于这些子问题会有重叠，一个子问题在求解后，可能会再次求解，可以将这些子问题的解存储起来，当下次再次求解这个子问题时，直接取过来用。</font>  

-->

## 1.1. 什么是递归  
&emsp; 递归就是指函数直接或间接的调用自己。递归函数也可以使用栈加循环来实现。  
&emsp; 以阶乘函数为例，如下， 在 factorial 函数中存在着factorial(n - 1) 的调用，所以此函数是递归函数。  

```java
/**
 * 求 n 的阶乘
 */
public int factorial(int n) {
    // 第二步的临界条件
    if (n <=1) {
        return 1;
    }

    // 第二步的递推公式
    return n * factorial(n-1);
}
```
&emsp; 进一步剖析「递归」，先有「递」再有「归」，「递」的意思是将问题拆解成子问题来解决，子问题再拆解成子子问题，...，直到被拆解的子问题无需再拆分成更细的子问题(即可以求解)，「归」是说最小的子问题解决了，那么它的上一层子问题也就解决了，上一层的子问题解决了，上上层子问题自然也就解决了，....，直到最开始的问题解决，文字说可能有点抽象，那就以阶层f(6) 为例来看下它的「递」和「归」。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-43.png)  
&emsp; 求解问题f(6)， 由于f(6) = n * f(5)，所以f(6) 需要拆解成f(5)子问题进行求解，同理f(5) = n * f(4)，也需要进一步拆分，... ，直到 f(1)，这是「递」，f(1) 解决了，由于 f(2) =  2 f(1) = 2也解决了，.... f(n)到最后也解决了，这是「归」，所以递归的本质是能把问题拆分成具有相同解决思路的子问题，...直到最后被拆解的子问题再也不能拆分，解决了最小粒度可求解的子问题后，在「归」的过程中自然顺其自然地解决了最开始的问题。  

## 1.2. ★★★递归的特点(满足递归的题型)
&emsp; 在上一节仔细剖析了什么是递归， **<font color = "clime">可以发现递归有以下两个特点：</font>**  

1. 一个问题可以分解成具有相同解决思路的子问题，子子问题，换句话说这些问题都能调用同一个函数。  
2. 经过层层分解的子问题最后一定是有一个不能再分解的固定值的(即终止条件)，如果没有的话，就无穷无尽地分解子问题了，问题显然是无解的。  

&emsp; 所以解递归题的关键在于首先需要根据以上递归的两个特点判断题目是否可以用递归来解。  

-------------

&emsp; **递归的特点(满足递归的条件、递归解题的关键)：**  
1. 一个问题的解可以分解为几个子问题的解；
2. 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样；
3. 存在递归终止条件，即必须有一个明确的递归结束条件，称之为递归出口。

## 1.3. ★★★递归算法通用解决思路
&emsp; 经过判断可以用递归后，接下来我们就来看看用递归解题的基本套路(四步曲)：  

1. 先定义一个函数，明确这个函数的功能，由于递归的特点是问题和子问题都会调用函数自身，所以这个函数的功能一旦确定了， 之后只要找寻问题与子问题的递归关系即可
2. 接下来寻找问题与子问题间的关系(即递推公式)，这样由于问题与子问题具有相同解决思路，只要子问题调用步骤 1 定义好的函数，问题即可解决。所谓的关系最好能用一个公式表示出来，比如 f(n) = n * f(n-) 这样，如果暂时无法得出明确的公式，用伪代码表示也是可以的， 发现递推关系后，要寻找最终不可再分解的子问题的解，即(临界条件)，确保子问题不会无限分解下去。由于第一步我们已经定义了这个函数的功能，所以当问题拆分成子问题时，子问题可以调用步骤 1 定义的函数，符合递归的条件(函数里调用自身)
3. 将第二步的递推公式用代码表示出来补充到步骤 1 定义的函数中
4. 最后也是很关键的一步，根据问题与子问题的关系，推导出时间复杂度，如果发现递归时间复杂度不可接受，则需转换思路对其进行改造，看下是否有更靠谱的解法


&emsp; **<font color = "clime">如何写递归代码？</font>**  
1. 找到如何将大问题分解为小问题的规律
2. 通过规律写出递推公式
3. 通过递归公式的临界点推敲出终止条件
4. 将递推公式和终止条件翻译成代码


<!-- 
经过判断可以用递归后，接下来我们就来看看用递归解题的基本套路（四步曲）：

    先定义一个函数，明确这个函数的功能，由于递归的特点是问题和子问题都会调用函数自身，所以这个函数的功能一旦确定了， 之后只要找寻问题与子问题的递归关系即可
    接下来寻找问题与子问题间的关系（即递推公式），这样由于问题与子问题具有相同解决思路，只要子问题调用步骤 1 定义好的函数，问题即可解决。所谓的关系最好能用一个公式表示出来，比如 f(n) = n * f(n-) 这样，如果暂时无法得出明确的公式，用伪代码表示也是可以的, 发现递推关系后，要寻找最终不可再分解的子问题的解，即（临界条件），确保子问题不会无限分解下去。由于第一步我们已经定义了这个函数的功能，所以当问题拆分成子问题时，子问题可以调用步骤 1 定义的函数，符合递归的条件（函数里调用自身）
    将第二步的递推公式用代码表示出来补充到步骤 1 定义的函数中
    最后也是很关键的一步，根据问题与子问题的关系，推导出时间复杂度,如果发现递归时间复杂度不可接受，则需转换思路对其进行改造，看下是否有更靠谱的解法
-->

## 1.4. 递归题型  
<!--
数据结构与算法之递归系列
https://mp.weixin.qq.com/s/2gL7s8T6vjYQwwz_4UDy4g
-->


<!-- 

阶层
&emsp; 输入一个正整数n，输出n!的值。其中n!=123*…*n，即求阶乘  
&emsp; 套用上一节说的递归四步解题套路来看看怎么解  

1. 定义这个函数，明确这个函数的功能，我们知道这个函数的功能是求 n 的阶乘， 之后求 n-1， n-2 的阶乘就可以调用此函数了

```java
/**
 * 求 n 的阶乘
 */
public int factorial(int n) {
}
```
2. 寻找问题与子问题的关系 阶乘的关系比较简单， 以 f(n) 来表示 n 的阶乘， 显然 f(n) = n * f(n - 1)，  同时临界条件是 f(1) = 1，即
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-44.png)  
3. 将第二步的递推公式用代码表示出来补充到步骤 1 定义的函数中

```java
/**
 * 求 n 的阶乘
 */
public int factorial(int n) {
    // 第二步的临界条件
    if (n <=1) {
        return 1;
    }

    // 第二步的递推公式
    return n * factorial(n-1);
}
```
4. 求时间复杂度 由于  f(n) = n * f(n-1) = n * (n-1) * .... * f(1)，总共作了 n 次乘法，所以时间复杂度为 n。  
-->

### 1.4.1. 递归解排列组合  
<!-- 
一文学会排列组合 
https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483857&idx=1&sn=c4fbb9d55a656aac55c4976c48879c45&scene=21#wechat_redirect
Java递归实现字符串的排列和组合
https://mp.weixin.qq.com/s?__biz=MzA5NDIwNTk2Mw==&mid=2247484636&amp;idx=1&amp;sn=9ea705d330e7955c83dcfc3d6a7f90d0&source=41#wechat_redirect
-->

#### 排列  



#### 组合

### 1.4.2. 链表反转  
<!--
★★★视频
https://vdse.bdstatic.com//1d050c05e13d6be0f3868929d0de4a73.mp4?authorization=bce-auth-v1%2F40f207e648424f47b2e3dfbb1014b1a5%2F2021-04-07T01%3A07%3A13Z%2F-1%2Fhost%2F6e190a5128ee5562d2e0411e62bd5da6e8fa23195db53e41c37bf09e9d1c6b92

★★★ 
https://icode.blog.csdn.net/article/details/100110336


https://mp.weixin.qq.com/s/RkYTtHYghiK8LNUnlWUrlg

图解java递归实现反转单向链表
https://blog.csdn.net/keep12moving/article/details/103116065
一篇文章教你搞定递归单链表反转
https://blog.csdn.net/javageektech/article/details/105236461
Java实现单向链表反转
https://www.cnblogs.com/hiver/p/7008112.html

-->

```java
public static Node invertLinkedList(Node listNode) {

    if (listNode.next == null) {
        return listNode;
    }

    // 步骤 1: 先翻转 listNode 之后的链表
    Node newHead = invertLinkedList(listNode.next);
    // 步骤 2: 再把原 listNode 节点后继结点的后继结点指向 listNode (4)，listNode 的后继节点设置为空(防止形成环)
    listNode.next.next = listNode;  //4 -> 3, 1 -> 2 -> 3
    listNode.next = null;
    // 步骤 3: 返回翻转后的头结点
    return newHead;
}

public static void main(String[] args) {
    SingleLinkedList linkedList = new SingleLinkedList();
    int[] arr = {4,3,2,1};
    for (int i = 0; i < arr.length; i++) {
        linkedList.addHead(arr[i]);
    }
    Node newHead = invertLinkedList(linkedList.head.next);
    // 翻转后别忘了设置头结点的后继结点！
    linkedList.head.next = newHead;
    System.out.println(linkedList);
    //linkedList.printList();      // 打印 1，2，3，4
}
```

### 1.4.3. 斐波那契数列，递归计算型，并列计算
<!-- 
https://mp.weixin.qq.com/s/RkYTtHYghiK8LNUnlWUrlg
-->


## 递归转非递归  
<!--
https://www.cnblogs.com/bakari/p/5349383.html
-->