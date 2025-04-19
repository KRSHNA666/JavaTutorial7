public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread sleeping...");
                Thread.sleep(5000);
                System.out.println("Woke up!");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        });

        thread.start();

        try { Thread.sleep(2000); } catch (Exception e) {}
        thread.interrupt();  // Interrupt the sleeping thread
    }
}
