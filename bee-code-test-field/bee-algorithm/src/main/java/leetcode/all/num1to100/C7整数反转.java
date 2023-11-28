/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

public class C7整数反转 {
    public static void main(String[] args) {
        C7整数反转 test = new C7整数反转();
        int a = test.reverse(123);
        System.out.println(a);
        // System.out.println(-1 % 10);
    }

    public int reverse(int x) {
        long b = 0;
        while (x != 0) {
            long c = x % 10;
            x = x / 10;
            b = b * 10 + c;
        }
        if(b > Integer.MAX_VALUE || b <  Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)b;
        }
    }
}
