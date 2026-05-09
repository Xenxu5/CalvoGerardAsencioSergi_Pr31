package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {
    /**
     * Afegir element a la llista. Afegeix un usuari a la llista
     * Si aquest ja es troba en ella, es llença excepció
     *
     * @param usuari
     */
    @Override
    public void afegir(Usuari usuari) throws BiblioException {
        // Si ja està, llencem excepció
        if (contains(usuari.getEmail())) {
            throw new BiblioException("Aquest usuari ja es troba a la llista");
        }
        // Si no està, l'afegim
        super.afegir(usuari);
    }

    public boolean contains(String email) {
        Iterator<Usuari> it = llista.iterator();

        while (it.hasNext()) {
            Usuari usuari = it.next();
            if (usuari.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
