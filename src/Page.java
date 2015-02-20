import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Cedric
 *
 */
public class Page{
	private AVL<Mot> contenu;
	private int id;
	private static int k;
	
	/**
	 * Constructeur
	 * @throws FileNotFoundException 
	 */
	public Page(String chemin,Dictionnaire d ) throws FileNotFoundException {
		Scanner scan=new Scanner(new FileReader(chemin));
		if(scan.hasNext()){
			this.setId(Integer.parseInt(scan.next()));
			Mot m=new Mot();
			while(scan.hasNext()){
				m.setMot(scan.next());
				if(m.getMot().length()>=2 && m.getMot().charAt(1)=='\''){
					m.setMot(m.getMot().substring(2, m.getMot().length()));
				}
				if(m.getMot().charAt(m.getMot().length()-1)=='.' || m.getMot().charAt(m.getMot().length()-1)==',' || m.getMot().charAt(m.getMot().length()-1)=='!' || m.getMot().charAt(m.getMot().length()-1)==';' || m.getMot().charAt(m.getMot().length()-1)==':' || m.getMot().charAt(m.getMot().length()-1)=='?'){
					m.setMot(m.getMot().substring(0, m.getMot().length()-1));
				}
				if(d.getDico()!=null && d.getDico().present(m)){
					if(contenu==null){
						contenu=new AVL<Mot>(new Mot(m.getMot()));
					}
					else{
						contenu=contenu.ajouter(new AVL<Mot>(new Mot(m.getMot())));
					}
				}
			}
		}
	}	

	
	public boolean unir(Page p){
		int i=0;
		ArrayList<Mot> contenuP=p.listeMots();
		if(contenuP!=null){
			for(Mot m:contenuP){
				if(this.contenu.present(m)){
					++i;
				}
			}
			return i>=k;
		}
		else return false;
	}

	/**
	 * Fonction retournant l'identifiant de la page
	 * @return id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Fonction retournant la liste des mots de la page
	 * @return liste des mots de la page
	 */
	public ArrayList<Mot> listeMots(){
		if(this.contenu!=null) return this.contenu.listeElts(new ArrayList<Mot>());
		else return null;
	}

	
	/**
	 * Fonction renvoyant l'arbre des mots de la page
	 * @return
	 */
	public AVL<Mot> getContenu() {
		return contenu;
	}

	
	

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(AVL<Mot> contenu) {
		this.contenu = contenu;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param n valeur de k
	 */
	public static void setK(int n){
		k=n;
	}
}
