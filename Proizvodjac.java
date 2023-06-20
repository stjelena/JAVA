package parcele;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {
	
	protected int vreme;
	protected Baterija baterija;
	protected Thread thread;
	protected boolean uspesno = false;
	private boolean work = false;
	

	public Proizvodjac(String o, Color c, int vreme, Baterija bat) {
		super(o, c);

		this.vreme = vreme;
		this.baterija = bat;
	}
	
	public int ukVremeProizvodnje() {
		Random rand = new Random(); 
	    int int_random = rand.nextInt(300);
	    
	    return vreme + int_random;
	}
	
	public synchronized void finish() {
		if(thread != null) {
			if (thread.isInterrupted() == false) {
				thread.interrupt();
				thread = null;
				work = false;
			}
		}
	}
	
	public abstract void proizvedi();

	@Override
	public void run() {
		
		while(work) {
			uspesno = false;
			setForeground(Color.WHITE);
	    	revalidate();
			try {
				thread.sleep(ukVremeProizvodnje());
				
				proizvedi();
			    
			    if(uspesno) {
			    	setForeground(Color.RED);
			    	revalidate();
			    }
			    else break;
			    
			    thread.sleep(300);
			    
			} catch (InterruptedException e) {}
		}
		
	}
	
	public void go() {
		thread = new Thread(this);
		work = true;
		thread.start();
		//notify();
	}

}
