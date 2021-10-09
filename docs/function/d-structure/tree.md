

<!-- TOC -->

- [1. 树](#1-树)
    - [1.1. 二叉树](#11-二叉树)
        - [1.1.1. 二叉树简介及各种类型](#111-二叉树简介及各种类型)
        - [1.1.2. 二叉树的遍历方式](#112-二叉树的遍历方式)
            - [1.1.2.1. 深度优先遍历](#1121-深度优先遍历)
            - [1.1.2.2. 广度优先遍历](#1122-广度优先遍历)
        - [1.1.3. 有关二叉树的算法题](#113-有关二叉树的算法题)
            - [1.1.3.1. 两个通用方法和思路](#1131-两个通用方法和思路)
                - [1.1.3.1.1. 自顶向下的递归遍历](#11311-自顶向下的递归遍历)
                - [1.1.3.1.2. 自底向上的分治](#11312-自底向上的分治)
                - [1.1.3.1.3. ***两种方式比较](#11313-两种方式比较)
            - [1.1.3.2. 递归转非递归](#1132-递归转非递归)

<!-- /TOC -->

<!--
搜索算法
https://mp.weixin.qq.com/s/gMMnZC0KvKee1V16lJzPKg

***树
https://mp.weixin.qq.com/s?__biz=MzI4MzUxNjI3OA==&mid=2247485899&idx=1&sn=27d1c7b8ff88cbe235b7fca63227d356&chksm=eb88c5d2dcff4cc4102a036bc558b9c598fbf1c69f6ee9dc2822b0784975f8b2df8b8a7609dd&scene=178&cur_album_id=1506626428316991490#rd

树的遍历  
遍历不是目的，遍历是为了更好地做处理，这里的处理包括搜索，修改树等。树虽然只能从根开始访问，但是我们可以「选择」在访问完毕回来的时候做处理，还是在访问回来之前做处理，这两种不同的方式就是「后序遍历」和「先序遍历」。  

前序遍历和后序遍历是最常见的两种 DFS 方式。而另外一种遍历方式 （中序遍历）一般用于平衡二叉树，这个我们后面的「四个重要概念」部分再讲。  


BFS 比较适合找「最短距离/路径」和「某一个距离的目标」。比如给定一个二叉树，在树的最后一行找到最左边的值。，此题是力扣 513 的原题。这不就是求距离根节点「最远距离」的目标么？一个 BFS 模板就解决了。  



-->

# 1. 树  

&emsp; 二叉树的递归套路

&emsp; 1) 假设以x节点为头，假设可以向x左树和x右树要任何信息  
&emsp; 2) 在上一步的假设下，讨论以x为头节点的树，得到答案的可能性（最重要）  
&emsp; 3) 列出所有可能性后，确定到底需要向左树和右树要什么样的信息  
&emsp; 4) 把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S  
&emsp; 5) 递归函数都返回S，每一颗子树都这么要求  
&emsp; 6) 写代码，在代码中考虑如何把左树都信息和右树信息整合出整棵树的信息  

## 1.1. 二叉树  
### 1.1.1. 二叉树简介及各种类型
&emsp; **二叉树有两种特殊形式：**一个叫满二叉树，一个叫完全二叉树。  
&emsp; **二叉树的实现：**树是一种逻辑数据结构。二叉树即可以用数组实现，也可以用链表实现。二叉树一般使用链表实现； **<font color = "clime">二叉堆，一种特殊的完全二叉树，使用数组来操作。</font>**  
&emsp; **二叉树的遍历：**二叉树的遍历方式有深度优先遍历、广度优先遍历。  

&emsp; **二叉树的应用：**二叉树包含许多特殊的形式，每一种形式都有自己的应用。但是其最主要的应用还在于进行查找操作和维持相对顺序这两个方面。有一种特殊的二叉树叫做**二叉查找树或二叉排序树**。  
&emsp; 二叉查找树有可能退化成一个链表，可以采用自平衡方式优化结构。<font color = "red">二叉树自平衡的方式有多种，如红黑树、平衡二叉树(AVL)等。</font>  

&emsp; **树与递归：**对于二分搜索树这种结构我们要明确的是，树是一种天然的可递归的结构。  

### 1.1.2. 二叉树的遍历方式  
<!-- 
图文详解 树的DFS 和 BFS 
https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247484022&idx=1&sn=9890a47b9a08809c9a66e613aa8fe311&scene=21#wechat_redirect
https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247483881&idx=1&sn=3b1de7f74aaaade96ee0f71960a80609&chksm=fa0e6e68cd79e77e45633b52731e83262dd7ad70a0fd4d97e3c1e44170cc69a62f870526568e&scene=21#wechat_redirect

https://mp.weixin.qq.com/s/VwjaMs4g2cxydt8dXNdS0g
-->
&emsp; 二叉树都有哪些遍历方式呢？  
&emsp; 从节点之间位置关系的角度来看，二叉树的遍历分为4种。1. 前序遍历。2. 中序遍历。3. 后序遍历。4. 层序遍历。  
&emsp; 从更宏观的角度来看，二叉树的遍历归结为两大类。 1. 深度优先遍历(前序遍历、中序遍历、后序遍历)。2. 广度优先遍历(层序遍历)。  


#### 1.1.2.1. 深度优先遍历  
* 前序遍历  
&emsp; 二叉树的前序遍历，输出顺序是根节点、左子树、右子树。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-26.png)  
&emsp; 输出顺序为1--->2--->4--->5--->3--->6。  
* 中序遍历  
&emsp; 二叉树的中序遍历，输出顺序是左子树、根节点、右子树。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-27.png)  
&emsp; 输出顺序为4--->2--->5--->1--->3--->6。  
* 后序遍历  
&emsp; 二叉树的后序遍历，输出顺序是左子树、右子树、根节点。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-28.png)  
&emsp; 输出顺序为4--->5--->2--->6--->3--->1。  

&emsp; 使用递归方式来实现前序、中序、后序遍历。  
```java

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    /**
     * 构建二叉树
     * @param inputList   输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode listNode = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if(data != null){
            listNode = new TreeNode(data);
            listNode.leftChild = createBinaryTree(inputList);
            listNode.rightChild = createBinaryTree(inputList);
        }
        return listNode;
    }

    /**
     * 二叉树前序遍历
     * @param listNode   二叉树节点
     */
    public static void preOrderTraversal(TreeNode listNode){
        if(listNode == null){
            return;
        }
        System.out.println(listNode.data);
        preOrderTraversal(listNode.leftChild);
        preOrderTraversal(listNode.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param listNode   二叉树节点
     */
    public static void inOrderTraversal(TreeNode listNode){
        if(listNode == null){
            return;
        }
        inOrderTraversal(listNode.leftChild);
        System.out.println(listNode.data);
        inOrderTraversal(listNode.rightChild);
    }


    /**
     * 二叉树后序遍历
     * @param listNode   二叉树节点
     */
    public static void postOrderTraversal(TreeNode listNode){
        if(listNode == null){
            return;
        }
        postOrderTraversal(listNode.leftChild);
        postOrderTraversal(listNode.rightChild);
        System.out.println(listNode.data);
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode TreeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraversal(TreeNode);
        System.out.println("中序遍历：");
        inOrderTraversal(TreeNode);
        System.out.println("后序遍历：");
        postOrderTraversal(TreeNode);
    }
}
```

#### 1.1.2.2. 广度优先遍历  
&emsp; 如果说深度优先遍历是在一个方向上“一头扎到底”，那么广度优先遍历则恰 恰相反：先在各个方向上各走出1步，再在各个方向上走出第2步、第3步……一直到 各个方向全部走完。通过二叉树的层序遍历，来看一 看广度优先是怎么回事。  
&emsp; 层序遍历，顾名思义，就是二叉树按照从根节点到叶子节点的层次关系，一层 一层横向遍历各个节点。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-29.png)  
&emsp; 输出顺序为1--->2--->3--->4--->5--->6。  

```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversalLevel {

    /**
     * 构建二叉树
     * @param inputList   输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode listNode = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if(data != null){
            listNode = new TreeNode(data);
            listNode.leftChild = createBinaryTree(inputList);
            listNode.rightChild = createBinaryTree(inputList);
        }
        return listNode;
    }

    /**
     * 二叉树层序遍历
     * @param root   二叉树根节点
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode listNode = queue.poll();
            System.out.println(listNode.data);
            if(listNode.leftChild != null){
                queue.offer(listNode.leftChild);
            }
            if(listNode.rightChild != null){
                queue.offer(listNode.rightChild);
            }
        }
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode TreeNode = createBinaryTree(inputList);
        System.out.println("层序遍历：");
        levelOrderTraversal(TreeNode);
    }

}
```

### 1.1.3. 有关二叉树的算法题
<!-- 
~~
LeetCode二叉树问题小总结
https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247486350&idx=3&sn=f847d84a0c2553d2854b37b6202cb923&chksm=fa0e640fcd79ed19006e12d9d4e330fca44db451413a5870de3758515be60f387d43a1f80ef1&mpshare=1&scene=1&srcid=&sharer_sharetime=1567642529620&sharer_shareid=b256218ead787d58e0b58614a973d00d&key=a1704a04d6cad8d086b12ea2ff25a231d33902d1a964dc54bf8fa7ac6214cc54031a9fadea253fc8d1458fefa4d791da5f09b8d8b6e4ee35369d746f3486560b6d10bdfdd164449b259756a720157dd7&ascene=1&uin=MTE1MTYxNzY2MQ%3D%3D&devicetype=Windows+10&version=62060844&lang=zh_CN&pass_ticket=OvcJlS3excB3jnhYEzWG32VCQK0zodStiSrRfXXkqPZtu4LVEri6wuSl7MUtsbkU -->
&emsp; LeetCode上面的二叉树问题一般可以看成是简单的深度优先搜索问题，一般的实现方式是使用递归，也会有非递归的实现方法，本节主要介绍一下解决二叉树问题的几个常规方法和思路，然后会给一个从递归转换到非递归的小技巧。  

#### 1.1.3.1. 两个通用方法和思路  
&emsp; 两个通用方法和思路：拿到一道二叉树的问题，多半需要遍历这个树，只不过是在遍历的过程中，不同的题目要求做的计算不一样。  
&emsp; 这里有两个遍历方法，自顶向下的递归遍历，以及自底向上的分治。  
&emsp; 两种方法都用到了递归，在代码实现上面，差别不是特别大，但是思路却截然相反，拿树的中序遍历这道题目来作为示例。  

##### 1.1.3.1.1. 自顶向下的递归遍历

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    helper(root, result);

    return result;
}

private void helper(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }

    helper(root.left, result);
    result.add(root.val);
    helper(root.right, result);
}
```
&emsp; 代码非常的简短，上面代码的重心全放在了helper函数上，这个函数没有返回值，它做的事情也非常的简单，就是去到对应的树节点，然后把节点的值加到result中。  
&emsp; 这里要求的是树的中序遍历，因此，要先去到当前树节点的左边，把左边所有的节点的值放到result中，才会继续放当前树节点，放完当前树节点的值后，会去到右边进行同样的操作。  
&emsp; 对于这种实现方法其实有点类似于循环遍历，只不过循环遍历只作用于数组还有链表这样的线性结构，对于树的话，这里采用了递归的方式去遍历。  

##### 1.1.3.1.2. 自底向上的分治
```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
        return result;
    }

    result.addAll(inorderTraversal(root.left));
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));

    return result;
}
```
&emsp; 同一个问题，再来看看之前提到的另外一种思路实现。  
&emsp; 这里也使用了递归，但是这次的递归函数是有返回值的，而且没有将保存结果的list 传入函数。  
&emsp; 正因为是自底向上，所以对于一个树节点来说，它这里会知道它子节点的返回值，也就是子节点的记录结果，在它这里会把左右子节点的结果，和它自己本身的结果汇总，然后将汇总的结果返回给上一层节点。  
&emsp; 和之前的递归遍历的思路相比的话，代码实现上面的区别可能就是，是将result list放在参数中，还是放在返回值中，但是思考方向是截然相反的。  

##### 1.1.3.1.3. ***两种方式比较
&emsp; **这两种方法没有好坏之分，有的题目使用自顶向下递归遍历的方式会比较直接一点，比如求最大最小值，有些题目则使用自底向上分治的方式会比较好一些，比如说subtree的问题。** 对于不同的题目，需要选择不同的方法，但是思考方式可以考虑从这两个方向去思考。  
&emsp; 一般来说，二叉树问题的时间复杂度都是 O(n) ，这个时间复杂的怎么理解呢？可以看成是在每个树节点上的操作的时间复杂度是 O(1)，但是要遍历所有的节点，因此 O(1) * n = O(n)。  

#### 1.1.3.2. 递归转非递归  
&emsp; 对于树的问题，也可以使用非递归的方式求解，其实任何一个递归的解法，都可以转换为非递归，而且就性能和稳定性来说的话，非递归的方式要比递归来的好。    
&emsp; 这里给出了一个递归转非递归的通用方法，不仅仅适用于树的问题，对于任何的递归问题都适用。还是拿上面中序遍历作为例子，之前的代码实现：  

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    helper(root, result);

    return result;
}

private void helper(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }

    helper(root.left, result); // line 0
    result.add(root.val);      // line 1
    helper(root.right, result);// line 2
}
```
&emsp; 在helper函数最后 3 行代码标上了序号，后面的非递归实现的程序中会用到，这里主要是要实现helper函数中的东西。  
&emsp; **非递归代码如下：**  

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    Stack<Integer> systemStack = new Stack<>(); // 表示函数进度
    Stack<TreeNode> paramStack = new Stack<>(); // 表示函数输入参数

    systemStack.push(0);
    paramStack.push(root);

    while (!systemStack.isEmpty()) {
        int curLine = systemStack.pop();
        TreeNode curParam = paramStack.peek();

        // 提前将当前进度后移，因为后面可能会有其他函数入栈
        systemStack.push(curLine + 1);

        if (curLine == 0) {
            if (curParam.left != null) {
                systemStack.push(0);
                paramStack.push(curParam.left);                    
            }
        } else if (curLine == 1) {
            result.add(curParam.val);
        } else if (curLine == 2) {
            if (curParam.right != null) {
                systemStack.push(0);
                paramStack.push(curParam.right);
            }
        } else {
            systemStack.pop();
            paramStack.pop();
        }
    }

    return result;
}
```
&emsp; 一般来说，用非递归写递归，都需要用到一个数据结构-栈。  
&emsp; 这个好解释，递归的解法是利用了系统中提供的函数栈，非递归需要手动创建这么一个数据结构，但是可能会问的是，这里为什么要用到两个栈？  
&emsp; 可以这样认为，一个栈用来表示函数的运行进度，里面的元素表示此时该函数运行到了第几行代码，另一个栈用来记录函数的传入参数，当然也可以把这两个栈合成一个栈，里面装的是封装好的对象。  

    首先，根据之前的递归解法，最开始是把 root 传入 helper 函数，因此这时也把 root 加入函数栈，另外一个表示函数进度的栈往里面添加 0，表示当前函数运行到了第 0 行，然后就是 while 循环里面的东西，while 循环一开始我们就获取当前函数的输入参数和进度，然后根据函数的进度去看需要执行哪一段代码，因为有的代码会继续往栈里面添加函数，因此，需要提前把函数进度往后移动，可以对应之前的递归的代码和我标的序号，可以看到，整个 if-else if…else 部分就表示了之前的递归函数中的代码，只不过这里需要根据函数的进度去判断它要执行哪一行。
    使用这种方法后，递归转非递归只需要往上套就行，不需要单独分析。
