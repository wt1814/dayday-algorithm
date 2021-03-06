

# 算法基础  

## print 和 println的区别
&emsp; println 输出字符后，下一个输出的字符会换行展示  
&emsp; print 输出字符后，下一个输出字符不会会换展示  

```java
System.out.print(stack.pop());
// print 输出字符后，下一个输出字符不会会换展示
// 输出 uoy era woh

aStack
// println 输出字符后，下一个输出的字符会换行展示
// 输出u
//o
//y
//
//e
//r
//a
//
//w
//o
//h
```

## i++ 与 ++i 
<!-- 
&emsp; i++ 与 ++i 的主要区别有两个：  
1. i++ 返回原来的值，++i 返回加1后的值。  
2. i++ 不能作为左值，而++i 可以。  
-->


## for与while循环
<!-- 
https://blog.csdn.net/sixabs/article/details/82708318
-->

```text
for(int k=i*2+1;k<length;k=k*2+1){ 

}

while (childIndex < length) {
    //todo 选取孩子结点的左孩子结点，继续向下筛选
    //todo 对比for循环的区别，while循环此处要编码修改指针
    parentIndex = childIndex;
    childIndex = 2 * childIndex + 1;
}
```

&emsp; for循环，在迭代条件里更新下标；while循环需要额外编码实现指针移动。  


## ~~递归和迭代~~
<!-- 
https://zhidao.baidu.com/question/1638784639202969220.html
-->  
&emsp; 刷题过程中，发现部分题型即可以用递归解决，也可以用迭代解决。  

&emsp; “递归”和“迭代”的区别如下：  

1. 递归的基本概念:程序调用自身的编程技巧称为递归，是函数自己调用自己。一个函数在其定义中直接或间接调用自身的一种方法，它通常把一个大型的复杂的问题转化为一个与原问题相似的规模较小的问题来解决，可以极大的减少代码量。递归的能力在于用有限的语句来定义对象的无限集合。  
2. 迭代：利用变量的原值推算出变量的一个新值。如果递归是自己调用自己的话，迭代就是A不停的调用B。  
3. 递归中一定有迭代，但是迭代中不一定有递归，大部分可以相互转换。能用迭代的不用递归，递归调用函数，浪费空间，并且递归太深容易造成堆栈的溢出。  
