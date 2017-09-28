import util.ArrayUtil;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // 构建最大堆，此时堆顶一定是最大数
        buildMaxHeap(array);
        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i >= 1; i--) {
            // 将最大数放到数组最后
            ArrayUtil.swap(array, 0, i);
            // 然后将剩下的元素排序，使得剩下数中的最大数到达堆顶，循环操作
            maxHeap(array, i, 0);
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 构建最大堆，最大堆表示每一棵子树的节点均不大于根节点
     */
    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 沉降法，将堆中某一个点调整至符合最大堆性质的位置，不代表所有点都符合最大堆性质
     *
     * @param array
     * @param heapSize
     * @param index
     */
    private static void maxHeap(int[] array, int heapSize, int index) {
        // 用数组表示堆时的性质，左节点在2x+1处，右节点在2x+2处
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            ArrayUtil.swap(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }
}
