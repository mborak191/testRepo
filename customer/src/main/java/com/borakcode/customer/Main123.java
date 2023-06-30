package com.borakcode.customer;

import java.util.HashMap;
import java.util.Map;

public class Main123 {

    public static void main(String[] args) {

        int[] nums  = new int[]{1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));

        int countPairs = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i + 1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    countPairs++;
                }
            }
        }
        System.out.println(countPairs);
    }

    public static int numIdenticalPairs(int[] nums) {

        Map<Integer,Integer> occurences = new HashMap<>();
        int count = 1;
        int goodPairs = 0;
        for(int i = 0; i<nums.length; i++){
            if (!occurences.containsKey(nums[i])){
                occurences.put(nums[i],count);
            }
            else{
                Integer replacedValue = occurences.get(nums[i]) + count;
                occurences.replace(nums[i], replacedValue);
            }
        }

     for(Map.Entry<Integer, Integer> entry : occurences.entrySet()){
            Integer value = entry.getValue();

            if(value>1){
                goodPairs+= (value * (value-1)) / 2;
            }
        }

     return goodPairs;

    }
}
