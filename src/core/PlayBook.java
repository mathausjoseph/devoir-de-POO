package core;
import core.feature.affichage.Lecture;
import core.feature.algo.AccesWatching;
public class PlayBook {

	public static void main(String[] args) {
		Lecture lecture = new Lecture();
		int entierPos = lecture.readPositifInteger();
		int[] tab = new int[entierPos];
		AccesWatching access = new AccesWatching(entierPos,tab);
		access.mainProgram();
	}

}
