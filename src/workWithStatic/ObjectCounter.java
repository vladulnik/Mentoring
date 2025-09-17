package workWithStatic;

public class ObjectCounter {

    public static int count = 0;

    public ObjectCounter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
