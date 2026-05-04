package prog2.model;

import java.util.Date;

public abstract class Prestec implements InPrestec{

    private Exemplar exemplar;
    private Usuari usuari;
    private Date DataCreacio, DataLimitRetorn;
    private Boolean retornat;

    public Prestec (Exemplar exemplar, Usuari usuari, Date dataCreacio){
        this.exemplar= exemplar;
        this.usuari = usuari;
        this.DataCreacio = DataCreacio;
        DataLimitRetorn = DataLimitRetorn;
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
    public Usuari getUsuari() {
        return usuari;
    }

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
    public abstract String tipusPrestec() ;


    @Override
    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    @Override
    public boolean getRetornat() {
        return retornat;
    }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna()  {

    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public long duradaPrestec() {
        return 0;
    }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        return false;
    }

    public String toString(){
        return "";
    }
}
