package calculatrice;
import java.util.Scanner; 
import java.util.ArrayList;

public class premier {
	
	public  int  claculepremier(int nb) { //clacule directement en affichant le premier ces as dire son multiplicateur et son r�sultat
		int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59};
		int cpt=0;
		if(nb != 0) {
		System.out.println(1+" et "+nb);
		for(int i=0;i<16;i++) {
			if(nb%tab[i] == 0) {
				System.out.println(tab[i]+" et "+nb/tab[i]);
				cpt++;
			}
		}
		}
		return cpt;
	}
	
	public int souscalcule(int nb){// calcule pour trouver quelle est la valeur premier la plus grande
		int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59};
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
	public void calculed�compositionplusgrand(int nb) {// permet de montrer le d�compostions d'un nombre
		int cpt = 0, ret;
		ArrayList<Integer> i = new ArrayList<Integer>();
		premier p = new premier();
		
		while(cpt == 0) {// calcule de la d�compostions classique
			ret = p.souscalcule(nb);
			if(ret == 0) {
					cpt++;
					i.add(nb);
			}else {
				i.add(ret);
				nb=nb/ret;
				
			}
		}
		p.affichecalcule(i,p);
	}

	
		public void affichecalcule(ArrayList<Integer> i,premier p) {
			int cpt,f,n,ret;
			String s="";
		for (int j = 0; j < i.size(); j++) {// calcule de la d�compostions appret d�compostions ces as dire avec le r�sultat de la d�compositions 
			cpt=0;
			f = i.get(j);
			n=f;
			while(cpt == 0){// mise en plase du tchec pour voir si chaque terme peux aitre encore r�duit 
				ret = p.souscalcule(f);
				if(ret == 0) {
					n=f;
					if((i.size())-1 == j) { 
						s+= n;
					}else {
						s+= n+"*";
					}
					cpt++;	
				}else {
					n=ret;
					f=f/ret;
				}
			}
		}
		System.out.println(s);// affichage de la d�compostions 
	}
		
	public void affichepremie(int nb){
		int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59};
		int cpt=0,i=0;
		String s="";
		while(cpt == 0) {
			if(tab[i]*tab[i] <nb ) {
				s+=tab[i]+",";
			}else if(i==15 && tab[i]*tab[i] >nb)
					cpt++;
			i++;
		}
		System.out.println(s);
	}

	public void premieroupas(int p) {
		if(p != 0) {
			System.out.println("-------------------------------");
			System.out.println("votre chiffre n'est pas premier");
			System.out.println("-------------------------------");
		}else if(p==0){
			System.out.println("----------------------------------------");
			System.out.println("votre chiffre a une infiniter de diviser");
			System.out.println("----------------------------------------");
		}else {
			System.out.println("--------------------------");
			System.out.println("votre chiffre est premier");
			System.out.println("--------------------------");	
		}
	}
	
	
	public static void main(String[] args) {
		premier p = new premier();
		Scanner scan = new Scanner(System.in);
		System.out.println("�hugo biegas�");
		System.out.println("/--------------------------------------------------------------------");
		System.out.println("|saisiser un nombre pour trouver son premier et sa d�compositions : |");
		System.out.println("--------------------------------------------------------------------/");
		int i = scan.nextInt();
		System.out.println("les nombre premier pour votre nombre peuve aitre :");
		p.affichepremie(i);
		System.out.println("s'avoir si votre nombre et premier ou non  :");
		int n =p.claculepremier(i);
		p.premieroupas(n);
		System.out.println("la d�compositions de votre chiffre :");
		p.calculed�compositionplusgrand(i);
		scan.close();

	}

}
