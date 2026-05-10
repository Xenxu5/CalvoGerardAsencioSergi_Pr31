package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;

public class Adaptador {

    /**
     * Atribut
      */
    private Dades dades;

    /**
     * Constructor
     */
    public Adaptador() {
        this.dades = new Dades();
    }

    // Persistència de dades

    /**
     * Mètode que s'encarrega de guardar les dades de l'actual versió del programa en un fitxer
     * @param camiDesti
     * @throws BiblioException
     */
    public void guardaDades(String camiDesti) throws BiblioException {
        try {
            // Obrim el canal de sortida cap al fitxer
            FileOutputStream fos = new FileOutputStream(camiDesti);
            // Generem la màquina traductora que converteix en 0s i 1s l'objecte
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Guardem l'objecte 'dades' sencer (com que tot és Serializable, es guarda de cop)
            oos.writeObject(this.dades);
            oos.close();
        } catch (IOException e) {
            throw new BiblioException("Error al guardar les dades al fitxer: " + e.getMessage());
        }
    }

    /**
     * Mètode per carregar una versió del programa guardada en un fitxer
     * @param camiOrigen
     * @throws BiblioException
     */
    public void carregaDades(String camiOrigen) throws BiblioException {
        try {
            // Obrim el canal d'entrada des del fitxer
            FileInputStream fis = new FileInputStream(camiOrigen);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Carreguem l'objecte i sobreescrivim les dades actuals (Fem un cast explícit perquè sabem que és un objecte Dades)
            this.dades = (Dades) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BiblioException("Error al carregar les dades del fitxer: " + e.getMessage());
        }
    }

    // Mètodes traductors de model a vista

    // Mètodes per a les opcions de visualització
    /**
     * Mètode que converteix la llista d'exemplars a una llista de Strings
     */
    public ArrayList<String> recuperaExemplars() {
        // 1. Li demanem els objectes al model
        ArrayList<Exemplar> llistaExemplars = dades.recuperaExemplars();

        // 2. Creem una llista de Strings per a la Vista
        ArrayList<String> llistaStrings = new ArrayList<>();

        // 3. Traduïm cada objecte a String utilitzant el seu toString()
        for (Exemplar e : llistaExemplars) {
            llistaStrings.add(e.toString());
        }

        // 4. Retornem la llista neta a la Vista
        return llistaStrings;
    }

    /**
     * Mètode que converteix la llista d'usuaris a una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaUsuaris() {
        // Agafem la llista de Dades
        ArrayList<Usuari> llistaUsuaris = dades.recuperaUsuaris();

        // Generem la llista de Strings
        ArrayList<String> llistaStrings = new ArrayList<>();

        // Iterem i anem guardant cada element a la llista String
        for (Usuari u : llistaUsuaris) {
            llistaStrings.add(u.toString());
        }
        return llistaStrings;
    }

    /**
     * Mètode que converteix la llista de prestecs a una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaPrestecs() {
        // Agafem la llista de prestecs
        ArrayList<Prestec> llistaPrestecs = dades.recuperaPrestecs();

        // Generem la llista String
        ArrayList<String> llistaStrings = new ArrayList<>();

        // Iterem la llista i afegim el string de cada element a la llista String
        for (Prestec p : llistaPrestecs) {
            llistaStrings.add(p.toString());
        }
        return llistaStrings;
    }

    /**
     * Mètode que converteix la llista de prestecs no retornats a una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaPrestecsNoRetornats() {
        // Agafem la llista de prestecs no retornats
        ArrayList<Prestec> llistaPrestecsNoRetornats = dades.recuperaPrestecsNoRetornats();

        // Generem llista String
        ArrayList<String> llistaStrings = new ArrayList<>();

        // Iterem i afegim el string de cada element a llista String
        for (Prestec p : llistaPrestecsNoRetornats) {
            llistaStrings.add(p.toString());
        }
        return llistaStrings;
    }

    // Mètodes per afegir (actuen com a pont directe cap a dades)

    /**
     * Mètode que afegeix un exemplar (crida a dades i aquesta classe ho gestiona)
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     * @throws BiblioException
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Mètode que afegeix un usuari (crida a dades i aquesta classe ho gestiona)
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     * @throws BiblioException
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Mètode que afegeix un prestec (crida a dades i aquesta classe ho gestiona)
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     * @throws BiblioException
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Mètode que retorna un prestec (crida a dades i aquesta classe ho gestiona)
     * @param position
     * @throws BiblioException
     */
    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }
}
