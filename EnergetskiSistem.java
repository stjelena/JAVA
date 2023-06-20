package parcele;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {
	
	private int rows, columns;
	private Plac plac;
	private Baterija baterija;
	private Panel buttonPanel = new Panel();
	private Button dodaj;
	
	
	public EnergetskiSistem(int rows, int columns, int kap) {
		this.rows = rows;
		this.columns = columns;
		baterija = new Baterija();
		baterija.kap = kap;
		
		plac = new Plac(rows, columns);
		plac.baterija = baterija;
		
		setBounds(700, 200, 500, 500);
		
		setTitle("Energetski sistem");
		
		setResizable(false);
		
		populateWindow();
		//pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				plac.zaustaviProizvodjace();
				dispose();
			}
		});
		
		setVisible(true);
		
	}

	private void populateWindow() {
		
		dodaj = new Button("Dodaj");
		buttonPanel.add(dodaj);
		
		dodaj.addActionListener((ae) -> {
			plac.dodajProizvodjaca();
		});
		
		add(buttonPanel, BorderLayout.NORTH);
		add(plac, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new EnergetskiSistem(5, 5, 100);
	}

}
