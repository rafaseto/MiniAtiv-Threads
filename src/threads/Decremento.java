/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author JoãoPaulo
 */
public class Decremento implements Runnable{

    private Contador contador;
    private Lock lock;
   
    public Decremento(Contador contador, Lock lock) {
        this.contador = contador;
        this.lock = lock;
    }

    //onde irá ocorrer o decremento no contador
    public void run() {
        lock.lock();
        try {
            int i = 0;
            while (i < 5) {
                contador.dec();
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } finally {
            lock.unlock();
        }
    }

    
    public void start() {
        new Thread(this).start();
    }
}
