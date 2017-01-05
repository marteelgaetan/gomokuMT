import javax.swing.*;
import gui.*;
import jeu.*;
import regles.*;
public class Gomoku extends JFrame {
    
    
    public static void main(String[] arg){
	Gomoku gomoku = new Gomoku();
	gomoku.setVisible(true);
    }

    private Plateau  plateau;
    private Regle regle = new Regle();
    private int inter = regle.getIntersection();

    public Gomoku(){
	super("GomokuMT");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Plateau plateau = new Plateau();
	this.add(plateau);
    }
}
