package td3;

import java.util.Scanner;

public class TD3 {

	public static void main(String[] args) {
		//exercice1();
		
		//exercice2();
		
		// exercice3();
		
		//exercice4();
		
		//exercice5();
		
		exercice6();
	}

	/**
	 * Écrire un programme qui écrit tous les multiples de 7 compris entre 0 et 1000.
	 */
	private static void exercice1() {
		// Étape 1 : initialiser les variables
		//int chiffre = 0;
		
		// Méthode 1
		/*while(chiffre <= 1000) {
			if(chiffre % 7 == 0) {
				System.out.print(chiffre + ", ");
			}
			chiffre++;
		}*/
		
		// Méthode 2
		/*while(chiffre <= 1000) {
			System.out.print(chiffre + ", ");
			chiffre = chiffre + 7;
		}*/
		
		// Méthode 3
		for(int chiffre = 0; chiffre <= 1000; chiffre = chiffre+7) {
			System.out.print(chiffre + ", ");			
		}
	}
	
	
	/**
	 * Écrire un programme qui lit une chaîne de caractères et qui écrit le premier et le dernier caractère.
	 * Entrez une chaîne : BARBAPAPA
	 * Le premier caractère est B et le dernier est A.
	 */
	private static void exercice2() {
		// Étape 1 : initialiser les variables
		String mot;
		
		// Étape 2 : récupérer le mot de l'utilisateur
		Scanner scan = new Scanner(System.in);
		System.out.println("Écrivez quelque chose");
		mot = scan.nextLine();
		
		// Étape 3: extraire et afficher le 1er caractère et le dernier
		System.out.println("Le 1er caractère du mot est " + mot.charAt(0));
		System.out.println("le dernier caractère du mot sera : " + mot.charAt(mot.length() - 1) );
		
	}

	/**
	 * a) Écrire -22 sur 10 bits en utilisant la méthode du complément vrai.
	 * b) Quel nombre entier est représenté par cet octet, lorsque les négatifs sont codés en complément vrai : 11100001 ?
	 */
	private static void exercice3() {
		System.out.println("A");
		System.out.println("22 = (00010110)2 donc -22 est représenté par 11101010. " + 
				"soit on fait 11111111 - le nombre + 1" + 
				"soit on part de la droite, on recopie les zéros s’il y en a, on recopie le premier 1 qui suit et on inverse le reste).");
		

		System.out.println("B");
		System.out.println("C’est un négatif (bit le plus à gauche à 1). On utilise la même méthode (elle est utilisée pour encoder et " + 
				"décoder. 00011111 vaut 31 => le nombre représenté est -31.");
	}
	
	/**
	 * Écrire un programme qui lit deux chaînes et qui affiche "OK" si leurs longueurs diffèrent, mais d'un caractère
	 * seulement. Les chaînes se lisent avec s.nextLine(). La longueur d'une chaîne ch s'obtient avec ch.length().
	 */
	private static void exercice4() {
		// Étape 1 : initialiser les variables
		String mot1, mot2;
		int differenceTailleMots;
		
		// Étape 2 : récupérer les mots de l'utilisateur
		Scanner scan = new Scanner(System.in);
		System.out.println("Écrivez un 1er mot: ");
		mot1 = scan.nextLine();
		
		System.out.println("Écrivez un 2e mot: ");
		mot2 = scan.nextLine();
		
		// Étape 3: afficher OK si la différence de longueur est d'1 charactère
		differenceTailleMots = mot1.length() - mot2.length();
		//if(differenceTailleMots == 1 || differenceTailleMots == -1) {
		if(Math.abs(differenceTailleMots) == 1) {
			System.out.println("OK");
		}
	}
	
