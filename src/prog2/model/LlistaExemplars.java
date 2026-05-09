package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param o
     */
    @Override
    public void afegir(Exemplar o) throws BiblioException {
        Iterator<Exemplar> it = llista.iterator();
        while (it.hasNext()) {
            Exemplar ex = it.next();

            if (ex.getId().equals(o.getId())) {
                throw new BiblioException("Id duplicat");
            }
        }
        llista.add(o);
    }

    public boolean contains(String id) {

        Iterator<Exemplar> it = llista.iterator();
        while (it.hasNext()) {
            Exemplar e = it.next();
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


}
