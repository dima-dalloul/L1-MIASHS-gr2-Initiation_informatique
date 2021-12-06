
public class DureeConnexions {

	static String extrait(String ligne,int champ) {
		// renvoie le champ de la chaine ligne (1: avant le #, 2: après le #)
		int indiceDuDiese;
		indiceDuDiese=ligne.indexOf('#');
		if (champ ==1)
		    return(ligne.substring(0,indiceDuDiese));
		else // champ==2
		    return(ligne.substring(indiceDuDiese+1));
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
