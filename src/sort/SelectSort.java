package sort;

/**
 * 选择排序
 * 1. 选择排序  时间复杂度O(n^2)
 *    它是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 *
 * 2. 堆排序，O(nlgN)
 *    1.先将数据建成一个大堆。
 *    2.再将对顶元素与最后一个元素进行交换，由于交换后新的堆可能违反堆的性质，故应将堆进行调整。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,0,4,9,3,6,8,7,1,5};
        selectSort(arr);
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        int size = arr.length;

        int start = 0, end = size-1;
        while(start <= end) {
            int min = start, max = end;

            for (int i=start; i<=end; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }

                if (arr[i] > arr[max]) {
                    max = i;
                }
            }

            if (start == max) {  //start和min交换后，start的值在min位置处
                max = min;
            }

            swap(arr, min, start);
            swap(arr, max, end);
            start++;
            end--;

        }
    }

    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    /**
     * 堆排序
     */
    public static void heapSort() {

    }
}
