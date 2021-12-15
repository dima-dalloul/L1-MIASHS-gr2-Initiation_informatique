package td12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TD12 {

	public static void main(String[] args) throws IOException {
		//exercice1();
		
		//exercice2();
		
		exercice3();
	}
	
	/**
	 * Écrire la fonction ecartMoyen qui étant donné un
	 * tableau d’entiers, renvoie la moyenne des écarts entre les
	 * valeurs adjacentes. Par exemple, les écarts dans le tableau ci-contre sont 5 (écart entre 7 et
	 * 12), 8 (écart entre 12 et 4)… et 7 (écart entre 2 et 9). La moyenne de ces écarts est donc
	 * (5+8+7+6+14+1+8)/7 = 6.857. Attention à ne pas déborder du tableau, à gauche ou à
	 * droite.
	 */
	public static void exercice1() {
		int[] notes = {7, 12, 4, 11, 17, 3, 2, 9};
		
		System.out.println("Le résultat est  "+ ecartMoyen(notes));
	}

	
	public static double ecartMoyen(int[] tableau) {
		double sommeEcarts = 0;
		
		// On itère sur le tableau
		for(int i = 0; i < tableau.length-1; i++) {
			// on augmente le total des écarts avec l'élément qui se trouve à l'indice i et celui qui vient après 
			sommeEcarts += Math.abs(tableau[i] - tableau[i+1]);
		}
		
		// On divise par le nombre d'écarts, donc la taille du tableau - 1
		sommeEcarts = (double) sommeEcarts / (tableau.length - 1);
		
		// On retourne le résultat
		return sommeEcarts;
	}
	
	/**
	 * Écrire une fonction qui, étant donné deux chaînes de caractères ordonnées retourne une
	 * chaîne fusionnant les deux, tout en conservant l’ordre. Il suffit d’avancer simultanément dans
	 * chacune des chaînes en copiant dans la chaîne résultat le plus "petit" caractère des deux. Par
	 * exemple, si les deux chaînes sont "BDKKL" et "FKLM", cette fonction doit retourner
	 * "BDFKKKLLM".
	 */
	public static void exercice2() {
		String a = "BDKKL";
		String b = "FKLM";
		
		System.out.println("Le résultat est " + fusion(a, b));
		
	}
	
	public static String fusion(String ch1, String ch2) {
		// On crée 2 indices différents pour les 2 mots
		int i = 0; 
		int j = 0;
		String resultat = "";
		
		// On avance tant que les 2 mots ne sont pas finis
		while(i < ch1.length() && j < ch2.length()){
			// On compare les 2 lettres et on ajoute le plus petit
			if(ch1.charAt(i) < ch2.charAt(j)) {
				resultat += ch1.charAt(i);
				i++;
			} else {
				resultat += ch2.charAt(j);
				j++;
			}
		}
		
		// On ajoute le reliquat du mot 1 s'il existe
		if(i < ch1.length())
			resultat += ch1.charAt(i);

		
		// On ajoute le reliquat du mot 2 s'il existe
		if(j < ch2.length())
			resultat += ch2.charAt(j);
		
		// On renvoie le résultat
		return resultat;
	}
	
	/**
	 * Écrire un programme qui lit un nom de fichier java et qui indique le nombre d’instructions
	 * while de ce programme. On suppose qu’il suffit de chercher la chaine "while" dans les lignes
	 * du programme. Pour cela, vous pouvez utiliser la fonction indexOf qui renvoie l'indice de la
	 * première occurrence d'une chaîne dans une autre. Par exemple, si ch1 = "Nul ne peut se
	 * prévaloir de la turpitude d'autrui", alors ch1.indexOf("valoir") retourne 18, alors
	 * que ch1.indexOf("tartine") retourne -1, ce qui est l'indication que la sous-chaîne n'est pas
	 * présente dans la chaîne.
	 * Bonus : en ne considérant que les accolades du fichier java, vérifiez qu’elles sont
	 * correctement placées. Par exemple, ceci est correct : "...{….{…..}….{….}..}" mais pas ceci
	 * "{….}…..}…..". Vous pouvez utiliser un compteur, initialisé à 0, qui est incrémenté à chaque
	 * parenthèse ouvrante et décrémenté à chaque parenthèse fermante. Ce compteur ne doit
	 * jamais être négatif.
	 * @throws IOException 
	 */
	public static void exercice3() throws IOException {
		// je lis le fichier
		BufferedReader f = new BufferedReader(new FileReader("src/td12/TD12.java"));
		String ligne = f.readLine();
		int compteurWhile = 0;
		
		// j'itère sur chaque ligne
		while(ligne != null) {
			// si le mot while existe alors la position est différente de -1
			if(ligne.indexOf("while") != -1)
				compteurWhile++;
			
			// on avance à la ligne d'après
			ligne = f.readLine();
		}
		
		// on indique le résultat et on ferme le lecteur
		System.out.println("Le nombre de while est " + compteurWhile);
		f.close();
	}
}
