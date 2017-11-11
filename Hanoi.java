package proyecto_final;
import acm.program.ConsoleProgram;

public class Hanoi extends ConsoleProgram{

	public void run() {
		
		torresH(3, 'a','b', 'c');
		println("El numero de pasos fueron: " + nPasos(3));
		
	}
	public void torresH(int numd,char torrei,char torreaux, char torref) {
		if (numd == 1) {
			println("Mueva disco de " + torrei + " a " + torref);
		} else {
			torresH(numd - 1, torrei, torref, torreaux);
			println("Mueva disco de " + torrei + " a " + torref);
			torresH(numd - 1, torreaux, torrei, torref);
		}
	}
	public int nPasos(int numd) {
		int nPasos = (int)(Math.pow(2, numd) - 1);
		return nPasos;
	}
}
