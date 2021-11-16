package calculatrice;

public class premier {
    public  void clacule(int nb) {
        int [] tab= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,51,59},rep;
        rep = new int[16];
        if(nb!=0) {
        System.out.println(1+" et "+nb);
        for(int i=0;i<16;i++) {
            if(nb%tab[i] == 0) {
                System.out.println(tab[i]+" et "+nb/tab[i]);
            }
        }}else
        	 System.out.println("0 nes pas un nombre valable");
    }
    public static void main(String[] args) {
        premier p = new premier();
        p.clacule(0);
    }

}
