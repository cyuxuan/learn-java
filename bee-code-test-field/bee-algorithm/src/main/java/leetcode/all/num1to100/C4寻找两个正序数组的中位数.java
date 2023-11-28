/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

public class C4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
      C4寻找两个正序数组的中位数 test = new C4寻找两个正序数组的中位数();
      int[] nums1 = {1,3};
      int[] nums2 = {}; // 1,2,2,3,3,4,4,5
      double a = test.findMedianSortedArrays(nums1,nums2);
      System.out.println(a);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 计算总数量
        int sumn = nums1.length + nums2.length;
        // 判断当前数据是偶数还是奇数
        int is = sumn;
        // 判断当前的a
        is = is & 0x0001;
        int b = (sumn + 1) / 2;
        // 如果其中一个为0则直接取另一个的值
        if(nums1.length == 0) {
            if(is == 0) {
                return (nums2[b - 1] + nums2[b]) / 2.0;
            } else {
                return nums2[b - 1];
            }
        }
        if(nums2.length == 0) {
            if(is == 0) {
                return (nums1[b - 1] + nums1[b]) / 2.0;
            } else {
                return nums1[b - 1];
            }
        }

        b = b + 1;
        int i = 0;
        int j = 0;
        int k = 1;
        // 记录上一个被移除的数字
        int m1 = 0;
        int m2 = 0;
        while(true) {
            if(k > b) {
                break;
            }
            if(i >= nums1.length) {
                // 数组1没有多余的元素, 移动数据2的元素
                m2 = m1;
                m1 = nums2[j];
                j++;
            } else if(j >= nums2.length) {
                // 数组2没有多余的元素，移动数组1的元素
                m2 = m1;
                m1 = nums1[i];
                i++;
            } else {
                // 否则进一步判断
                if(nums1[i] < nums2[j]) {
                    // 此时数组1的坐标往后移动
                    m2 = m1;
                    m1 = nums1[i];
                    i++;
                } else {
                    // 否则数组2的坐标往后移动
                    m2 = m1;
                    m1 = nums2[j];
                    j++;
                }
            }


            // 计数
            k++;
        }
        if(is == 0) {
            return (m1 + m2) / 2.0;
        } else {
            return m2;
        }
    }
}
