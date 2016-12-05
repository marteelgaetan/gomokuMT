package gui;
import java.awt.*;
import java.applet.Applet;

public class Grille extends Applet {
    public void init(int x, int y) {
	this.setLayout(new GridLayout(x,y));
	for(int i=0; i<x; i++){
	    for(int j=0; j<y; j++){
		this.add(new Bouton());
	    }
	}
    }
 }
