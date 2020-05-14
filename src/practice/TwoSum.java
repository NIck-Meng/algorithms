package practice;


import java.util.Random;

import java.util.HashMap;

public class TwoSum {
    private  int[] twoSum1(int[] nums, int target) {
        int[] array = new int[2];
        for(int i=0;i!=nums.length;i++){
            for(int j=i+1;j!=nums.length;j++){
                int temp=nums[i]+nums[j];
                if(temp==target) {
                    array[0]=i;
                    array[1]=j;
                    break;
                }
            }
        }
        return array;
    }

    private int[] twoSum2(int[] nums,int target){
        int[] res=new int[2];
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            integerIntegerHashMap.put(nums[i],i);
        }
        for (int num : nums) {
            int temp = target - num;
            if (integerIntegerHashMap.containsKey(temp)) {
                int index2 = integerIntegerHashMap.get(temp);
                res[0] = num;
                res[1] = index2;
                break;
            }

        }
        
        return res;
    }



    public static void main(String[] args){
        int[] array=new int[100000];
        Random random = new Random(1);
        for(int i=0;i<array.length;i++) {
            int anInt = random.nextInt(500);
            array[i]=anInt;
        }
//        int[] array={1,2};
        int target=855;
        TwoSum solution=new TwoSum();



        int loopTimes=10;
        long startTime1 = System.currentTimeMillis();    //获取开始时间
        for(int i=0;i<loopTimes;i++){
            solution.twoSum1(array, target);
        }
        long endTime1 = System.currentTimeMillis();    //获取结束时间
        System.out.println("sum1程序运行时间：" + (endTime1 - startTime1)/loopTimes + "ms");    //输出程序运行时间





        long startTime = System.currentTimeMillis();    //获取开始时间
        for(int i=0;i<loopTimes;i++){
            solution.twoSum2(array, target);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("sum2运行时间：" + (endTime - startTime)/loopTimes + "ms");    //输出程序运行时间


    }
}
