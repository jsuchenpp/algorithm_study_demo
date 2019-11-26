package sort;

import java.util.Arrays;

/**
 * 
 * All rights Reserved, Designed www.xiao100.com
 * 
 * @Description: 希尔排序
 * @author chenpingping 【chenpingping1@xiao100.com】
 * @date 2019年11月26日
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 9, 12, 6, 1, 7, 2, 4, 11, 8, 10};
        System.out.println("原数据    :" + Arrays.toString(array));
        shellSort(array);
        System.out.println("排序结果:" + Arrays.toString(array));
    }
    
    /**
     * 
     * @Description: 希尔排序
     * 时间复杂度：
     * 它利用分组粗调的方式减少了直接插入排序的工作量，使得算法的平均时间复杂度低于O(n^2)。
     * 但是，在某些极端情况下，希尔排序的最坏时间复杂度仍然是O(n^2)，甚至比插入排序更慢。
     * 空间复杂度：O(1)
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date  2019年11月26日
     * @param array 待排序的数组
     */
    public static void shellSort(int[] array) {
        // 希尔排序的增量
        int d = array.length;
        while (d > 1) {
            // 使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j;
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

}
