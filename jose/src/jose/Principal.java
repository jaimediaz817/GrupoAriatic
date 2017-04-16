package jose;

import javax.swing.JOptionPane;

public class Principal {
		
	public static void main(String[] args) {
		
		
		int baraja[]=new int [52];
		int pinta[]=new int [13];
		int persona[]=new int [12];
		int diler[]=new int[12];
		int maximo=21;
		comenzarJuego(diler,persona);
		pedirCarta(diler,persona);
		 
	}

	public static void pedirCarta(int[] diler, int[] persona) {
		int cont1=0;int cont2=0;
		for(int i=0;i<2;i++){
			if(diler[i]==1){
				String nom1="DILER";
				int a= valorDelAs(nom1);
				diler[i]=a;
			}
			cont1+=diler[i];
			if(persona[i]==1){
				String nom2="PERSONA";
				int a= valorDelAs(nom2);
				persona[i]=a;
			}
			cont2+=persona[i];
		}
		JOptionPane.showMessageDialog(null, "TOTAL DILER\n"+cont1);
		JOptionPane.showMessageDialog(null, "TOTAL PERSONA\n"+cont2);
		
		
	}

	public static int valorDelAs(String nom) {
		int a=Integer.parseInt(JOptionPane.showInputDialog("QUE TAMAÑO QUIERE QUE EL As TOME: "+nom+"\n"+"1 / 11"));
		return a;
	}

	public static void comenzarJuego(int diler[],int persona[]){
		for(int i=0;i<2;i++){
			diler[i]=(int)(Math.random()*10)+1;
			if(diler[i]==1){
				JOptionPane.showMessageDialog(null, "DILER\n"+"As");
			}else{
				JOptionPane.showMessageDialog(null,"DILER\n"+ diler[i]);
				}
			persona[i]=(int)(Math.random()*10)+1;
			if(persona[i]==1){
				JOptionPane.showMessageDialog(null,"PERSONA\n"+ "As");
			}else{
				JOptionPane.showMessageDialog(null,"PERSONA\n"+ persona[i]);
				}	
		}
	}
}
