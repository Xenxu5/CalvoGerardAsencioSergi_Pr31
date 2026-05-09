package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades{

    /**
     * Atributs privats (arraylists) de Dades
     */
    private ArrayList<Exemplar> exemplars;
    private ArrayList<Usuari> usuaris;
    private ArrayList<Prestec> prestecs;

    /**
     * Cosntructor de Dades
     */
    public Dades() {
        exemplars = new ArrayList<>();
        usuaris = new ArrayList<>();
        prestecs = new ArrayList<>();
    }


    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     */
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {

        Iterator<Exemplar> it = exemplars.iterator();

        while (it.hasNext()) {
            Exemplar e = it.next();
            if (e.getId().equals(id)) {
                throw new BiblioException("Id duplicat");
            }
        }
        exemplars.add(new Exemplar(id, titol, autor, admetPrestecLlarg));
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return exemplars;
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {

        Iterator<Usuari> it = usuaris.iterator();

        while (it.hasNext()) {
            Usuari u = it.next();
            if (u.getEmail().equals(email)) {
                throw new BiblioException("Email duplicat");
            }
        }

        if (esEstudiant){
            usuaris.add(new Estudiant(email, nom, adreca));
        }else{
            usuaris.add(new Professor(email, nom, adreca));
        }
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return usuaris;
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     *
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     */
    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {

        Exemplar e = exemplars.get(exemplarPos);
        Usuari u = usuaris.get(usuariPos);

        // exemplar no disponible
        if (!e.isDisponible()) {
            throw new BiblioException("Exemplar no disponible");
        }

        // usuari amb prestecs endarrerits
        Iterator<Prestec> it = prestecs.iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            if (!p.getRetornat() && p.getUsuari().equals(u) && p.prestecEndarrerit()) {
                throw new BiblioException("Usuari amb prestecs endarrerits");
            }
        }

        // no es de tipus de prestec llarg
        if (esLlarg && !e.getAdmetPrestecLlarg()) {
            throw new BiblioException("No admet prestec llarg");
        }

        // limits de l'usuari (tipus de prestecs)
        if (!esLlarg && u.getNumPrestecsNormals() >= u.getMaxPrestecsNormals()) {
            throw new BiblioException("Limit normals superat");
        }

        if (esLlarg && u.getNumPrestecsLlargs() >= u.getMaxPrestecsLlargs()) {
            throw new BiblioException("Limit llargs superat");
        }

        // afegim els prestecs
        if (esLlarg) {
            prestecs.add (new PrestecLlarg(e, u, new Date()));
            u.setNumPrestecsLlargs(u.getNumPrestecsLlargs() + 1);
        } else {
            prestecs.add (new PrestecNormal(e, u, new Date()));
            u.setNumPrestecsNormals(u.getNumPrestecsNormals() + 1);
        }

    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {

        Prestec p = prestecs.get(position);
        if(p.getRetornat()){
            throw new BiblioException("Ja es va retornar");
        }
        p.retorna();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return prestecs;
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {

        ArrayList<Prestec> resultat = new ArrayList<>();
        Iterator<Prestec> it = prestecs.iterator();

        while (it.hasNext()) {
            Prestec p = it.next();

            if (!p.getRetornat()) {
                resultat.add(p);
            }
        }
        return resultat;
    }
}
