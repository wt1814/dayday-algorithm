


# 队列
<!-- 
https://www.cnblogs.com/ysocean/p/7921930.html
https://www.jianshu.com/p/8439a9854932
-->
&emsp; **队列的实现：** 与栈类似，队列即可以用数组实现，也可以用链表实现。  
&emsp; **队列的基本操作：** 队列有两种操作入队(enqueue)、出队(dequeue)。  
&emsp; 如果队列不断出队，队头左边的空间失去作用，那队列的容量越来越小。 **<font color = "red">用数组实现的队列可以采用循环队列的方式来维持队列容量的恒定。</font>**  
&emsp; **队列的应用：** 队列的输出顺序和输入顺序相同，所以队列通常用于对“历史”的回放，也就是按照“历史”顺序，把“历史”重演一遍。

&emsp; **<font color = "red">双端队列，</font>** 可以结合栈和队列的特点，即可以先入先出，也可以先入后出。  
&emsp; **<font color = "red">优先级队列，</font>** 遵循的不是先入先出，而是谁的优先级最高，谁先出队列。优先级队列是基于二叉堆来实现的。  
&emsp; 队列通常用于对“历史”的回放，也就是按照“历史”顺序，把“历史”重演一遍。  


## 单调队列
<!-- 
https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html
-->

## 优先级队列
&emsp; [优先级队列](/docs/function/d-structure/priorityQueue.md)

