import java.util.ArrayList;

/**
 * 
 * @author Cedric
 *
 * @param <Type> Type contenu par l'AVL
 */
public class AVL<Type extends Comparable<Type>> {

	private Type elt;
	private	AVL<Type> fg;
	private	AVL<Type> fd;
	
	/**
	 * Constructeur
	 * @param e element contenu par le nouvel AVL
	 */
	public AVL(Type e) {
		super();
		fg=null;
		fd=null;
		elt=e;
	}
	
	/**
	 * Fonction retourner la liste des elements de l'arbre
	 * @param elts	liste vide
	 * @return	liste des elements
	 */
	public ArrayList<Type> listeElts(ArrayList<Type> elts){
		if(fd!=null) elts=fd.listeElts(elts);
		elts.add(this.elt);
		if(fg!=null) elts=fg.listeElts(elts);
		return elts;
		
	}
	
	/**
	 * Fonction ajoutant un element a l'arbre
	 * @param a element a ajouter
	 * @return	nouvelle racine de l'arbre
	 */
	public AVL<Type> ajouter(AVL<Type> a){
		if(a.getElt().compareTo(elt)<0){
			if(fg==null) fg=a;
			else{
				fg=fg.ajouter(a);
			}
		}
		else if(a.getElt().compareTo(elt)>0){
			if(fd==null) fd=a;
			else {
				fd=fd.ajouter(a);
				
			}
		}
		return equilibre();
	}
	
	/**
	 * Fonction supprimant un element de l'arbre
	 * @param t element a supprimer
	 * @return	nouvelle racine de l'arbre
	 */
	public AVL<Type> suppression(Type t){
		if(t.compareTo(this.elt)==0){ 
			if(this.fg!=null){
				
				AVL<Type> p=this.fg.pereMax();		//p=pere du max du sous arbre gauche
				if(p!=null){
					AVL<Type> tmp=this.fg.pereMax().fd;
					if(!p.equals(this)){
						p.fd=tmp.fg;
						tmp.fg=this.fg;
						if(tmp.fd==null){
							tmp.fd=this.fd;
							return tmp;
						}
						else{
							tmp.fd.setFd(this.fd);
							return tmp;
						}
					}
					else{
						tmp.fd=this.fd;
						return tmp;
					}
				}
				else{
					fg.setFd(fd);
					return fg.equilibre();
				}
			}
			else if(fd!=null){
				System.out.println();
				AVL<Type> p=this.fd.pereMin();
				
				if(p!=null){
					AVL<Type> tmp=this.fd.pereMin().fg;
					if(!p.equals(this)){
						p.fg=tmp.fd;
						tmp.fd=this.fd;
						if(tmp.fg==null){
							tmp.fg=this.fg;
							return tmp;
						}
						else{
							tmp.fg.setFd(this.fg);
							p.equilibre();
							return tmp;
						}
					}
					else{
						tmp.fg=this.fg;
						return tmp;
					}
				}
				else{
					fd.setFg(fg);
					return fd.equilibre();
				}
			}
			else{
				return null;
			}
		}
		else if(t.compareTo(this.elt)==-1){
			fg=fg.suppression(t);
			return this.equilibre();
			
			
		}
		else{
			fd=fd.suppression(t);
			return this.equilibre();
			
		}
	}
	
	/**
	 * Fonction indiquant si un element est present dans l'arbre
	 * @param t	element a chercher dans l'arbre
	 * @return	true si l'element est present, sinon false
	 */
	public boolean present(Type t){
		
		if(this.elt.compareTo(t)==0){
			return true;
		}
		else{
			if(this.estFeuille())return false;
			if(t.compareTo(elt)<0){
				if(fg==null)return false;
				else return fg.present(t);
			}
			if(t.compareTo(elt)>0){
				if(fd==null)return false;
				else return fd.present(t);
			}
		}
		return false;	
	}
	
