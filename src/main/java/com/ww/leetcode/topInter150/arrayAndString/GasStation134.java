package com.ww.leetcode.topInter150.arrayAndString;

import java.util.Arrays;

/**
 * @since 2024/12/18 9:25
 */
public class GasStation134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasTotal = 0;
        int costTotal = 0;
        int minSum = 0;
        int minSumIndex = 0;
        int[] sum = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            sum[i] = gas[i] - cost[i];
            if (sum[i] < minSum) {
                minSum = sum[i];
                minSumIndex = i;
            }
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if (gasTotal < costTotal) {
            return -1;
        } else {
            for (int i = 1; i <= sum.length; i++) {
                int index = (minSumIndex + i) % sum.length;
                if (canCompleteCircuitIndex(sum, index)) {
                    return index;
                }
            }
        }

        return -1;
    }

    private boolean canCompleteCircuitIndex(int[] sum, int i) {
        int j = i;
        int count = sum[i];
        if (count < 0) {
            return false;
        }

        while (true) {
            j = (j + 1) % sum.length;
            if (j == i) {
                break;
            }

            count += sum[j];
            if (count < 0) {
                break;
            }
        }

        if (count >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.deepToString(args));
    }
}
