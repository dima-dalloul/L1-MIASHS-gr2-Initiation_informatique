package paquetage;

import java.util.Scanner;

public class Bases {

	public static void main(String[] args) {
		int entier = 2;
		int[] tableau = {1,2,3,4,5,6,7};
		
		float flottant = 24536247;
		double doubl = 5.2;
		String str = "Coucou ici !";
		char c = 'd';
		boolean booleen = true;
		
		// Je veux écrire à l'utilisateur => j'affiche => j'imprime vers l'utilisateur
		System.out.println(str);
		
		// Je veux recevoir une entrée utilisateur
		Scanner scan = new Scanner(System.in);
		String entreeUtilisateur = scan.nextLine();
		
		// Echo de l'écriture utilisateur
		System.out.print("ECHO " + entreeUtilisateur);

	}
}
