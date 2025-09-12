import problemSolvingClasses.workWithEnum.TaskPriority;

public class Main {
    public static void main(String[] args) {

        TaskPriority taskPriority = TaskPriority.LOW;
        TaskPriority taskPriority1 = TaskPriority.HIGH;

        System.out.println(taskPriority1.getExecutionTime());
        System.out.println(taskPriority1.isHigherThan(taskPriority));
        System.out.println(taskPriority1.isLowerThan(taskPriority));
    }
}
