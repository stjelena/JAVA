package parcele;

public class Baterija {
	
	private int q;
	int kap;
	
	public Baterija() {
		q = kap;
	}
	
	public void dodajQ(int e) {
		q += e;
		
		if(q > kap)
			q = kap;
	}
	
	public void isprazni() {
		q = 0;
	}
	
	public boolean puna() {
		if (q == kap) 
			return true;
		else
			return false;
	}

}
