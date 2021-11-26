package td9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TD9 {

	public static void main(String[] args) throws IOException {
		//exercice1();

		//exercice2();

		exercice3();
	}

	/**
	 * Écrire un programme qui affiche la longueur moyenne des lignes d'un fichier
	 * dont le nom est saisi au clavier. Les lignes vides ne sont pas prises en compte.
	 * @throws IOException 
	 */
	private static void exercice1() throws IOException {
		// Étape 1: Récupérer le nom du fichier depuis l'utilisateur 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est le nom du fichier?");
		String nomFichier = scanner.next();

		// Étape 2 : ouvrir le fichier et lire sa 1ère ligne
		BufferedReader f = new BufferedReader(new FileReader(nomFichier));
		String ligne = f.readLine();

		// Étape 3 : déclarer les variables total et nombre de lignes significatives
		int longueurTotale = 0;
		int nombreLignes = 0;

		// Étape 4 : entrer dans la boucle
		while(ligne != null) {
			// Voir si la ligne contient quelque chose
			if(ligne.length() > 0) {
				nombreLignes++;
				longueurTotale += ligne.length();
			}

			// Avancer à la ligne d'après
			ligne = f.readLine();
		}

		// Étape 5 : fermer le flot du Reader
		f.close();

		// Étape 6: afficher la longueur moyenne
		double longueurMoyenne = longueurTotale / nombreLignes;
		System.out.println("La longueur moyenne est " + longueurMoyenne);
	}


	/**
	 * On dispose de fichiers contenant sur chaque ligne un nom de produit, un point-virgule et un nombre flottant.
	 * a) Écrire une fonction total qui, étant donné un nom de fichier, retourne la somme des nombres qui
	 * se trouvent après les points-virgules. Vous pouvez utiliser la fonction substring qui renvoie une souschaîne
	 * d’une chaîne (ch.substring(debut,longueur) ou ch.substring(debut)) et la fonction
	 * indexOf qui renvoie l’indice de la première occurrence d’un caractère (ch.indexOf(car)).
	 * b) Écrire une action qui prend en paramètre le nom d’un fichier, ainsi qu’une valeur taux et qui crée
	 * un second fichier qui contient les mêmes informations que le premier fichier, excepté que les nombres
	 * après les point-virgules auront été augmentés d’un pourcentage égal au paramètre taux. Par exemple,
	 * si taux = 10, la ligne précédente deviendra, dans le nouveau fichier. Le nouveau fichier devra porter le 
	 * même nom que le précédent avec le préfixe NOUV_. Par exemple, à partir du fichier articles.txt, on 
	 * créera le nouveau fichier NOUV_articles.txt
	 * @throws IOException 
	 */
	private static void exercice2() throws IOException {
		// Partie A
		double totalPrix = total("ex2.txt");
		System.out.println("Le total est "+ totalPrix);

		//  Partie B
		float taux = (float) 23.2;
		nouveauPrix("ex2.txt", taux);
	}

	private static double total(String nomFichier) throws IOException {
		// Étape 1: lire le fichier
		BufferedReader f = new BufferedReader(new FileReader(nomFichier));

		// Étape  2 : lire la 1ère ligne
		String ligne = f.readLine();

		// Étape 3 : itérer dans le fichier
		double total = 0;
		while(ligne != null) {
			String sousChainePrix;
			double prix;

			// Extraire le prix et le convertir en double
			sousChainePrix = ligne.substring(ligne.indexOf(";") + 1);
			prix = Double.parseDouble(sousChainePrix);
			//prix = Float.parseFloat(sousChainePrix);

			// Ajouter le prix au total
			total += prix;

			// Lire la ligne d'après pour éviter les boucles infinies
			ligne = f.readLine();
		}

		// Étape 4 : retourner le résultat
		return total;
	}

	private static void nouveauPrix(String nomFichier, float taux) throws IOException {
		// Étape 1 : Lire le fichier donné en paramètre
		BufferedReader fr = new BufferedReader(new FileReader(nomFichier));

		// Étape 2: ëcrire le 2nd fichier
		BufferedWriter fw = new  BufferedWriter(new FileWriter("NOUV_"+nomFichier));

		// Étape 3: Lire la 1ère ligne du fichier donné
		String ligne = fr.readLine();

		// Étape 4 : itérer dans le fichier donné
		String nomProduit, partiePrix;
		float prix, nouveauPrix;
		while(ligne != null) {
			// Extraire le nom du produit
			nomProduit = ligne.substring(0, ligne.indexOf(";"));

			// Extraire le prix
			partiePrix = ligne.substring(ligne.indexOf(";") +1);
			prix = Float.parseFloat(partiePrix);

			//  Calculer le nouveau prix en se basant sur le taux
			nouveauPrix = prix + (prix * taux /100);

			// Écrire dans le nouveau fichier
			fw.write(nomProduit + ";" + nouveauPrix + "\n");

			// Lire la ligne d'après dans le fichier original
			ligne = fr.readLine();
		}

		// Étape 5 : fermer le lecteur et le writer
		fr.close();
		fw.close();		
	}

	/**
	 * Écrire une action qui lit successivement au clavier un nom et un nombre de secondes jusqu’à ce que le
	 * nom entré soit "*FIN*". Cette action écrit également dans le fichier resultat.txt chaque nom et
	 * chaque durée sous la forme HH:MM:SS (sauf éventuellement les 0 des dizaines), à raison d’un par
	 * ligne.
	 * @throws IOException 
	 */
	private static void exercice3() throws IOException {
		// Étape 1 : ouvrir le scanner et lire le retour utilisateur
		Scanner scanner = new Scanner(System.in);
		
		// Étape 2 : créer le writer pour y écrire les entrées de l'utilisateur
		BufferedWriter f = new BufferedWriter(new FileWriter("resultat.txt"));
		
		// Étape 3 : itérer sur les retours de l'utilisateur
		String nom;
		int temps;
		do {
			// Demander à l'utilisateur le nom
			System.out.print("Nom ? ");
			nom = scanner.nextLine();
			
			// Si le nom n'est pas *FIN*, alors on continue
			if (!nom.equals("*FIN*")) {

				// Demander à l'utilisateur le temps
				System.out.print("Temps ? ");
				temps = scanner.nextInt();
				scanner.nextLine(); 	// pour supprimer le saut de ligne que ne consomme pas
										//nextInt() et qui va être lu à tort par le nextLine suivant...
				
				// Écrire le nom et le temps dans le fichier
				f.write(nom + " " + ( temps / 3600 ) + ":" + (( temps / 60 ) % 60 ) + ":" + ( temps % 60));
				// Aller à la ligne dans le fichier
				f.newLine();
			}
		}
		while (!nom.equals("*FIN*"));
		
		// Étape 4: afficher le message de fin suite à l'entrée *FIN* et fermer le writer
		System.out.print("Merci. Le fichier \"resultat.txt\" a été généré.");
		f.close();
	}
}
