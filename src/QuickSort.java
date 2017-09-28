import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static int partition(int[] array, int low, int high) {
        int key = getKey(array, low, high, 1);

        while (low < high) {
            while (array[high] >= key && high > low) {// 从后半部分向前扫描
                high--;
            }
            // 上面的循环停止有两个可能，若high=low，则数组有序后面操作均不影响
            // 另一种可能则为找到一个小于基准点的数，将该数直接移到前面去,相当于先把基准点拿出去
            // 将数组的数进行移位，最后将基准点移入到应该在的位置上
            array[low] = array[high];
            System.out.println(Arrays.toString(array));
            while (array[low] <= key && high > low) {// 从前半部分向后扫描
                low++;
            }
            array[high] = array[low];
            System.out.println(Arrays.toString(array));
        }
        array[high] = key;
        return high;
    }

    /**
     * @param array
     * @param low
     * @param high
     * @param mode  切分模式，一共三种，其中随机切分没有写出，切分的意思是取出一个基准数
     * @return
     */
    private static int getKey(int[] array, int low, int high, int mode) {
        switch (mode) {
            case 1:// 固定切分
                return array[low];
            case 2:// 三数取中切分，先将头尾与中间位置的数排序，然后已中间的数作为基准数
                int mid = low + (high - low) / 2;//写成这样防止high+low超出int范围
                if (array[mid] > array[high]) {
                    swap(array[mid], array[high]);
                }
                if (array[low] > array[high]) {
                    swap(array[low], array[high]);
                }
                if (array[mid] > array[low]) {
                    swap(array[mid], array[low]);
                }
                return array[mid];
            default:
                return -1;
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        sort(array, low, index - 1);
        sort(array, index + 1, high);
    }
}