	/**
	 * A) Écrire un programme qui lit une chaîne et qui affiche un caractère sur 2 en commençant par le premier.
	 * B) Même question en demandant en plus à l’utilisateur le pas qui n’est donc pas forcément 2.
	 */
	private static void exercice5() {
		System.out.println("A");
		// Étape 1 : initialiser les variables
		String mot;
		
		// Étape 2 : récupérer le mot de l'utilisateur
		Scanner scan = new Scanner(System.in);
		System.out.println("Écrivez un mot: ");
		mot = scan.nextLine();
		

		// Étape 3: afficher un caractère sur 2
		for(int i = 0; i < mot.length(); i = i + 2) {
			System.out.print(mot.charAt(i) + " ");
		}
		

		System.out.println("B");
		// Étape 1 : déclarer les variables
		String motB;
		int nombreLettres;
		
		// Étape 2 : récupérer le mot de l'utilisateur
		System.out.println("Écrivez un autre mot: ");
		motB = scan.nextLine();
		
		System.out.println("Spécifiez le nombre de lettres à ne pas afficher:");
		nombreLettres = scan.nextInt();
		

		// Étape 3: afficher un caractère sur nombreLettres donnée par l'utilisateur
		for(int i = 0; i < mot.length(); i = i + nombreLettres) {
			System.out.print(mot.charAt(i) + " ");
		}
	}

	
	/**
	 * Écrire un programme qui lit une somme d’argent inférieure à 50 € et indique comment la répartir selon les
	 * billets et pièces habituelles. On désire fournir le minimum de billets et de pièces.
	 */
	private static void exercice6() {
		// Étape 1 : déclarer les variables
		int nombreBillets20, nombreBillets10, nombreBillets5;
		int nombrePieces2, nombrePieces1, nombrePieces50c, nombrePieces20c, nombrePieces10c, nombrePieces5c, nombrePieces2c, nombrePieces1c;
		float montantUtilisateur;
		int euros, centimes;
		Scanner scanner = new Scanner(System.in);
		
		// Étape 2 : récupérer le montant de l'utilisateur
		System.out.println("Entrez un montant: ");
		montantUtilisateur = scanner.nextFloat();
		
		// Étape 3 : récupérer la partie entière du montant, ainsi que la partie décimale
		euros = (int) montantUtilisateur;
		centimes = (int) (Math.round(100 * (montantUtilisateur - euros)));
		// On utilise Math.round pour corriger les erreurs de précision de Java : 0.4999999999 au lieu de 0.5

		// Étape 4: Rendre les billets et pièces
		if(montantUtilisateur >= 50) {
			System.out.println("Moins de 50€ svp!");
		} else {
			// Obtenir le nombre de pièces et billets à afficher
			nombreBillets20 = euros / 20;
			nombreBillets10 = (euros % 20) / 10;
			nombreBillets5 = (euros % 10) / 5;
			
			nombrePieces2 = (euros % 5) / 2;
			nombrePieces1 = euros % 2;
			
			nombrePieces50c = centimes / 50;
			nombrePieces20c = (centimes % 50) / 20;
			nombrePieces10c = ( (centimes % 50) % 20) / 10;
			nombrePieces5c = ( centimes %10 ) / 5;
			nombrePieces2c = ( centimes % 5 ) / 2;
			nombrePieces1c = ( centimes % 5 ) % 2;
			
			if (nombreBillets20 > 0)
				System.out.println(" " + nombreBillets20 + " billet(s) de 20€");
			
			if (nombreBillets10 > 0)
				System.out.println(" " + nombreBillets10 +" billet(s) de 10€");
			
			if (nombreBillets5 > 0)
				System.out.println(" " + nombreBillets5 + " billet(s) de 5€");
			
			if (nombrePieces2 > 0)
				System.out.println(" " + nombrePieces2 + " piece(s) de 2€");
			
			if (nombrePieces1 > 0)
				System.out.println(" " + nombrePieces1 + " piece(s) de 1€");
			
			if (nombrePieces50c > 0)
				System.out.println(" " + nombrePieces50c + " piece(s) de 50 centimes");
			
			if (nombrePieces20c > 0)
				System.out.println(" " + nombrePieces20c + " piece(s) de 20 centimes");
			
			if (nombrePieces10c > 0)
				System.out.println(" " + nombrePieces10c + " piece(s) de 10 centimes");
			
			if (nombrePieces5c > 0)
				System.out.println(" " + nombrePieces5c + " piece(s) de 5 centimes");
			
			if (nombrePieces2c > 0)
				System.out.println(" " + nombrePieces2c + " piece(s) de 2 centimes");
			
			if (nombrePieces1c > 0)
				System.out.println(" " + nombrePieces1c + " piece(s) de 1 centime");
		}
	}
}
