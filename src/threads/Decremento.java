/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author JoãoPaulo
 */
public class Decremento implements Runnable{

    private Contador contador;
   
    public Decremento(Contador contador) {
        this.contador = contador;
    }
    
	//onde irá ocorrer o decremento no contador
    public void run() {
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
    }

    
    public void start() {
        
    }
}
