
<!-- TOC -->

- [1. 链表](#1-链表)
    - [1.1. 单向链表](#11-单向链表)
    - [1.2. 基本操作](#12-基本操作)
    - [1.3. 两个考点](#13-两个考点)
        - [1.3.1. 指针的修改](#131-指针的修改)
        - [1.3.2. 链表的拼接](#132-链表的拼接)
    - [1.4. 三个注意](#14-三个注意)
        - [1.4.1. 环](#141-环)
        - [1.4.2. 边界](#142-边界)
        - [1.4.3. 前后序（递归使用）](#143-前后序递归使用)
    - [1.5. 四个技巧](#15-四个技巧)
        - [1.5.1. 引入哑节点（虚拟头）](#151-引入哑节点虚拟头)
        - [1.5.2. 快慢指针](#152-快慢指针)
            - [1.5.2.1. 寻找/删除第K个结点](#1521-寻找删除第k个结点)
            - [1.5.2.2. 有关链表环问题的相关解法](#1522-有关链表环问题的相关解法)
        - [1.5.3. 穿针引线](#153-穿针引线)
        - [1.5.4. 先穿再排后判空](#154-先穿再排后判空)
            - [1.5.4.1. 先穿](#1541-先穿)
            - [1.5.4.2. 再排](#1542-再排)
            - [1.5.4.3. 后判空](#1543-后判空)
    - [1.6. 链表翻转](#16-链表翻转)
        - [1.6.1. 递归翻转链表](#161-递归翻转链表)
        - [1.6.2. 非递归翻转链表(迭代解法)](#162-非递归翻转链表迭代解法)
        - [1.6.3. 变形题](#163-变形题)

<!-- /TOC -->

# 1. 链表
<!-- 
几乎刷完了力扣所有的链表题，我发现了这些东西。。。
https://mp.weixin.qq.com/s/Ym7MhhJ--NcaRRnj1y1vFA

 2021 秋招算法高频题汇总 - 链表篇 
https://mp.weixin.qq.com/s/pJGRhBFhlLoHrYDZ4sUtRA
-->

&emsp; 参考`力扣加加`链表专题  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-58.png)  
&emsp; 由于在进行链表操作时，尤其是删除节点时，经常会因为对当前节点进行操作而导致内存或指针出现问题。有两个小技巧可以解决这个问题：一是尽量处理当前节点的下一个节点而非当前节点本身，二是建立一个虚拟节点 (dummy node)，使其指向当前链表的头节点，这样即使原链表所有节点全被删除，也会有一个 dummy 存在，返回 dummy->next 即可。  

<!-- 
 23张图！万字详解「链表」，从小白到大佬！ 
 https://mp.weixin.qq.com/s/BRcsDO9aAKtYWduCtST9gA
-->
&emsp; 链表分类：单向链表、双端链表、有序链表、双向链表。  
&emsp; `链表反转两种方式：1).指针反转；2).类似头插法`  

## 1.1. 单向链表  
&emsp; 链节点可以是一个单独的类，也可以是内部类。  

```java
public class SingleLinkedList {
    private int size;//链表节点的个数
    private Node head;//头节点

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    //链表的每个节点类
    private class Node{
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接

        public Node(Object data){
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj){
        Node newHead = new Node(obj);
        if(size == 0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public Node find(Object obj){
        Node current = head;
        int tempSize = size;
        while(tempSize > 0){
            if(obj.equals(current.data)){
                return current;
            }else{
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }



    //判断链表是否为空
    public boolean isEmpty(){
        return (size == 0);
    }

    //显示节点信息
    public void display(){
        if(size >0){
            Node listNode = head;
            int tempSize = size;
            if(tempSize == 1){//当前链表只有一个节点
                System.out.println("["+listNode.data+"]");
                return;
            }
            while(tempSize>0){
                if(listNode.equals(head)){
                    System.out.print("["+listNode.data+"->");
                }else if(listNode.next == null){
                    System.out.print(listNode.data+"]");
                }else{
                    System.out.print(listNode.data+"->");
                }
                listNode = listNode.next;
                tempSize--;
            }
            System.out.println();
        }else{//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }
    }

}
```

&emsp; **<font color = "red">删除节点两种情况：第一个节点，后面节点。</font>**    

```java
//删除指定的元素，删除成功返回true
public boolean delete(Object value){
    if(size == 0){
        return false;
    }
    Node current = head;
    Node previous = head;
    while(current.data != value){
        if(current.next == null){
            return false;
        }else{
            previous = current;
            current = current.next;
        }
    }
    //如果删除的节点是第一个节点
    if(current == head){
        head = current.next;
        size--;
    }else{//删除的节点不是第一个节点
        previous.next = current.next;
        size--;
    }
    return true;
}
```



## 1.2. 基本操作  
<!-- 

带头节点的单链表及其基本操作(Java实现)
https://blog.csdn.net/m0_37572458/article/details/78199507
java实现无头单链表
https://blog.csdn.net/zhizhengguan/article/details/105967696
-->

&emsp; 插⼊插⼊只需要考虑要插⼊位置前驱节点和后继节点（双向链表的情况下需要 更新后继节点）即可，其他节点不受影响，因此在给定指针的情况下插⼊ 的操作时间复杂度为 O(1) 。这⾥给定指针中的指针指的是插⼊位置的前 驱节点。  
&emsp; 伪代码：  

```text
temp = 待插⼊位置的前驱节点.next
待插⼊位置的前驱节点.next = 待插⼊指针 
待插⼊指针.next = temp
```

&emsp; 如果没有给定指针，我们需要先遍历找到节点，因此最坏情况下时间复杂 度为 O(N) 。 提示 1: 考虑头尾指针的情况。  

## 一个原则
&emsp; 一个原则就是 「画图」，尤其是对于新手来说。不管是简单题还是难题一定要画图，这是贯穿链表题目的一个准则。  
&emsp; 画图可以减少我们的认知负担，这其实和打草稿，备忘录道理是一样的，将存在脑子里的东西放到纸上。举一个不太恰当的例子就是你的脑子就是 CPU，脑子的记忆就是寄存器。寄存器的容量有限，我们需要把不那么频繁使用的东西放到内存，把寄存器用在真正该用的地方，这个内存就是纸或者电脑平板等一切你可以画图的东西。  
&emsp; 画的好看不好看都不重要，能看清就行了。用笔随便勾画一下， 能看出关系就够了。  


## 1.3. 两个考点
&emsp; 链表的考点很单一。除了设计类题目，其考点无法就两点：  

* 指针的修改
* 链表的拼接


### 1.3.1. 指针的修改
&emsp; 其中指针修改最典型的就是链表反转。其实链表反转不就是修改指针么？  
&emsp; 对于数组这种支持随机访问的数据结构来说， 反转很容易， 只需要头尾不断交换即可。  


### 1.3.2. 链表的拼接  
&emsp; 大家有没有发现链表总喜欢穿来穿去（拼接）的？比如反转链表 II，再比如合并有序链表等。  
&emsp; 为啥链表总喜欢穿来穿去呢？实际上，这就是链表存在的价值，这就是设计它的初衷呀！  
&emsp; 链表的价值就在于其「不必要求物理内存的连续性，以及对插入和删除的友好」。这在文章开头的链表和数组的物理结构图就能看出来。  
&emsp; 因此链表的题目很多拼接的操作。  

## 1.4. 三个注意
&emsp; 链表最容易出错的地方就是我们应该注意的地方。链表最容易出的错 90 % 集中在以下三种情况：  

* 出现了环，造成死循环。
* 分不清边界，导致边界条件出错。
* 搞不懂递归怎么做

### 1.4.1. 环


### 1.4.2. 边界
&emsp; 很多人错的是没有考虑边界。一个考虑边界的技巧就是看题目信息。  

* 如果题目的头节点可能被移除，那么考虑使用虚拟节点，这样「头节点就变成了中间节点」，就不需要为头节点做特殊判断了。  
* 题目让你返回的不是原本的头节点，而是尾部节点或者其他中间节点，这个时候要注意指针的变化。  

&emsp; 以上两者部分的具体内容，我们在稍微讲到的虚拟头部分讲解。大家留个印象即可。  

### 1.4.3. 前后序（递归使用）
<!-- 
https://mp.weixin.qq.com/s/Ym7MhhJ--NcaRRnj1y1vFA
-->



## 1.5. 四个技巧  
&emsp; **<font color = "red">链表常见解题思路有翻转和快慢指针。</font>**  

### 1.5.1. 引入哑节点（虚拟头）
&emsp; 哑节点（dummy node）是初始值为NULL的节点，创建在使用到链表的函数中，可以起到避免处理头节点为空的边界问题的作用，减少代码执行异常的可能性。  
&emsp; 也就是说，哑节点的使用可以对代码起到简化作用（省略当函数的入口参数为空时的判断）。  




### 1.5.2. 快慢指针  
&emsp; **<font color = "clime">可以用快慢指针解决以下两大类问题：</font>**  
1. 寻找/删除第K个结点  
2. 有关链表环问题的相关解法    

#### 1.5.2.1. 寻找/删除第K个结点  

    LeetCode 876：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。  

&emsp; 这里引入快慢指针，主要有三步 1、快慢指针同时指向 head 的后继结点 2、慢指针走一步，快指针走两步 3、不断地重复步骤2，什么时候停下来呢，这取决于链表的长度是奇数还是偶数。  

* 如果链表长度为奇数，当 fast.next = null 时，slow 为中间结点   
![Alt Text](https://gitee.com/wt1814/pic-host/raw/master/algorithm/641.gif)  
* 如果链表长度为偶数，当 fast = null 时，slow 为中间结点  
![Alt Text](https://gitee.com/wt1814/pic-host/raw/master/algorithm/642.gif)  

&emsp; 由以上分析可知：当 fast = null 或者 fast.next = null 时，此时的 slow 结点即为要求的中间结点，否则不断地重复步骤 2， 知道了思路，代码实现就简单了  

```java
/**
 * 使用快慢指针查找找到中间结点
 * @return
 */
public Node findMiddleNodeWithSlowFastPointer() {
    Node slow = head.next;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
        // 快指针走两步
        fast = fast.next.next;
        // 慢指针走一步
        slow = slow.next;
    }
    // 此时的 slow 结点即为哨兵结点
    return slow;
}
```

#### 1.5.2.2. 有关链表环问题的相关解法  
&emsp; 接下来看如何用快慢指针来判断链表是否有环，这是快慢指针最常见的用法。  
&emsp; 判断链表是否有环，如果有，找到环的入口位置，要求空间复杂度为O(1)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-20.png)  
&emsp; 首先要看如果链表有环有什么规律，如果从 head 结点开始遍历，则这个遍历指针一定会在以上的环中绕圈子，所以可以分别定义快慢指针，慢指针走一步，快指针走两步， 由于最后快慢指针在遍历过程中一直会在圈中里绕，且快慢指针每次的遍历步长不一样，所以它们在里面不断绕圈子的过程一定会相遇，就像 5000 米长跑，一人跑的快，一人快的慢，跑得快的人一定会追上跑得慢的(即套圈)。  

&emsp; 简单证明一下  
1. 假如快指针离慢指针相差一个结点，则再一次遍历，慢指针走一步，快指针走两步，相遇    
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-21.png)   
2. 假如快指针离慢指针相差两个结点，则再一次遍历，慢指针走一步，快指针走两步，相差一个结点，转成上述 1 的情况   
3. 假如快指针离慢指针相差 N 个结点(N大于2)，则下一次遍历由于慢指针走一步，快指针走两步，所以相差 N+1-2 = N-1 个结点，发现了吗，相差的结点从 N 变成了 N-1，缩小了！不断地遍历，相差的结点会不断地缩小，当 N 缩小为 2 时，即转为上述步骤 2 的情况，由此得证，如果有环，快慢指针一定会相遇！   

        画外音：如果慢指针走一步，快指针走的不是两步，而是大于两步，会有什么问题，大家可以考虑一下

```java
/**
 * 判断是否有环，返回快慢指针相遇结点，否则返回空指针
 */
public Node detectCrossNode() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        
        if (fast == null) {
            return null;
        }

        if (slow == fast) {
            return slow;
        }
    }
    return  null;
}
```
&emsp; 判断有环为啥要返回相遇的结点，而不是返回 true 或 false 呢。 因为题目中还有一个要求，判断环的入口位置，就是为了这个做铺垫的，一起来看看怎么找环的入口，需要一些分析的技巧。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-22.png)  
&emsp; 假设上图中的 7 为快慢指针相遇的结点，不难看出慢指针走了 L + S 步，快指针走得比慢指针更快，它除了走了 L + S 步外，还额外在环里绕了 n  圈，所以快指针走了 L+S+nR 步(R为图中环的长度)，另外每遍历一次，慢指针走了一步，快指针走了两步，所以快指针走的路程是慢指针的两倍，即 2 (L+S) = L+S+nR，即  L+S = nR  

* 当 n = 1 时，则 L+S = R 时，则从相遇点 7 开始遍历走到环入口点 2 的距离为 R - S = L，刚好是环的入口结点，而 head 与环入口点 2 的距离恰好也为 L，所以只要在头结点定义一个指针，在相遇点(7)定义另外一个指针，两个指针同时遍历，每次走一步，必然在环的入口位置 2 相遇
* 当 n > 1 时，L + S = nR，即 L = nR - S，  nR-S 怎么理解？可以看作是指针从结点  7 出发，走了 n 圈后，回退 S 步，此时刚好指向环入口位置，也就是说如果设置一个指针指向 head(定义为p1)， 另设一个指针指向 7(定义为p2)，不断遍历，p2 走了 nR-S 时(即环的入口位置)，p1也刚好走到这里(此时 p1 走了 nR-S =  L步，刚好是环入口位置)，即两者相遇！

&emsp; 综上所述，要找到入口结点，只需定义两个指针，一个指针指向head， 一个指针指向快慢指向的相遇点，然后这两个指针不断遍历(同时走一步)，当它们指向同一个结点时即是环的入口结点  

```java
/**
* 到入口结点
**/
public Node getRingEntryNode() {
    // 获取快慢指针相遇结点
    Node crossNode = detectCrossNode();

    // 如果没有相遇点，则没有环
    if (crossNode == null) {
        return null;
    }

    // 分别定义两个指针，一个指向头结点，一个指向相交结点
    Node tmp1 = head;
    Node tmp2 = crossNode;

    // 两者相遇点即为环的入口结点
    while (tmp1.data != tmp2.data) {
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;
    }
    return tmp1;
}
```

### 1.5.3. 穿针引线
&emsp; 这是链表的第二个考点 - 「拼接链表」。我在 25. K 个一组翻转链表，61. 旋转链表 和 92. 反转链表 II都用了这个方法。穿针引线是我自己起的一个名字，起名字的好处就是方便记忆。  
&emsp; 这个方法通常不是最优解，但是好理解，方便书写，不易出错，推荐新手用。  


### 1.5.4. 先穿再排后判空
这是四个技巧的最后一个技巧了。虽然是最后讲，但并不意味着它不重要。相反，它的实操价值很大。

继续回到上面讲的链表反转题。

```text
cur = head
pre = None
while cur != tail:
    # 留下联系方式
    next = cur.next
    # 修改指针
    cur.next = pre
    # 继续往下走
    pre = cur
    cur = next
# 反转后的新的头尾节点返回出去
```

什么时候需要判断 next 是否存在，上面两行代码先写哪个呢？

是这样？

```text
    next = cur.next
    cur.next = pre
```

还是这样？

```text
    cur.next = pre
    next = cur.next
```

#### 1.5.4.1. 先穿
&emsp; 我给你的建议是：先穿。这里的穿是修改指针，包括反转链表的修改指针和穿针引线的修改指针。「先别管顺序，先穿」。  

#### 1.5.4.2. 再排
&emsp; 穿完之后，代码的总数已经确定了，无非就是排列组合让代码没有 bug。  
&emsp; 因此第二步考虑顺序，那上面的两行代码哪个在前？应该是先 next = cur.next ，原因在于后一条语句执行后 cur.next 就变了。由于上面代码的作用是反转，那么其实经过 cur.next = pre 之后链表就断开了，后面的都访问不到了，也就是说此时你「只能返回头节点这一个节点」。  
&emsp; 实际上，有假如有十行「穿」的代码，我们很多时候没有必要全考虑。我们「需要考虑的仅仅是被改变 next 指针的部分」。比如 cur.next = pre 的 cur 被改了 next。因此下面用到了 cur.next 的地方就要考虑放哪。其他代码不需要考虑。  

#### 1.5.4.3. 后判空



## 1.6. 链表翻转  
<!-- 
链表反转的姿势
https://mp.weixin.qq.com/s/YVQvbhO0HJtnrocVg8-qmQ
-->

&emsp; 什么是链表的翻转：给定链表 head-->4--->3-->2-->1，将其翻转成 head-->1-->2-->3-->4。翻转链表可以用非递归和递归这两种方式来解题。  

### 1.6.1. 递归翻转链表  
&emsp; 首先要查看翻转链表是否符合递归规律：问题可以分解成具有相同解决思路的子问题，子子问题...，直到最终的子问题再也无法分解。  
&emsp; 要翻转 head--->4--->3-->2-->1 链表，不考虑 head 结点，分析 4--->3-->2-->1，仔细观察，发现只要先把 3-->2-->1 翻转成 3<----2<----1，之后再把 3 指向 4 即可(如下图示)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-14.png)  
<center>图：翻转链表主要三步骤</center>  

&emsp; 只要按以上步骤定义好这个翻转函数的功能即可， 这样由于子问题与最初的问题具有相同的解决思路，拆分后的子问题持续调用这个翻转函数即可达到目的。  
&emsp; 注意看上面的步骤1，问题的规模是不是缩小了(如下图)，从翻转整个链表变成了只翻转部分链表！问题与子问题都是从某个结点开始翻转，具有相同的解决思路，另外当缩小到只翻转一个结点时，显然是终止条件，符合递归的条件！之后的翻转 3-->2-->1， 2-->1 持续调用这个定义好的递归函数即可!  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-15.png)  
&emsp; 既然符合递归的条件，那就可以套用递归四步曲来解题了(注意翻转之后 head 的后继节点变了，需要重新设置！别忘了这一步)  

1. 定义递归函数，明确函数的功能 根据以上分析，这个递归函数的功能显然是翻转某个节点开始的链表，然后返回新的头结点  

```java
/**
 * 翻转结点 listNode 开始的链表
 */
public Node invertLinkedList(Node listNode) {
}
```
2. 寻找递推公式上文中已经详细画出了翻转链表的步骤，简单总结一下递推步骤如下  

    * 针对结点 listNode (值为 4)，先翻转 listNode 之后的结点 invert(listNode->next)，翻转之后 4--->3--->2--->1 变成了 4--->3<---2<---1
    * 再把 listNode 节点的下个节点(3)指向 listNode，listNode 的后继节点设置为空(避免形成环)，此时变成了 4<---3<---2<---1
    * 返回新的头结点，因为此时新的头节点从原来的 4 变成了 1，需要重新设置一下head
3. 将递推公式代入第一步定义好的函数中，如下 (invertLinkedList)

```java
/**
 * 递归翻转结点 listNode 开始的链表
 */
public Node invertLinkedList(Node listNode) {
    if (listNode.next == null) {
        return listNode;
    }

    // 步骤 1: 先翻转 listNode 之后的链表
    Node newHead = invertLinkedList(listNode.next);

    // 步骤 2: 再把原 listNode 节点后继结点的后继结点指向 listNode (4)，listNode 的后继节点设置为空(防止形成环)
    listNode.next.next = listNode;
    listNode.next = null;

    // 步骤 3: 返回翻转后的头结点
    return newHead;
}

public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    int[] arr = {4，3，2，1};
    for (int i = 0; i < arr.length; i++) {
        linkedList.addNode(arr[i]);
    }
    Node newHead = linkedList.invertLinkedList(linkedList.head.next);
    // 翻转后别忘了设置头结点的后继结点！
    linkedList.head.next = newHead;
    linkedList.printList();      // 打印 1，2，3，4
}
```
        画外音：翻转后由于 head 的后继结点变了，别忘了重新设置！

4. 计算时间/空间复杂度。由于递归调用了 n 次 invertLinkedList 函数，所以时间复杂度显然是 O(n)，空间复杂度呢，没有用到额外的空间，但是由于递归调用了 n 次 invertLinkedList 函数，压了 n 次栈，所以空间复杂度也是 O(n)。  

&emsp; 递归一定要从函数的功能去理解，从函数的功能看，定义的递归函数清晰易懂，定义好了之后，由于问题与被拆分的子问题具有相同的解决思路，所以子问题只要持续调用定义好的功能函数即可，切勿层层展开子问题，此乃递归常见的陷阱！仔细看函数的功能，其实就是按照下图实现的。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-16.png)  

### 1.6.2. 非递归翻转链表(迭代解法)  
&emsp; 递归比较容易造成栈溢出，所以如果有其他时间/空间复杂度相近或更好的算法，应该优先选择非递归的解法，那看看如何用迭代来翻转链表，主要思路如下  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-17.png)  
&emsp; 步骤 1： 定义两个节点：pre， cur ，其中 cur 是 pre 的后继结点，如果是首次定义， 需要把 pre 指向 cur 的指针去掉，否则由于之后链表翻转，cur 会指向 pre， 就进行了一个环(如下)，这一点需要注意  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-18.png)  
&emsp; 步骤2：知道了cur 和 pre，翻转就容易了，把 cur 指向 pre 即可，之后把 cur 设置为 pre ，cur 的后继结点设置为 cur 一直往前重复此步骤即可，完整动图如下  
![Alt Text](https://gitee.com/wt1814/pic-host/raw/master/algorithm/640.gif)  
&emsp; 注意：同递归翻转一样，迭代翻转完了之后 head 的后继结点从 4 变成了 1，记得重新设置一下。  

&emsp; 知道了解题思路，实现代码就容易多了，直接上代码  

```java
/**
 * 迭代翻转
 */
public void iterationInvertLinkedList() {
    // 步骤 1
    Node pre = head.next;
    Node cur = pre.next;
    pre.next = null;

    while (cur != null) {
        /**
         * 务必注意：在 cur 指向 pre 之前一定要先保留 cur 的后继结点，不然 cur 指向 pre 后就再也找不到后继结点了
         * 也就无法对 cur 后继之后的结点进行翻转了
         */
        Node next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    // 此时 pre 为头结点的后继结点
    head.next = pre;
}
```
&emsp; 用迭代的思路来做由于循环了 n 次，显然时间复杂度为 O(n)，另外由于没有额外的空间使用，也未像递归那样调用递归函数不断压栈，所以空间复杂度是 O(1)，对比递归，显然应该使用迭代的方式来处理！

### 1.6.3. 变形题  
......
<!--
一文学会链表解题 
https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483899&idx=1&sn=ab5b06d99e9652826ed9ed33763e1371&scene=21#wechat_redirect
-->




