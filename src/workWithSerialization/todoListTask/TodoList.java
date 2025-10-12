package workWithSerialization.todoListTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoList implements Serializable {
    private static class TodoItem implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String title;
        private boolean done;

        public TodoItem(String title) {
            this.title = title;
            this.done = false;
        }

        @Override
        public String toString() {
            return "TodoItem{" +
                    "title='" + title + '\'' +
                    ", done=" + done +
                    '}';
        }
    }

    private static final long serialVersionUID = 1L;

    private final List<TodoItem> items = new ArrayList<>();

    public void add(String title) {
        if (title == null || title.isBlank()) {
            System.out.println("Task is empty");
            return;
        }
        items.add(new TodoItem(title.trim()));
    }

    public void toggle(int index1based) {
        int i = index1based - 1;
        if (i < 0 || i >= items.size()) {
            System.out.println("No task with this index: " + index1based);
            return;
        }
        TodoItem it = items.get(i);
        it.done = !it.done;
    }

    public void print() {
        if (items.isEmpty())
            return;

        for (TodoItem item : items)
            System.out.println(item);

    }

    public void save(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
            System.out.println("Saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Saving error: " + e.getMessage());
        }
    }

    public static TodoList load(File file) {
        if (!file.exists())
            return new TodoList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            return (TodoList) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Loading erroe: " + e.getMessage());
            return new TodoList();
        }
    }
}
