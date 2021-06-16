
<!-- TOC -->

- [1. ~~备忘录与动态规划~~](#1-备忘录与动态规划)
    - [1.1. 前言](#11-前言)
    - [1.2. 青蛙跳阶问题](#12-青蛙跳阶问题)
        - [1.2.1. 暴力递归](#121-暴力递归)
        - [1.2.2. 带备忘录的递归解法（自顶向下）](#122-带备忘录的递归解法自顶向下)
        - [1.2.3. 自底向上的动态规划](#123-自底向上的动态规划)
    - [1.3. 斐波那契数列](#13-斐波那契数列)
        - [1.3.1. 暴力递归](#131-暴力递归)
        - [1.3.2. 备忘录递归](#132-备忘录递归)
        - [1.3.3. 动态规划](#133-动态规划)
    - [1.4. 斐波那契数列-2](#14-斐波那契数列-2)
    - [1.5. 斐波那契数列-3](#15-斐波那契数列-3)
    - [1.6. 凑零钱兑换](#16-凑零钱兑换)
        - [1.6.1. 暴力递归](#161-暴力递归)
        - [1.6.2. 备忘录递归](#162-备忘录递归)
        - [1.6.3. 动态规划](#163-动态规划)

<!-- /TOC -->


<!-- 
 看一遍就理解：动态规划详解 
https://mp.weixin.qq.com/s/MJD9t_y26lAT2ffXT3qGGg


https://mp.weixin.qq.com/s/CXLM0KC3eYYl6u2NsCpW4g

-->


<!--
~~
https://blog.csdn.net/zw6161080123/article/details/80639932
动态规划题解（转）
https://www.cnblogs.com/wsw-seu/p/13381312.html
这才是真正的状态压缩动态规划好不好！！！ 
https://mp.weixin.qq.com/s/H2V3D0DMPbT8hQW9Cq6LjQ
https://mp.weixin.qq.com/s?__biz=MzI2NjI5MzU2Nw==&mid=2247484633&idx=1&sn=c2b3ecd346ce8d84fbbddb85e5391686&chksm=ea911c89dde6959f9a3c401e9b52eba68a661d0d2251199dadf3fff12fe4d6beac6bea4d05f6&scene=21#wechat_redirect
-->


<!--
~~
https://www.cnblogs.com/fivestudy/p/11855853.html

三角形的最小路径和 
https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483932&idx=1&sn=d9cd9d5a5ebf5f31e23f11c82b6465f1&scene=21#wechat_redirect
-->

# 1. ~~备忘录与动态规划~~

<!-- 
备忘录方法
https://baike.baidu.com/item/%E5%A4%87%E5%BF%98%E5%BD%95%E6%96%B9%E6%B3%95/6756819?appJump=1&ivk_sa=1022817p
细谈递归，备忘录递归，动态规划，三种算法思想和运行原理
https://blog.csdn.net/qq_39046727/article/details/78966105
备忘录方法与动态规划比较
https://blog.csdn.net/annmi26002/article/details/101975994
-->

## 1.1. 前言  
&emsp; 动态规划遵循一套固定的流程： **<font color = "clime">递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解法</font>** 。这个过程是层层递进的解决问题的过程。  

## 1.2. 青蛙跳阶问题

### 1.2.1. 暴力递归

    leetcode原题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 10 级的台阶总共有多少种跳法。”

&emsp; 有些小伙伴第一次见这个题的时候，可能会有点蒙圈，不知道怎么解决。其实可以试想：

    要想跳到第10级台阶，要么是先跳到第9级，然后再跳1级台阶上去;要么是先跳到第8级，然后一次迈2级台阶上去。
    同理，要想跳到第9级台阶，要么是先跳到第8级，然后再跳1级台阶上去;要么是先跳到第7级，然后一次迈2级台阶上去。
    要想跳到第8级台阶，要么是先跳到第7级，然后再跳1级台阶上去;要么是先跳到第6级，然后一次迈2级台阶上去。

&emsp; 假设跳到第n级台阶的跳数我们定义为f(n)，很显然就可以得出以下公式：

```
f（10） = f（9）+f(8)
f (9)  = f(8) + f(7)
f (8)  = f(7) + f(6)
...
f(3) = f(2) + f(1)
```

&emsp; 即通用公式为: f(n) = f(n-1) + f(n-2)

&emsp; 那f(2) 或者 f(1) 等于多少呢？

    当只有2级台阶时，有两种跳法，第一种是直接跳两级，第二种是先跳一级，然后再跳一级。即f(2) = 2;
    当只有1级台阶时，只有一种跳法，即f（1）= 1；

&emsp; 因此可以用递归去解决这个问题：

```java
class Solution {
    public int numWays(int n) {
    if(n == 1){
        return 1;
    }
     if(n == 2){
        return 2;
    }
    return numWays(n-1) + numWays(n-2);
    }
}
```
去leetcode提交一下，发现有问题，超出时间限制了


### 1.2.2. 带备忘录的递归解法（自顶向下）  
一般使用一个数组或者一个哈希map充当这个备忘录。  



```java
public class Solution {
    //使用哈希map，充当备忘录的作用
    Map<Integer, Integer> tempMap = new HashMap();
    public int numWays(int n) {
        // n = 0 也算1种
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        //先判断有没计算过，即看看备忘录有没有
        if (tempMap.containsKey(n)) {
            //备忘录有，即计算过，直接返回
            return tempMap.get(n);
        } else {
            // 备忘录没有，即没有计算过，执行递归计算,并且把结果保存到备忘录map中，对1000000007取余（这个是leetcode题目规定的）
            tempMap.put(n, (numWays(n - 1) + numWays(n - 2)) % 1000000007);
            return tempMap.get(n);
        }
    }
}
```

### 1.2.3. 自底向上的动态规划  


```java
public class Solution {
    public int numWays(int n) {
        if (n<= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = (a + b)% 1000000007;
            a = b;
            b = temp;
        }
        return temp;
    }
}
```

## 1.3. 斐波那契数列  
<!-- 
https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA
-->

### 1.3.1. 暴力递归  

```java
public static int fibonacci(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```


### 1.3.2. 备忘录递归  

```java
public static int fibonacci(int n) {
    if (n = 1) return 1;
    if (n = 2) return 2;
    if (map.get(n) != null)  {
        return map.get(n);
    }
    int result = fibonacci(n - 1) + fibonacci(n - 2);
    map.put(n, result);
    return result;
}
```


### 1.3.3. 动态规划  
```java
public int f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int result = 0;
    int pre = 1;
    int next = 2;
    
    for (int i = 3; i < n + 1; i ++) {
        result = pre + next;
        pre = next;
        next = result;
    }
    return result;
}
```




## 1.4. 斐波那契数列-2
<!-- 
https://mp.weixin.qq.com/s?__biz=MzI5MTU1MzM3MQ==&mid=2247483932&idx=1&sn=d9cd9d5a5ebf5f31e23f11c82b6465f1&scene=21#wechat_redirect
-->

## 1.5. 斐波那契数列-3
<!-- 
https://www.cnblogs.com/wsw-seu/p/13381312.html
-->





## 1.6. 凑零钱兑换  

    讲解 “如何列出状态转移方程？”

&emsp; leetCode322题  
<!-- 
https://mp.weixin.qq.com/s/Cw39C9MY9Wr2JlcvBQZMcA
https://www.cnblogs.com/wsw-seu/p/13381312.html
-->


### 1.6.1. 暴力递归
```java
public class Solution {

    private static int exchange(int amount, int[] coins) {

        // 说明零钱刚好凑完
        if (amount == 0) {
            return 0;
        }

        // 说明没有满足的条件
        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = exchange(amount - coins[i], coins);
            if (subMin == -1) continue;
            result = Math.min(subMin + 1, result);
        }

        // 说明没有符合问题的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }

    public static  void main(String[] args)  throws Throwable {
        int amount = 11;
        int[] coins = {1,2,5};
        int result = exchange(amount, coins);
        System.out.println("result = " + result);
    }
}
```

### 1.6.2. 备忘录递归

```java
public class Solution {

    // 保存中间结果
    private static HashMap<Integer, Integer> map = new HashMap();

    // 带备忘录的递归求解
    private static int exchangeRecursive(int amount, int[] coins) {
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        // 说明零钱已经凑完
        if (amount == 0) {
            return 0;
        }

        // 说明没有满足的条件
        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = exchangeRecursive(amount - coins[i], coins);
            if (subMin == -1) continue;
            result = Math.min(subMin + 1, result);
        }

        // 说明没有符合问题的解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        map.put(amount, result);
        return result;
    }

    public static  void main(String[] args)  throws Throwable {
        int amount = 11;
        int[] coins = {1,2,5};
        int result = exchangeRecursive(amount, coins);
        System.out.println("result = " + result);
    }
}
```


```java
int coinChange(vector<int>& coins, int amount) {
    // 备忘录初始化为 -2
    vector<int> memo(amount + 1, -2);
    return helper(coins, amount, memo);
}

int helper(vector<int>& coins, int amount, vector<int>& memo) {
    if (amount == 0) return 0;
    if (memo[amount] != -2) return memo[amount];
    int ans = INT_MAX;
    for (int coin : coins) {
        // 金额不可达
        if (amount - coin < 0) continue;
        int subProb = helper(coins, amount - coin, memo);
        // 子问题无解
        if (subProb == -1) continue;
        ans = min(ans, subProb + 1);
    }
    // 记录本轮答案
    memo[amount] = (ans == INT_MAX) ? -1 : ans;
    return memo[amount];
}
```

### 1.6.3. 动态规划  

```java
// 动态规划求解
private static int exchangeDP(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
    for (int i = 0; i < amount + 1; i++) {
        dp[i] = amount + 1;
    }

    // 0 硬币本来就没有，所以设置成 0
    dp[0] = 0;

    for (int i = 0; i < amount + 1; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (i >= coins[j]) {
                dp[i] = Math.min(dp[i- coins[j]], dp[i]) + 1;
            }
        }
    }

    if (dp[amount] == amount + 1) {
        return -1;
    }
    return dp[amount];
}
```


```java
int coinChange(vector<int>& coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;
    for (int i = 0; i < dp.size(); i++) {
        // 内层 for 在求所有子问题 + 1 的最小值
        for (int coin : coins) {
            if (i - coin < 0) continue;
            dp[i] = min(dp[i], 1 + dp[i - coin]);
        }
    }
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
}
```