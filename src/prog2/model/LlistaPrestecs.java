package prog2.model;

import java.io.Serializable;

public class LlistaPrestecs extends Llista<Prestec> implements Serializable {

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param o
     */
    @Override
    public void afegir(Prestec o) {
        llista.add(o);
    }
}
