package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {
    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param o
     */
    @Override
    public void afegir(Usuari o) throws BiblioException {
        Iterator<Usuari> it = llista.iterator();

        while (it.hasNext()) {
            Usuari usuari = it.next();

            if (usuari.getEmail().equals(o.getEmail())) {
                throw new BiblioException("Email duplicat");
            }
        }
        llista.add(o);
    }

    public boolean contains(String o) {
        Iterator<Usuari> it = llista.iterator();

        while (it.hasNext()) {
            Usuari e = it.next();
            if (e.getEmail().equals(o)) {
                return true;
            }
        }
        return false;
    }

}
