package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2023/11/3 8:39
 */
public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i : nums) {
            if(0 == count) {
                result = i;
                count++;
            } else if(result == i) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElement169 majorityElement169 = new MajorityElement169();
        int[] nums = {0,0,0,0,0,0,0,0,2,2,1,1,1,2,2};

        int result = majorityElement169.majorityElement(nums);
        System.out.println(result);
    }
}
