package td4;

import java.util.Scanner;

public class TD4 {

	public static void main(String[] args) {
		//exercice1();

		//exercice2();
		
		//exercice3();
		
		//exercice4();
		
		exercice5();
	}

	/**
	 * Correction Exercice 1
	 */
	private static void exercice1() {
		System.out.println("Question A:");
		System.out.println("On écrit chaque symbole sous la forme de 4 bits. Donc (3B,OC)16=(0011 1011 , 0000 1100)2\r\n" + 
				"Puis on repart de la base 2 pour grouper les bits par 3, de part et d'autre de la virgule, ce qui donne\r\n" + 
				"(73,03)8");
		
		System.out.println("\nQuestion B:");
		System.out.println("Il y a donc 24-15-1 = 8 bits pour l’exposant\r\n" + 
				"-11001100,1=-1,10011001×27\r\n" + 
				"Le signe est 1 (négatif)\r\n" + 
				"L’exposant est 7+28-1-1 = 134 qui s’écrit 10000110\r\n" + 
				"La mantisse est 100110010000000\r\n" + 
				"Les 24 bits sont donc 110000110100110010000000");
		
		System.out.println("\nQuestion C:");
		System.out.println("10010011 (qui représente –(01101101)2 = -109)\r\n" + 
				"+ 10011100 (qui représente -(01100100)2 = -100)\r\n" + 
				"----------\r\n" + 
				"100101111\r\n" + 
				"Il y a un report (le 9e bit) et un débordement puisqu’on additionne 2 négatifs et qu’on trouve un\r\n" + 
				"positif.");
		
	}

	/**
	 * Écrire un programme qui demande à l’utilisateur d’entrer une phrase et qui affiche le nombre
	 * d’espaces de cette phrase.
	 */
	private static void exercice2() {
		// Etape 1 : déclarer les variables
		String phraseUtilisateur;
		int compteurEspaces;
		Scanner scanner;
		
		// Étape 2 : récupérer la phrase de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez quelque chose");
		phraseUtilisateur = scanner.nextLine();
		compteurEspaces = 0;	// Je l'initialise à 0 car au début du programme
		
		// Étape 3 : calculer le nombre d'espaces
		for(int i = 0; i < phraseUtilisateur.length(); i++) {
			if(phraseUtilisateur.charAt(i) == ' ' ) {
				compteurEspaces++;
			}
		}
		
		// Étape 4 : afficher le résultat
		System.out.println("Le nombre d'espaces dans la phrase est : " + compteurEspaces);
		scanner.close();
	}

	/**
	 * Correction Exercice 3
	 */
	private static void exercice3() {
		System.out.println("Question A:");
		System.out.println("Il y a 3 chiffres en hexadécimal après le \"1,\", donc 12 bits. La mantisse de 10 bits n’est donc pas\r\n" + 
				"	suffisante. Il en aurait fallu au moins 12. On a perdu les 2 derniers bits du 7 et donc on a\r\n" + 
				"	représenté 0100 au lieu de 0111 pour ce chiffre. On a donc représenté le nombre (1,E04)16.");
		

		System.out.println("\nQuestion B:");
		System.out.println("Le signe est négatif (1)\r\n" + 
				"L’exposant est 010011 qui vaut 19 auquel il faut retrancher l’excédent 26-1-1=31 qu’on lui avait ajouté\r\n" + 
				"au codage, ce qui donne -12.\r\n" + 
				"Le nombre est donc -1,101 × 2-12 = -0,000000000001101");
	}

	/**
	 * Prenez un entier positif. S'il est pair, divisez-le par 2 ; s'il est impair, multipliez-le par 3 et ajoutez lui
	 * 1. Recommencez... Immanquablement, on aboutit à la valeur 1. Par exemple, à partir de l'entier 7, on
	 * obtient la suite suivante : 7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1. Cette conjecture
	 * attend toujours une preuve... Écrire un programme qui lit un entier et qui affiche les valeurs
	 * successives de la suite à partir de cet entier.
	 */
	private static void exercice4() {
		// Etape 1 : déclarer les variables
		int nombreUtilisateur, nombreIntermediaire;
		Scanner scanner;
		
		// Étape 2 : récupérer l'entier de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez un entier");
		nombreUtilisateur = scanner.nextInt();
		// Je l'initialise avec la valeur de l'utilisateur car au début du programme, je dois partir de cette valeur
		nombreIntermediaire = nombreUtilisateur;	
		
		// Étape 3 : effectuer les calculs selon si c'est pair ou pas, et afficher le résultat
		System.out.print(nombreIntermediaire);
		while(nombreIntermediaire != 1){
			if(nombreIntermediaire % 2 == 0)
				nombreIntermediaire = nombreIntermediaire / 2;
			else
				nombreIntermediaire = (nombreIntermediaire * 3) + 1;
			
			System.out.print("," + nombreIntermediaire);
		}
	}
	
	/**
	 * Écrire un programme qui lit une chaîne de caractères et qui indique le nombre de caractères de cette
	 * chaîne identiques au premier caractère (sans le compter lui-même).
	 */
	private static void exercice5() {
		// Etape 1 : déclarer les variables
		String phraseUtilisateur;
		int compteurlettreInitiale;
		Scanner scanner;
		
		// Étape 2 : récupérer la phrase de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez quelque chose");
		phraseUtilisateur = scanner.nextLine();
		compteurlettreInitiale = 0;	// Je l'initialise à 0 car au début du programme
		
		// Étape 3 : calculer le nombre de caractères qui sont identiques à la lettre initiale
		// L'énoncé nous dit de ne pas compter le 1er, donc la boucle commence dès le 2e caractère
		for(int i = 1; i < phraseUtilisateur.length(); i++) {
			if(phraseUtilisateur.charAt(i) == phraseUtilisateur.charAt(0) ) {
				compteurlettreInitiale++;
			}
		}
		
		// Étape 4 : afficher le résultat
		System.out.println("Le nombre de lettres identiques à la 1ère lettre dans la phrase est de : " + compteurlettreInitiale + " lettres");
	}
	
}
