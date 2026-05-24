package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVisualitzarExemplars extends JDialog {
    private JPanel pnlVisualitzarExemplars;
    private JList lstExemplars;
    private JButton btnSortir;
    private JScrollPane scroll;
    private final Adaptador adaptador;

    public FrmVisualitzarExemplars(JDialog parent, Adaptador adaptador) {

        this.adaptador = adaptador;
        setTitle("Visualitzar Exemplars");
        setContentPane(pnlVisualitzarExemplars);
        setSize(400, 700);
        setLocationRelativeTo(parent);
        setModal(true);
        // Cridem al mètode per mostrar els exemplars
        visualitzarExemplars();

        btnSortir.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }

    /**
     * Mètode que permet mostrar els exemplars en un format adequat.
     */
    private void visualitzarExemplars() {

        DefaultListModel<String> model = new DefaultListModel<>();

        int contadorExempPrestLlarg = 0;
        int contadorExemPrestNormal = 0;

        model.addElement("===== EXEMPLARS AMB PRÉSTEC LLARG =====");
        model.addElement("");

        for (String exemplar : adaptador.recuperaExemplars()) {

            if (exemplar.contains("Admet préstec llarg: true")) {

                contadorExempPrestLlarg++;

                model.addElement("EXEMPLAR LLARG " + contadorExempPrestLlarg + ":");

                String[] linies = exemplar.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }
                model.addElement("----------------------");
                model.addElement("");
            }
        }

        model.addElement("===== EXEMPLARS AMB PRÉSTEC NORMAL =====");
        model.addElement("");

        for (String exemplar : adaptador.recuperaExemplars()) {
            if (exemplar.contains("Admet préstec llarg: false")) {

                contadorExemPrestNormal++;

                model.addElement("EXEMPLAR NORMAL " + contadorExemPrestNormal + ":");

                String[] linies = exemplar.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }

                model.addElement("----------------------");
                model.addElement("");
            }
        }
        // Ho apliquem a la llista
        lstExemplars.setModel(model);
    }
}
