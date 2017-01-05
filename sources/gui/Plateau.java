package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import regles.*;

public class Plateau extends JPanel{
    private int pions[][];
    private int tourDeJeu;
    private Regle regle = new Regle();
    private int inter = regle.getIntersection();
    
    public Plateau(){
       	pions = new int[inter][inter];
	tourDeJeu = 1;
	this.addMouseListener(new PlateauListener());
	for(int i = 0; i < inter; i++){
	    for(int j = 0;j <inter; j++){
		pions[i][j] = 0;
	    }
	}
    }

    public boolean plein(){
        for(int i = 0; i < inter; i++){
	    for(int j = 0;j < inter; j++){
		if(pions[i][j] == 0){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean vide(){
	for(int i = 0; i < inter; i++){
	    for(int j = 0;j < inter; j++){
		if(pions[i][j] != 0){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean gagner(){
	for(int i = 0; i < inter; i++){
	    for(int j = 0;j <inter; j++){
		if(verificationHorizontale() || verificationVerticale() || verificationDiagB() || verificationDiagH()){
		    System.out.println("Win");
		    return true;		    
		}
	    }
	}
	return false;
    }

    public boolean verificationHorizontale(){
	int count = 0;
	boolean isWinner = false;

	for (int row = 0; row < pions.length; row++) {
	    for (int column = 0; column < pions[row].length; column++) {
		if (pions[column][row] != 0)
		    count++;
		else if(count == 5){
		    isWinner = true;
		    break;
		}
		else{
		    isWinner = false;
		    count = 0;
		}
	    }
	    if(isWinner){
		break;
	    }
	}
	return isWinner;
    }


     public boolean verificationDiagB() {
	int count = 0;
	int dec = 0;
	boolean isWinner = false;

	for (int row = 0; row < pions.length; row++) {
	    for (int column = 0; column < pions[row].length; column++) {
		for(int d = 0; d < pions.length; d++){
		    for (int de = 0; de < pions.length; de ++){
			if(column-de > 0 && row-de > 0){
			    if(pions[row-de][column-de] != 0){
				dec++;
			    }
			    else{
				break;
			    }
			}
		    }
		    if(column+d-dec < pions.length && row+d-dec < pions.length){
			if(pions[row+d-dec][column+d-dec] != 0 && count < pions.length){
			    count++;
			}
			else{
			    if(count > 5){
				isWinner = false;
			    }
			    count = 0;
			}
			if(count == 5){
			    isWinner = true;
			}
			if(count > 5){
			    isWinner = false;
			}
		    }
		    dec = 0;
		}
		if(isWinner){
		    return true;
		}
		else{
		    count = 0;
		}
	    }
	}
	return false;
     }

    public boolean verificationVerticale() {
	int count = 0;
	boolean isWinner = false;

	for (int row = 0; row < pions.length; row++) {
	    for (int column = 0; column < pions[row].length; column++) {
		if (pions[row][column] != 0 && count < 5)
		    count++;
		else if(count == 5){
		    isWinner = true;
		    break;
		}
		else{
		    isWinner = false;
		    count = 0;
		}
	    }
	    if(isWinner){
		break;
	    }
	}
	return isWinner;
    }

     public boolean verificationDiagH() {
	int count = 0;
	int dec = 0;
	boolean isWinner = false;

	for (int row = 0; row < pions.length; row++) {
	    for (int column = 0; column < pions.length; column++) {
		for(int d = 0; d < pions.length; d++){
		    for (int de = 0; de < pions.length; de ++){
			if(column+de < pions.length && row-de > 0){
			    if(pions[row-de][column+de] != 0){
				dec++;
			    }
			    else{
				break;
			    }
			}
		    }
		    //System.out.println(" dec : " + dec);
		    if(column+d-dec < pions.length && row-d-dec > 0){
			if(pions[row-d-dec][column+d+dec] != 0 && count < pions.length){
			    count++;
			}
			else{
			    if(count > 5){
				isWinner = false;
			    }
			    count = 0;
			}
			if(count == 5){
			    isWinner = true;
			}
			if(count > 5){
			    isWinner = false;
			}
		    }
		    dec = 0;
		}
		if(isWinner){
		    return true;
		}
		else{
		    count = 0;
		}
	    }
	}
	return false;
     }
    
    public void paint(Graphics g){

	int marge = 30;
	
	for(int i = 1; i < inter; i++){
	    for(int j = 1;j < inter; j++){
		g.drawRect(marge+i*40,marge+j*40,40,40);
	    }
	}

	JPanel pnlButton = new JPanel();
	
        for(int i = 0; i < inter; i++){
	    for(int j = 0;j < inter; j++){
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
		    gagner();
		}
		else{
		    pions[x][y] = 2;
		    gagner();
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
	frame.setSize(900,900);
	frame.setVisible(true);
	frame.setBackground(Color.ORANGE); 
	}
}
