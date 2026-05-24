package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmVisualitzarUsuaris extends JDialog {

    /**
     * Atributs privats de la finestra de visualització d'usuaris
     */
    private JPanel pnlVisualitzarUsuaris;
    private JList lstUsuaris;
    private JButton btnSortir;
    private JScrollPane scroll; //si la llista comença a omplir la finestra apareix un scroll
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra per a visualitzar els usuaris registrats
     */
    public FrmVisualitzarUsuaris(JDialog parent, Adaptador adaptador){

        this.adaptador = adaptador;
        setTitle("Visualitzar Usuaris");
        setContentPane(pnlVisualitzarUsuaris);
        setSize(400,700);
        setLocationRelativeTo(parent);
        setModal(true);
        // Cridem al mètode per mostrar els usuaris
        visualitzarUsuaris();

        /**
         * El btnSortir tanca la finestra de dades i torna a la finestra de gestions d'usuari
         */
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Mètode que permet mostrar els usuaris en un format adequat.
     */
    private void visualitzarUsuaris() {

        DefaultListModel<String> model = new DefaultListModel<>();

        int contadorEstudiants = 0;
        int contadorProfessors = 0;

        model.addElement("===== ESTUDIANTS =====");
        model.addElement("");

        for (String usuari : adaptador.recuperaUsuaris()) {

            if (usuari.contains("Estudiant")) {

                contadorEstudiants++;

                model.addElement("ESTUDIANT " + contadorEstudiants + ":");

                String[] linies = usuari.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }
                model.addElement("----------------------");
                model.addElement("");
            }
        }

        model.addElement("===== PROFESSORS =====");
        model.addElement("");

        for (String usuari : adaptador.recuperaUsuaris()) {
            if (usuari.contains("Professor")) {

                contadorProfessors++;

                model.addElement("PROFESSOR " + contadorProfessors + ":");

                String[] linies = usuari.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }

                model.addElement("----------------------");
                model.addElement("");
            }
        }
        // Ho apliquem a la llista
        lstUsuaris.setModel(model);
    }

}
