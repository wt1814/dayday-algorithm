


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











