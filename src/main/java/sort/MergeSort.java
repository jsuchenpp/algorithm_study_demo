package sort;

import java.util.Arrays;

/**
 * 
 * All rights Reserved, Designed www.xiao100.com
 * 
 * @Description: 归并排序
 * @author chenpingping 【chenpingping1@xiao100.com】
 * @date 2019年11月22日
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数据    :" + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("排序结果:" + Arrays.toString(array));
    }
    
    /**
     * 
     * @Description: 归并排序
     * 时间复杂度：
     * 归并排序把集合一层一层进行折半分组。如果集合长度是n，那么折半的层数就是logn，每一层进行归并操作的运算量是n。
     * 所以时间复杂度是O(nlogn)
     * 空间复杂度：
     * 每次归并所创建的额外集合都会随着方法的结束而被释放，因此这部分空间不应该累加计算。单次归并操作开辟的最大的空间是n，
     * 所以归并排序的空间复杂度是O(n)。
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date  2019年11月22日
     * @param array 待排序数组
     * @param start 开始index
     * @param end 结束index
     */
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            // 折半成两个小集合，分别进行递归
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            // 把两个有序小集合，归并成一个大集合
            merge(array, start, mid, end);
        }
    }
    
    /**
     * 
     * @Description: 归并
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date  2019年11月22日
     * @param array 待排序数组
     * @param start 开始index
     * @param mid 中间index
     * @param end 结束index
     */
    private static void merge(int[] array, int start, int mid, int end) {
        // 开辟额外大集合，设置指针
        int[] tempArray = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        // 比较两个小集合的元素，依次放入大集合
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                tempArray[p++] = array[p1++];
            } else {
                tempArray[p++] = array[p2++];
            }
        }
        // 左侧小集合还有剩余，依次放入大集合尾部
        while (p1 <= mid) {
            tempArray[p++] = array[p1++];
        }
        // 右侧小集合还有剩余，依次放入大集合尾部
        while (p2 <= end) {
            tempArray[p++] = array[p2++];
        }
        // 把大集合的元素复制回原数组
        for (int i = 0; i < tempArray.length; i++) {
            array[i + start] = tempArray[i];
        }
    }
}
