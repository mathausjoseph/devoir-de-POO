package core.feature.affichage;

import java.util.Scanner;

public class Lecture {
	private Scanner scan;
	
	public Lecture() {
		scan = new Scanner(System.in);
	}
	
	public int readInt() {
		return this.scan.nextInt();
	}
	
	public int readPositifInteger() {
		Affichage.affich("Entrer la taille du tableau");
		
		int i = this.scan.nextInt();
		
		while(i<=0) {
			Affichage.affich("La taille du tableau ne doit etre negatif ");
			i = this.scan.nextInt();
		}
		
		return i;
	}
	
	public void readArray(int[] array, int lenght) {
		Affichage.affich("Entrer les valeurs du tableau");
		for (int i = 0; i <lenght; i++) {

			array[i] = scan.nextInt();

		}
	}
}

