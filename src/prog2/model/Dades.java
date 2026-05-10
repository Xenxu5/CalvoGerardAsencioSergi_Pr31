package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades{

    /**
     * Atributs privats de Dades
     */
    private LlistaExemplars exemplars;
    private LlistaUsuaris usuaris;
    private LlistaPrestecs prestecs;

    /**
     * Cosntructor de Dades
     */
    public Dades() {
        exemplars = new LlistaExemplars();
        usuaris = new LlistaUsuaris();
        prestecs = new LlistaPrestecs();
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
        // Generem l'objecte exemplar
        Exemplar nouExemplar = new Exemplar(id, titol, autor, admetPrestecLlarg);

        // Cridem al mètode afegir de la classe LlistaExemplars, ja que ell mateix controla duplicats i llença excepció
        exemplars.afegir(nouExemplar);
    }

    /**
     * Recuperar exemplars. Retorna un ArrayList amb tots els exemplars
     */
    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        // Volem una còpia en format ArrayList del contingut de la llista
        return exemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant paràmetre per poder saber si és estudiant o professor
     */
    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        // Declarem l'objecte
        Usuari nouUsuari;

        // Generem l'objecte comprovant si és estudiant o professor
        if (esEstudiant) {
            nouUsuari = new Estudiant(email, nom, adreca);
        } else {
            nouUsuari = new Professor(email, nom, adreca);
        }

        // Cridem al mètode de LlistaUsuaris (aquest mètode ja comprova les excepcions)
        usuaris.afegir(nouUsuari);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return usuaris.getArrayList(); // Donem una còpia de la llista
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     *
     * @param exemplarPos Posició de l'exemplar
     * @param usuariPos Posició de l'usuari
     * @param esLlarg
     */
    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {

        // Obtenim els objectes a partir de la posició
        Exemplar e = exemplars.getAt(exemplarPos);
        Usuari u = usuaris.getAt(usuariPos);

        // Condició 1: Exemplar no disponible
        if (!e.isDisponible()) {
            throw new BiblioException("L'exemplar sol·licitat no està disponible.");
        }

        // Condició 2: Usuari amb préstecs endarrerits

        Iterator<Prestec> it = prestecs.getArrayList().iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            if (!p.getRetornat() && p.getUsuari().equals(u) && p.prestecEndarrerit()) {
                throw new BiblioException("L'usuari té préstecs endarrerits actius i no pot demanar-ne de nous.");
            }
        }

        // Condició 3: Exemplar que no admet préstecs llargs
        if (esLlarg && !e.getAdmetPrestecLlarg()) {
            throw new BiblioException("Aquest exemplar no admet préstecs de llarg termini.");
        }

        // Condició 4: Límit de préstecs superat
        if (esLlarg) {
            if (u.getNumPrestecsLlargs() >= u.getMaxPrestecsLlargs()) {
                throw new BiblioException("L'usuari ha superat el seu límit de préstecs llargs.");
            }
        } else {
            if (u.getNumPrestecsNormals() >= u.getMaxPrestecsNormals()) {
                throw new BiblioException("L'usuari ha superat el seu límit de préstecs normals.");
            }
        }

        // Si arribem aquí, el prestec és correcte i l'afegim
        Prestec nouPrestec;
        if (esLlarg) {
            nouPrestec = new PrestecLlarg(e, u, new Date());
            u.setNumPrestecsLlargs(u.getNumPrestecsLlargs() + 1); // L'usuari gasta un dels seus prestecs disponibles
        } else {
            nouPrestec = new PrestecNormal(e, u, new Date());
            u.setNumPrestecsNormals(u.getNumPrestecsNormals() + 1); // L'usuari gasta un dels seus prestecs disponibles
        }

        // Marquem l'exemplar com a no disponible
        e.setDisponible(false);

        // L'afegim a la llista
        prestecs.afegir(nouPrestec);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es vaig retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {
        // Utilitzem getAt ja que no és un ArrayList i necessitem aquest mètode com a pont
        Prestec p = prestecs.getAt(position);

        // Cridem al mètode retorna, ja que aquest controla si ja està retornat i, si no, el retorna correctament.
        p.retorna();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return prestecs.getArrayList(); // Donem una copia
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        // Fem un ArrayList on guardarem els préstecs no retornats
        ArrayList<Prestec> resultat = new ArrayList<>();
        Iterator<Prestec> it = prestecs.getArrayList().iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            // Si el préstec no està retornat, l'afegim a la llista de resultats
            if (!p.getRetornat()) {
                resultat.add(p);
            }
        }
        return resultat;
    }
}
