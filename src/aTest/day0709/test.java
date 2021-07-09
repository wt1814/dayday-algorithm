package aTest.day0709;

public class test {


    public String solve (int[] nums) {
        // write code here

        if(nums.length == 0){
            return "";
        }

        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j>0;j--){
                if(Integer.valueOf(String.valueOf(nums[j])+String.valueOf(nums[j-1])) > Integer.valueOf(String.valueOf(nums[j-1])+String.valueOf(nums[j]))){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            sb.append(String.valueOf(nums[i]));
        }
        return sb.toString();
    }
}
