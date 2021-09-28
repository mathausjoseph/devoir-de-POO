package core.feature.affichage;

public abstract class Affichage {
	public static void affich(String a) {
		System.out.println(a);
	}
	
	public static void sortMenu() {
		affich("1....tri a bulle");
		affich("2....tri par selection");
		affich("3....tri par insertion");
		affich("4....tri par transposition");
	}
	
	public static void orderMenu() {
		affich("1....croissant");
		affich("2....decroissant");
	}
	
	public static void searchMenu() {
		affich("1....Recherche lineaire");
		affich("2....Recherche dichotomique");
		affich("3....Recherche fibonacci");
		affich("4....Recherche saut");
	}
}
