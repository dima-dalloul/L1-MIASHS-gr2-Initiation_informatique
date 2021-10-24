package td6;

import java.util.Scanner;

public class TD6 {

	public static void main(String[] args) {
		//exercice1();
		
		//exercice2();
		
		//exercice3();
		
		//exercice4();
		
		exercice5();
	}

	/**
	 * Écrire une fonction qui, étant donné un tableau de double, renvoie le nombre de valeurs négatives
	 */
	private static void exercice1() {
		// Donner un exemple de tableau de doubles
		double[] tableau = {1.0, 2.3, -5.1, -9, 0, 9};
		
		// Afficher le résultat de l'exécution de nbValeursNegatives
		System.out.println("Compteur de valeurs négatives = " + nbValeursNegatives(tableau));
	}
	
	/**
	 * Fonction qui renvoie le nombre de valeurs négatives dans un tableau de doubles donné en paramètre
	 * @param tableau de doubles
	 * @return compteur de valeurs négatives
	 */
	private static int nbValeursNegatives(double[] tableau) {
		// Étape 1 : Déclarer la variable
		int compteur = 0;
		
		// Étape 2 : Itérer dans le tableau
		for(int i = 0; i < tableau.length; i++) {
			// Si l'élément à la position i est négatif, alors on incrémente le compteur
			if(tableau[i] < 0) {
				compteur++;
			}
		}
		
		// Étape 3 : On retourne le compteur à la fin de l'exécution
		return compteur;
	}

	/**
	 * Écrire la fonction repeat qui étant donné une chaîne et un entier N retourne la chaîne répétée N fois.
	 * Par exemple, repeat("LA",4) renvoie "LALALALA". La fonction doit renvoyer la chaîne vide si N est
	 * négatif ou nul.
	 */
	private static void exercice2() {
		// Afficher le résultat de l'exécution de repeat
		System.out.println(repeat("LA",-4));
		System.out.println(repeat("11",4));
	}
	
	/**
	 * Fonction qui prend en paramètre une chaîne et un entier N et retourne la chaîne répétée N fois.
	 * @param ch la chaîne à répéter
	 * @param n le nombre de répétitions
	 * @return la chaîne répétée n fois
	 */
	static String repeat(String ch, int n) {
		// Étape 1 : Déclarer la variable
		String resultat = "";
		
		// Étape 2 : Tester si n est positif ou pas
		if(n <= 0) {
			// S'il est nul ou négatif, on retourne une chaîne vide
			return "";
		} else {
			// S'il est positif, alors on répéte la chaîne n fois
			for(int i = 0; i < n; i++) {
				resultat = resultat + ch;
			}
			
			// Étape 3 : on retourne cette chaîne
			return resultat;
		}
	}

	/**
	 * Écrire en Java la fonction nbcommun qui étant donné deux chaînes de même longueur retourne le
	 * nombre d’éléments identiques aux mêmes positions. Par exemple, nbcommun("ABC",DEF") renvoie 0 et
	 * nbcommun("ABCD",AMCZ") renvoie 2 (car les premiers et troisièmes caractères sont identiques).
	 */
	private static void exercice3() {
		// Afficher le résultat de l'exécution de nbcommun
		System.out.println(nbcommun("LA", "BA"));
		System.out.println(nbcommun("Test", "TEST"));
		System.out.println(nbcommun("ON", "NO"));
		System.out.println(nbcommun("LALALA", "LALAA"));
	}
	
	/**
	 * Fonction qui prend en paramètre deux chaînes de même longueur et retourne le
	 * nombre d’éléments identiques aux mêmes positions
	 * @param a 1ère chaîne
	 * @param b 2ème chaîne
	 * @return le nombre d'éléments identiques
	 */
	private static int nbcommun(String a, String b) {
		// Étape 1 : Déclarer la variable
		int compteur = 0;

		// Étape 2 : Tester si les chaînes a et b ont la même taille
		if(a.length() != b.length()) {
			// Si la taille est différente, on renvoie -1 pour signaler l'anomalie
			return -1;
		} else {
			// Si la taille est égale, alors on compare les lettres à chaque position
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == b.charAt(i)) {
					// Si la lettre est identique, alors on incrémente le compteur
					compteur++;
				}
			}
			
