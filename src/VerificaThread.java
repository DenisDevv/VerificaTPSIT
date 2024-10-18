public class VerificaThread extends Thread {
    private static int[] arrayDiNumeri = new int[100];
    private int ruolo;
    private static Integer index = 0;
    public VerificaThread(int ruolo) {
        if (arrayDiNumeri[1] == 0) {
            for (int i = 0; i < arrayDiNumeri.length; i++) {
                arrayDiNumeri[i] = i + 1;
            }
        }
        this.ruolo = ruolo;
    }
    public void run() {
        if (ruolo == 0) {
            try {
                Thread.sleep(Math.round(Math.random() * 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i<arrayDiNumeri.length; i++) {
            synchronized (index) {
                if (arrayDiNumeri[index] == index + 1) {
                    arrayDiNumeri[index] = arrayDiNumeri[index] + 1;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    index++;
                    System.out.println("record già modificato");
                }

            }
            }
        } else {
                for (int i = 0; i < arrayDiNumeri.length; i++) {
                    synchronized (index) {
                        System.out.println("Valore: " + arrayDiNumeri[i] + " Indice: " + i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}
