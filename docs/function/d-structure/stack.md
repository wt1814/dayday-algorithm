

<!-- TOC -->

- [1. 栈Stack](#1-栈stack)
    - [1.1. 简介](#11-简介)
    - [1.2. 单调栈](#12-单调栈)
        - [1.2.1. 介绍](#121-介绍)
        - [1.2.2. 适用场景](#122-适用场景)
        - [1.2.3. 伪代码](#123-伪代码)
    - [1.3. 栈与递归](#13-栈与递归)
    - [1.4. 有关栈的算法题](#14-有关栈的算法题)
        - [1.4.1. 利用栈实现字符串逆序](#141-利用栈实现字符串逆序)
        - [1.4.2. 利用栈判断分隔符是否匹配](#142-利用栈判断分隔符是否匹配)
        - [1.4.3. 用两个栈实现队列](#143-用两个栈实现队列)
        - [1.4.4. 栈的压入、弹出序列](#144-栈的压入弹出序列)
        - [1.4.5. 使用两个栈进行排序](#145-使用两个栈进行排序)

<!-- /TOC -->


# 1. 栈Stack  
<!-- 
分享｜2021秋招算法总结12-栈篇
https://leetcode-cn.com/circle/discuss/kdY0zV/

-->
## 1.1. 简介
&emsp; **栈的实现：**既可以用「数组」来实现一个栈，也可以用「链表」来实现一个栈。  
&emsp; **栈的基本操作：**栈有两种操作：Push和Pop。用Push(压入)来表示往栈中插入数据，也叫入栈，用Pop(弹出)来表示从栈中删除数据，也叫出栈。  

&emsp; 栈中的方法peek()和pop()  
* stack1.peek() 返回栈顶元素，但不在堆栈中删除它。
* Stack2.pop() 返回栈顶元素，并在堆栈中删除它。

&emsp; **栈的应用：**栈的输出顺序和输入顺序相反，所以 **<font color = "red">栈通常用于“历史”的回溯，也就是逆流而上追溯“历史”。例如：实现递归的逻辑，就可以用栈来代替。</font>** 因为栈可以回溯方法的调用链。  

## 1.2. 单调栈
<!-- 
【西法带你学算法】单调栈解题模板秒杀八道题 
https://mp.weixin.qq.com/s/Mb8PAxMj2KLTQ1QrCh8XAA
单调栈解题模板秒杀三道算法题 
https://mp.weixin.qq.com/s/KYfjBejo84AmajnPZNs5nA
-->

&emsp; `单调递增栈解下一个更大元素。`  

### 1.2.1. 介绍
&emsp; 单调栈是⼀种特殊的栈。栈本来就是⼀种受限的数据结构了，单调栈在此 基础上⼜受限了⼀次（受限++）。  
&emsp; 单调栈要求栈中的元素是单调递减或者单调递减的。  

### 1.2.2. 适用场景
&emsp; 单调栈适合的题目是求解「第一个一个大于 xxx」或者「第一个小于 xxx」这种题目。所以当你有这种需求的时候，就应该想到单调栈。  
&emsp; 那么为什么单调栈适合求解「第一个一个大于 xxx」或者「第一个小于 xxx」这种题目？原因很简单，我这里通过一个例子给大家讲解一下。这里举的例子是单调递增栈。  
&emsp; 比如我们需要依次将数组 [1,3,4,5,2,9,6] 压入单调栈。  

1. 首先压入 1，此时的栈为：[1]
2. 继续压入 3，此时的栈为：[1,3]
3. 继续压入 4，此时的栈为：[1,3,4]
4. 继续压入 5，此时的栈为：[1,3,4,5]
5. 「如果」继续压入 2，此时的栈为：[1,3,4,5,2] 不满足单调递增栈的特性， 因此需要调整。如何调整？由于栈只有 pop 操作，因此我们只好不断 pop，直到满足单调递增为止。
6. 上面其实我们并没有压入 2，而是先 pop，pop 到压入 2 依然可以保持单调递增再 压入 2，此时的栈为：[1,2]
7. 继续压入 9，此时的栈为：[1,2,9]
8. 「如果」继续压入 6，则不满足单调递增栈的特性， 我们故技重施，不断 pop，直到满足单调递增为止。此时的栈为：[1,2,6]
注意这里的栈仍然是非空的，如果有的题目需要用到所有数组的信息，那么很有可能因没有考虑边界而不能通过所有的测试用例。这里介绍一个技巧 - 「哨兵法」，这个技巧经常用在单调栈的算法中。

&emsp; 对于上面的例子，我可以在原数组 [1,3,4,5,2,9,6] 的右侧添加一个小于数组中最小值的项即可，比如 -1。此时的数组是 [1,3,4,5,2,9,6,-1]。这种技巧可以简化代码逻辑，大家尽量掌握。  
&emsp; 上面的例子如果你明白了，就不难理解为啥单调栈适合求解「第一个一个大于 xxx」或者「第一个小于 xxx」这种题目了。比如上面的例子，我们就可以很容易地求出「在其之后第一个小于其本身的位置」。比如 3 的索引是 1，小于 3 的第一个索引是 4，2 的索引 4，小于 2 的第一个索引是 0，但是其在 2 的索引 4 之后，因此不符合条件，也就是不存在「在 2 之后第一个小于 2 本身的位置」。  
&emsp; 上面的例子，我们在第 6 步开始 pop，第一个被 pop 出来的是 5，因此 5 之后的第一个小于 5 的索引就是 4。同理被 pop 出来的 3，4，5 也都是 4。  
&emsp; 如果用 ans 来表示「在其之后第一个小于其本身的位置」，ans[i] 表示 arr[i] 之后第一个小于 arr[i] 的位置， ans[i] 为 -1 表示这样的位置不存在，比如前文提到的 2。那么此时的 ans 是 [-1,4,4,4,-1,-1,-1]。  
&emsp; 第 8 步，我们又开始 pop 了。此时 pop 出来的是 9，因此 9 之后第一个小于 9 的索引就是 6。  
&emsp; 这个算法的过程用一句话总结就是，「如果压栈之后仍然可以保持单调性，那么直接压。否则先弹出栈的元素，直到压入之后可以保持单调性。」 这个算法的原理用一句话总结就是，`「被弹出的元素都是大于当前元素的，并且由于栈是单调增的，因此在其之后小于其本身的最近的就是当前元素了」。`  

### 1.2.3. 伪代码
&emsp; 上面的算法可以用如下的伪代码表示，同时这是一个通用的算法模板，大家遇到单调栈的题目可以直接套。  
&emsp; 建议大家用自己熟悉的编程语言实现一遍，以后改改符号基本就能用。  

```text
class Solution:
    def monostoneStack(self, arr: List[int]) -> List[int]:
        stack = []
        ans = 定义一个长度和 arr 一样长的数组，并初始化为 -1
        循环 i in  arr:
            while stack and arr[i] > arr[栈顶元素]:
                peek = 弹出栈顶元素
                ans[peek] = i - peek
            stack.append(i)
        return ans
```

&emsp; 「复杂度分析」

&emsp; 时间复杂度：由于 arr 的元素最多只会入栈，出栈一次，因此时间复杂度仍然是O(N)，其中 N 为数组长度。  
&emsp; 空间复杂度：由于使用了栈， 并且栈的长度最大是和 arr 长度一致，因此空间复杂度是O(N)，其中 N 为数组长度。  

-----------


```text
vector<int> nextGreaterElement(vector<int>& nums) {
    vector<int> res(nums.size()); // 存放答案的数组
    stack<int> s;
    // 倒着往栈里放
    for (int i = nums.size() - 1; i >= 0; i--) {
        // 判定个子高矮
        while (!s.empty() && s.top() <= nums[i]) {
            // 矮个起开，反正也被挡着了。。。
            s.pop();
        }
        // nums[i] 身后的 next great number
        res[i] = s.empty() ? -1 : s.top();
        // 
        s.push(nums[i]);
    }
    return res;
}
```

&emsp; 这就是单调队列解决问题的模板。for 循环要从后往前扫描元素，因为我们借助的是栈的结构，`倒着入栈，其实是正着出栈`。while 循环是把两个「个子高」元素之间的元素排除，因为他们的存在没有意义，前面挡着个「更高」的元素，所以他们不可能被作为后续进来的元素的 Next Great Number 了。  
&emsp; 这个算法的时间复杂度不是那么直观，如果你看到 for 循环嵌套 while 循环，可能认为这个算法的复杂度也是O(n^2)，但是实际上这个算法的复杂度只有O(n)。  
&emsp; 分析它的时间复杂度，要从整体来看：总共有n个元素，每个元素都被push入栈了一次，而最多会被pop一次，没有任何冗余操作。所以总的计算规模是和元素规模n成正比的，也就是O(n)的复杂度。  

## 1.3. 栈与递归
&emsp; **栈与递归：**用非递归写递归，都需要用到栈。  

## 1.4. 有关栈的算法题  
### 1.4.1. 利用栈实现字符串逆序  
&emsp; 可以将一个字符串分隔为单个的字符，然后将字符一个一个push()进栈，在一个一个pop()出栈就是逆序显示了。如：将字符串“how are you” 反转！！！

    ps：这里是用上面自定的栈来实现的，大家可以将ArrayStack替换为JDK自带的栈类Stack试试    

```java
//进行字符串反转
@Test
public void testStringReversal(){
    ArrayStack stack = new ArrayStack();
    String str = "how are you";
    char[] cha = str.toCharArray();
    for(char c : cha){
        stack.push(c);
    }
    while(!stack.isEmpty()){
        System.out.print(stack.pop());
    }
}

//结果：
//uoy era woh
```

### 1.4.2. 利用栈判断分隔符是否匹配  
&emsp; 在xml标签或者html标签中，<必须和最近的>进行匹配，[ 也必须和最近的 ] 进行匹配。  
&emsp; 比如：<abc[123]abc>这是符号相匹配的，如果是 <abc[123>abc] 那就是不匹配的。  
&emsp; 对于 12<a[b{c}]>，分析在栈中的数据：遇到匹配正确的就消除
![image](https://gitee.com/wt1814/pic-host/raw/master/algorithm/function-23.png)  
&emsp; 最后栈中的内容为空则匹配成功，否则匹配失败！！！  

```java
//分隔符匹配
//遇到左边分隔符了就push进栈，遇到右边分隔符了就pop出栈，看出栈的分隔符是否和这个有分隔符匹配
@Test
public void testMatch(){
    ArrayStack stack = new ArrayStack(3);
    String str = "12<a[b{c}]>";
    char[] cha = str.toCharArray();
    for(char c : cha){
        switch (c) {
            case '{':
            case '[':
            case '<':
                stack.push(c);
                break;
            case '}':
            case ']':
            case '>':
                if(!stack.isEmpty()){
                    char ch = stack.pop().toString().toCharArray()[0];
                    if(c=='}' && ch != '{'
                            || c==']' && ch != '['
                            || c==')' && ch != '('){
                        System.out.println("Error:"+ch+"-"+c);
                    }
                }
                break;
            default:
                break;
        }
    }
}
```

-----------------

&emsp; 遍历输入字符串：

* 如果当前字符为左半边括号时，则将其压入栈中；  
* 如果遇到右半边括号时，分类讨论：  
    * 如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环  
    * 若此时栈为空，则直接返回 false  
    * 若不为对应的左半边括号，反之返回 false  

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
```

### 1.4.3. 用两个栈实现队列  
<!-- 
如何用两个栈实现一个队列？
https://mp.weixin.qq.com/s/alba6Zdn_3KyUrlI91Hx8g
-->
&emsp; 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。  
&emsp; 解题思路：in 栈用来处理入栈(push)操作，out 栈用来处理出栈(pop)操作。一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。  

&emsp; push元素时，始终是进入栈，pop和peek元素时始终是走出栈。  
&emsp; pop 和 peek 操作，如果出栈为空，则需要从入栈将所有元素移到出栈，也就是调换顺序，比如开始push的顺序是 3-2-1，1 是最先进入的元素，则到出栈的顺序是 1-2-3，那 pop 操作拿到的就是 1，满足了先进先出的特点。  
&emsp; pop和peek操作，如果出栈不为空，则不需要从入栈中移到数据到出栈。  

```java
Stack<Integer> in = new Stack<Integer>();
Stack<Integer> out = new Stack<Integer>();

public void push(int listNode) {
    in.push(listNode);
}

public int pop() throws Exception {
    if (out.isEmpty())
        while (!in.isEmpty())
            out.push(in.pop());

    if (out.isEmpty())
        throw new Exception("queue is empty");

    return out.pop();
}
```

### 1.4.4. 栈的压入、弹出序列  
&emsp; **问题描述：**  
&emsp; 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1，2，3，4，5 是某栈的压入顺序，序列4，5，3，2，1是该压栈序列对应的一个弹出序列，但4，3，5，1，2就不可能是该压栈序列的弹出序列。(注意：这两个序列的长度是相等的)  
&emsp; **解题思路：**  
&emsp; 借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4 ，所以需要继续压栈，直到相等以后开始出栈。  
&emsp; 出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。  

```java
public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
    int n = pushSequence.length;
    Stack<Integer> stack = new Stack<>();
    for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
        stack.push(pushSequence[pushIndex]);
        while (popIndex < n && !stack.isEmpty()
                && stack.peek() == popSequence[popIndex]) {
            stack.pop();
            popIndex++;
        }
    }
    return stack.isEmpty();
}
```

### 1.4.5. 使用两个栈进行排序  
<!-- 
https://www.nowcoder.com/questionTerminal/d0d0cddc1489476da6b782a6301e7dec
https://blog.csdn.net/windflybird/article/details/80186048
https://www.jianshu.com/p/6cf87a4fbebf
https://blog.csdn.net/MrLiar17/article/details/86704959
-->

