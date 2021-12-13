package td11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TD11 {

	public static void main(String[] args) throws IOException {
		exercice1();
		exercice2();
		exercice3();
	}
	
	/**
	 * Écrire la fonction plusGrand qui, étant donné un tableau d’entiers représentant un arbre binaire de
	 * recherche, renvoie la plus grande valeur du tableau. Il ne faut pas chercher linéairement dans le
	 * tableau comme d’habitude, mais suivre les branches de l’arbre. Le plus grand élément est en effet la
	 * feuille la plus à droite dans l’arbre.
	 */
	public static void exercice1() {
		int[] arbreBinaire = {0, 4, 2, 7, -1, -1, 5, 13, -1, -1, -1, -1, 6, -1, -1, -1, -1};
		
		System.out.println("La plus grande valeur de l'arbre binaire est : " + plusGrand(arbreBinaire));
	}
	
	/**
	 * Fonction qui renvoie l'élément le plus à droite de l'arbre binaire
	 * @param tableau
	 * @return l'élément le plus grand
	 */
	static int plusGrand(int[] tableau){
		// On commence à 1
		int n = 1;
		
		// Boucler sur le tableau sur la base que les plus grandes valeurs sont à 2n + 1
		while(tableau[2 * n + 1]  != -1){
			n = n  * 2 + 1;
		}
		
		// Retourner la plus grande valeur trouvée
		return tableau[n];
	}

	/**
	 * A- Écrire la fonction booléenne identiques qui, étant donné une
	 * chaîne de caractères, renvoie vrai si tous les caractères sont égaux et
	 * faux sinon. Par exemple, identiques("2222") renvoie true mais
	 * identiques("bbbabb") renvoie false. Si la chaîne est vide, la
	 * fonction renvoie false.
	 * B- Écrire un programme qui utilise la fonction précédente pour déterminer le nombre de lignes du
	 * fichier monFichier.txt qui contiennent des caractères tous identiques. Par exemple, avec le fichier cicontre,
	 * le programme devra afficher :
	 * "Le fichier contient 3 lignes aux caractères tous identiques"
	 * c) Même chose mais le programme affiche en plus la dernière ligne dont les caractères sont tous
	 * identiques :
	 * "Le fichier contient 3 lignes aux caractères tous identiques et la dernière est : aaaaa"
	 * @throws IOException 
	 */
	public static void exercice2() throws IOException {
		// Partie A
		String a = "2222";
		String b = "bbbabb";
		
		System.out.println(a + " tous identiques? " + identiques(a));
		System.out.println(b + " tous identiques? " + identiques(b));
		
		// Partie B et C
		BufferedReader f = new BufferedReader(new FileReader("fichier.txt"));
		String ligne = f.readLine();		
		int compteurLignesIdenitques = 0;
		String derniereLigneIdentique = "";
		
		// On itère dans le fichier
		while(ligne != null) {
			// On appelle la méthode créée précédemment
			if(identiques(ligne)) {
				// Si tout est identique, alors on incrémente le compteur et on sauvegarde la ligne
				compteurLignesIdenitques++;
				derniereLigneIdentique = ligne;
			}
			
			ligne = f.readLine();
		}
		
		// On affiche le résultat
		System.out.println("Le fichier contient "+ compteurLignesIdenitques + " lignes aux caractères tous identiques et la dernière est : " + derniereLigneIdentique);
		
		// On ferme le lecteur de fichiers
		f.close();
	}
	
	/**
	 * Méthode pour tester que tous les caractères sont identiques
	 * @param ch
	 * @return vrai s'ils sont tous identiques
	 */
	static boolean identiques(String ch) {
		// On place le curseur à 0
		int i = 0;
		
		// Si la chaîne est vide, alors on renvoie faux
		if(ch.equals("")) {
			return false;
		} else {
			// On parcourt la chaîne tout en comparant chaque élément avec le 1er élément
			while(i < ch.length() && (ch.charAt(0) == ch.charAt(i))) {
				i++;
			}
			
			// Si i atteint le bout de la chaîne, alors ça veut dire que tous les éléments sont identiques.
			// Donc on renvoie vrai. Et dans le cas inverse, si i est différent de la taille, ça voudra dire
			// qu'un élément n'est pas identique au 1er, et donc on renvoit faux
			return (i == ch.length());
		}
	}

	/**
	 * Écrivez un programme qui calcule cette approximation de π en sommant les 10.000 premiers termes et en
	 * les affichant au fur et à mesure.
	 */
	public static void exercice3() {
		int compteurTermes = 1; 
		int diviseur = 1;
		double pi = 0;
		
		// On itère jusqu'à 10000 fois
		while(compteurTermes < 10000) {
			if(compteurTermes % 2 == 0) {	// Si c'est pair, alors on soustrait
				pi = pi - 4 * 1 / (double) diviseur;		// si j'oublie le cast, la division est entière, sans décimales		
			} else {	// Si c'est impair, alors on additionne
				pi = pi + 4 * 1 / (double) diviseur;
			}
			
			// On incrémente le compteur d'1 et le diviseur de 2
			diviseur = diviseur + 2;
			compteurTermes++;
			
			// On imprime pi
			System.out.println(pi);
		}
	}
}
