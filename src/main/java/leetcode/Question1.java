package leetcode;

/**
 * 
 * All rights Reserved, Designed www.xiao100.com
 * 
 * @Description: 给一个整形数组，要求删除其中一个元素，使得剩余元素的乘积最大
 * @author chenpingping 【chenpingping1@xiao100.com】
 * @date 2019年11月29日
 */
public class Question1 {

    public static void main(String[] args) {
        int[] array1 = {-4, 3, -5, -7, -21, 9, -1, 5, 6};
        int index = findRemovedIndex(array1);
        System.out.println("删除元素：" + array1[index]);

        int[] array2 = {4, 3, 5, -7, -21, 9, -1, -5, 6, 0};
        index = findRemovedIndex(array2);
        System.out.println("删除元素：" + array2[index]);

        int[] array3 = {-4, -3, -5, -7, -21, -9, -1, -8};
        index = findRemovedIndex(array3);
        System.out.println("删除元素：" + array3[index]);
    }

    /**
     * 
     * @Description: 查询一个整形数组中的元素，使得删除该元素后，数组中剩余元素的乘积最大
     * @Author chenpingping【chenpingping1@xiao100.com】
     * @Date 2019年11月29日
     * @param array 待处理的整形数组
     * @return int 删除的元素下标
     */
    public static int findRemovedIndex(int[] array) {
        // 1.统计负元素的个数
        int negativeCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeCount++;
            }
        }
        // 2.根据不同情况，选择要删除的元素
        int tempIndex = 0;
        if ((negativeCount & 1) == 1) {
            // 情况A：负数个数是奇数
            for (int i = 1; i < array.length; i++) {
                if (array[i] < 0) {
                    if (array[tempIndex] >= 0 || array[i] > array[tempIndex]) {
                        tempIndex = i;
                    }
                }
            }
            return tempIndex;
        } else {
            // 情况B：负数个数是偶数
            if (array.length == negativeCount) {
                // 子情况：所有元素都是负数
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[tempIndex]) {
                        tempIndex = i;
                    }
                }
                return tempIndex;
            }

            for (int i = 1; i < array.length; i++) {
                if (array[i] >= 0) {
                    if (array[tempIndex] < 0 || array[i] < array[tempIndex]) {
                        tempIndex = i;
                    }
                }
            }
            return tempIndex;
        }
    }

}
