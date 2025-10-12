package workWithSerialization.calcHistoryTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalcHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<String> entries = new ArrayList<>();

    private transient int cachedCount = -1;

    public void add(String entry) {
        if (entry == null || entry.isBlank())
            return;

        entries.add(entry.trim());

        if (cachedCount != -1)
            cachedCount++;
    }

    public int count() {
        if (cachedCount == -1)
            cachedCount = entries.size();
        return cachedCount;
    }

    public void print() {
        if (entries.isEmpty())
            return;

        for (int i = 0; i < entries.size(); i++)
            System.out.printf("%2d) %s%n", i + 1, entries.get(i));
    }

    public void save(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
            System.out.println("Saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Save error: " + e.getMessage());
        }
    }

    public static CalcHistory load(File file) {
        if(!file.exists()) {
            System.out.println("No file");
            return new CalcHistory();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (CalcHistory) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Load error: " + e.getMessage());
            return new CalcHistory();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        cachedCount = -1;
    }
}
