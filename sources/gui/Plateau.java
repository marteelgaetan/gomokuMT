package gui;
import java.awt.*; 
import javax.swing.*;

public class Plateau extends JFrame{
    int x;
    int y;
    

    public Plateau(int x, int y){
	this.x = x;
	this.y = y;
	JFrame fenetre = new JFrame();
        Grille g = new Grille();
	g.init(x,y);
	JPanel pan = new JPanel();
	pan.add(g);
	fenetre.setTitle("Mini Gomoku 3D Lite");
	fenetre.setSize(x*60, y*60);
	fenetre.setLocationRelativeTo(null);

	pan.setBackground(Color.ORANGE);
	pan.add(new Bouton());
	fenetre.setContentPane(g);  
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fenetre.setVisible(true);
	
    }

    public static void main(String args[]){
	Plateau p = new Plateau(8,8);
    }
}
