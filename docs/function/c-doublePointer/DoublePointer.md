
<!-- TOC -->

- [1. 双指针法](#1-双指针法)
    - [1.1. 什么是双指针？](#11-什么是双指针)
    - [1.2. 双指针法介绍](#12-双指针法介绍)
    - [1.3. 相向指针/快慢指针](#13-相向指针快慢指针)
    - [1.4. 对撞指针](#14-对撞指针)
    - [1.5. 两个数组的指针](#15-两个数组的指针)

<!-- /TOC -->


# 1. 双指针法
<!-- 
持续更新：
宫水
https://mp.weixin.qq.com/mp/appmsgalbum?action=getalbum&__biz=MzU4NDE3MTEyMA==&scene=1&album_id=1748659352518868992&count=3#wechat_redirect

题解-西法的刷题秘籍-2021-04-20 第315页 
-->


<!-- ~~

算法一招鲜——双指针问题
https://zhuanlan.zhihu.com/p/71643340
-->


&emsp; `双重for循环可以使用 "相向指针 + 单循环" 替代。`  

## 1.1. 什么是双指针？  
&emsp; 双指针主要用于遍历数组，两个指针指向不同的元素，从而协同完成任务。`也可以延伸到多个数组的多个指针。`  
1. 若两个指针指向同一数组，遍历方向相同且不会相交，则也称为滑动窗口（两个指针包围的区域即为当前的窗口），`经常用于区间搜索`。  
&emsp; 双指针：按照指针移动方向，分为相向指针（快慢指针）、对撞指针；双指针关注指针端点，两指针形成的区间，又叫窗口。  
&emsp; ~~双指针，指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个相同方向（快慢指针）或者相反方向（对撞指针）的指针进行扫描，从而达到相应的目的。~~  
&emsp; ~~换言之，双指针法充分使用了数组有序这一特征，从而在某些情况下能够简化一些运算。`  
&emsp; ~~双指针技巧还可以分为两类，一类是「快慢指针」，另一类是「左右指针」。前者解决主要解决链表中的问题，比如典型的判定链表中是否包含环；后者主要解决数组（或者字符串）中的问题，比如二分查找。~~  
2. 若两个指针指向同一数组，但是遍历方向相反，则可以用来进行搜索，待搜索的数组往往是排好序的。  


## 1.2. 双指针法介绍
<!-- 
https://www.pianshen.com/article/17581087109/
-->
&emsp; 双指针法的时间复杂度一般是O(n)，可以`作为暴力二次循环的优化解法`。利用双指针法可以不用遍历每个子数组而只要循环数组一次或者两次。有点类似二分查找，双指针法也是通过一步步缩小范围来确定答案的。只不过二分查找是一个指针双向移动，而双指针是两个指针单向移动。  
&emsp; 二分查找用来查找一个变量，而双指针法一般用于求解由两个变量组成的子串子数组问题。拿这道题目为例，子串可以变长也可以变短，而变长和变短如果使用一个指针则会返回之前的状态陷入循环，所以需要双指针来从不同的角度使数组变长变短。  
&emsp; 两个指针的位置，移动方向都不是固定的，可以向相同方向移动，也可以相反，也可以从任意位置开始移动，视具体情况而定，但是，每个指针只能往一个方向移动，而且它们对待定结果的影响是相反的，比如右指针使窗口变长，左指针使它变短。  


## 1.3. 相向指针/快慢指针  
&emsp; 快慢指针也是双指针，但是两个指针从同一侧开始遍历数组，将这两个指针分别定义为快指针（fast）和慢指针（slow），两个指针以不同的策略移动，直到两个指针的值相等（或其他特殊条件）为止，如fast每次增长两个，slow每次增长一个。  

&emsp; 比如LeetCode 26 删除排序数组中的重复项，这里还是定义快慢两个指针。快指针每次增长一个，慢指针只有当快慢指针上的值不同时，才增长一个（由于是有序数组，快慢指针值不等说明找到了新值）。  

&emsp; 真实代码：  

```
var removeDuplicates = function (nums) {
  if (nums.length === 0) {
    return 0;
  }
  let slow = 0;
  for (let fast = 0; fast < nums.length; fast++) {
    if (nums[fast] !== nums[slow]) {
      slow++;
      nums[slow] = nums[fast];
    }
  }
  return slow + 1;
};
```



## 1.4. 对撞指针
&emsp; 对撞指针是指在有序数组中，将指向最左侧的索引定义为左指针(left)，最右侧的定义为右指针(right)，然后从两头向中间进行数组遍历。  
&emsp; `对撞数组适用于有序数组，`也就是说当你遇到题目给定有序数组时，应该第一时间想到用对撞指针解题。  
&emsp; 伪代码大致如下：

```
function fn (list) {
  var left = 0;
  var right = list.length - 1;

  //遍历数组
  while (left <= right) {
    left++;
    // 一些条件判断 和处理
    ... ...
    right--;
  }
}
```

&emsp; 举个LeetCode上的例子：  
&emsp; 以LeetCode 881救生艇问题为例  
&emsp; 由于本题只要求计算出最小船数，所以原数组是否被改变，和元素索引位置都不考虑在内，所以可以先对于给定数组进行排序，再从数组两侧向中间遍历。所以解题思路如下：  

1. 对给定数组进行升序排序  
2. 初始化左右指针
3. 每次都用一个”最重的“和一个”最轻的“进行配对，如果二人重量小于Limit，则此时的”最轻的“上船，即（left++）。不管”最轻的“是否上船，”最重的“都要上船，即（right--）并且所需船数量加一，即（num++）  

&emsp; 代码如下：  

```
var numRescueBoats = function(people, limit) {
  people.dSort((a, b) => (a - b));
  var num = 0
  let left = 0
  let right = people.length - 1
  while (left <= right) {
    if ((people[left] + people[right]) <= limit) {
      left++
    }
    right--
    num++
  }
  return num
};
```



## 1.5. 两个数组的指针  



