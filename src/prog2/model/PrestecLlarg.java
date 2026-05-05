package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec{

    /**
     * Constructor de PrestecLlarg
     */
    public PrestecLlarg(Exemplar exemplar, Usuari usuari, Date dataCreacio) {
        super(exemplar, usuari, dataCreacio);
    }

    /**
     * @return el tipus de prestec: llarg
     */
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    /**
     * @return durada prestec. La durada del prestec depen del tipus de prestec: llarg 14 dies
     */
    @Override
    public long duradaPrestec() {return 140_000L;}
}
