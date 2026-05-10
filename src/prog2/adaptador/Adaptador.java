package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
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
     * Mètode que s'encarrega de guardar les dades de l'actual versió del programa
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

    public void carregaDades(String camiOrigen) throws BiblioException {
        try {
            // Obrim el canal d'entrada des del fitxer
            FileInputStream fis = new FileInputStream(camiOrigen);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Carreguem l'objecte i sobreescrivim les dades actuals
            this.dades = (Dades) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BiblioException("Error al carregar les dades del fitxer: " + e.getMessage());
        }
    }

    // =========================================================
    // 2. MÈTODES TRADUCTORS (De Model a Vista)
    // =========================================================

    /**
     * Exemple de servei que demana el PDF: converteix Llista d'Exemplars a Llista de Strings
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

        // 4. Retornem la llista "neta" a la Vista
        return llistaStrings;
    }

    // Mètodes per afegir (actuen com a pont directe cap a dades)
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }
}
}
