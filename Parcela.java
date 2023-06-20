package parcele;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcela extends Label {
	
	protected String oznaka;
	protected Color boja;
	private Font font;
	Plac plac;
	int index;
	
	public Parcela(String o, Color c) {
		oznaka = o;
		boja = c;
		
		setText(oznaka);
		setBackground(boja);
		setAlignment(Label.CENTER);
		
		setForeground(Color.WHITE);
		font = new Font("Serif",Font.BOLD,14);
		setFont(font);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Parcela source = (Parcela)e.getSource();
				plac.izaberiParcelu(source);
			}
		});
		
	}
	
	public void promeniBoju(Color novaBoja) {
		boja = novaBoja;
		setBackground(novaBoja);
		revalidate();
	}

	public void ponisti() {
		
		font = new Font("Serif",Font.BOLD,14);
		setFont(font);
		revalidate();
		
	}

	public void izaberi() {
		font = new Font("Serif",Font.BOLD,20);
		setFont(font);
		revalidate();
		
	}
	
	public void updateIndex(int i) {
		index = i;
		
	}
	
	

}
