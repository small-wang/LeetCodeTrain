package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2024/12/20 15:17
 */
public class IntegertoRoman12 {

    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000 % 10] + C[num / 100 % 10] + X[num / 10 % 10] + I[num % 10];
    }

    public static void main(String[] args) {
        IntegertoRoman12 integertoRoman12 = new IntegertoRoman12();
        System.out.println(integertoRoman12.intToRoman(2930));
    }
}
