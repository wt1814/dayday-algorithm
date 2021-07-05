package aTest.day0705;

public class minMoney {


    public static void main(String[] args) {
        int[] arr = {5,2,3};
        int aim = 20;
        System.out.println(minMoney(arr,aim));
    }

    public static int minMoney (int[] arr, int aim) {
        // write code here
        if(aim == 0){
            return 0;
        }
        int result = 0;
        sort(arr);
        if(aim<arr[arr.length-1]){
            return -1;
        }
        for(int i = 0;i<arr.length;i++){
            int num = aim/arr[i];
            aim = aim -  arr[i]*num;
            result = result +num;
            if(aim == 0){
                break;
            }

            if(arr[arr.length-1] %aim != 0){
                result = -1;
            }
        }
        return result;

    }

    public static void sort(int[] arr){
        int temp;//定义一个临时变量
        for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){ //todo 最后的xxx不需要再次比较了
                if(arr[j+1]>arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
