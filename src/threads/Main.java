/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author Jo�oPaulo
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contador contador = new Contador();
        Lock lock = new ReentrantLock();

        Incremento tgt1 = new Incremento(contador, lock);
        Thread thread1 = new Thread(tgt1);

        Decremento tgt2 = new Decremento(contador, lock);
        Thread thread2 = new Thread(tgt2);

        thread1.start();
        thread2.start();
    }
}
