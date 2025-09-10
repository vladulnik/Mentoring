package utils;

public class ArrayUtils {

    private ArrayUtils() {}

    public static int findMax(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static boolean isSortedAscending(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if(arr.length < 2) {
            return true;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedDescending(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if(arr.length < 2) {
            return true;
        }
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] arr) {
        if(arr == null) return;

        boolean swapped;

        for(int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}
