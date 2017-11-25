package InicioProyecto;

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;
import java.util.Stack;


public class Interfaz extends GraphicsProgram {
	
	Stack<Disk> torreA = new Stack<Disk>(); 
	Stack<Disk> torreB = new Stack<Disk>();
	Stack<Disk> torreC = new Stack<Disk>();	
	
	int h = Disk.hDisco; 
	int time; //Tiempo de espera para cambiar discos en milisegundos(ms)
	
	public static final double cAstaX = 225; //Posicion en x del centro del asta 1
	public static final int cAstaY= 290; //Posicion en y del centro de las astas
	public static final double cAsta2X = 225+300; //Posicion en x del centro del asta 2
	public static final double cAsta3X = 225+600; //Posicion en x del centro del asta 3
	
	
	
	public void run() {
		int num = 4; //numero de discos
		time = 1000; //tiempo en milisengundos (ms)
		discosApilados(num); //Crea la pila de discos
		astas(); //Dibuja las astas
		torresH(num, 'A','B', 'C'); // resuelve el problema
	}

	/**
	 * Función recursiva quu resuelve el problema base. 
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
	
	/**
	 * Método que mueve los discos de una torrei a una torref
	 * @param numd Número del disco
	 * @param torrei Nombre de la torre de donde se mueve el disco
	 * @param torref Nombre de la torre hacia donde se lleva el disco
	 */
	public void mueve(int numd,char torrei,char torref) {
		Stack <Disk> i = traductorChartoLista(torrei);
		Stack <Disk> f = traductorChartoLista(torref);
		Disk k = i.pop();
		pause(time);
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
