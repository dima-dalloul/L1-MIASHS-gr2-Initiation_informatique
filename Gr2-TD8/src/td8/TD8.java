package td8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TD8 {

	public static void main(String[] args) throws IOException {
		exercice1();
		exercice2();
		exercice3();
		exercice4();
	}


	/**
	 * On considère une matrice d'entiers, c'est-à-dire un tableau à deux dimensions de type int[][].
	 * a) Écrire la fonction max qui retourne le plus grand élément de la matrice. Il faut parcourir toutes les
	 * lignes et pour chacune parcourir toutes les colonnes.
	 * b) Écrire la fonction diagIdentiques qui renvoie vrai si tous les éléments de la diagonale sont
	 * identiques. Les éléments de la diagonale sont aux indices [1][1], [2][2], [3][3]…
	 */
	private static void exercice1() {
		int[][] matrice = new int[3][3];
		matrice = remplirMatrice(matrice);

		// Réponse à la question A: 
		int maximum = max(matrice);
		System.out.println("Maximm est " + maximum);

		// Réponse à la question B: diagIdentique(matrice)
		boolean identique = diagIdentiques(matrice);
		System.out.println("Diagonale Identique ? " + identique);
		
	}

	/**
	 * Fonction pour remplir la matrice avec des données aléatoires
	 */
	private static int[][] remplirMatrice(int[][] tableau){
		Random aleatoire = new Random();
		int		min = 0,
				max = 3;

		for(int i = 0; i < tableau.length; i++) {
			for(int j = 0; j < tableau[i].length; j++) {
				tableau[i][j] = min + (int)(Math.random() * ((max - min) + 1));
			}
		}

		return tableau;
	}

	/**
	 * Fonction qui retourne le plus grand élément de la matrice
	 * @param matrice m
	 * @return maximum trouvé
	 */
	private static int max(int[][] m) {
		// Étape 1 : déclarer les variables
		int resultat = 0;

		// Étape 2 : Boucler sur toutes les lignes et toutes les colonnes
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				// Étape 3 : comparer avec le résultat local
				if(resultat < m[i][j]) {
					resultat = m[i][j];
				}
			}
		}

		// Étape 4 : retourner le résultat
		return resultat;
	}


	/**
	 * Fonction qui renvoie vrai si ous les éléments de la diagonale sont identiques.
	 * @param matrice m
	 * @return booléen.
	 */
	private static boolean diagIdentiques(int[][] m) {
		// Étape 1 : déclarer les variables
		int i = 0;
		
		// Étape 2 : boucler sur la diagonale
		while(i < m.length && m[i][i] == m[0][0]) {
			i++;
		}
		
		// Étape 3 : renvoyer le résultat
		return (i == m.length);
	}


	/**
	 * On dispose d’un fichier texte contenant, sur chaque ligne, deux suites de lettres séparées par une
	 * espace. Écrire une fonction qui, étant donné le nom du fichier et un caractère, retourne le nombre de
	 * lignes dont les deux mots commencent tous les deux par ce caractère.
	 */
	private static void exercice2() {
		int compteur = nbLignes("exo2.txt", 'B');
		System.out.println("Compteur exercice 2 : "+compteur);
	}

	/**
	 * Fonction qui, étant donné le nom du fichier et un caractère, retourne le nombre de
	 * lignes dont les deux mots commencent tous les deux par ce caractère.
	 * @param le nom du fichier à lire
	 * @param le caractère à trouver
	 * @return nombre de lignes dont les 2 mots commencent par ce caractère
	 * @throws FileNotFoundException 
	 */
	private static int nbLignes(String nomFichier, char c){
		// Étape 1 : déclarer les variables
		int compteur = 0;
		
		try {
			// Étape 2: ouvrir le lecteur de fichiers et déclarer les variables
			BufferedReader f = new BufferedReader(new FileReader(nomFichier));
			String mot1, mot2;
			String ligne = f.readLine();
			int positionEspace;
			
			// Étape 3: Boucler sur le fichier
			while(ligne != null) {
				// Étape 4: Localiser l'espace dans la ligne
				positionEspace = ligne.indexOf(' ');
				
				if(positionEspace > 0) {
					// Étape 5: Récupérer le mot 1 et le mot 2
					mot1 = ligne.substring(0, positionEspace);
					mot2 = ligne.substring(positionEspace+1);
					
					// Étape 5: Si l'initiale du mot 1 est égale au caractère recherché ET l'initiale 
					// du mot 2 est égale au caractère recherché ALORS on incrémente
					// le compteur
					if(mot1.charAt(0) == c && mot2.charAt(0) == c) {
						compteur++;
					}
				}
				
				// Étape 6: Avancer d'une ligne
				ligne = f.readLine();
			}
			
			// Étape 7: Fermer le lecteur de fichiers
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return compteur;
	}

	/**
	 * Écrire l’action puissance2 qui, étant donné un entier n, écrit les n premières
	 * puissances de 2 dans le fichier "puissances2.txt", un nombre par ligne. Par
	 * exemple, avec la valeur 6, cette action devra créer le fichier ci-contre.
	 * @throws IOException 
	 */
	private static void exercice3() throws IOException {
		puissance2(8);
	}


	/**
	 * Fonction qui écrit les n premières puissances de 2 dans le fichier puissances2.txt 
	 * @param n premières puissances de 2
	 * @throws IOException 
	 */
	private static void puissance2(int n) throws IOException {	
		// Étape 1: Ouvrir le Buffered Writer pour commencer à écrire les puissances
		// Si le fichier n'existe pas, alors le Buffered Writer le crée, et sinon,
		// il va l'ouvrir et l'écraser.
		BufferedWriter f = new BufferedWriter(new FileWriter("puissances2.txt"));
		
		// Étape 2 : déclarer la variable
		long resultat = 1;
		
		// Étape 3 : écrire les n occurences de puissance 2 dans le fichier
		for(int i = 0; i < n; i++) {
			f.write(resultat + "\n");
			resultat  = resultat*2;
		}

		// Étape 4: Fermer le Buffered Writer
		f.close();
	}

	/**
	 * Écrire les instructions pour copier le contenu du tableau d’entiers tab dans un fichier texte, un entier
	 * par ligne. Par exemple, si le tableau contient les valeurs {1,2,3,4,5}, alors un fichier texte sera créé
	 * avec 5 lignes : 1 sur la première ligne, 2 sur la 2e, etc. Attention, l’action d’écriture dans un fichier
	 * prend en paramètre une chaîne et non un entier.
	 * @throws IOException 
	 */
	private static void exercice4() throws IOException {
		int[] tableau = new int[] {1,2,3,4,5,6,7,8,9,10};
		ecrireTableauDansFichier(tableau, "exo4.txt");
	}

	/**
	 * Fonction qui écrit le contenu du tableau dans le fichier qui s'appelle nomFichier.
	 * Le fichier sera écrit de la manière suivante: 1 sur la première ligne, 2 sur la 2e,
	 * @param tableau à écrire
	 * @param nom du Fichier qui contiendra le tableau
	 */
	private static void ecrireTableauDansFichier(int[] tableau, String nomFichier) throws IOException {	
		// Étape 1: Ouvrir le Buffered Writer pour commencer à écrire le tableau
		// Si le fichier n'existe pas, alors le Buffered Writer le crée, et sinon,
		// il va l'ouvrir et l'écraser.
		BufferedWriter f = new BufferedWriter(new FileWriter(nomFichier));

		
		// Étape 2 : écrire les valeurs du tableau
		for(int i = 0; i < tableau.length; i++) {
			f.write(""+tableau[i]);
			f.newLine();
		}

		// Étape 3: Fermer le Buffered Writer
		f.close();	
	}
}
