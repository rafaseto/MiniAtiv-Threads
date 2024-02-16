/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author JoãoPaulo
 */
public class Incremento implements Runnable{

    private Contador contador;
    public Incremento(Contador contador) {
        this.contador = contador;
    }
    
    public void run() {
        int i = 0;
        while(i < 5){
            contador.inc();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    
    public void start() {
    }   
}
