/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author Jo�oPaulo
 */

// Classe Incremento implementa a interface Runnable, de modo que pode
// ser executada como uma thread
public class Incremento implements Runnable{

    // ref ao contador, de modo que Incremento pode acessar o recurso compartilhado
    private Contador contador;

    // Objeto lock que garante exclus�o m�tua
    private Lock lock;

    public Incremento(Contador contador, Lock lock) {
        this.contador = contador;
        this.lock = lock;
    }

    // Onde ir� ocorrer o incremento no contador
    // Cont�m o c�digo que sera executado quando a thread � iniciada
    public void run() {
        lock.lock();
        try {
            int i = 0;
            while(i < 5){
                contador.inc();
                try {
                    // Coloca a thread em espera por 1seg
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } finally {
            // Destrava ap�s a utiliza��o do contador compartilhado
            lock.unlock();
        }
    }

    // M�todo utilizado na classe Main para iniciar a execu��o da thread
    public void start() {
        new Thread(this).start();
    }   
}
