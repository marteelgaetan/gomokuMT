package jeu;

public class Joueur{
    private String nom;
    
    public Joueur(String nom)
    {
	this.nom=nom;
    }

    public void setNom(String nom)
    {
	this.nom=nom;
    }

    public String getNom()
    {
	return this.nom;
    }
