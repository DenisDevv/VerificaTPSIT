import java.util.Arrays;

public class VerificaThread extends Thread {
    private static int[] arrayDiNumeri = new int[100];
    private int ruolo;
    private String nome;
    private static Integer index = 0;
    public VerificaThread(int ruolo) {
            for (int i = 0; i < arrayDiNumeri.length; i++) {
                arrayDiNumeri[i] = i + 1;
            }
        this.ruolo = ruolo;
    }
    public VerificaThread(int ruolo, String nome) {
        this.ruolo = ruolo;
        this.nome = nome;
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
                    System.out.println(nome + " Sta modificando il record" );
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    index++;
                    System.out.println("record già modificato, incremento l'indice " + nome);
                }

            }
            }
        } else {
                while (index <= arrayDiNumeri.length) {
                    synchronized (index) {
                        System.out.println(Arrays.toString(arrayDiNumeri));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (index == arrayDiNumeri.length-1) {
                        break;
                    }
                }
        }
    }
}
