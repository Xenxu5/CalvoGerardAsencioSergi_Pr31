package prog2.model;

public class Estudiant extends Usuari{

    public Estudiant(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }
    @Override
    public int getMaxPrestecsNormals(){return 2;}
    @Override
    public int getMaxPrestecsLlargs(){return 1;}
    @Override
    public String tipusUsuari(){return "Estudiant";}
}
