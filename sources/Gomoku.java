import javax.swing.*;
import gui.*;
public class Gomoku extends JFrame {
    
    
    public static void main(String[] arg){
	Gomoku gomoku = new Gomoku();
	gomoku.setVisible(true);
    }

    private Plateau  plateau;

    public Gomoku(){
	super("GomokuMT");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	plateau = new Plateau();
    }
}
