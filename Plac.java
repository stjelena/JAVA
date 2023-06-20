package parcele;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Random;

public class Plac extends Panel{
	
	private ArrayList<Parcela> parcele = new ArrayList<>();
	private int rows, columns;
	private Parcela izabrana = null;
	Baterija baterija;
	
	public Plac(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		GridLayout layout = new GridLayout(rows, columns);
		layout.setHgap(1);
		layout.setVgap(1);
		
		this.setLayout(layout);
		this.setSize(500, 450);
		
		initializePlac();
		
	}
	
	
	public void initializePlac() {
		for (int i = 0; i < rows*columns; i++) {
			Random rand = new Random(); 
			int int_random = rand.nextInt(100);
			if (int_random < 70) {
				TravnataPovrs newTP = new TravnataPovrs("''", Color.GREEN);
				newTP.plac = this;
				this.add(newTP);
				parcele.add(newTP);
				newTP.updateIndex(i);
			}
			else {
				VodenaPovrs newVP = new VodenaPovrs("~", Color.CYAN);
				newVP.plac = this;
				this.add(newVP);
				parcele.add(newVP);
				newVP.updateIndex(i);
			}
		}
	}
	
	public void izaberiParcelu(Parcela parcela) {
		if (parcela == izabrana) {
			parcela.ponisti();
			izabrana = null;
		}
		else {
			if (izabrana != null)
				izabrana.ponisti();
			parcela.izaberi();
			izabrana = parcela;
		}
		revalidate();
	}
	
	public void dodajProizvodjaca() {
		if (izabrana == null) {
			return;
		}
		Hidroelektrana pr = new Hidroelektrana("H", Color.BLUE, 1000, baterija);		
		
		add(pr, izabrana.index);
		pr.updateIndex(izabrana.index);
		remove(izabrana);
		revalidate();
		
		parcele.set(izabrana.index, pr);
		
		pr.setBrVodPovr(brVodPovr(pr));
		
		pr.go();
		revalidate();
		
		
	}
	
	public int brVodPovr(Hidroelektrana h) {
		int br = 0;
		for (int i = 0; i < rows*columns; i++) {
			if (i == h.index) {
				if ((i%columns) != 0)
					if (parcele.get(i-1) instanceof VodenaPovrs) br++;
				if(i != columns-1)
					if (parcele.get(i+1) instanceof VodenaPovrs) br++;
				if(i >= columns)
					if (parcele.get(i-columns) instanceof VodenaPovrs) br++;
				if(i<=(rows*columns - columns))
					if (parcele.get(i+columns) instanceof VodenaPovrs) br++;
			}
		}
		
		return br;
	}
	
	public void zaustaviProizvodjace() {
		for(Parcela p : parcele) {
			if (p instanceof Proizvodjac) {
				((Proizvodjac) p).finish();
			}
		}
	}

}
