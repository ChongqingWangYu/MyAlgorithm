package AlgorithmBased;

import LogarithmicDetector.IntArrays;

/**
 * @ClassName MySort
 * @Description 排序算法集合
 * @Author ChongqingWangYu
 * @DateTime 2019/3/18 21:09
 * @GitHub https://github.com/ChongqingWangYu
 */
public class MySort {

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次循环将最大的数放到end的最后一位，然后end--
        for (int end = arr.length - 1; end > 0; end--) {
            //下标小于end
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    //将小数放在左边，大的数放在右边
                    swap(arr, j, j + 1);
                }
            }
        }
        return;
    }


    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //记录最小值的下标
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小的数的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //将最小的数放到i位置
            swap(arr, i, minIndex);
        }
        return;
    }


    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~i的位置为有序区
        for (int i = 1; i < arr.length; i++) {
            //从i-1到0遍历，将数有序插入左边已排序的序列中。类似扑克牌整牌。
            for (int j = i - 1; j >= 0; j--) {
                //如果当前数比下一个数大
                if (arr[j] > arr[j + 1]) {
                    //将当前数与下一个数交换
                    swap(arr, j, j + 1);
                }
            }
        }
        return;
    }

    /**
     * 归并排序入口
     */
    public static void mergerSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergerSortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序递归处理
     */
    private static void mergerSortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        //L和R中点的位置 (L+R)/2
        int mid = L + ((R - L) >> 1);
        //左半部分排序 复杂度 T(n/2)
        mergerSortProcess(arr, L, mid);
        //右半部分排序 复杂度 T(n/2)
        mergerSortProcess(arr, mid + 1, R);
        //两部分合并 O(N)
        merge(arr, L, mid, R);
        //T(n)=2*T(n/2)+O(n)
    }

    /**
     * 将左部分与右部分合并
     */
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        //p1=0
        int p1 = L;
        //p2=(0+length-1)/2
        int p2 = mid + 1;
        //p1到中轴，p2到最后一个
        while (p1 <= mid && p2 <= R) {
            //p1与p2下标的值，谁小填谁到help[i]，并且填入和被填入的下标++，没填入的下标不变
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1与p2必有且只有一个越界。
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        IntArrays.printArray(arr);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        return;
    }

    /**
     * 交换两个数
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}