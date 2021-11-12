package td7;

import java.util.Random;

public class TD7 {

	public static void main(String[] args) {	
		//exercice1();

		//exercice2();

		//exercice3();

		exercice4();
	}

	/**
	 * On dispose d'un tableau d'un million de cases de type float. Ecrire la fonction booléeenne zero qui
	 * retourne vrai s'il existe une valeur nulle dans ce tableau. Ne pas parcourir tout le tableau inutilement.
	 */
	private static void exercice1() {
		float[] tableau = constructeurTableauFlottants();

		System.out.println("Présence de valeur nulle dans le tableau : " + zero(tableau));
	}


	/**
	 * Methode pour construire un tableau de 1000000 flottants
	 * @return tableau de 1000000 flottants
	 */
	private static float[] constructeurTableauFlottants(){
		float[] tableau = new float[1000000];
		Random aleatoire = new Random();
		int		min = -1,
				max = 1;

		for(int i = 0; i < tableau.length; i++) {
			tableau[i] = min + aleatoire.nextFloat() * (max - min);
		}

		return tableau;
	}

	/**
	 * Ecrire la fonction booléeenne zero qui retourne vrai s'il existe une valeur nulle dans ce tableau.
	 * Ne pas parcourir tout le tableau inutilement.
	 * @param tableau de flottants
	 * @return vrai si une valeur nulle existe dans le tableau, faux sinon
	 */
	private static boolean zero(float[] tableau) {
		// boucle FOR
		/*
		// Étape 1 : déclaration de variables
		boolean zeroTrouve = false;

		// Étape 2 : itérer dans le tableau
		for(int i = 0; i < tableau.length; i++) {
			if(tableau[i] == 0) {
				zeroTrouve = true;
				return zeroTrouve;
			}
		// Étape 3 : renvoyer le résultat
		return zeroTrouve;
		}*/

		//Boucle While
		// Étape 1 : déclaration de variables
		int i = 0;

		// Étape 2 : itérer dans le tableau
		while(i < tableau.length && tableau[i] != 0) {
			i++;
		}

		// Étape 3 : renvoyer le résultat
		return (i < tableau.length);
	}

	/**
	 * Écrire la fonction booléenne egale qui détermine si deux chaînes de caractères sont identiques (sans
	 * utiliser equals évidemment, uniquement charAt). Ne pas parcourir toutes les chaînes inutilement.
	 */
	private static void exercice2() {
		String 	string1 = "bonjour",
				string2 = "Bonjour",
				string3 = "ABCD",
				string4 = "ABCD",
				string5 = "",
				string6 = "WE bientôt";

		System.out.println(string1 + " = " + string2 + " ? Résultat " + egale(string1, string2) );
		System.out.println(string3 + " = " + string4 + " ? Résultat " + egale(string3, string4) );
		System.out.println(string5 + " = " + string6 + " ? Résultat " + egale(string5, string6) );
	}

	/**
	 * Fonction booléenne egale qui détermine si deux chaînes de caractères sont identiques
	 * @param chaîne de caractères 1
	 * @param chaîne de caractères 2
	 * @return vrai si les 2 chaînes sont identiques, faux sinon
	 */
	private static boolean egale(String stringA, String stringB) {
		// Étape 1 : déclaration de variables
		boolean estIdentique = false;

		// Étape 2: tester la longueur des 2 mots
		if(stringA.length() != stringB.length()){
			return estIdentique;
		} else {
			// BOUCLE FOR
			/*for(int i = 0; i < stringA.length(); i ++) {
				if(stringA.charAt(i) != stringB.charAt(i)) {
					estIdentique = false;
					return false;
				}
			}
			estIdentique = true;
			return estIdentique;
			 */

			// BOUCLE WHILE
			int i = 0;

			// Itérer sur les mots
			while(i < stringA.length() && stringA.charAt(i) == stringB.charAt(i)) {
				i++;
			}

			// Tester si on est sorti de la boucle avant la fin du mot ou pas
			return (i == stringA.length());
		}
	}

	/**
	 * A- On veut vérifier automatiquement qu'un mot de passe est suffisamment complexe. Écrire
	 * la fonction verifieMotDePasse, qui étant donné une chaîne, renvoie vrai si cette chaîne
	 * comporte au moins 8 caractères dont au moins une majuscule, une minuscule et un chiffre.
	 * B- Pour vérifier cette fonction, écrire une autre fonction genereMotDePasse qui génère un mot
	 * de passe aléatoire de 8 caractères compris entre les codes ASCII 48 ('0') et 122 ('z').
	 */
	private static void exercice3() {
		int i=0;
		String mdp;
		while(i <= 20) {
			mdp= genereMotDePasse();
			System.out.println(mdp + " : "+ verifieMotDePasse(mdp));
			i++;
		}
	}

