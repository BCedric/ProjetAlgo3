import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author Cedric
 *
 */
public class Mot implements Comparable<Mot>{
	private String mot;
	
	/**
	 * Constructeur
	 * @param s mot
	 */
	public Mot(String s){	
		mot=s;
		
	}
	
	public Mot(){
		
	}
	
	@Override
	public int compareTo(Mot o) {
		int i=0;
		if(this.mot.length()<o.getMot().length()) return -1;
		else if(this.mot.length()>o.getMot().length()) return 1;
		else{
			while(i<mot.length() && i<o.getMot().length()){
				if((int)mot.toLowerCase().charAt(i)<(int)o.getMot().toLowerCase().charAt(i)) return -1;
				else if((int)mot.toLowerCase().charAt(i)>(int)o.getMot().toLowerCase().charAt(i)) return 1;
				++i;
			}
		}
		return 0;
	}

	/**
	 * @return the mot
	 */
	public String getMot() {
		return mot;
	}
	
	public void setMot(String m){
		mot=m;
	}

}
