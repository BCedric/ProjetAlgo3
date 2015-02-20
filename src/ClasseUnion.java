import java.util.ArrayList;


/**
 * 
 * @author Cedric
 *
 */
public class ClasseUnion{
	
	ArrayList<Page> elt;
	Page[] classes;
	
	/**
	 * Constructeur
	 */
	public ClasseUnion( ArrayList<Page> elt){
		this.elt=elt;
		classes=new Page[elt.size()];
	}
	
	/**
	 * Fonction permettant d'unir les groupe auxquels appartiennent deux pages
	 * @param p1 page appartenant à un groupe
	 * @param p2 page appartenant à un groupe
	 */
	public void union(Page p1, Page p2){
		if(classes[p2.getId()-1]==null || classes[p2.getId()-1]==p2){
			if(classes[p1.getId()-1]==null) classes[p2.getId()-1]=p1;
			else classes[p2.getId()-1]=classes[p1.getId()-1];
		}
		else{
			union(p1,classes[p2.getId()-1]);
		}
	}
	
	/**
	 * Fonction renvoyant la page qui sert d'identifiant à un groupe
	 * @param p	Page dont on veut savoir l'identifiant
	 * @return	page qui servant à identifier le groupe
	 */
	public Page classe(Page p){
		if(classes[p.getId()-1]!=null && classes[p.getId()-1]!=p) return classe(classes[p.getId()-1]);
		else return p;
	}

	/**
	 * @return the elt
	 */
	public ArrayList<Page> getElt() {
		return elt;
	}
	
	
}
