/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

import java.util.Arrays;

public class C1两数之和 {
    public static void main(String[] args) {
        int[] nums =  {3,3};
        int target = 6;

        int[] res = twoSum(nums, target);

        Arrays.stream(res).forEach(System.out::println);
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];

        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
}
