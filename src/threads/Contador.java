/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Jo�oPaulo
 */
public class Contador {        
	
	//Valor que deve ser alterado pelas threads
	public int contador = 0;


    // Utilizando a keyword 'synchronized' garantimos exclusao mutua entre threads
	//incremento
    public synchronized void inc() {
        contador++;
    }

	//decremento
    public synchronized void dec() {
        contador--;
    }
    
    public int getContador(){
        return contador;
    }
}