	/**
	 * Fonction verifieMotDePasse, qui étant donné une chaîne, renvoie vrai si cette chaîne
	 * comporte au moins 8 caractères dont au moins une majuscule, une minuscule et un chiffre.
	 * @param chaîne de caractères
	 * @return vrai si la chaîne comporte au moins 8 caractères dont au moins une majuscule, une minuscule et un chiffre, faux sinon
	 */
	private static boolean verifieMotDePasse(String password) {
		// Étape 1 : déclaration de variables
		boolean estComplexe = false;

		// Étape 2 : tester la longueur du mot de passe
		if(password.length() < 8) {
			return estComplexe;
		} else {
			// Tester pour voir si les 3 autres conditions sont remplies
			int i = 0;
			boolean majusculeOK = false,
					minusculeOK = false,
					chiffreOK = false;

			while(i < password.length()) {
				if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
					majusculeOK = true;

				if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
					minusculeOK = true;

				if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
					chiffreOK = true;

				i++;
			}

			// Retourner vrai si les 3 conditions sont remplies
			return (majusculeOK && minusculeOK && chiffreOK);
		}

	}

	/**
	 * Fonction genereMotDePasse qui génère un mot de passe aléatoire de 8 caractères compris entre les codes ASCII 48 ('0') et 122 ('z').
	 * @return mot de passe aléatoire de 8 caractères compris entre les codes ASCII 48 ('0') et 122 ('z').
	 */
	private static String genereMotDePasse() {
		// Étape 1 : déclarer les variables
		String mdp = "";
		int i = 0;
		char caractereAleatoire;

		// Étape 2 : construire le mot de passe
		while(i < 8) {
			caractereAleatoire = (char) (Math.random() * ('z' - '0' + 1)+ '0');
			// Équivaut à
			//caractereAleatoire = (char) (Math.random()*(122-48+1)+48);

			// ajouter la lettre aléatoire au mot de passe à construire
			mdp += caractereAleatoire;
			i++;
		}

		// Étape 3 : retourner le mot de passe construit
		return mdp;
	}

	/**
	 * On dispose d’une grille représentée par un tableau t à deux dimensions
	 * quelconques de booléens. Les cases noires sont représentées par la valeur true
	 * et les cases blanches par la valeur false. Ce tableau est déjà initialisé.
	 * Écrire la fonction proportionTrue qui étant donné le tableau renvoie la proportion (entre 0 et 1) de cases noires
	 */
	private static void exercice4() {
		boolean[][] grille = {
				{false, false, true, false},
				{false, true, true, true},
				{false, false, false, false},
				{true, true, false, false}
		};

		double proportionTrue = proportionTrue(grille) * 100;
		System.out.println("La grille contient " + proportionTrue + "% de cases 'true'.");

		if (ligneBlanche(grille))
			System.out.println("Il existe une ligne sans cases 'true'");
		else
			System.out.println("Toutes les lignes ont au moins une case 'true'");
	}

	/**
	 * Fonction proportionTrue, qui étant donné le tableau renvoie la proportion (entre 0 et 1) de cases noires
	 * @param tableau t à 2 dimensions
	 * @return proportion (entre 0 et 1) de cases noires
	 */
	private static double proportionTrue(boolean[][] tableau) {
		// Étape 1 : déclarer les variables
		double somme = 0;

		// Étape 2 : itérer dans le tableau et si case noire trouvée, on incrémente la somme
		for(int i = 0; i < tableau.length; i++)
			for(int j = 0; j < tableau[0].length; j++)
				if (tableau[i][j])	// si case noire trouvée alors on incrémente la somme
					somme++;

		// Étape 3 : retourner la proportion, qui est la somme divisée par la taille
		return( somme / (tableau.length * tableau[0].length));
	}


	/**
	 * Fonction ligneBlanche qui renvoie true s'il existe une ligne sans aucune case noire et false
	 * sinon (ne pas parcourir systématiquement toutes les lignes !).
	 * @param tableau t à 2 dimensions
	 * @return vrai s'il existe une ligne sans aucune case noire et false sinon 
	 */
	private static boolean ligneBlanche(boolean[][] tableau) {
		// Étape 1 : déclarer les variables
		int i = 0;
		int j;
		boolean trouve = false;
		
		// Étape 2 : itérer sur les lignes et les colonnes
		while (( i < tableau.length) && !trouve) {
			j = 0;
			while ((j<tableau[0].length) && (tableau[i][j]==false)) {
				j++;
			}
			
			if (j < tableau[0].length)
				trouve=false;
			else
				trouve=true;
			
			i++;
		}
		
		// Étape 3 : retourner le résultat
		return(trouve);
	}
}
