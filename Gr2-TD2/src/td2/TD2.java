package td2;

import java.util.Scanner;

public class TD2 {

	public static void main(String[] args) {
		//exercice1();
		
		exercice2();
		
		//exercice3();
		
		//exercice4();
		
		//exercice5();
	}

	/**
	 * Écrire un programme Java qui lit deux flottants et qui indique lequel est le plus grand.
	 * Entrez un premier nombre : 3
	 * Entrez un second nombre : 6.2
	 * Le plus grand est 6.2.
	 */
	private static void exercice1() {
		//VERSION LONGUE
		/*
		 float flottant1, flottant2, flottantLePlusGrand;
		
		System.out.print("Entrez un premier nombre : ");
		Scanner scan = new Scanner(System.in);
		flottant1 = scan.nextFloat();
		
		System.out.print("Entrez un second nombre : ");
		flottant2 = scan.nextFloat();
		
		if(flottant1 < flottant2) {
			flottantLePlusGrand = flottant2;
		} else {
			flottantLePlusGrand = flottant1;
		}
		
		System.out.print("Le plus grand est " + flottantLePlusGrand);
		*/
		
		// VERSION COURTE
		float flottant1, flottant2;
		
		System.out.print("Entrez un premier nombre : ");
		Scanner scan = new Scanner(System.in);
		flottant1 = scan.nextFloat();
		
		System.out.print("Entrez un second nombre : ");
		flottant2 = scan.nextFloat();
		
		if(flottant1 < flottant2) {
			System.out.print("Le plus grand est " + flottant2);
		} else if (flottant1 == flottant2) {
			System.out.print("Ils sont égaux");
		} else {
			System.out.print("Le plus grand est " + flottant1);
		}	
	}
	
	/**
	 * Écrire un programme Java qui lit 3 valeurs a,b et c et qui les affiche dans l'ordre croissant. Exemple 
	 * Quelle est la valeur de a ? : -3
	 * Quelle est la valeur de b ? : 11
	 * Quelle est la valeur de c ? : 6
	 * Les voici dans l'ordre : -3, 6 et 11.
	 * */
	private static void exercice2() {
		double a, b, c;
		
		System.out.print("Quelle est la valeur de a ? : ");
		Scanner scan = new Scanner(System.in);
		a = scan.nextDouble();
		
		System.out.print("Quelle est la valeur de b ? : ");
		b = scan.nextDouble();
		
		System.out.print("Quelle est la valeur de c ? : ");
		c = scan.nextDouble();
		
		if(a < b) {
			// Je sais que a < b
			// Il faut que je teste b et c
			
			if (b < c) {
				// a < b < c
				System.out.print("es voici dans l'ordre : " + a + ", " + b + ", " + c + ".");
			} else if ( a < c){
				// a < c < b
				System.out.print("es voici dans l'ordre : " + a + ", " + c + ", " + b + ".");
			} else {
				// c < a < b
				System.out.print("es voici dans l'ordre : " + c + ", " + a + ", " + b + ".");
			}
		} else {
			// Je sais que b <= a
			// Il faut que je teste a et c
			if(a < c) {
				// b < a < c
				System.out.print("es voici dans l'ordre : " + b + ", " + a + ", " + c + ".");
			} else if(b < c) {
				// b < c < a
				System.out.print("es voici dans l'ordre : " + b + ", " + c + ", " + a + ".");
			} else {
				// c < b < a
				System.out.print("es voici dans l'ordre : " + c + ", " + b + ", " + a + ".");
			}			
		}	
	}
	
	/**
	 * Le noir d’Aniline est un pigment synthétique utilisé dans la fabrication des encres et des peintures. Cette
	 * couleur est définie dans le codage RGB par les 3 valeurs (18, 13 et 22). Votre logiciel demande les valeurs
	 * en hexadécimal. Quelles sont-elles ?
	 */
	private static void exercice3() {
		System.out.println("La réponse est : (12, D, 16) en hexadécimale");
	}
	
	/**
	 * Question A: Écrire (FAC)16 en base 2 et en base 8.
	 * Question B: Écrire (1001100001,1011)2 en base 8 et en base 16
	 */
	private static void exercice4() {
		// Question A
		System.out.println("Réponse A");
		System.out.println("(FAC)16 = (1111 1010 1100) en base 2 et ensuite en groupant par 3 en partant de la droite : (7654) en base 8");
		
		// Question B
		System.out.println("Réponse B");
		System.out.println("(1001100001,1011) en base 2 sera (1141,54) en base 8");
	}
	
	/**
	 * Question B: Écrire 7,375 en base 2
	 * Question C: Écrire (1011,11)2 en base 10
	 */
	private static void exercice5() {
		// Question B
		System.out.println("Réponse B");
		System.out.println("(111,011) en base 2");
		
		// Question C
		System.out.println("Réponse C");
		System.out.println("11,75");
	}
	
	/**
	 * Écrire un programme qui lit une température et qui indique si l'eau s'y trouve sous forme gazeuse,
	 * liquide ou solide.
	 */
	private static void exercice6() {
		double temperature;

		System.out.print("Quelle est la température de l'eau? ");
		Scanner scan = new Scanner (System.in);
		temperature = scan.nextDouble();
		
		if(temperature < 0) {
			// L'eau est en état solide
			System.out.println("l’eau est solide");
		} else if (temperature < 100) {
			// L'eau est en état liquide
			System.out.println("l’eau est liquide");
		} else {
			// L'eau est en état gazeux
			System.out.println("l’eau est gazeuse");
		}		
	}
}
