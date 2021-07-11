package jSlidingWindow;

/**
 * 最长重复子串 https://www.nowcoder.com/practice/4fe306a84f084c249e4afad5edf889cc?tpId=188&&tqId=38654&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * todo 双指针解法， 非滑动窗口
 */
public class dSolve {

    public static void main(String[] args){
        int solve = solve("abcdiiiiiiiiiiiiadiiiiiiiiiiabcr'");
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println(solve);
    }

    public static int solve (String a) {
        // write code here
        int result = 0;

        char[] arr = a.toCharArray();
        int len = arr.length-1;

        int left = 0;
        int right = len;

        for (int i = right;i>=0;i--){
            for (int j=left;j<i;j++){
                if (isChongFu(arr,j,i)){
                    result = Math.max(result,i-j+1);
                    break;
                }
            }
        }


/*        while(right >= 0){
            right--;
*//*            if (isChongFu(arr,left,right)){
                result = Math.max(result,right-left+1);
                break;
            }
            left++;*//*

            while(left<=len && isChongFu(arr,left,right)){

                System.out.println(left);
                System.out.println(right);
                System.out.println("----------------");

                result = Math.max(result,right-left+1);
                left++;
            }

        }*/

        return result;

    }

    public static boolean isChongFu(char[] arr,int left,int right){
        if((right - left +1)%2 ==1){
            return false;
        }
        boolean result = true;
        int len = arr.length;
        int mid = left + (right - left)/2;

        for(int i = left;i<=mid;i++){
            int rightTemp = mid+(i-left+1);
            if(rightTemp <= len-1 && arr[i] !=  arr[rightTemp]){
                result = false;
                break;
            }
        }
        return result;
    }

}
