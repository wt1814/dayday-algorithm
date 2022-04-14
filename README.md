


<!-- TOC -->

- [1. 算法小抄](#1-算法小抄)
    - [1.1. 笔记](#11-笔记)
    - [1.2. 算法](#12-算法)
        - [1.2.1. Java](#121-java)
        - [1.2.2. Array](#122-array)
        - [1.2.3. 排序](#123-排序)
        - [1.2.4. 搜索](#124-搜索)
        - [1.2.5. 双指针和滑动窗口](#125-双指针和滑动窗口)
            - [1.2.5.1. 双指针](#1251-双指针)
                - [1.2.5.1.1. 两个数组](#12511-两个数组)
            - [1.2.5.2. 滑动窗口](#1252-滑动窗口)
                - [1.2.5.2.1. 替换](#12521-替换)
                - [1.2.5.2.2. 两个数组](#12522-两个数组)
        - [1.2.6. 字符串](#126-字符串)
            - [1.2.6.1. 单字符串](#1261-单字符串)
            - [1.2.6.2. 双字符串](#1262-双字符串)
        - [1.2.7. 链表](#127-链表)
            - [1.2.7.1. 删除链表节点](#1271-删除链表节点)
            - [1.2.7.2. 反转链表](#1272-反转链表)
            - [1.2.7.3. 重置链表](#1273-重置链表)
            - [1.2.7.4. 双指针](#1274-双指针)
                - [1.2.7.4.1. 快慢指针](#12741-快慢指针)
                - [1.2.7.4.2. 两个数组](#12742-两个数组)
            - [1.2.7.5. 排序](#1275-排序)
        - [1.2.8. 栈](#128-栈)
            - [1.2.8.1. 栈](#1281-栈)
            - [1.2.8.2. 单调栈](#1282-单调栈)
        - [1.2.9. 队列](#129-队列)
            - [1.2.9.1. 单调队列](#1291-单调队列)
            - [1.2.9.2. 优先级队列](#1292-优先级队列)
        - [1.2.10. Hash](#1210-hash)
        - [1.2.11. 树](#1211-树)
            - [1.2.11.1. DFS](#12111-dfs)
                - [1.2.11.1.1. 属性](#121111-属性)
                - [1.2.11.1.2. 路径](#121112-路径)
                - [1.2.11.1.3. 兄弟](#121113-兄弟)
            - [1.2.11.2. BFS](#12112-bfs)
            - [1.2.11.3. 搜索二叉树](#12113-搜索二叉树)
                - [1.2.11.3.1. 创建](#121131-创建)
                - [1.2.11.3.2. 查询](#121132-查询)
                - [1.2.11.3.3. 修改](#121133-修改)
            - [1.2.11.4. 建立](#12114-建立)
            - [1.2.11.5. 修改](#12115-修改)
        - [1.2.12. 深度优先遍历和回溯](#1212-深度优先遍历和回溯)
            - [1.2.12.1. 排列](#12121-排列)
                - [1.2.12.1.1. 数字](#121211-数字)
                - [1.2.12.1.2. 字符串](#121212-字符串)
            - [1.2.12.2. 组合](#12122-组合)
                - [1.2.12.2.1. 数字](#121221-数字)
                - [1.2.12.2.2. 字符串](#121222-字符串)
                - [1.2.12.2.3. 两个数组](#121223-两个数组)
            - [1.2.12.3. 子集](#12123-子集)
            - [1.2.12.4. 切割](#12124-切割)
            - [1.2.12.5. 矩阵](#12125-矩阵)
                - [1.2.12.5.1. 一维](#121251-一维)
                - [1.2.12.5.2. 二维](#121252-二维)
        - [1.2.13. 位运算](#1213-位运算)

<!-- /TOC -->


# 1. 算法小抄  
## 1.1. 笔记  
[总结](/docs/summary.md)  
[Java基础语法](/docs/function/a-basic/JavaBasics.md)  
[算法基本概念](/docs/function/a-basic/notion.md)  
&emsp; [时间复杂度](/docs/function/a-basic/TimeComplexity.md)  
[数据结构](/docs/function/d-structure/structure.md)  
&emsp; [数组](/docs/function/d-structure/array.md)  
&emsp; &emsp; [前缀和](/docs/function/d-structure/prefixAnd.md)  
&emsp; &emsp; [排序算法](/docs/function/a-sort/sort.md)  
&emsp; &emsp; &emsp; [比较排序](/docs/function/a-sort/compare.md)  
&emsp; &emsp; &emsp; [非比较排序](/docs/function/a-sort/noCompare.md)  
&emsp; &emsp; &emsp; [外部排序](/docs/function/a-sort/externalSort.md)  
&emsp; &emsp; [查找算法](/docs/function/b-search/search.md)  
&emsp; &emsp; &emsp; [二分查找](/docs/function/b-search/BinarySearch.md)  
&emsp; &emsp; &emsp; [双指针法](/docs/function/c-doublePointer/DoublePointer.md)  
&emsp; &emsp; &emsp; [滑动窗口](/docs/function/c-doublePointer/SlidingWindow.md)  
&emsp; &emsp; [字符串](/docs/function/d-structure/String.md)  
&emsp; [链表](/docs/function/d-structure/Linked.md)  
&emsp; [栈](/docs/function/d-structure/stack.md)  
&emsp; [队列](/docs/function/d-structure/queue.md)  
&emsp; &emsp; [优先级队列](/docs/function/d-structure/priorityQueue.md)  
&emsp; [哈希](/docs/function/d-structure/hash.md)   
&emsp; [二叉树](/docs/function/d-structure/tree.md)  
&emsp; [二叉排序(查找)树](/docs/function/d-structure/binarySort.md)  
&emsp; &emsp; [平衡二叉树](/docs/function/d-structure/AVL.md)  
&emsp; &emsp; [红黑树](/docs/function/d-structure/redBlack.md)  
&emsp; [B树](/docs/function/d-structure/BTree.md)  
&emsp; [二叉堆](/docs/function/d-structure/binaryReactor.md)  
[算法思想](/docs/function/AlgorithmicIdea.md)  
&emsp; [递归](/docs/function/e-recursion/recursion.md)  
&emsp; [DFS/回溯](/docs/function/e-recursion/recall.md)  
&emsp; [BFS](/docs/function/e-recursion/BFS.md)  
&emsp; [动态规划](/docs/function/e-recursion/dynamic.md)  
&emsp; &emsp; [备忘录与动态规划](/docs/function/e-recursion/MemorandumAndDynamic.md)  
&emsp; &emsp; [动态规划解题](/docs/function/e-recursion/DynamicSolve.md)  
&emsp; [贪心](/docs/function/Greedy.md)  
[位运算](/docs/function/BitOperation.md)  
[其他数据结构](/docs/function/g-complexStructure/otherStructure.md)  
&emsp; [跳跃表](/docs/function/g-complexStructure/SkipList.md)  
&emsp; [位图](/docs/function/g-complexStructure/BitMap.md)  
&emsp; [BloomFilter](/docs/function/g-complexStructure/BloomFilter.md)  
&emsp; [HyperLogLog](/docs/function/g-complexStructure/HyperLogLog.md)  
&emsp; [Trie](/docs/function/g-complexStructure/Trie.md)  
[大数据和空间限制](/docs/function/g-complexStructure/bigdata.md)  


## 1.2. 算法  
### 1.2.1. Java  
[LRU-基于LinkedHashMap实现，不重写removeEldestEntry](src/bJava/LRU/aZZZLRUByLinkedOne.java)  
[LRU-基于LinkedHashMap实现，重写removeEldestEntry](src/bJava/LRU/bLRUByLinkedTwo.java)  
[LRU-基于Node实现](src/bJava/LRU/cLRUByNode.java)  
[Object#Join](src/bJava/JoinTest.java)  
[StudentClass](src/bJava/StudentClass.java)  
[SynchronizedTest](src/bJava/SynchronizedTest.java)  

### 1.2.2. Array  
[560.和为K的子数组](src/cArray/prefixAnd/oneDimensional/dZZZSubarraySum.java)  
[363.矩形区域不超过 K 的最大数值和](src/cArray/prefixAnd/twoDimensional/maxSumSubmatrix.java)  
[1074.元素和为目标值的子矩阵数量](src/cArray/prefixAnd/twoDimensional/numSubmatrixSumTarget.java)  

### 1.2.3. 排序  
[冒泡排序](src/dSort/aBubbleSort.java)  
[插入排序](src/dSort/bInsertionSort.java)  
[选择排序](src/dSort/cSelectionSort.java)  
[快速排序](src/dSort/dZZZQuickSort.java)  
[选择排序-小灰](src/dSort/dZZZQuickSortOfXiaohui.java)  
[利用快速排序寻找第K大数](src/dSort/dZZZQuickSortToFindKth.java)  
[归并排序-迭代](src/dSort/eMergeSortOfItera.java)  
[归并排序-递归](src/dSort/eZZZMergeSortOfRecursion.java)  
[合并k个已排序的链表](src/dSort/fMergeSortOfKLists.java)  
[希尔排序](src/dSort/gShellSort.java)  
[堆排序](src/dSort/hZZZHeapSort.java)  
[703.第 K 大元素](src/dSort/jZZZKthLargest.java)  
[347.前K 个高频元素](src/dSort/kZZZTopKFrequent.java)  

### 1.2.4. 搜索  
[二分查找](src/eSearch/aZZZBinarySearchOfIteration.java)  
[二分查找-递归解](src/eSearch/bBinarySearchOfRecursion.java)  
[二分查找的变形](src/eSearch/cBinarySearchDeformation.java)  
[“旋转数组”中的二分查找](src/eSearch/dRotatedBinarySearch.java)  
[旋转数组中的最小数字](src/eSearch/eMinNumberInRotateArray.java)  
[求平方根](src/eSearch/gMySqrtXXX.java)  


### 1.2.5. 双指针和滑动窗口  
#### 1.2.5.1. 双指针
[26. 双指针解删除有序数组中的重复项](src/fSlidingWindow/doublePointer/aRemoveDuplicates.java)  
[15. 双指针解三数之和](src/fSlidingWindow/doublePointer/bThreeSum.java)  
[18. 四数之和](src/fSlidingWindow/doublePointer/cFourSum.java)  
[11. 盛最多水的容器](src/fSlidingWindow/doublePointer/eZZZMaxAreaGGG.java)  
[42. 双指针求接雨水问题](src/fSlidingWindow/doublePointer/gTrapXXX.java)  

##### 1.2.5.1.1. 两个数组  
[88. 合并两个有序数组，A数组长度足够长](src/fSlidingWindow/doublePointer/twoArray/aMergeArray.java)  
[在两个长度相等的排序数组中找到上中位数](src/fSlidingWindow/doublePointer/twoArray/bFindMedianinTwoSortedAray.java)  


#### 1.2.5.2. 滑动窗口  
[★★★滑动窗口模板](src/fSlidingWindow/slidingWindow/aModel.java)  
[3. 双指针求无重复字符的最长子串](src/fSlidingWindow/slidingWindow/bLengthOfLongestSubstring.java)  
[最长无重复子数组](src/fSlidingWindow/slidingWindow/bNoRepetition.java)  
[413. 等差数列划分](src/fSlidingWindow/slidingWindow/eNumberOfArithmeticSlices.java)  
[209. 长度最小的子数组](src/fSlidingWindow/slidingWindow/fMinSubArrayLen.java)  
[1456. 定长子串中元音的最大数目](src/fSlidingWindow/slidingWindow/gMaxVowels.java)  
[1438. 绝对差不超过限制的最长连续子数组](src/fSlidingWindow/slidingWindow/kLongestSubarray.java)  
[395. 至少有K个重复字符的最长子串](src/fSlidingWindow/slidingWindow/lLongestSubstringXXX.java)  
[239. 滑动窗口最大值](src/fSlidingWindow/slidingWindow/zMaxSlidingWindowXXXXX.java)  

##### 1.2.5.2.1. 替换
[1208. 尽可能使字符串相等](src/fSlidingWindow/slidingWindow/replace/cEqualSubstring.java)  
[424. 双指针解替换后的最长重复字符](src/fSlidingWindow/slidingWindow/replace/dZZZCharacterReplacement.java)  
[滑动窗口解最大连续1的个数 III](src/fSlidingWindow/slidingWindow/replace/eLongestOnes.java)  

##### 1.2.5.2.2. 两个数组
[76. 最小覆盖子串-自己](src/fSlidingWindow/slidingWindow/twoArray/aMinimumCoveringSubstringOfOneself.java)  
[76. 最小覆盖子串](src/fSlidingWindow/slidingWindow/twoArray/aZZZMinimumCoveringSubstringOfOther.java)  
[567. 字符串的排列](src/fSlidingWindow/slidingWindow/twoArray/bZZZCheckInclusion.java)  
[438. 找到字符串中所有字母异位词](src/fSlidingWindow/slidingWindow/twoArray/cZZZFindAnagrams.java)  
[1044. 最长【重复】子串](src/fSlidingWindow/slidingWindow/twoArray/dLongestDupSubstringXXX.java)  
[407，动态规划和滑动窗口解决最长重复子数组](src/fSlidingWindow/slidingWindow/twoArray/zFindLengthXXXXX.java)  


### 1.2.6. 字符串  
#### 1.2.6.1. 单字符串  
[反转字符串-不考虑字符串开头有空格](src/fString/single/aStringReverse.java)  
[反转字符串-考虑字符串开头有空格](src/fString/single/bStringReverse.java)  
[验证回文串](src/fString/single/cValidPalindrome.java)  
[回文子串的个数](src/fString/single/dPalindromeSubstring.java)  
[8. 字符串转换整数](src/fString/single/eZZZStringToNumber.java)  

#### 1.2.6.2. 双字符串  
[14. 最长公共前缀](src/fString/two/LongestCommonPrefix.java)  


### 1.2.7. 链表  
#### 1.2.7.1. 删除链表节点
[链表删除节点的两种方式](src/gLinked/aDelete/aZZZDeleteNode.java)  
[19. 删除链表的倒数第 N 个结点](src/gLinked/aDelete/bRemoveNthFromEnd.java)  
[83. 删除排序链表中的重复元素](src/gLinked/aDelete/cDeleteDuplicates2.java)  
[82. 删除排序链表中的重复元素 II](src/gLinked/aDelete/dDeleteDuplicates.java)  

#### 1.2.7.2. 反转链表  
[不带头节点单向链表，双指针迭代反转链表](src/gLinked/bReversal/aZZZInvertLinkedListOfIterate.java)  
[~~不带头节点单向链表，递归反转链表~~](src/gLinked/bReversal/bInvertLinkedListOfRecursion.java)  
[链表内指定区间反转](src/gLinked/bReversal/cZZZReverseBetween.java)  
[K 个一组翻转链表](src/gLinked/bReversal/dZZZReverseKGroup.java)  
[是否回文链表](src/gLinked/bReversal/lIsPail.java)  

#### 1.2.7.3. 重置链表  
[86. 分隔链表](src/gLinked/cReset/aPartition.java)  
[328. 奇偶链表](src/gLinked/cReset/bOddEvenList.java)  
[725. 分隔链表](src/gLinked/cReset/cSplitListToPartsXXX.java)  
[合并两个有序链表](src/gLinked/cReset/dMergeOrderedList.java)  
[23. 合并K个升序链表](src/gLinked/cReset/eMergeKLists.java)  

#### 1.2.7.4. 双指针  
##### 1.2.7.4.1. 快慢指针  
[链表快慢指针找到单链表中间节点](src/gLinked/dDoublePointer/SpeedPointer/aSpeedPointer.java)  
[链表环](src/gLinked/dDoublePointer/SpeedPointer/bZZZCrossLink.java)  
[NC132 环形链表的约瑟夫问题](src/gLinked/dDoublePointer/SpeedPointer/cZZZCrossJoseph.java)  
[160. 相交链表](src/gLinked/dDoublePointer/SpeedPointer/dGetIntersectionNodeXXX.java)  

##### 1.2.7.4.2. 两个数组  
[160. 相交链表](src/gLinked/dDoublePointer/twoArray/aAddTwoNumbers.java)  
[445. 两数相加 II](src/gLinked/dDoublePointer/twoArray/bAddTwoNumbers.java)  

#### 1.2.7.5. 排序 
[147. 对链表进行插入排序](src/gLinked/eSort/aZZZInsertionSortList.java)  
[148. 排序链表](src/gLinked/eSort/bSortListXXX.java)  


### 1.2.8. 栈  
#### 1.2.8.1. 栈  
[946. 验证栈序列](src/hStack/aStack/aValidateStackSequences.java)  
[利用栈实现字符串逆序](src/hStack/aStack/bStringReversal.java)  
[20. 有效的括号](src/hStack/aStack/cStringMatch.java)  
[224. 基本计算器](src/hStack/aStack/dZZZCalculate.java)  
[227. 使用栈解基本计算器 II](src/hStack/aStack/eZZZCalculate.java)  
[150. 逆波兰表达式求值](src/hStack/aStack/fZZZEvalRPN.java)  
[232. 用栈实现队列](src/hStack/aStack/zMyQueue.java)  

#### 1.2.8.2. 单调栈  
[519，单调栈解下一个更大元素 I](src/hStack/bMonotoneStack/aNextGreaterElement.java)  
[单调栈解下一个更大元素 II - 循环数组](src/hStack/bMonotoneStack/bNextGreaterElements.java)  
[1019. 链表中的下一个更大节点](src/hStack/bMonotoneStack/cNextLargerNodes.java)  
[739. 温度](src/hStack/bMonotoneStack/dDailyTemperatures.java)  
[84. 柱状图中最大的矩形（难）](src/hStack/bMonotoneStack/eLargestRectangleAreaXXX.java)  
[42. 接雨水问题](src/hStack/bMonotoneStack/fTrap.java)  
[3250. 看到的牛](src/hStack/bMonotoneStack/gGetSeeLowSum.java)  


### 1.2.9. 队列  
[225. 用队列实现栈](src/iQueue/MyStack.java)  

#### 1.2.9.1. 单调队列  
[239. 滑动窗口最大值](src/iQueue/monotonous/MaxSlidingWindowXXX.java)  

#### 1.2.9.2. 优先级队列  
[优先级队列](src/iQueue/priorityQueue/aPriorityQueue.java)  
[215. 数组中的第K个最大元素](src/iQueue/priorityQueue/bFindKthLargest.java)  
[347.前 K 个高频元素](src/iQueue/priorityQueue/cTopKFrequent.java)  
[703. 数据流中的第 K 大元素](src/iQueue/priorityQueue/dKthLargest.java)  


### 1.2.10. Hash  
[387. 字符串中的第一个唯一字符](src/jHash/bFirstNotRepeatingChar.java)  
[数组中出现次数超过一半的数字](src/jHash/cMoreThanHalfNum.java)   


### 1.2.11. 树  
#### 1.2.11.1. DFS  
[深度优先遍历](src/kTree/aDFS/aDepthOrderTraversal.java)  
[深度优先遍历-递归](src/kTree/aDFS/bDepthOrderTraveralWithStack.java)  
[987. 二叉树的垂序遍历](src/kTree/aDFS/verticalTraversal.java)  

##### 1.2.11.1.1. 属性  
[110. 平衡二叉树](src/kTree/aDFS/aAttribute/zuo/aIsBalanced.java)  
[是否为搜索二叉树和完全二叉树](src/kTree/aDFS/aAttribute/zuo/bJudgeIt.java)  
[222. 完全二叉树的节点个数](src/kTree/aDFS/aAttribute/cCountNodes.java)  
[111. 二叉树的最小深度](src/kTree/aDFS/aAttribute/dMinDepth.java)  
[104. 二叉树的最大深度](src/kTree/aDFS/aAttribute/dZZZMaxDepth.java)  
[559. N叉树的最大深度](src/kTree/aDFS/aAttribute/eMaxDepthOfN)  
[剑指Offer-树的子结构](src/kTree/aDFS/aAttribute/cCountNodes.java)  
[404. 左叶子之和](src/kTree/aDFS/aAttribute/fIsSubStructureXXX.java)  
[513.找树左下角的值](src/kTree/aDFS/aAttribute/kTraversalXXX.java)  

##### 1.2.11.1.2. 路径  
[257. 二叉树的所有路径](src/kTree/aDFS/bPath/aAllPath.java)  
[二叉树所有路径-数字](src/kTree/aDFS/bPath/aZZZAllPathOfNum.java)  
[129. DFS和BFS解求根到叶子节点数字之和](src/kTree/aDFS/bPath/bSumNumbersXXX.java)  
[112. 路径总和](src/kTree/aDFS/bPath/cHasPathSum.java)  
[113. 路径总和 II](src/kTree/aDFS/bPath/dPathSum.java)  
[437. 路径总和 III](src/kTree/aDFS/bPath/eZZZPathSumXXX.java)  
[124. 二叉树中的最大路径和](src/kTree/aDFS/bPath/fZZZMaxPathSum.java)  
[543. 二叉树的直径](src/kTree/aDFS/bPath/gZZZDiameterOfBinaryTree.java)  
[二叉树的最大距离](src/kTree/aDFS/bPath/MaxDistance.java)  

##### 1.2.11.1.3. 兄弟
[993. 二叉树的堂兄弟节点](src/kTree/aDFS/cBrother/isCousins.java)  
[236. 二叉树的最近公共祖先](src/kTree/aDFS/cBrother/LowestCommonAncestor.java)  

#### 1.2.11.2. BFS  
[层序遍历](src/kTree/bBFS/aLevelOrderTraversal.java)  
[层序遍历，每一层结束](src/kTree/bBFS/bZZZLevelTraversalOfEnd.java)  
[104. 二叉树的最大深度](src/kTree/bBFS/eTreeMaxWidth.java)  
[1302. BFS和DFS解层数最深叶子节点的和](src/kTree/bBFS/fDeepestLeavesSum.java)  
[662. 二叉树最大宽度](src/kTree/bBFS/gZZZWidthOfBinaryTreeXXX.java)  
[101. 对称二叉树](src/kTree/bBFS/iIsSymmetric.java)  
[1609. BFS和DFS解奇偶树](src/kTree/bBFS/jIsEvenOddTree.java)  

#### 1.2.11.3. 搜索二叉树  
##### 1.2.11.3.1. 创建  
[701. 二叉搜索树中的插入操作](src/kTree/cBinarySearch/c/aInsertIntoBST.java)  
[108. 将有序数组转换为二叉搜索树](src/kTree/cBinarySearch/c/bSortedArrayToBST.java)  
[538. 把二叉搜索树转换为累加树](src/kTree/cBinarySearch/c/cConvertBST.java)  

##### 1.2.11.3.2. 查询  
[700. 二叉搜索树中的搜索](src/kTree/cBinarySearch/r/aSearchBST.java)  
[98. 验证二叉搜索树](src/kTree/cBinarySearch/r/bIsValidBST.java)  
[235. 二叉搜索树的最近公共祖先](src/kTree/cBinarySearch/r/cLowestCommonAncestor.java)  
[剑指 Offer-二叉搜索树的后序遍历序列](src/kTree/cBinarySearch/r/dVerifyPostorder.java)  
[501.二叉搜索树中的众数](src/kTree/cBinarySearch/r/findMode.java)  
[530.二叉搜索树的最小绝对差](src/kTree/cBinarySearch/r/getMinimumDifference.java)  
[230. 二叉搜索树中第K小的元素](src/kTree/cBinarySearch/r/kthSmallest.java)  
[二叉搜索树的范围和](src/kTree/cBinarySearch/r/rangeSumBST.java)  


##### 1.2.11.3.3. 修改  
[450. 删除二叉搜索树中的节点](src/kTree/cBinarySearch/u/deleteNode.java)  
[669. 修剪二叉搜索树](src/kTree/cBinarySearch/u/trimBST.java)  


#### 1.2.11.4. 建立  
[106. 从中序与后序遍历序列构造二叉树](src/kTree/dBuild/buildTree.java)  
[从前序与中序遍历序列构造二叉树](src/kTree/dBuild/buildTree1.java)  
[654.最大二叉树](src/kTree/dBuild/constructMaximumBinaryTree.java)  
[重建二叉树](src/kTree/dBuild/ReConstructBinaryTree.java)  
[1028. 从先序遍历还原二叉树](src/kTree/dBuild/recoverFromPreorder.java)  

#### 1.2.11.5. 修改  
[617. 合并二叉树](src/kTree/eEidt/aMergeTrees.java)  
[226. 翻转二叉树](src/kTree/eEidt/bInvertTree.java)  

### 1.2.12. 深度优先遍历和回溯  
[生成括号](src/nDFSAndBacktrack/bGenerateParenthesis.java)  

#### 1.2.12.1. 排列  
##### 1.2.12.1.1. 数字  
[46. 数组全排列-自己](src/nDFSAndBacktrack/aRandk/num/aPrientAllSortOfOneself.java)  
[46. 数组全排列-其他](src/nDFSAndBacktrack/aRandk/num/bPrientAllSortOfOther.java)  
[47. 一个可包含重复数字的序列](src/nDFSAndBacktrack/aRandk/num/cZZZPrientAllSortTwo.java)  

##### 1.2.12.1.2. 字符串    
[字符串全排列-自己](src/nDFSAndBacktrack/aRandk/str/aPrientAllSortOfOneself.java)  
[字符串全排列-其他](src/nDFSAndBacktrack/aRandk/str/bPrientAllSortOfOther.java)  
[字符串去重全排列](src/nDFSAndBacktrack/aRandk/str/cPrintAllSortNoRepetition.java)  

#### 1.2.12.2. 组合  
##### 1.2.12.2.1. 数字  
[77.组合](src/nDFSAndBacktrack/bCombine/num/aZZZCombinationSum.java)  
[40.组合总和](src/nDFSAndBacktrack/bCombine/num/bCombinationSum2.java)  
[39. 组合总和，candidates 中的数字可以无限制重复被选取](src/nDFSAndBacktrack/bCombine/num/cZZZCombinationSum.java)  
[216.组合总和III](src/nDFSAndBacktrack/bCombine/num/eCombinationSum3.java)  

##### 1.2.12.2.2. 字符串  
[字符串组合-自己](src/nDFSAndBacktrack/bCombine/str/gPrintAllSubsquenceOfOneself.java)  
[字符串组合-其他](src/nDFSAndBacktrack/bCombine/str/gPrintAllSubsquenceOfother.java)  
[字符串的所有子序列(字符串的组合) 去重](src/nDFSAndBacktrack/bCombine/str/hPrintAllSubsquenceNoRepetition.java)  

##### 1.2.12.2.3. 两个数组  
[17.电话号码的字母组合](src/nDFSAndBacktrack/bCombine/twoArry/letterCombinations.java)  

#### 1.2.12.3. 子集  
[78. 子集](src/nDFSAndBacktrack/cSubset/aZZZSubsets.java)  
[90. 子集II](src/nDFSAndBacktrack/cSubset/bSubsetsWithDup.java)  

#### 1.2.12.4. 切割  
[139. 单词拆分](src/nDFSAndBacktrack/dDivision/aZZZWordBreak.java)  
[140. 回溯算法和DFS解 单词拆分 II](src/nDFSAndBacktrack/dDivision/bWordBreakTwo.java)  
[131，回溯算法解分割回文串](src/nDFSAndBacktrack/dDivision/cSplitToPalindromes.java)  
[132. 分割回文串 II](src/nDFSAndBacktrack/dDivision/cSplitToPalindromesII.java)  
[93.复原IP地址](src/nDFSAndBacktrack/dDivision/dRestoreIpAddresses.java)  
[282. 给表达式添加运算符（回溯算法解决）](src/nDFSAndBacktrack/dDivision/eAddOperators.java)  
[494. DFS解目标和问题](src/nDFSAndBacktrack/dDivision/fZZZFindTargetSumWays.java)  
[473. 火柴拼正方形](src/nDFSAndBacktrack/dDivision/gZZZMakesquareXXX.java)  
[698 回溯算法解划分为k个相等的子集](src/nDFSAndBacktrack/dDivision/hCanPartitionKSubsets.java)  
[473. 火柴拼正方形](src/nDFSAndBacktrack/dDivision/gZZZMakesquareXXX.java)  
[842. 将数组拆分成斐波那契序列](src/nDFSAndBacktrack/dDivision/splitIntoFibonacci.java)  

#### 1.2.12.5. 矩阵  
##### 1.2.12.5.1. 一维  
[剑指 Offer-使用DFS和BFS解机器人的运动范围](src/nDFSAndBacktrack/eMatrix/oneDimensional/aMovingCount.java)  
[51. 九皇后](src/nDFSAndBacktrack/eMatrix/oneDimensional/NineQueens.java)  

##### 1.2.12.5.2. 二维  
[01 矩阵](src/nDFSAndBacktrack/eMatrix/twoDimensional/aUpdateMatrixXXX.java)  
[79. 单词搜索](src/nDFSAndBacktrack/eMatrix/twoDimensional/bExist.java)  
[212. 单词搜索 II](src/nDFSAndBacktrack/eMatrix/twoDimensional/bExistII.java)  
[NC109 岛屿数量](src/nDFSAndBacktrack/eMatrix/twoDimensional/cIslandsNumXXX.java)  
[求岛屿的最大面积](src/nDFSAndBacktrack/eMatrix/twoDimensional/dMaxAreaOfIsland.java)  
[1219. 黄金矿工](src/nDFSAndBacktrack/eMatrix/twoDimensional/eGetMaximumGold.java)  
[37. 解数独](src/nDFSAndBacktrack/eMatrix/twoDimensional/solveSudoku.java)  



### 1.2.13. 位运算  
[136. 只出现一次的数字](src/rBitOperation/aSingleNumber.java)  
[260. 只出现一次的数字 III：位运算](src/rBitOperation/cSingleNumberIII.java)  
[268. 丢失的数字](src/rBitOperation/dMissingNumber.java)  
[389. 寻找不同](src/rBitOperation/eFindTheDifference.java)  

