package pDP.bString.two;

/**
 * KMP算法
 * todo 两个字符串比较的普通思路，不匹配时，待匹配的模式串向右移动一个位置。
 * todo 优化：当模式串有公共的前缀和后缀（acddddac，ac就是公共的前缀和后缀），直接移动到后缀的位置
 * kmp算法：当不匹配时，找最长公共前后缀，移动到后缀部分
 */
public class KMP {

    // 字符串匹配的KMP算法
    //https://mp.weixin.qq.com/s?__biz=MzIwNTc4NTEwOQ==&mid=2247486950&idx=1&sn=61185c72b270891a0e1aa0db1f9a627f&chksm=972adc9ca05d558a3d5e8a505b29937768e6f47b6c318bc6cc478803d9634e2f4555c26179f9&mpshare=1&scene=1&srcid=&key=00a8e91eefd868fc0218770ad47efc19a0eb1837e26a2fde21a4e6ae367993f51dcfd216c2397954d6a4de33fa5f65dd63b8b620d6e981902b0f9ace3bbbf335784449a15c08450df602e9229d6857de&ascene=1&uin=MTE1MTYxNzY2MQ%3D%3D&devicetype=Windows+10&version=62060833&lang=zh_CN&pass_ticket=eg5OolRG8y0%2Bw9bavl09Uyc6GPxVmhjvDrWe622XQSg9XG10VZWa9GR31nV6T9cV
    //KMP算法，字符串匹配：
    //动态规划之 KMP 算法详解(配代码版)
    //https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247486490&idx=3&sn=35ba410818207a1bef83d6578f4b332c&chksm=fa0e639bcd79ea8dff1141a8729cf4b1243d23ac276652a58fc23d7b6b2ce01ca2666feab293&mpshare=1&scene=1&srcid=&sharer_sharetime=1569055567478&sharer_shareid=b256218ead787d58e0b58614a973d00d&key=20f7b87cb3d4d9a8e94f75ad1bbd1fe8ed4af91513a424bebd0c4df328ea367a462e742f0885a4dbf9693a65560f764378ab2da5e0d620daa8cd627756a8d79b7b364eb9ccf4a8629e46dad4de38545d&ascene=1&uin=MTE1MTYxNzY2MQ%3D%3D&devicetype=Windows+10&version=62060844&lang=zh_CN&pass_ticket=l152qY7UDy13%2FQ8lMQftZpzwON66UoS8zNnRNqU0gQ1B38kfpkeCoh6I%2F0Cu%2FOwX

    // 视频讲解：https://www.bilibili.com/video/BV1jb411V78H?from=search&seid=16480680497195823788
    // 视频讲解：计算next函数值：https://www.bilibili.com/video/BV12J411m74v/?spm_id_from=autoNext

    // 重学KMP： https://mp.weixin.qq.com/s/MoRBHbS4hQXn7LcPdmHmIg


}
