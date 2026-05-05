package prog2.model;

import prog2.vista.BiblioException;

import java.util.Date;

public abstract class Prestec implements InPrestec{

    private Exemplar exemplar;
    private Usuari usuari;
    private Date DataCreacio, DataLimitRetorn;
    private Boolean retornat;

    public Prestec (Exemplar exemplar, Usuari usuari, Date DataCreacio){
        this.exemplar= exemplar;
        this.usuari = usuari;
        this.DataCreacio = DataCreacio;
        DataLimitRetorn = new Date(DataCreacio.getTime() + duradaPrestec());

        retornat = true;
    }

    @Override
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public Exemplar getExemplar() {
        return exemplar;
    }


    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public Usuari getUsuari() {return usuari;}


    @Override
    public void setDataCreacio(Date data) {
        this.DataCreacio = data;
    }

    @Override
    public Date getDataCreacio() {
        return DataCreacio;
    }


    @Override
    public void setDataLimitRetorn(Date data) {
        this.DataLimitRetorn = data;
    }

    @Override
    public Date getDataLimitRetorn() {return DataLimitRetorn;}


    @Override
    public void setRetornat(boolean retornat) {this.retornat = retornat;}

    @Override
    public boolean getRetornat() {
        return retornat;
    }



    @Override
    public abstract String tipusPrestec() ;

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public abstract long duradaPrestec();



    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna() throws BiblioException {

    }


    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        if (retornat) return false;
        Date ahora = new Date();
        return ahora.after(DataLimitRetorn);
    }

    public String toString(){
        return "Tipus="+tipusPrestec()+", Exemplar="+exemplar+", Usuari="+usuari+", Data de creacio="+DataCreacio+", " +
                "Data límit retorn="+DataLimitRetorn+", Retornat="+retornat;
    }
}
