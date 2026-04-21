package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.io.Serializable;
import prog2.vista.BiblioException;



public class Llista<T> implements InLlista,Serializable{
    protected ArrayList<T> llista;

    public Llista() {
        llista = new ArrayList<>();
    }

    /**
     * Retornar nombre d'elements continguts a la llista
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param o
     */
    @Override
    public void afegir(Object o) throws BiblioException {

    }

    /**
     * Esborrar element de la llista. Esborra l'element t a la llista
     *
     * @param o
     */
    @Override
    public void esborrar(Object o) {

    }

    /**
     * Retornar element de la llista a la posició position
     *
     * @param position
     */
    @Override
    public Object getAt(int position) {
        return null;
    }

    /**
     * Buidar tots el elements de la llista
     */
    @Override
    public void clear() {

    }

    /**
     * Retornar true si la llista és buida
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Retornar l'ArrayList que es fa servir dins de la classe
     */
    @Override
    public ArrayList getArrayList() {
        return null;
    }
}
