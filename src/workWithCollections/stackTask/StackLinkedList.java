package workWithCollections.stackTask;

public class StackLinkedList {
    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void push(int item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int pop() {
        if (size == 0)
            throw new IllegalStateException("Stack is empty");

        int result = last.value;

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
        return result;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException("Stack is empty");
        return last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;
    }
}
