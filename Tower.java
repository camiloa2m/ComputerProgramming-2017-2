package proyecto_final;

public class Tower {
	private char nameTower;
	private Disk[] disksTower;
	
	/**
	 * Constructor que crea un objeto de tipo Tower. Representa una de las torres de hanoi
	 * @param nameTower Representa el nombre de la torre en tipo char, se recomienda 'A','B','C'.
	 * @param disksTower Arreglo de objetos tipo Disk, es decir conjunto de los dicos en la torre.
	 */
	public Tower(char nameTower,Disk[] disksTower) {
		this.nameTower = nameTower;
		this.disksTower = disksTower;
	}
	
	/**
	 * Método para retornar el nombre de la torre
	 * @return Nombre de la torre
	 */
	public char getNameTower() {
		return nameTower;
	}
	
	/**
	 * Método para retornar una arreglo que contiene los discos que estan en la torre.
	 * @return Arreglo de los discos en la torre, arreglo de objetos tipo Disk
	 */
	public Disk[] getDisksTower() {
		return disksTower;
	}
	
}
