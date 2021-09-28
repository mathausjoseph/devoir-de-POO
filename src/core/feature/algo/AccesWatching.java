package core.feature.algo;

import java.util.Arrays;

import core.feature.affichage.Affichage;
import core.feature.affichage.Lecture;

public class AccesWatching {
	private int lenght;
	private int[] array;
	Lecture r;
	AlgoRecherche searchFeatures;
	AlgoTri sortFeatures;
	
	public AccesWatching(int lenght, int[] array) {
		super();
		this.lenght = lenght;
		this.array = array;
		r = new Lecture();
		searchFeatures = new AlgoRecherche(lenght,array);
		sortFeatures = new AlgoTri(array,lenght);
	}
	
	
	
	@Override
	public String toString() {
		return "[array=" + Arrays.toString(array) + "]";
	}



	public void mainProgram() {
		r.readArray(this.array,this.lenght);
		Affichage.affich(toString());
		Affichage.orderMenu();
		
		int choice = r.readInt();
		AscDescTri type;
		if(choice==1) {
			type = AscDescTri.ASCENDANT;
		}
		else if(choice==2) {
			type = AscDescTri.DESCENDANT;
		}
		else {
			Affichage.affich("Desole,vous n'avez effectue aucun choix");
			return;
		}
		
		Affichage.sortMenu();
		choice = r.readInt();
		sort(type,choice);
		if(choice<1 || choice>4) {
			return;
		}
		Affichage.affich(toString());
		Affichage.searchMenu();
		
		choice = r.readInt();
		
		if(choice<1 || choice>4) {
			return;
		}
		
		Affichage.affich("entrer la valeur a rechercher");
		
		int value = r.readInt();
		
		if(search(value,type,choice)){
			Affichage.affich("trouve");
		}
		else {
			Affichage.affich("non trouve");
		}
		
	}
	
	public boolean search(int value,AscDescTri type,int method) {
		switch(method) {
		case 1:{
			return searchFeatures.linearSearch(value);
		}
			
		case 2:{
			return searchFeatures.dichotoSearch(value,type);
		}
		
		case 3:{
			return searchFeatures.fibonnaciSearch(value,type);
		}
		
		case 4:{
			return searchFeatures.searchByJump(value,type);
		}
		
		default:{
			return false;
		}
		}
		
	}
	
	public void sort(AscDescTri type,int method) {
		switch(method) {
		case 1:{
			sortFeatures.triAbulles(type);
		}break;
			
		case 2:{
			sortFeatures.triSelection(type);
		}break;
		
		case 3:{
			sortFeatures.triInsertion(type);
		}break;
		
		case 4:{
			sortFeatures.triTransposition(type);
		}break;
		
		default:{
			Affichage.affich("C'est dommage q'aucune methode n'a pas ete choisi");
		}
		
		}
	}
}
