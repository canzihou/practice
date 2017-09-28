package util;

public class ArrayUtil {

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void revert(char[] array) {
        char temp;
        for (int i = 0, j = array.length - 1; j >= i; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
