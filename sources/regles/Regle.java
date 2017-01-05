package regles;
public class Regle{
    private int intersection = 19;
    private String IA = "";
    private String coup = "";
    
    public Regle()
    {}
    
    public void setIntersection(int nb)
    {
	this.intersection = nb;
    }

    public void setIA(String ia)
    {
	this.IA = ia;
    }

    public void setCoup(String coup)
    {
	this.coup = coup; 
    }

    public int getIntersection()
    {
	return this.intersection;
    }

    public String getIA()
    {
	return this.IA;
    }

    public String getCoup()
    {
	return this.coup;
    }
}
