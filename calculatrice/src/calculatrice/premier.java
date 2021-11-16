package calculatrice;
import java.util.Scanner; 
import java.util.ArrayList;

public class premier {
	public  void claculepremier(int nb) {
		int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59},rep;
		rep = new int[16];
		System.out.println(1+" et "+nb);
		for(int i=0;i<16;i++) {
			if(nb%tab[i] == 0) {
				System.out.println(tab[i]+" et "+nb/tab[i]);
			}
		}
	}
	
	public int souscalcule(int nb){
		int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59},rep;
		rep = new int[16];
		int nbrenvoi = 0;
		for(int i=0;i<16;i++) {
			if(nb%tab[i] == 0) {
				if(nbrenvoi <tab[i] && nb != tab[i]) {
					nbrenvoi = tab[i];
				}
			}
		}
		return nbrenvoi;
	}
	
	public void calculedécomposition(int nb) {
		int cpt = 0, ret,f,n;
		String s="";
		ArrayList<Integer> i = new ArrayList<Integer>();
		premier p = new premier();
		
		while(cpt == 0) {
			ret = p.souscalcule(nb);
			if(ret == 0) {
					cpt++;
					i.add(nb);
			}else {
				i.add(ret);
				
				nb=nb/ret;
				
			}
		}
		
			for (int j = 0; j < i.size(); j++) {
				cpt=0;
				f = i.get(j);
				n=f;
				while(cpt == 0){
					ret = p.souscalcule(f);
					if(ret == 0) {
						if((i.size())-1 == j) { 
							s+= n;
						}else {
							s+= n+"*";
						}
						cpt++;	
					}else {
						f=f/ret;
						n=ret;
					}
				}
			}
		System.out.println(s);

	}

	public static void main(String[] args) {
		premier p = new premier();
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		p.claculepremier(i);
		p.calculedécomposition(i);
		scan.close();

	}

}
