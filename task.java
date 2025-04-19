public class Task {
    public static void main(String[] args) {
        Thread task1 = new Thread(() -> System.out.println("Task 1 running..."));
        Thread task2 = new Thread(() -> System.out.println("Task 2 running..."));

        task1.start();
        task2.start();
    }
}
