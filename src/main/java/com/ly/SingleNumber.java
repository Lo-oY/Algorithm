package com.ly;

/**
 * 一个只出现一次的数字
 *
 * @author yong.liang
 * 2018/9/27
 */
public class SingleNumber {
    public static void main(String args[]) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 8, 8, 9, 9, 10};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
    }
}
