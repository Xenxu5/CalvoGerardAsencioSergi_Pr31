package prog2.model;

import java.util.Date;

public class PrestecNormal extends Prestec{

    /**
     * Atribut estatic
     */
    private static final long Duracio = 70 * 1000L; // Duració d'un prestem normal en aquesta pràctica (70 segons)

    /**
     * Constructor de PrestecNormal
     */
    public PrestecNormal(Exemplar exemplar, Usuari usuari, Date dataCreacio) {
        super(exemplar, usuari, dataCreacio);
    }

    /**
     * @return el tipus de prestec: normal
     */
    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    /**
     * @return durada prestec. La durada del prestec depen del tipus de prestec: normal 7 dies
     */
    @Override
    public long duradaPrestec(){
        return Duracio;
    }
}
