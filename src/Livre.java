import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author Cedric
 *
 */
public class Livre {
	private ClasseUnion pages;
	private Dictionnaire dico;

	/**
	 * Constructeur du Livre
	 * @param d	Dictionnaire
	 * @throws FileNotFoundException 
	 */
	public Livre(String[] args) throws FileNotFoundException {
		super();
		ArrayList<Page> ensemblePages=new ArrayList<Page>(); 
		dico=new Dictionnaire(args[1]);
		
		for(int i=2;i<args.length;++i){
			ensemblePages.add(new Page(args[i], dico));
		}
		pages=new ClasseUnion(ensemblePages);
	}
	
	/**
	 * Fonction ajoutant une page au livre
	 * @param chemin chemin du fichier de la page
	 * @throws FileNotFoundException 
	 */
	
	public void unirPages(){
		ArrayList<Page> p=pages.getElt();
		for(int i=0;i<p.size();++i){
			for(int j=i+1;j<p.size();++j){
				if(p.get(i).unir(p.get(j)) && pages.classe(p.get(i))!=pages.classe(p.get(j))){
					pages.union(p.get(i), p.get(j));	
				}
			}
		}
		
		
	}
		
		

		
	
	
	/**
	 * Fonction d'affichage du livre
	 */
	public void afficher(){
		
		ArrayList<Page> p=pages.getElt();
		for(Page p0:p){
			System.out.print("page :"+p0.getId()+" , chapitre : ");
			if(pages.classe(p0)!=null){
				System.out.print(pages.classe(p0).getId());
			}
			System.out.println();
		}
		
	}
	
	
	
	
}
