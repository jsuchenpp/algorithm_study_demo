package sort;

import java.util.Arrays;

/**
 * 
 * All rights Reserved, Designed www.xiao100.com
 * 
 * @Description: 计数排序
 * @author chenpingping 【chenpingping1@xiao100.com】
 * @date 2019年11月20日
 */
public class CountSort {

    public static void main(String[] args) {
        // int[] array = new int[]{95,94,91,98,99,90,99,93,91,92};
        int[] array = new int[] {4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = countSort(array);
        System.out.println("原数据    :" + Arrays.toString(array));
        System.out.println("排序结果:" + Arrays.toString(sortedArray));
    }

    /**
     * 
     * @Description: 计数排序
     *  时间复杂度： 
     *  代码1,2,4步都涉及到遍历原始数列，运算量都是N，第3步遍历统计数列，运算量是M，所以总体运算量是3N+M，去掉系数，时间复杂度是O(N+M) 
     *  空间复杂度：
     *  如果不考虑结果数组，只考虑统计数组大小的话，空间复杂度是O(M)
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date 2019年11月20日
     * @param array 待排序的数组
     * @return 已排序的数组
     */
    public static int[] countSort(int[] array) {
        // 1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        // 2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        // 3.统计数组做变形，后面的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        // 4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }
}
