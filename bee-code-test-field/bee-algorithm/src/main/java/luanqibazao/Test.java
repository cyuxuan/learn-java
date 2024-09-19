/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package luanqibazao;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        // 文件D:\test\gailv\test2.txt中的数据按照行写入list
        File file = new File("D:\\test\\gailv\\test2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        List<Numbers> list = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            // 将str按照空格拆封成数组
            String[] str = line.split(" ");
            Numbers numbers = new Numbers();
            numbers.num1 = Integer.parseInt(str[0]);
            numbers.num2 = Integer.parseInt(str[1]);
            numbers.num3 = Integer.parseInt(str[2]);
            numbers.num4 = Integer.parseInt(str[3]);
            numbers.num5 = Integer.parseInt(str[4]);
            numbers.num6 = Integer.parseInt(str[5]);
            numbers.num7 = Integer.parseInt(str[6]);
            list.add(numbers);
        }
        reader.close();

        // 开始执行数据分析
        // 统计Numbers中num1在1到35中出现概率最小的数字
        Map<Integer, Integer> map1 = new HashMap<>();
        initMap(map1, 35);
        Map<Integer, Integer> map2 = new HashMap<>();
        initMap(map2, 35);
        Map<Integer, Integer> map3 = new HashMap<>();
        initMap(map3, 35);
        Map<Integer, Integer> map4 = new HashMap<>();
        initMap(map4, 35);
        Map<Integer, Integer> map5 = new HashMap<>();
        initMap(map5, 35);
        Map<Integer, Integer> map6 = new HashMap<>();
        initMap(map6, 35);
        Map<Integer, Integer> map7 = new HashMap<>();
        initMap(map7, 35);
        for (Numbers numbers : list) {
            map1.put(numbers.num1, map1.get(numbers.num1) + 1);
            map2.put(numbers.num2, map2.get(numbers.num2) + 1);
            map3.put(numbers.num3, map3.get(numbers.num3) + 1);
            map4.put(numbers.num4, map4.get(numbers.num4) + 1);
            map5.put(numbers.num5, map5.get(numbers.num5) + 1);
            map6.put(numbers.num6, map6.get(numbers.num6) + 1);
            map7.put(numbers.num7, map7.get(numbers.num7) + 1);
        }

        // 使用poi写出数据到excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计结果");

        for(int i = 0; i < 35; i++) {
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(map1.get(i + 1));
            row.createCell(1).setCellValue(map2.get(i + 1));
            row.createCell(2).setCellValue(map3.get(i + 1));
            row.createCell(3).setCellValue(map4.get(i + 1));
            row.createCell(4).setCellValue(map5.get(i + 1));
            row.createCell(5).setCellValue(map6.get(i + 1));
            row.createCell(6).setCellValue(map7.get(i + 1));
        }



        // 遍历map1
//        HSSFRow row = sheet.createRow(0);
//        for (int i = 1; i < map1.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map1.get(i));
//        }
//
//        // 遍历map2
//        row = sheet.createRow(1);
//        for (int i = 1; i < map2.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map2.get(i));
//        }
//
//        // 遍历map3
//        row = sheet.createRow(2);
//        for (int i = 1; i < map3.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map3.get(i));
//        }
//
//        // 遍历map4
//        row = sheet.createRow(3);
//        for (int i = 1; i < map4.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map4.get(i));
//        }
//
//        // 遍历map5
//        row = sheet.createRow(4);
//        for (int i = 1; i < map5.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map5.get(i));
//        }
//
//        // 遍历map6
//        row = sheet.createRow(5);
//        for (int i = 1; i < map6.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map6.get(i));
//        }
//
//        // 遍历map7
//        row = sheet.createRow(6);
//        for (int i = 1; i < map7.size() + 1; i++) {
//            row.createCell(i - 1).setCellValue(map7.get(i));
//        }

        FileOutputStream fos = new FileOutputStream("D:\\test\\gailv\\test22.xls");
        workbook.write(fos);
        fos.close();



//        // 获取map1中value最小的key
//        Numbers number = new Numbers();
//        number.num1 = getMinValue(map1);
//        number.num2 = getMinValue(map2);
//        number.num3 = getMinValue(map3);
//        number.num4 = getMinValue(map4);
//        number.num5 = getMinValue(map5);
//        number.num6 = getMinValue(map6);
//        number.num7 = getMinValue(map7);
//        System.out.println(number.toString());
//
//
//        number = new Numbers();
//        number.num1 = getMaxValue(map1);
//        number.num2 = getMaxValue(map2);
//        number.num3 = getMaxValue(map3);
//        number.num4 = getMaxValue(map4);
//        number.num5 = getMaxValue(map5);
//        number.num6 = getMaxValue(map6);
//        number.num7 = getMaxValue(map7);
//        System.out.println(number.toString());
    }

    public static int getMaxValue(Map<Integer, Integer> map) {
        // 获取map中value最大的key
        int max = 0;
        int maxCount = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > maxCount) {
                max = key;
                maxCount = map.get(key);
            }
        }
        return max;
    }


    public static int getMinValue(Map<Integer, Integer> map) {
        // 获取map中value最小的key
        int min = 0;
        int minCount = 1000000;
        for (int key : map.keySet()) {
            if (map.get(key) < minCount) {
                min = key;
                minCount = map.get(key);
            }
        }
        return min;
    }

    public static void initMap(Map<Integer, Integer> map, int count) {

        for (int i = 1; i <= count; i++) {
            map.put(i, 0);
        }
    }
}

