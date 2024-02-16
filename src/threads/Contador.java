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
public class Contador {        
	
	//Valor que deve ser alterado pelas threads
	public int contador = 0;

    // Objeto lock que garante exclusão mútua, de modo que apenas
    // uma thread por vez possa incrementar e decrementar
    private Lock lock = new ReentrantLock();

	// Incremento, é uma operação atômica
    public void inc() {
        // Trava antes de começar a incrementar
        lock.lock();
        try {
            contador++;
            System.out.println("Thread Incremento: " + getContador());
        } finally {
            // Destrava após o incremento
            lock.unlock();
        }
    }

	// Decremento, é uma operação atômica
    public void dec() {
        // Trava antes de começar a decrementar
        lock.lock();
        try {
            contador--;
            System.out.println("Thread Decremento: " + getContador());
        } finally {
            // Destrava após o decremento
            lock.unlock();
        }
    }

    // Método que retorna o valor atual do contador
    public int getContador(){
        return contador;
    }
}
