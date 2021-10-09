

<!-- TOC -->

- [1. 动态规划](#1-动态规划)
    - [1.1. ~~动态规划基本概念-百度百科~~](#11-动态规划基本概念-百度百科)
        - [1.1.1. 能用动态规划解决的问题的特点](#111-能用动态规划解决的问题的特点)
        - [1.1.2. 动态规划术语](#112-动态规划术语)
    - [1.2. 入门案例走进动态规划](#12-入门案例走进动态规划)
    - [1.3. 动态规划解题步骤小结](#13-动态规划解题步骤小结)
        - [1.3.1. 解题步骤一](#131-解题步骤一)
        - [1.3.2. 解题步骤二](#132-解题步骤二)
        - [1.3.3. 解题步骤三](#133-解题步骤三)
    - [1.4. 解题模版](#14-解题模版)
        - [1.4.1. 解题模板](#141-解题模板)
        - [1.4.2. 解题模板使用-动态规划背包问题](#142-解题模板使用-动态规划背包问题)
    - [1.5. 动态规划解题](#15-动态规划解题)

<!-- /TOC -->


# 1. 动态规划
<!-- 

https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA
1、到底什么才叫「最优⼦结构」，和动态规划什么关系。 2、为什么动态规划遍历 dp 数组的⽅式五花⼋门，有的正着遍历，有的倒 着遍历，有的斜着遍历。  
https://mp.weixin.qq.com/s/qvlfyKBiXVX7CCwWFR-XKg

https://mp.weixin.qq.com/s/YePeNnzBUSsfpApMFKqzAQ
 状态压缩技巧：动态规划的降维打击 
https://mp.weixin.qq.com/s/SnyN1Gn6DTLm0uJyp5l6CQ

回溯算法和动态规划
https://mp.weixin.qq.com/s/OyqQXQnyH_UzmxdytK2rTA


西法的刷题秘籍

-->

## 1.1. ~~动态规划基本概念-百度百科~~  
&emsp; **<font color = "red">动态规划求解最值问题。动态规划的一般形式就是求最优值，比如最长公共子序列、最大子段和、最优二叉搜索树等等。动态规划实质是求最优解，不过很多题目是简化版，只要求返回最大值/最小值。</font>** 最优解问题是指问题通常有多个可行解，需要从这些可行解中找到一个最优的可行解。  

### 1.1.1. 能用动态规划解决的问题的特点
&emsp; 能用动规解决的问题的特点  
&emsp; 能采用动态规划求解的问题的一般要具有3个性质：  
&emsp; (1) 最优化原理：如果问题的最优解所包含的子问题的解也是最优的，就称该问题具有最优子结构，即满足最优化原理。  
&emsp; (2) 无后效性：即某阶段状态一旦确定，就不受这个状态以后决策的影响。也就是说，某状态以后的过程不会影响以前的状态，只与当前状态有关。  
&emsp; (3) 有重叠子问题：即子问题之间是不独立的，一个子问题在下一阶段决策中可能被多次使用到。（该性质并不是动态规划适用的必要条件，但是如果没有这条性质，动态规划算法同其他算法相比就不具备优势）

------
&emsp; 动态规划特点：1. 重叠子问题；2. 状态转移方程（最关键）；3. 最优子结构。  


### 1.1.2. 动态规划术语
&emsp; 动态规划算法是通过拆分问题，定义问题状态和状态之间的关系，使得问题能够以递推（或者说分治）的方式去解决。它的几个重要概念如下所述。
1. 阶段：对于一个完整的问题过程，适当的切分为若干个相互联系的子问题，每次在求解一个子问题，则对应一个阶段，整个问题的求解转化为按照阶段次序去求解。
2. **状态：状态表示每个阶段开始时所处的客观条件，即在求解子问题时的已知条件。状态描述了研究的问题过程中的状况。**
3. 决策：决策表示当求解过程处于某一阶段的某一状态时，可以根据当前条件作出不同的选择，从而确定下一个阶段的状态，这种选择称为决策。
4. 策略：由所有阶段的决策组成的决策序列称为全过程策略，简称策略。
5. **最优策略：在所有的策略中，找到代价最小，性能最优的策略，此策略称为最优策略。**
6. **状态转移方程：状态转移方程是确定两个相邻阶段状态的演变过程，描述了状态之间是如何演变的。**


-----

&emsp; **<font color = "red">动态规划中包含三个重要的概念：</font>** 最优子结构( f(10) =f(9)+f(8) )、边界( f(1) 与 f(2) )、状态转移公式( f(n) =f(n-1)+f(n-2) )。

&emsp; 综合了动态规划的特点给出的动态规划的定义： 动态规划是一种多阶段决策最优解模型，一般用来求最值问题，多数情况下它可以采用自下而上的递推方式来得出每个子问题的最优解（即最优子结构），进而自然而然地得出依赖子问题的原问题的最优解。

1. 多阶段决策，意味着问题可以分解成子问题，子子问题，。。。，也就是说问题可以拆分成多个子问题进行求解
2. 最优子结构，在自下而上的递推过程中，我们求得的每个子问题一定是全局最优解，既然它分解的子问题是全局最优解，那么依赖于它们解的原问题自然也是全局最优解。
3. 自下而上，怎样才能自下而上的求出每个子问题的最优解呢，可以肯定子问题之间是有一定联系的，即迭代递推公式，也叫「状态转移方程」，要定义好这个状态转移方程， 我们就需要定义好每个子问题的状态（pDP 状态），那为啥要自下而上地求解呢，因为如果采用像递归这样自顶向下的求解方式，子问题之间可能存在大量的重叠，大量地重叠子问题意味着大量地重复计算，这样时间复杂度很可能呈指数级上升（在下文中我们会看到多个这样重复的计算导致的指数级的时间复杂度），所以自下而上的求解方式可以消除重叠子问题。

&emsp; 简单总结一下，最优子结构，状态转移方程，重叠子问题就是动态规划的三要素，这其中定义子问题的状态与写出状态转移方程是解决动态规划最为关键的步骤，状态转移方程如果定义好了，解决动态规划就基本不是问题了。

-------
&emsp; 会变化的就是状态。DP数组是几维根据状态来决定。    
&emsp; 动态规划的转移方程就是(暴力递归中)决策过程中的决策。  

## 1.2. 入门案例走进动态规划
&emsp; [备忘录与动态规划](/docs/function/e-recursion/MemorandumAndDynamic.md)  
&emsp; 用一句话解释动态规划就是 `“记住你之前做过的事”`，如果更准确些，其实是 `“记住你之前得到的答案”`。  

## 1.3. 动态规划解题步骤小结  

### 1.3.1. 解题步骤一
<!-- 
https://www.bilibili.com/video/BV1xb411e7ww?from=search&seid=13345442502676523377&spm_id_from=333.337.0.0
-->
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-56.png)  


### 1.3.2. 解题步骤二  
<!--
!!!!!!!重要
https://mp.weixin.qq.com/s?__biz=MzI4MzUxNjI3OA==&mid=2247488433&idx=1&sn=86bb57247b56b493af2aef0954c9eb62&chksm=eb88dfa8dcff56be1034750b2bb9d87240a197de4f4ea574b3ae26242d226bc1581ca4e88bfc&scene=21#wechat_redirect

https://mp.weixin.qq.com/s/afRM6owOL_KTKekmW7wzpQ

https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA


一一状态定义和状态转移方程
https://blog.csdn.net/qq_40963043/article/details/100765212
-->

<!--
~~
https://www.cnblogs.com/fivestudy/p/11855853.html
-->

<!-- 
动态规划这四个步骤其实是相互递进的，状态的定义离不开问题的拆解，递推方程的推导离不开状态的定义，最后的实现代码的核心其实就是递推方程，这中间如果有一个步骤卡壳了则会导致问题无法解决，当问题的复杂程度增加的时候，这里面的思维复杂程度会上升。
-->
&emsp; ~~动态规划问题的解题步骤：1.确定子问题；2.确定状态转移方程；3.确定边界条件。~~   
&emsp; **<font >解题套路：1. 明确“状态”；2. 明确“选择”；3. 明确DP函数、数组的定义；4. 明确base case。  

------

1. 分析问题，确定是否能用动态规划？  
&emsp; 如果能使用动态规划，分析流程中思考解题时几个重点问题：边界条件、状态（子问题的入参）、算法流程（状态转移方程）  
2. 确定状态，根据状态定义dp数组。 ~~子问题的入参（变量）。~~    
&emsp; 状态定义 其实是需要思考在解决一个问题的时候我们做了什么事情，然后得出了什么样的答案，对于这个问题，当前问题的答案就是当前的状态。  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-3.png)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-5.png)  
3. 确定边界条件  
4. 进行状态转移。 ~~“选择/决策”和无后效性~~  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-6.png)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-7.png)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-8.png)  


---------------

&emsp; 如何列出正确的状态转移方程：  
1. 先确定「状态」。在凑零钱问题中，由于硬币数量无限，所以唯一的状态就是目标金额amount。  
2. 然后确定dp函数的定义。函数 dp(n)表示，当前的目标金额是n，至少需要dp(n)个硬币凑出该金额。  
3. 然后确定「选择」并择优，也就是对于每个状态，可以做出什么选择改变当前状态。具体到凑零钱问题，无论当的目标金额是多少，选择就是从面额列表coins中选择一个硬币，然后目标金额就会减少：  
```text
# 伪码框架
def coinChange(coins: List[int], amount: int):
    # 定义：要凑出金额 n，至少要 dp(n) 个硬币
    def dp(n):
        # 做选择，需要硬币最少的那个结果就是答案
        for coin in coins:
            res = min(res, 1 + dp(n - coin))
        return res
    # 我们要求目标金额是 amount
    return dp(amount)
```

4. 最后明确 base case，显然目标金额为 0 时，所需硬币数量为 0；当目标金额小于 0 时，无解，返回 -1：

```text
def coinChange(coins: List[int], amount: int):

    def dp(n):
        # base case
        if n == 0: return 0
        if n < 0: return -1
        # 求最小值，所以初始化为正无穷
        res = float('INF')
        for coin in coins:
            subproblem = dp(n - coin)
            # 子问题无解，跳过
            if subproblem == -1: continue
            res = min(res, 1 + subproblem)

        return res if res != float('INF') else -1

    return dp(amount)
```
&emsp; 至此，状态转移方程其实已经完成了。      




### 1.3.3. 解题步骤三
&emsp; 动态规划解题步骤：  
&emsp; 动态规划所处理的问题是一个多阶段决策问题，一般由初始状态开始，通过对中间阶段决策的选择，达到结束状态。这些决策形成了一个决策序列，同时确定了完成整个过程的一条活动路线(通常是求最优的活动路线)。如图所示。动态规划的设计都有着一定的模式，一般要经历以下几个步骤。  
&emsp; 初始状态→│决策１│→│决策２│→…→│决策ｎ│→结束状态

&emsp; (1)划分阶段：按照问题的时间或空间特征，把问题分为若干个阶段。在划分阶段时，注意划分后的阶段一定要是有序的或者是可排序的，否则问题就无法求解。

&emsp; (2)确定状态和状态变量：将问题发展到各个阶段时所处于的各种客观情况用不同的状态表示出来。当然，状态的选择要满足无后效性。

&emsp; (3)确定决策并写出状态转移方程：因为决策和状态转移有着天然的联系，状态转移就是根据上一阶段的状态和决策来导出本阶段的状态。所以如果确定了决策，状态转移方程也就可写出。但事实上常常是反过来做，根据相邻两个阶段的状态之间的关系来确定决策方法和状态转移方程。

&emsp; (4)寻找边界条件：给出的状态转移方程是一个递推式，需要一个递推的终止条件或边界条件。

&emsp; 一般，只要解决问题的阶段、状态和状态转移决策确定了，就可以写出状态转移方程（包括边界条件）。

&emsp; 实际应用中可以按以下几个简化的步骤进行设计：

&emsp; （1）分析最优解的性质，并刻画其结构特征。  
&emsp; （2）递归的定义最优解。  
&emsp; （3）以自底向上或自顶向下的记忆化方式（备忘录法）计算出最优值  
&emsp; （4）根据计算最优值时得到的信息，构造问题的最优解

&emsp; 算法实现的说明

&emsp; 动态规划的主要难点在于理论上的设计，也就是上面4个步骤的确定，一旦设计完成，实现部分就会非常简单。

&emsp; 使用动态规划求解问题，最重要的就是确定动态规划三要素：

&emsp; （1）问题的阶段 （2）每个阶段的状态 （3）从前一个阶段转化到后一个阶段之间的递推关系。

&emsp; 递推关系必须是从次小的问题开始到较大的问题之间的转化，从这个角度来说，动态规划往往可以用递归程序来实现，不过因为递推可以充分利用前面保存的子问题的解来减少重复计算，所以对于大规模问题来说，有递归不可比拟的优势，这也是动态规划算法的核心之处。

&emsp; 确定了动态规划的这三要素，整个求解过程就可以用一个最优决策表来描述，最优决策表是一个二维表，其中行表示决策的阶段，列表示问题状态，表格需要填写的数据一般对应此问题的在某个阶段某个状态下的最优值（如最短路径，最长公共子序列，最大价值等），填表的过程就是根据递推关系，从1行1列开始，以行或者列优先的顺序，依次填写表格，最后根据整个表格的数据通过简单的取舍或者运算求得问题的最优解。

    f(n,m)=max{f(n-1,m), f(n-1,m-w[n])+P(n,m)}  

&emsp; 算法实现的步骤    
&emsp; 1、创建一个一维数组或者二维数组，保存每一个子问题的结果，具体创建一维数组还是二维数组看题目而定，基本上如果题目中给出的是一个一维数组进行操作，就可以只创建一个一维数组，如果题目中给出了两个一维数组进行操作或者两种不同类型的变量值，比如背包问题中的不同物体的体积与总体积，找零钱问题中的不同面值零钱与总钱数，这样就需要创建一个二维数组。  
&emsp; 注：需要创建二维数组的解法，都可以创建一个一维数组运用滚动数组的方式来解决，即一位数组中的值不停的变化，后面会详细徐叙述  
&emsp; 2、设置数组边界值，一维数组就是设置第一个数字，二维数组就是设置第一行跟第一列的值，特别的滚动一维数组是要设置整个数组的值，然后根据后面不同的数据加进来变幻成不同的值。  
&emsp; 3、找出状态转换方程，也就是说找到每个状态跟他上一个状态的关系，根据状态转化方程写出代码。  
&emsp; 4、返回需要的值，一般是数组的最后一个或者二维数组的最右下角。

&emsp; 代码基本框架：

```java
for(j=1; j<=m; j=j+1) // 第一个阶段
    xn[j] = 初始值;
 
  for(i=n-1; i>=1; i=i-1)// 其他n-1个阶段
    for(j=1; j>=f(i); j=j+1)//f(i)与i有关的表达式
      xi[j]=j=max（或min）{g(xi-[j1:j2]), ......, g(xi-1[jk:jk+1])};
 
 t = g(x1[j1:j2]); // 由子问题的最优解求解整个问题的最优解的方案
 
 print(x1[j1]);
 
 for(i=2; i<=n-1; i=i+1）
 {  
      t = t-xi-1[ji];
 
      for(j=1; j>=f(i); j=j+1)
         if(t=xi[ji])
              break;}
```


## 1.4. 解题模版
### 1.4.1. 解题模板  
```text
# 初始化 base case
dp[0][0][...] = base
# 进行状态转移
for 状态1 in 状态1的所有取值: 
	for  状态2 in 状态2的所有取值: 
		for ...
			dp[][][...] =  求最值(选择1, 选择2 ...)
```

![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-1.png)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-2.png)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/dp-4.png)  

### 1.4.2. 解题模板使用-动态规划背包问题  
<!-- 

https://www.bilibili.com/video/BV15B4y1P7X7
-->

## 1.5. 动态规划解题  
&emsp; [动态规划解题](/docs/function/e-recursion/DynamicSolve.md)  
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-57.png)  
&emsp; 对动态规划进行空间压缩  
