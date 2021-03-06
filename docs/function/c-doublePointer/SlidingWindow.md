
<!-- TOC -->

- [1. 滑动窗口](#1-滑动窗口)
    - [1.1. 双指针与滑动窗口](#11-双指针与滑动窗口)
    - [1.2. 基本示例](#12-基本示例)
    - [1.3. 滑动窗口模版](#13-滑动窗口模版)

<!-- /TOC -->

# 1. 滑动窗口
<!-- 
算法题单 | 滑动窗口 
https://mp.weixin.qq.com/s/H88llGFboj_3nRhakb9GPw

滑动窗口算法
https://www.cnblogs.com/huansky/p/13488234.html
https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect
-->

&emsp; 滑动窗口 求解 最xx的连续xx。  


滑动窗口模版  
* todo 现在开始套模板，只需要思考以下四个问题：  
* todo 1、当移动right扩大窗口，即加入字符时，应该更新哪些数据？  
* todo 2、什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？  
* todo 3、当移动left缩小窗口，即移出字符时，应该更新哪些数据？  
* todo todo 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？  


## 1.1. 双指针与滑动窗口
&emsp; 双指针 + 哈希表解法（滑动窗口）  

&emsp; 双指针

* 计算过程仅与两端点相关的称为双指针。
* 不固定大小。
* 双指针是解决问题的一种方法。
* 双指针可以同向移动可以双向移动。
* 同向移动的双指针和滑动窗口没有任何联系


&emsp; 滑动窗口

* 计算过程与两端点表示的区间相关的称为滑动窗口。
* 默认固定大小的窗口，在一些条件触发的情况下，可能会将其大小进行修改。
* 滑动窗口本身并不是解决问题的一种方法（或者说算法），它其实就是问题本身。
* 滑动窗口一定是同向移动的。
* 滑动窗口是一类问题，不同的问题需要使用不同的算法和数据结构来解决。


&emsp; `滑动窗口关注双指针的区间，一般用于解决数组连续问题，例如...`  

--------------
&emsp; `滑动窗⼝主要⽤来处理连续问题。⽐如题⽬求解“连续⼦串 xxxx”，“连续⼦数组 xxxx”，就应该可以想到滑动窗⼝。`能不能解决另说，但是这种敏感性还是要有的。  
&emsp; 从类型上说主要有：  

* 固定窗⼝⼤⼩ 
* 窗⼝⼤⼩不固定，求解最⼤的满⾜条件的窗⼝ 
* 窗⼝⼤⼩不固定，求解最⼩的满⾜条件的窗⼝（上⾯的 209 题就属于 这种） 

&emsp; 后⾯两种我们统称为可变窗⼝ 。当然不管是哪种类型基本的思路都是⼀样的，不⼀样的仅仅是代码细节。  


## 1.2. 基本示例
<!-- 
https://www.cnblogs.com/huansky/p/13488234.html
-->
&emsp; 如下图所示，设定滑动窗口（window）大小为 3，当滑动窗口每次划过数组时，计算当前滑动窗口中元素的和，得到结果 res。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-59.png)  
&emsp; 可以用来解决一些查找满足一定条件的连续区间的性质（长度等）的问题。由于区间连续，因此当区间发生变化时，可以通过旧有的计算结果对搜索空间进行剪枝，这样便减少了重复计算，降低了时间复杂度。`往往类似于“ 请找到满足 xx 的最 x 的区间（子串、子数组）的 xx ”这类问题都可以使用该方法进行解决。`  
&emsp; 需要注意的是，滑动窗口算法更多的是一种思想，而非某种数据结构的使用。  


## 1.3. 滑动窗口模版
&emsp; 滑动窗口模板伪代码   

```text
初始化慢指针 = 0
初始化 ans

for 快指针 in 可迭代集合 
    更新窗⼝内信息
    while 窗⼝内不符合题意 
        扩展或者收缩窗⼝
        慢指针移动 
    更新答案 
返回 ans
```

----------

```text
int left = 0, right = 0;

while (right < s.size()) {
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

----------

```text
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;

    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        printf("window: [%d, %d)\n", left, right);
        /********************/

        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

--------------


