/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Jo�oPaulo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Counter contador = new Counter();

        Incremento tgt1 = new Incremento(contador);
        Thread thread1 = new Thread(tgt1);

        Decremento tgt2 = new Decremento(contador);
        Thread thread2 = new Thread(tgt2);

        thread1.start();
        thread2.start();
    }
}
