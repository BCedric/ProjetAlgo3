import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		int k=Integer.parseInt(args[0]);// premier argument : k
		Page.setK(k);
		Livre livre=new Livre(args);
		livre.unirPages();
		livre.afficher();
		
		

		
//		AVL<Integer> a=new AVL<Integer>(5);
//		a=a.ajouter(new AVL<Integer>(2));
//		a=a.ajouter(new AVL<Integer>(6));
//		a=a.ajouter(new AVL<Integer>(4));
//		a=a.ajouter(new AVL<Integer>(1));
		
		
//		a=a.ajouter(new AVL<Integer>(8));
//		a=a.ajouter(new AVL<Integer>(19));
//		a=a.ajouter(new AVL<Integer>(100));
//		a=a.ajouter(new AVL<Integer>(34));
//		a=a.ajouter(new AVL<Integer>(7));
//		a=a.ajouter(new AVL<Integer>(67));
//		a=a.ajouter(new AVL<Integer>(10));
//		a=a.ajouter(new AVL<Integer>(102));
//		a=a.ajouter(new AVL<Integer>(5));
//		a=a.ajouter(new AVL<Integer>(15));
//		
//		a=a.suppression(2);
//		a=a.suppression(100);
//		a=a.suppression(67);
//		a=a.suppression(102);
//		a.affichageSym();
//		ArrayList<Integer> elts=new ArrayList<Integer>(); 
//		elts=a.listeElts(elts);
//		System.out.println(a.hauteur());
		System.out.println();
	}

}
