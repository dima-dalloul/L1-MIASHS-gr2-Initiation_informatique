import java.io.*;
import java.util.Scanner;

public class FiltreMots {

	static boolean matches(String mot,String filtre) {
		boolean resultat;
		if (mot.length() != filtre.length()) {
			resultat = false;
		}
		else {
			int i = 0;
			while(i<mot.length() && (filtre.charAt(i)=='?' || mot.charAt(i) == filtre.charAt(i))) {
				i++;
			}
			resultat = (i == mot.length()); // vrai si j'ai parcouru tout le mot, faux sinon
		}
		return resultat;
	}
	
	static void filtre(String nomDico, String filtre) throws IOException {
		// affiche tous les mots du dictionnaire qui passent le filtre
		// Le filtre est composé de lettres ou de ? qui représente
		// n'importe quelle lettre
		BufferedReader f = new BufferedReader(new FileReader(nomDico));
		String ligne=f.readLine();
		while (ligne != null) {
			//Traitement ElementCourant
			if(matches(ligne,filtre)) {
				System.out.println(ligne);
			}
			
			ligne=f.readLine();
		}
		f.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Filtre ? ");
		String chaineFiltre=s.next();
		filtre("lexique25776.txt",chaineFiltre);
	}

}
