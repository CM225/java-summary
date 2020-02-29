package com.java.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 思路：先把数组分为每个部分有序（每个部分一个元素），然后进行排序合并（从两个到所有）。
 * 该实例排序：小到大
 */
public class MergeSort {

    public static void main(String []args){
        int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        int[] result = MergeSort(b);
        for(int w:result)
            System.out.print(" "+w);
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);  //复制左边
        int[] right = Arrays.copyOfRange(array, mid, array.length);  //复制右边
        return merge(MergeSort(left), MergeSort(right));  //分为每个部分有序（单个元素）
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组，
     * 从两开始排序到所有合并排序。
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)   //当左边元素都填写结束后，右边剩余元素开始全部填充
                result[index] = right[j++];
            else if (j >= right.length) //当右边元素填充结束后，左边元素开始全部填充
                result[index] = left[i++];
            else if (left[i] > right[j]) //比较大小，左边大
                result[index] = right[j++];
            else                         //比较大小，右边大
                result[index] = left[i++];
        }
        return result;
    }
}
