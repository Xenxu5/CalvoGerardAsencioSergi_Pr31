package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {

    /**
     * Atributs privats d'usuari
     */
    private String email, nom, adreca;
    private int numPrestecsNormals, numPrestecsLlargs;

    /**
     * Constructor de Usuari
     */
    public Usuari(String email, String nom, String adreca){
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        numPrestecsLlargs = 0;
        numPrestecsNormals = 0;
    }

    /**
     * Setters i getters
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setAdreca(String adreca) {
        this.adreca =adreca;
    }
    @Override
    public String getAdreca() {
        return adreca;
    }

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }
    @Override
    public int getNumPrestecsNormals() {return numPrestecsNormals;}

    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.numPrestecsLlargs = numPrestecstLlargs;
    }
    @Override
    public int getNumPrestecsLlargs() {return numPrestecsLlargs;}

    /**
     * Metodes abstractes que depenen de les seves clases filles
     */
    @Override
    public abstract String tipusUsuari();

    @Override
    public abstract int getMaxPrestecsNormals() ;

    @Override
    public abstract int getMaxPrestecsLlargs();

    /**
     * @return un string amb l'informacio de l'Usuari
     */
    @Override
    public String toString(){
        return "Tipus="+tipusUsuari()+", Email="+ email +", Nom="+nom+", Adreca="+adreca+", " +
                "Num. prestecs normals="+ numPrestecsNormals +", Num. prestecs llargs="+ numPrestecsLlargs;
    }
}
