import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Cedric
 *
 */
public class Dictionnaire {
	private AVL<Mot> dico;
	
	/**
	 * Constructeur : 
	 * @param s Nom du fichier contenant la liste de mots du dictionnaire
	 * @throws FileNotFoundException
	 */
	public Dictionnaire(String s) throws FileNotFoundException{
		Scanner scan=new Scanner(new FileReader(s));
		String  motCourant= null;
		
		while(scan.hasNext()){
			motCourant=scan.next();
			ajouterMot(new Mot(motCourant));
		}
	}
	
	/**
	 * Fonction permettant d'ajouter un mot au dictionnaire
	 * @param m
	 */
	public void ajouterMot(Mot m){
		if(dico==null){
			dico=new AVL<Mot>(m);
		}
		else dico=dico.ajouter(new AVL<Mot>(m));
	}
	
	
	/**
	 * 
	 * @return
	 */
	public AVL<Mot> getDico(){
		return dico;
	}
	
	/**
	 * 
	 * @param avl
	 */
	public void setDico(AVL<Mot> avl){
		dico=avl;
	}


}
