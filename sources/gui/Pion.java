package gui;
import java.awt.*; 
import javax.swing.*;

public class Pion{
    private int x;
    private int y;
    private Color coul;
    
    public Pion(int x, int y, Color coul){
	this.x = x;
	this.y = y;
	this.coul = coul;
    }

    public int getX(){
	return this.x;
    }

    public int getY(){
	return this.y;
    }

    public Color getColor(){
	return this.coul;
    }

    public void setX(int x){
	this.x = x;
    }

    public void setY(int y){
	this.y = y;
    }

    public void setCouleur(Color coul){
	this.coul = coul;
    }
}
