package com.ww.leetcode.arrayAndString;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * @since 2024/12/17 13:30
 */
public class InsertDeleteGetRandom380 {

    private LinkedList<Integer> list = new LinkedList<>();

    public InsertDeleteGetRandom380() {

    }

    public boolean insert(int val) {
        for (Integer i : list) {
            if (i == val) {
                return false;
            }
        }

        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == val) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public int getRandom() {
        int length = list.size();
        Random random = new Random();
        return list.get(random.nextInt(length));
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(6));
    }


}
