package com.ly;

/**
 * @author yong.liang
 * 2018/10/5
 */
public class KMP {

    public static void main(String[] args) {
        char[] arrayA = ("acaba" +
                "" +
                "abaabcacacabc").toCharArray();
        char[] arrayB = "abaabcac".toCharArray();
        int[] next = next(arrayB);
        int i = 0, j = 0;
        while (i <= arrayA.length - 1 && j <= arrayB.length - 1) {
            if (j == -1 || arrayA[i] == arrayB[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        System.out.println("j==" + j);
        if (j > arrayB.length - 1) System.out.println(i - arrayB.length);
        else System.out.println(0);
    }

    public static int[] next(char[] array) {
        int[] next = new int[array.length];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < array.length - 1) {
            if (j == -1 || array[i] == array[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }

        for (int k = 0; k < array.length; k++) {
            System.out.println(next[k]);
        }

        return next;
    }
}
