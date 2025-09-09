import Statick.ObjectCounter;

public class Main {
    public static void main(String[] args) {

        ObjectCounter objectCounter1 = new ObjectCounter();
        ObjectCounter objectCounter2 = new ObjectCounter();
        ObjectCounter objectCounter3 = new ObjectCounter();
        ObjectCounter objectCounter4 = new ObjectCounter();

        System.out.println(ObjectCounter.getCount());
    }
}
