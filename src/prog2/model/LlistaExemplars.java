package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    /**
     * Afegir element a la llista. Afegeix l'element 'e' a la llista. En aquest cas, un exemplar
     *Llencem excepció si l'exemplar ja existeix en aquesta llista
     * @param e
     */
    @Override
    public void afegir(Exemplar e) throws BiblioException {
        // Utilitzem el mètode contains per simplificar
        if (contains(e.getId())) { // Si ja hi és, llencem excepció
            throw new BiblioException("Aquest exemplar ja es troba a la llista");
        }
        // Si no està, l'afegim
        super.afegir(e);
    }

    /**
     * Mètode que comprova si l'element és a la llista o no
     * @param id
     * @return
     */
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