	/**
	 * Fonction retournant le pere de l'element max
	 * @return	pere de lelement max
	 */
	public AVL<Type> pereMax(){
		if(fd==null)return null;
		if(fd.getFd()==null) return this;
		else return fd.pereMax();
	}
	
	/**
	 * Fonction retournant le pere de l'element min
	 * @return	pere de lelement min
	 */
	public AVL<Type> pereMin(){
		if(fg==null)return null;
		if(fg.getFg()==null) return this;
		else return fg.pereMin();
	}

	/**
	 * Fonction retournant la hauteur de l'arbre
	 * @return	hauteur de l'arbre
	 */
	public int hauteur(){
		
		if(estFeuille()){
			return 0;
		}
		else{
			if(fd==null){
				return fg.hauteur()+1;
			}
			else if(fg==null){
				return fd.hauteur()+1;
			}
			else{
				return Math.max(fd.hauteur(), fg.hauteur())+1;
			}
		}
	}
	
	/**
	 * Fonction equilibrant l'arbre
	 * @return	La nouvelle racine de l'arbre
	 */
	public AVL<Type> equilibre(){
		int b=balance();
		AVL<Type> tmp=this;
		if(Math.abs(b)>1){
			
			if(b>1){  				//fd plus important que fg
				if(fd.balance()>0){		
					tmp=fd;
					AVL<Type> tmp1=fd.getFg();
					fd.setFg(this);
					fd=tmp1;
				}
				else if(fd.balance()<0){
					tmp=fd.getFg();
					AVL<Type> tmp1=fd.getFg().getFg();
					AVL<Type> tmp2=fd.getFg().getFd();
					tmp=fd.getFg();
					fd.getFg().setFg(this);
					fd.getFg().setFd(fd);
					fd.setFg(tmp2);
					fd=tmp1;
				}
			}
			else if(b<-1){			//fg plus important que fd
				if(fg.balance()>0){
					tmp=fg.getFd();
					AVL<Type> tmp1=fg.getFd().getFd();
					AVL<Type> tmp2=fg.getFd().getFg();
					fg.getFd().setFd(this);
					fg.getFd().setFg(fg);
					fg.setFd(tmp2);
					fg=tmp1;
					
				}
				else if(fg.balance()<0){
					tmp=fg;
					AVL<Type> tmp1=fg.getFd();
					fg.setFd(this);
					fg=tmp1;
				}
			}
			
		}
		return tmp;
	}
	
	/**
	 * Fonction retournant la balance de l'arbre (hauteur(filsGauche)-hauteur(filsDroit))
	 * @return balance
	 */
	public int balance(){
		if(fd==null && fg==null) return 0;
		else if(fd==null) return -fg.hauteur()-1;
		else if(fg==null) return fd.hauteur()+1;
		else return fd.hauteur()-fg.hauteur();
	}
	
	
	
	
	/**
	 * Fonction permettant de connaitre si un element est une feuille
	 * @return true si l'element est une feuille, false sinon
	 */
	public boolean estFeuille(){
		if(this.fd==null && this.fg==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * @return the elt
	 */
	public Type getElt() {
		return elt;
	}



	/**
	 * @param elt the elt to set
	 */
	public void setElt(Type elt) {
		this.elt = elt;
	}



	/**
	 * @return the fg
	 */
	public AVL<Type> getFg() {
		return fg;
	}



	/**
	 * @param fg the fg to set
	 */
	public void setFg(AVL<Type> fg) {
		this.fg = fg;
	}



	/**
	 * @return the fd
	 */
	public AVL<Type> getFd() {
		return fd;
	}



	/**
	 * @param fd the fd to set
	 */
	public void setFd(AVL<Type> fd) {
		this.fd = fd;
	}

	public void affichageSym() {
		if(fg!=null) fg.affichageSym();
		System.out.println(this.elt);
		if(fd!=null) fd.affichageSym();
		
	}
	
	

}
