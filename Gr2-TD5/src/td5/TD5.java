package td5;

import java.util.Scanner;

public class TD5 {

	public static void main(String[] args) {
		//exercice1();

		//exercice2();

		//exercice3();

		//exercice4();

		exercice5();
	}

	/**
	 * Écrire la fonction avantDernierCar qui prend en paramètre une chaîne de caractères et qui
	 * retourne l’avant-dernier caractère de cette chaîne. On suppose que la chaîne contient au
	 * moins 2 caractères.
	 */
	private static void exercice1() {
		// Étape 1 : déclarer les variables
		String phraseUtilisateur;
		Scanner scanner;
		char resultat;

		// Étape 2 : récupérer la phrase de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez quelque chose");
		phraseUtilisateur = scanner.nextLine();

		// Étape 3 : exécuter  la méthode avantDernierCar et afficher le résultat
		resultat = avantDernierCar(phraseUtilisateur);
		System.out.println("L'avant-dernière lettre est : " + resultat);
	}

	/**
	 * Méthode qui retourne l'avant dernière lettre du String donné en paramètre
	 */
	private static char avantDernierCar(String phrase) {
		return phrase.charAt(phrase.length() - 2);
	}


	/**
	 * Écrire une fonction qui prend en paramètre deux entiers et qui retourne le plus grand. Écrire
	 * un programme principal qui lit deux entiers et qui affiche le plus grand en appelant la
	 * fonction.
	 */
	private static void exercice2() {
		// Étape 1 : déclarer les variables
		int entierA, entierB, resultat;
		Scanner scanner;

		// Étape 2 : récupérer les entiers de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez un entier");
		entierA = scanner.nextInt();
		System.out.println("Écrivez un autre entier");
		entierB = scanner.nextInt();

		// Étape 3 : exécuter  la méthode plusGrand et afficher le résultat
		resultat = plusGrand(entierA, entierB);
		System.out.println("L'entier le plus grand est : " + resultat);
	}
	
	/**
	 * Méthode qui reçoit 2 entiers et renvoie le plus grand
	 */
	private static int plusGrand(int entier1, int entier2) {
		if(entier1 > entier2) {
			return entier1;
		} else {
			return entier2;
		}
	}

	/**
	 * Écrire une action qui, étant donné un tableau d'entiers et un entier N, affiche les N premiers 
	 * éléments du tableau (les éléments d'indice 0 à N-1).
	 */
	private static void exercice3() {
		// Étape 1 : déclarer les variables
		int[] tableau = {1,2,4,5,7,8,9,5,2,2,2,5,10,1,122,5,12,5};
		int n;
		Scanner scanner;

		// Étape 2 : récupérer l'entier de l'utilisateur
		scanner = new Scanner(System.in);
		System.out.println("Écrivez un entier");
		n = scanner.nextInt();
		
		// Étape 3 : exécuter  la méthode afficherNElementsDuTableau
		afficherNElementsDuTableau(tableau, n);
	}
	
	/**
	 * Méthode qui imprime dans la console n éléments du tableau
	 */
	private static void afficherNElementsDuTableau(int[] tableau, int n) {
		int i = 0;

		// Je fais une boucle dans le tableau et j'imprime n éléments tant que
		// je ne dépasse pas la taille du tableau
		System.out.print("[ ");
		while((i<n) && (i < tableau.length)) {
			System.out.print(tableau[i] + " " );
			i++;
		}
		System.out.print("]");
	}

	/**
	 * Écrire une fonction qui, étant donné un tableau de booléens, retourne la proportion (entre 0
	 * et 1) de valeurs true de ce tableau.
	 */
	private static void exercice4() {
		// Étape 1 : déclarer les variables
		boolean[] tableau = {true, true, false, false};
		double resultat;
		
		// Étape 2 : exécuter la méthode proportionTrue
		resultat = proportionTrue(tableau);
		System.out.print("proportion " + resultat);
	}
	
	/**
	 * Méthode qui lit un tableau de booléens et qui retourne une proportion entre
	 * 0 et 1
	 */
	private static double proportionTrue(boolean[] tableau) {
		int compteur = 0;
		
		// Je fais une boucle dans le tableau
		for(int i = 0; i < tableau.length; i++) {
			//Si je trouve true, alors j'incrémente le compteur
			if(tableau[i])
				compteur++;
		}
		
		// je retourne la proportion de True dans ce tableau, donc le compteur / taille du tableau
		return ((double) compteur / tableau.length);
	}
	
	/**
	 * Écrire un programme qui permette de retrouver des mots dans une liste de mots. On utilise
	 * un tableau de chaîne de caractères initialisé au début du programme. Par exemple :
	 * String[]t= {"chocolat","caramel","farine","sel","sucre","chou"};
	 * Le programme lit une lettre au clavier et affiche tous les mots qui commencent par cette
	 * lettre, puis redemande une autre lettre, etc. Le programme s’arrête quand on tape ‘#’ :
	 */
	private static void exercice5() {
		// Étape 1 : déclarer les variables
		Scanner scanner = new Scanner(System.in);
		String[] tableau = {"chocolat","caramel","farine","sel","sucre","chou"};
		char caractereUtilisateur;
		
		// Étape 2 : réaliser  la boucle
		do {
			// Récupérer la lettre de l'utilisateur
			System.out.println("Lettre?");
			caractereUtilisateur = scanner.nextLine().charAt(0);
			
			// je cherche dans le tableau un mot dont l'initiale correspond à la lettre
			for(int i = 0; i < tableau.length; i++) {
				if(tableau[i].charAt(0) == caractereUtilisateur) {
					// j'imprime le mot concerné
					System.out.println(tableau[i]);
				}
			}
		} while(caractereUtilisateur != '#');
	}
}
