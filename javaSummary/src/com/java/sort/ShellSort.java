package com.java.sort;

public class ShellSort {

    public static void main(String []args){
        int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        int[] result = ShellSort(b);
        for(int w:b)
            System.out.print(" "+w);
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {   //不断缩小分组数
            for (int i = gap; i < len; i++) {  //遍历分组
                temp = array[i];
                int preIndex = i - gap; //分组的第一个元素
                while (preIndex >= 0 && array[preIndex] > temp) { //判断分组中元素大小
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;   //判断是否还有可比较元素
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }


}
