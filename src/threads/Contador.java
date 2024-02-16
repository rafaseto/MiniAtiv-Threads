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
    private Lock lock = new ReentrantLock();

    // Utilizamos lock para obter exclusao mutua, de modo que inc() e dec()
    // passam a ser operacoes atomicas
	//incremento
    public void inc() {
        lock.lock();
        try {
            contador++;
            System.out.println("Thread Incremento: " + getContador());
        } finally {
            lock.unlock();
        }
    }

	//decremento
    public void dec() {
        lock.lock();
        try {
            contador--;
            System.out.println("Thread Decremento: " + getContador());
        } finally {
            lock.unlock();
        }
    }
    
    public int getContador(){
        return contador;
    }
}
