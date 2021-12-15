package td12;

public class TD12 {

	public static void main(String[] args) {
		exercise1();
	}
	
	/**
	 * Écrire la fonction ecartMoyen qui étant donné un
	 * tableau d’entiers, renvoie la moyenne des écarts entre les
	 * valeurs adjacentes. Par exemple, les écarts dans le tableau ci-contre sont 5 (écart entre 7 et
	 * 12), 8 (écart entre 12 et 4)… et 7 (écart entre 2 et 9). La moyenne de ces écarts est donc
	 * (5+8+7+6+14+1+8)/7 = 6.857. Attention à ne pas déborder du tableau, à gauche ou à
	 * droite.
	 */
	public static void exercise1() {
		int[] notes = {7, 12, 4, 11, 17, 3, 2, 9};
	}

	
	//ecartMoyen
	
	/**
	 * Écrire une fonction qui, étant donné deux chaînes de caractères ordonnées retourne une
	 * chaîne fusionnant les deux, tout en conservant l’ordre. Il suffit d’avancer simultanément dans
	 * chacune des chaînes en copiant dans la chaîne résultat le plus "petit" caractère des deux. Par
	 * exemple, si les deux chaînes sont "BDKKL" et "FKLM", cette fonction doit retourner
	 * "BDFKKKLLM".
	 */
	public static void exercise2() {
		
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
	 */
	public static void exercise3() {
		
	}
}
