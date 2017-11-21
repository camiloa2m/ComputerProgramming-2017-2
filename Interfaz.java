package InicioProyecto;
import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.*;
import acm.program.*;

public class Interfaz extends GraphicsProgram {
	
	public static final int hDisco = 10;
	public static final int bDisco = 20;
	public static final double cAstaX = 225;
	public static final int cAstaY= 290;
	
	public static final double cAsta2X = 225+300;
	public static final double cAsta3X = 225+600;
	
	
	ArrayList<Disk> torreA = new ArrayList<Disk>();
	ArrayList<Disk> torreB = new ArrayList<Disk>();
	ArrayList<Disk> torreC = new ArrayList<Disk>();	
	
	
	public void run() {
		discosApilados(2);
		astas();
		torresH(1, 'A','B', 'C');
	}

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
	
	public void mueve(int numd,char torrei,char torref) {
		traductorChartoLista(torrei);
		traductorChartoLista(torref);
		Disk r = traductorChartoLista(torrei).get(numd-1);
		int x = r.getnumDisk();
		if (numd == x) {
			traductorChartoLista(torref).add(r);
			traductorChartoLista(torrei).remove(r);
		}
		
	}
	
	public ArrayList<Disk> traductorChartoLista(char x){
		ArrayList<Disk> torre = null;
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
	 * M�todo que crea una pila de discos de forma gr�fica
	 * @param n N�mero de discos en la pila
	 */
	public void discosApilados(int n) {
		for (int i = n ; i>=0; i--) {
			Disk d = new Disk(i);
			d.setFilled(true);
			d.setFillColor(Color.RED);
			torreA.add(d);
			add(d, cAstaX - 10*i, cAstaY- 10*(n-i));
		}	
	}
	

	/**
	 * M�todo que grafica las 3 astas o Ts donde van los discos
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
