package prog2.model;

public class Estudiant extends Usuari{

    /**
     * Constructor d'Estudiant
     */
    public Estudiant(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }

    /**
     * Retornan el nombre maxim de dias per a cada tipus de prestec
     */
    @Override
    public int getMaxPrestecsNormals(){return 2;}
    @Override
    public int getMaxPrestecsLlargs(){return 1;}

    /**
     * Retorna un string del tipus d'usuari
     */
    @Override
    public String tipusUsuari(){return "Estudiant";}
}
