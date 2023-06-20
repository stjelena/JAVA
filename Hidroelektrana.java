package parcele;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac implements Runnable {
	
	private int brVodPovr;

	public Hidroelektrana(String o, Color c, int vreme, Baterija bat) {
		super(o, c, vreme, bat);
		
		this.boja = Color.BLUE;
		this.oznaka = "H";
		brVodPovr = 0;
		this.vreme = 1000;
	}
	
	public void setBrVodPovr(int br) {
		brVodPovr = br;
	}

	@Override
	public void proizvedi() {
		
		for(int i = 0; i < brVodPovr; i++) {
			baterija.dodajQ(1);
		}
		
		if (brVodPovr > 0)
			uspesno = true;
		else uspesno = false;
		
		//if (uspesno)
			//System.out.println("Proizvedeno");
		//notify();
		
	}
	
	
	
	

}
