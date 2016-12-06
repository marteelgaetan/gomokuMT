package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plateau extends JPanel{
    private int pions[][];
    private int tourDeJeu;

    public Plateau(){
       	pions = new int[11][11];
	tourDeJeu = 1;
	this.addMouseListener(new PlateauListener());
	for(int i = 0; i < 11; i++){
	    for(int j = 0;j < 11; j++){
		pions[i][j] = 0;
	    }
	}
    }

    public boolean plein(){
        for(int i = 0; i < 11; i++){
	    for(int j = 0;j < 11; j++){
		if(pions[i][j] == 0){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean vide(){
	for(int i = 0; i < 11; i++){
	    for(int j = 0;j < 11; j++){
		if(pions[i][j] != 0){
		    return false;
		}
	    }
	}
	return true;
    }

    public void gagner(int x, int y){
	for(int i = 0; i < 11; i++){
	    for(int j = 0;j < 11; j++){
		if(verificationHorizontale() || verificationVerticale() || verificationDiagB() || verificationDiagH()){
		    return true;		    
		}
	    }
	}
	return false;
    }

    public boolean verificationHorizontale(int x, int y){
	for(int i = x; i < 11; i++){
	    if(pions[x][y] == pions[x+][y]){
	    }
	}
	if(pions[x][y])
    }
    
    public void paint(Graphics g){

	int marge = 30;
	
	for(int i = 0; i < 10; i++){
	    for(int j = 0;j < 10; j++){
		g.drawRect(marge+i*40,marge+j*40,40,40);
	    }
	}

	JPanel pnlButton = new JPanel();
	
        for(int i = 0; i < 11; i++){
	    for(int j = 0;j < 11; j++){
		if(pions[i][j]==1){
		    g.setColor(Color.BLACK);
		    g.fillOval(marge-15+i*40,marge-15+j*40,30,30);
		}
		if(pions[i][j]==2){
		    g.setColor(Color.WHITE);
		    g.fillOval(marge-15+i*40,marge-15+j*40,30,30);
		}
	    }
	}
    }

    class PlateauListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e){
	    double getx = Math.round(e.getX()-30.0)/40.0;
	    double gety = Math.round(e.getY()-30.0)/40.0;	    
	    int x = (int) Math.round(getx);
	    int y = (int) Math.round(gety);
	    System.out.println("getX = " + x + " getY = " + y +" \n");
	    if(pions[x][y]==0){
		if(tourDeJeu%2==1){
		    pions[x][y] = 1;
		}
		else{
		    pions[x][y] = 2;
		}
		tourDeJeu++;
	    }
	    repaint();
	    if(plein()){
		System.out.println("Egalite");
	    }
	}
    }

    public static void main(String[] a){
	JFrame frame = new JFrame();
	frame.getContentPane().add(new Plateau());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setBackground(Color.ORANGE); 
    }
}
