public class Main {
    public static void main(String[] args) {
        VerificaThread t1 = new VerificaThread(0, "Thread 1");
        VerificaThread t2 = new VerificaThread(0, "Thread 2");
        VerificaThread lettore = new VerificaThread(1);
        t1.start();
        t2.start();
        lettore.start();
    }
}