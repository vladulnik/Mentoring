package workWithCollections.arrayTask;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int number) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = number;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Incorrect index");
        }
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int element) {
        for (int i = 0; i < count; i++) {
            if (element == items[i]) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        if(count == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public void reverse() {
        int[] newItems = new int[count];
        int j = 0;
        for (int i = count - 1; i >= 0; i--) {
            newItems[j] = items[i];
            j++;
        }
        items = newItems;
    }

    public void insertAt(int item, int index) {
        if(index > count || index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }
        int[] newItems = new int[count + 1];
        for(int i = 0; i < index; i++) {
            newItems[i] = items[i];
        }
        newItems[index] = item;
        for(int i = index; i < count; i++) {
            newItems[i + 1] = items[i];
        }
        items = newItems;
        count++;
    }
}
