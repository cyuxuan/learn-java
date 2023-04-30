package club.beenest.algorithm.leetcode.books.IntermediateAlgorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-medium/xv33m7/
 * 括号生成
 *
 * @author 陈玉轩
 */
public class GenerateParenthesis {
    private static List<String> list = new ArrayList<>();
    private static int a = 0;

    public static void main(String[] args) {
        int n = 6;
        doGenerateParenthesis(n);
    }

    /**
     * 生成对应的括号对数
     * 采用回溯遍历的方式
     *
     * @param n 括号对的数量
     */
    private static void doGenerateParenthesis(int n) {
        // 生成对应的数据
        StringBuilder sb = new StringBuilder();
    }
}
