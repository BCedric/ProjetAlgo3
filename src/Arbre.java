import java.util.ArrayList;

/**
 * 
 * @author Cedric
 *
 * @param <Type>
 */
public class Arbre<Type> {
	private Arbre<Type> pere;
	private Type etq;
	
	/**
	 * Constructeur
	 * @param t
	 */
	public Arbre(Type t){
		pere=null;
		etq=t;
	}
	
	/**
	 * Fonction permettant d'unir deux arbres
	 * @param a	arbre a unir avec "this"
	 */
	public void union(Arbre<Type> a){
		a.setPere(this);
	}
	
	/**
	 * Fonction permettant de connaitre si l'element est le pere de l'arbre 
	 * @return true si l'element courant est le pere de l'arbre, sinon false
	 */
	public boolean estPere(){
		return this.pere==null;
	}
	
	/**
	 * Fonction renvoyant l'element en tete de l'arbre
	 * @return le pere de l'arbre
	 */
	public Type classe(){
		if(this.estPere()){
			return this.etq;
		}
		else{
			Type t=this.pere.classe();
			if(this.pere.getPere()!=null){
				this.pere=this.pere.getPere();
			}
			return t;
		}
	}
	
	/**
	 * @return the pere
	 */
	public Arbre<Type> getPere() {
		return pere;
	}

	/**
	 * @param pere the pere to set
	 */
	public void setPere(Arbre<Type> pere) {
		this.pere = pere;
	}

	/**
	 * @return the etq
	 */
	public Type getEtq() {
		return etq;
	}

	
	
	
}
