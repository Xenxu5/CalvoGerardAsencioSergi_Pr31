package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Iterator;

public class Llista<T> implements InLlista<T>,Serializable{
    /**
     * Atribut protected de Llista
     */
    protected ArrayList<T> llista;

    /**
     * Constructor de Llista
     */
    public Llista() {
        llista = new ArrayList<>();
    }

    /**
     * Retornar nombre d'elements continguts a la llista
     */
    @Override
    public int getSize() {
        return llista.size();
    }

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param
     */
    @Override
    public void afegir(T o) throws BiblioException{
        llista.add(o);
    }

    /**
     * Esborrar element de la llista. Esborra l'element t a la llista
     *
     * @param o
     */
    @Override
    public void esborrar(T o){
        Iterator<T> it = llista.iterator();

        while (it.hasNext()) {
            if (it.next().equals(o)) {
                it.remove();
                return;
            }
        }
    }

    /**
     * Retornar element de la llista a la posició position
     *
     * @param position
     */
    @Override
    public T getAt(int position) {
        return llista.get(position);
    }

    /**
     * Buidar tots els elements de la llista
     */
    @Override
    public void clear() {llista.clear();}

    /**
     * Retornar true si la llista és buida
     */
    @Override
    public boolean isEmpty() {
        return llista.isEmpty();
    }

    /**
     * Retornar l'ArrayList que es fa servir dins de la classe
     */
    @Override
    public ArrayList<T> getArrayList() {return new ArrayList<>(llista);}
}
