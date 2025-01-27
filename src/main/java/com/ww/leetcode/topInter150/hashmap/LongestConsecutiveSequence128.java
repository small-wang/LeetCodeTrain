package com.ww.leetcode.topInter150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2025/1/2 10:14
 *
 * 通过HashMap记录每个数的连续数字长度（key表示当前数，value表示当前数记录的连续数字串长度）
 * 由于数字key加入到一个连续数字串时，必须是从连续数字串的最左端，或者最右端加入
 * 所以只需要保持当前连续数字串，最左侧和最右侧的数key，记录的值value等于数字串的长度
 *
 * 例如：当有一个元素a满足从左侧加入时，取a+1元素的value，记录元素a的值等于value+1，记录元素a+value的指等于value+1
 * 同理：当有一个元素b满足从右侧加入时，取b-1元素的value,记录元素b的值等于value+1，记录元素b-value的指等于value+1
 */
public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        int result = 0;

        if (null == nums || 0 == nums.length) {
            return result;
        } else {
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i <= nums.length - 1; i++) {
                if (numsMap.getOrDefault(nums[i], 0) > 0) {
                    continue;
                } else {
                    int leftCount = numsMap.getOrDefault(nums[i] - 1 ,0);
                    int rightCount = numsMap.getOrDefault(nums[i] + 1 ,0);
                    int count = leftCount + rightCount + 1;
                    numsMap.put(nums[i], count);
                    if (0 != leftCount) {
                        numsMap.put(nums[i] - leftCount, count);
                    }
                    if (0 != rightCount) {
                        numsMap.put(nums[i] + rightCount, count);
                    }

                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }

//    public int longestConsecutive(int[] nums) {
//        if (null == nums || 0 == nums.length) {
//            return 0;
//        }
//
//        int result = 1;
//        Set<Integer> numsSet = new HashSet<>();
//        Set<Integer> iterSet = new HashSet<>();
//
//        for (int i = 0; i <= nums.length - 1; i++) {
//            numsSet.add(nums[i]);
//        }
//
//        for (int i = 0; i <= nums.length - 1; i++) {
//            if (iterSet.contains(nums[i])) {
//                continue;
//            } else {
//                if (numsSet.contains(nums[i] - 1)) {
//                    iterSet.add(nums[i]);
//                } else {
//                    int j = 1;
//                    while (true) {
//                        if (numsSet.contains(nums[i] + j)) {
//                            iterSet.add(nums[i] + j);
//                            j++;
//                            result = Math.max(result, j);
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence128().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
