package aTest.day0721;

/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=188&&tqId=38615&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 *
 */
public class test {

    public static void main(String[] args){
        int[] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int [] array) {

        if(array.length == 0){
            return -1;
        }

        int left = 0;
        int right = array.length-1;

        while(left < right){
            int mid = left +(right - left)/2;
            if(array[left] <= array[mid] && array[mid] <= array[right]){
                right--;
            }else if(array[left] <= array[mid] && array[mid] >= array[right]){
                left = mid+1;
            }else if(array[left] >= array[mid] && array[mid] <= array[right]){
                right = mid-1;
            }else if(array[left] >= array[mid] && array[mid] >= array[right]){
                right = mid-1;
            }

        }
        return array[left];
    }

}
