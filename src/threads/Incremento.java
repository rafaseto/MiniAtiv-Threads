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

// Classe Incremento implementa a interface Runnable, de modo que pode
// ser executada como uma thread
public class Incremento implements Runnable{

    // ref ao contador, de modo que Incremento pode acessar o recurso compartilhado
    private Contador contador;

    // Objeto lock que garante exclusão mútua
    private Lock lock;

    public Incremento(Contador contador, Lock lock) {
        this.contador = contador;
        this.lock = lock;
    }

    // Onde irá ocorrer o incremento no contador
    // Contém o código que sera executado quando a thread é iniciada
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
            // Destrava após a utilização do contador compartilhado
            lock.unlock();
        }
    }

    // Método utilizado na classe Main para iniciar a execução da thread
    public void start() {
        new Thread(this).start();
    }   
}
