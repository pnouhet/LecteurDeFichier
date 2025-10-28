package Main;

import java.io.IOException;

import Lecteurs.*;

public class FileReader {
	
	public static void main(String[] args) throws IOException {
		
		//Emplacement du fichier
		LecteurText fichier = new LecteurText("C:\\Users\\admin\\Desktop\\fichier1.json");
		fichier.lireFichier();
		System.out.println("Lecture du fichier : ");
		fichier.afficherFichier();
		System.out.println("-----------------------");
		System.out.println("Inversion du fichier : ");
		fichier.inverserFichier();
		System.out.println("-----------------------");
		System.out.println("Écriture palindromique du fichier : ");
		fichier.creerPalindrome();
	}
}
