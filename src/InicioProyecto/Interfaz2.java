package InicioProyecto;

import acm.graphics.*;
import acm.gui.IntField;
import acm.program.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class Interfaz2 extends GraphicsProgram {
	
	private static final int velocidadMinima = 1000; //Tiempo de espera para cambiar discos en milisegundos(ms)
	private static final int velocidadInicial = 500; //Tiempo de espera para cambiar discos en milisegundos(ms)
	private static final int velocidadMaxima = 20; //Tiempo de espera para cambiar discos en milisegundos(ms)
	
	private Thread runThread;
	private Thread Thread;
	private Thread Ajustar;
	
	IntField numdis;
	JSlider velocidad;
	
	Stack<Disk> torreA = new Stack<Disk>(); 
	Stack<Disk> torreB = new Stack<Disk>();
	Stack<Disk> torreC = new Stack<Disk>();	
	
	int h = Disk.hDisco; 
			
	public static final double cAstaX = 225; //Posicion en x del centro del asta 1
	public static final int cAstaY= 290; //Posicion en y del centro de las astas
	public static final double cAsta2X = 225+300; //Posicion en x del centro del asta 2
	public static final double cAsta3X = 225+600; //Posicion en x del centro del asta 3
	
	private static final int wWidth = 1050; //Anvho de la ventana
	private static final int wHeigth = 400; //Alto de la ventana
	
	
	public void init () {
		setSize(wWidth, wHeigth); //CAmbia tamaño de la ventana
		astas(); //Dibuja las astas
		numdis = new IntField();
		add(numdis, SOUTH);
		add(new JButton ("Ajustar discos"), SOUTH);
		add(new JButton ("Iniciar"), SOUTH); //JButton con etiqueta "Iniciar"
		add(new JButton ("Reiniciar"), SOUTH); //JButton con etiqueta "Reiniciar"
		add(new JLabel ("Velocidad Maxima"), SOUTH);
		velocidad = new JSlider(velocidadMaxima, velocidadMinima, velocidadInicial);
		add(velocidad, SOUTH);
		add(new JLabel ("Velocidad Minima"), SOUTH);
		
		discosApilados(numdis.getValue()); //Crea la pila de discos
		
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("Iniciar")){
			ejecutarNuevoThread();
		}
		
		if(e.getActionCommand().equals("Reiniciar")) {
			ejecutarReiniciarThread();
		}
		if(e.getActionCommand().equals("Ajustar discos")) {
			ejecutarAjustarDiscos();
		}
		
	}

	private void ejecutarNuevoThread(){
	    runThread = new Thread(
	      new  Runnable() {    
	        public void run() {
	        	torresH(numdis.getValue(), 'A', 'B', 'C');
	        }
	      }
	);
	    runThread.start();
	}
	
	private void ejecutarReiniciarThread() {
		Thread = new Thread (
			new Runnable(){
			public void run () {
				eliminar();
				}
			}
		);
		Thread.start();
	}		
	private void ejecutarAjustarDiscos() {
		Ajustar = new Thread (
			new Runnable() {
				public void run() {
					ajustar();
				}
			}
			);
			Ajustar.start();
	}
		/**
	 * Función recursiva que resuelve el problema base. 
	 * @param numd Número de discos
	 * @param torrei Nombre de la torre inicial en chart,'A'
	 * @param torreaux Nombre de la torre auxiliar en chart, 'B'
	 * @param torref Nombre de la torre final en chart, 'C'
	 */
	public void torresH(int numd,char torrei,char torreaux, char torref) {
		if (numd == 1) {
			//"Mueva disco "+numd+ " de " + torrei + " a " + torref
			mueve(numd,torrei,torref);
		} else {
			torresH(numd - 1, torrei, torref, torreaux);
			//"Mueva disco "+numd+" de " + torrei + " a " + torref
			mueve(numd,torrei,torref);
			torresH(numd - 1, torreaux, torrei, torref);
		}
	}
	
	public void eliminar() {
		removeAll();
		astas();
		torreA.removeAllElements(); //Elimina todos los elementos del stack 
		torreB.removeAllElements(); //Elimina todos los elementos del stack 
		torreC.removeAllElements(); //Elimina todos los elementos del stack 
		//discosApilados(numdis.getValue());
		discosApilados(0);
		
	}
	public void ajustar() {
		removeAll();
		astas();
		torreA.removeAllElements(); //Elimina todos los elementos del stack 
		torreB.removeAllElements(); //Elimina todos los elementos del stack 
		torreC.removeAllElements(); //Elimina todos los elementos del stack 
		discosApilados(numdis.getValue());
		
	}
	
	/**
	 * Método que mueve los discos de una torrei(torre partida) a una torref(torre destino final)
	 * @param numd Número del disco
	 * @param torrei Nombre de la torre de donde se mueve el disco
	 * @param torref Nombre de la torre hacia donde se lleva el disco
	 */
	public void mueve(int numd,char torrei,char torref) {
		Stack <Disk> i = traductorChartoLista(torrei);
		Stack <Disk> f = traductorChartoLista(torref);
		Disk k = i.pop();
		pause(velocidad.getValue());
		remove(k);
		switch (torref) {
			case 'C':
				add(f.push(k),cAsta3X - h*numd, cAstaY - h*(f.size())+h);
				break;
			case 'B':
				add(f.push(k),cAsta2X - h*numd, cAstaY - h*(f.size())+h);
				break;
			case 'A':
				add(f.push(k),cAstaX - h*numd, cAstaY - h*(f.size())+h);
				break;
		}
	}
	
	/**
	 * Método que relaciona los chars 'A', 'B' y 'C', que representan las torres,
	 * con un Stack correspondiente ya sea torreA, torreB o TorreC
	 * @param x chars 'A', 'B' y 'C' que representan las torres
	 * @return Retorna un Stack<Disk> que representa la torre
	 */
	public Stack<Disk> traductorChartoLista(char x){
		Stack<Disk> torre = null;
		switch (x) {
			case 'A':
				torre = torreA;
				break;
			case 'B':
				torre = torreB;
				break;
			case 'C':
				torre = torreC;
				break;
		}
		return torre;
	}

	/**
	 * Método que crea una pila de discos de forma gráfica
	 * @param n Número de discos en la pila
	 */
	public void discosApilados(int n) {
		for (int i = n ; i>0; i--) {
			Disk d = new Disk(i);
			d.setFilled(true);
			d.setFillColor(Color.RED);
			torreA.push(d);
			add(d, cAstaX - h*i, cAstaY- h*(n-i));
		}	
	}
	
	/**
	 * Método que grafica las 3 astas donde van los discos
	 */
	public void astas () {
		//Crea la barra vertical
		GRect e = new GRect (125-2.5,50,5, 150);
		e.setFilled(true);
		e.setFillColor(Color.GRAY);
		//Crea la barra horizontal
		GRect b = new GRect (0,200,240,10);
		b.setFilled(true);
		b.setFillColor(Color.GRAY);
		//Crea la T uniendo las anteriores barras
		GCompound ast = new GCompound();
		ast.add(e);
		ast.add(b);
		add(ast,100,100);
		ast.sendToBack();
		
		//Crea la barra vertical
		GRect f = new GRect (125-2.5,50,5, 150);
		f.setFilled(true);
		f.setFillColor(Color.GRAY);
		//Crea la barra horizontal
		GRect g = new GRect (0,200,240,10);
		g.setFilled(true);
		g.setFillColor(Color.GRAY);
		//Crea la T uniendo las anteriores barras
		GCompound ast2 = new GCompound();
		ast2.add(f);
		ast2.add(g);
		add(ast2,400,100);
		ast2.sendToBack();
		
		//Crea la barra vertical
		GRect h = new GRect (125-2.5,50,5, 150);
		h.setFilled(true);
		h.setFillColor(Color.GRAY);
		//Crea la barra horizontal
		GRect j = new GRect (0,200,240,10);
		j.setFilled(true);
		j.setFillColor(Color.GRAY);
		//Crea la T uniendo las anteriores barras
		GCompound ast3 = new GCompound();
		ast3.add(h);
		ast3.add(j);
		add(ast3,700,100);
		ast3.sendToBack();
	}
	
}
