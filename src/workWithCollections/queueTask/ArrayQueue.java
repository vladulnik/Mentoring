package workWithCollections.queueTask;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        this.items = new int[capacity];
    }

    public void enqueue(int item) {
        if(count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        var item = items[front];
        items[front++] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public boolean isFull() {
        return (items[front] == items[0] && items[rear] == items[items.length - 1]);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
