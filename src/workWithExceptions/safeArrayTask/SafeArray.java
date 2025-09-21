package workWithExceptions.safeArrayTask;

public class SafeArray{
    public static int getElement(int[] arr, int index) throws IndexOutOfBoundsCustomException {
        if(index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsCustomException("Index " + index + " is out of bounds for array size " + arr.length);
        }
        return arr[index];
    }
}
