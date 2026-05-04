package prog2.model;

public abstract class Usuari implements InUsuari{

    private String email, nom, adreca;
    private int numPrestecsNormals, numPrestecsLlargs;

    public Usuari(String email, String nom, String adreca){
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        numPrestecsLlargs = 0;
        numPrestecsNormals = 0;
    }


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
    public abstract String tipusUsuari();

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.numPrestecsLlargs = numPrestecstLlargs;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }

    @Override
    public abstract int getMaxPrestecsNormals() ;

    @Override
    public abstract int getMaxPrestecsLlargs();

    public String toString(){
        return "Tipus="+tipusUsuari()+", Email="+ email +", Nom="+nom+", Adreca="+adreca+", " +
                "Num. prestecs normals="+ numPrestecsNormals +", Num. prestecs llargs="+ numPrestecsLlargs;
    }
}