			// Étape 3 : on retourne cette chaîne
			return compteur;
		}
	}

	/**
	 * Écrire une fonction tousAvant qui, étant donné une chaîne de caractères composée de lettres et une
	 * lettre L1, renvoie vrai si tous les caractères de la chaîne sont situés avant L1 dans l'ordre
	 * alphabétique. Par exemple : tousAvant("GRENOBLE", 'W') renvoie true.
	 */
	private static void exercice4() {
		// Afficher le résultat de l'exécution de tousAvant
		System.out.println(tousAvant("GRENOBLE", 'W'));
		System.out.println(tousAvant("GRENOBLE", 'I'));
	}
	
	/**
	 * Fonction qui prend en paramètre une chaîne de caractères composée de lettres et une
	 * lettre L1, et renvoie vrai si tous les caractères de la chaîne sont situés avant L1 dans l'ordre
	 * alphabétique.
	 * @param mot à tester
	 * @param c lettre L1 à comparer
	 * @return un booléen vrai si toutes les lettres du mot sont avant la lettre L1
	 */
	private static boolean tousAvant(String mot, char c) {
		// Étape 1 : Déclarer les variables
		int i = 0;
		boolean tousAvant = true;

		// Étape 2 : Tester si la lettre à la position i est AVANT la lettre donnée en paramètre
		while(i < mot.length()) {
			if(mot.charAt(i) > c) {
				// Si une lettre du mot se trouve égale ou après la lettre donnée, alors on casse
				// la boucle en mettant tousAvant à false et en retournant false 
				tousAvant = false;
				return tousAvant;
			}
			i++;
		}
		
		// Étape 3 : on retourne le résultat en booléen
		return tousAvant;
	}

	/**
	 * Écrire un programme qui lit une chaîne de caractères et qui crée une autre chaîne de même longueur
	 * mais où chaque lettre majuscule est remplacée par la lettre qui se trouve cinq caractères avant dans
	 * l'alphabet. Par exemple, le J va être remplacé par E. Si on tombe avant le A, on continue à reculer
	 * en repartant de Z. Par exemple, B va être remplacé par W. Les autres caractères ne sont pas
	 * modifiés. Pour les lettres, il ne faut pas écrire une suite de 26 tests, un pour chaque lettre, mais
	 * trouver une formule générale avec éventuellement avec un test.
	 * Tester ce programme avec la chaîne "FUWJX MZNY MJZWJ YWJSYJ H’JXY UQZX Q MJZWJ".
	 */
	private static void exercice5() {
		// Afficher le résultat de l'exécution de transformMot
		transformMot("FUWJX MZNY MJZWJ YWJSYJ H’JXY UQZX Q MJZWJ");
		transformMot("GRENOBLE");
	}
	
	/**
	 * Cette fonction lit le mot donné en paramètre et crée et affiche un autre mot de même longueur
	 * mais où chaque lettre majuscule est remplacée par la lettre qui se trouve cinq caractères avant dans
	 * l'alphabet. 
	 * @param mot à transformer
	 */
	static void transformMot(String mot) {
		// Étape 1 : Déclarer les variables
		String resultat = "";
		
		// Étape 2 : Itérer sur chaque lettre du mot
		for(int i = 0; i < mot.length(); i++) {
			if(mot.charAt(i) >= 'F' && mot.charAt(i) <= 'Z') {
				// Si la lettre est entre F et Z, alors on peut remplacer avec la lettre qui est 5 lettres avant
				resultat += (char) (mot.charAt(i) - 5);
			} else if(mot.charAt(i) >= 'A' && mot.charAt(i) <= 'E') {
				// Si la lettre est entre A et E, alors on continue à reculer en repartant de Z
				resultat += (char) (mot.charAt(i) + 'Z' - 'A' + 1 - 5);
			} else {
				// Dans tous les autres cas, on ne transforme pas les lettres (car elles sont minuscules)
				resultat += mot.charAt(i);
			}			
		}
		
		// Étape 3 : Afficher le mot dans la console
		// NB : il n'a pas été demandé de le retourner, donc on l'affiche uniquement dans la console
		System.out.println(resultat);
	}
}
