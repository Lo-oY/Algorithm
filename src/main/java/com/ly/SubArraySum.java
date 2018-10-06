package com.ly;

/**
 * @author yong.liang
 * 2018/10/5
 * 连续子数组的最大和
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, -5, 1, 2, 3, -12, 2, 5, 6, 7, 8};
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            maxSum = maxSum > sum ? maxSum : sum;
            if (sum < 0)
                sum = 0;
        }
        System.out.println(maxSum);
    }
}
