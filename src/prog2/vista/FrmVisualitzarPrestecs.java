package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVisualitzarPrestecs extends JDialog{
    /**
     * Atributs de la finestra de visualització dels préstecs
     */
    private JPanel pnlVisualitzarPrestecs;
    private JCheckBox chkNoRetornats;
    private JList lstPrestecs;
    private JButton btnSortir;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra per visualitzar els préstecs
     */
    public FrmVisualitzarPrestecs(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Visualitzar Préstecs");
        setContentPane(pnlVisualitzarPrestecs);
        setSize(400, 700);
        setLocationRelativeTo(parent);
        setModal(true);
        // Cridem al mètode per mostrar els préstecs
        visualitzarPrestecs();

        btnSortir.addActionListener(new ActionListener() {
            /**
             * Listener que tanca la subfinestra quan es prem el botó "Sortir" i torna a la finestra de gestions de préstecs
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        chkNoRetornats.addActionListener(new ActionListener() {
            /**
             * Listener que actualitza la llista si se selecciona el check box
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                visualitzarPrestecs();
            }
        });
    }

    /**
     * Mètode que permet mostrar els préstecs
     */
    private void visualitzarPrestecs() {

        DefaultListModel<String> model = new DefaultListModel<>();
        boolean nomesNoRetornats = chkNoRetornats.isSelected();
        int contadorPrestecs = 0;

        model.addElement("===== LLISTA DE PRÉSTECS =====");
        model.addElement("");

        for (String prestec : adaptador.recuperaPrestecs()) {

            // Comprovem si el préstec NO està retornat
            boolean esNoRetornat = prestec.contains("Retornat: false");

            // Si el filtre NO està activat, o si ho està i el préstec NO està retornat, l'afegim
            if (!nomesNoRetornats || esNoRetornat) {

                contadorPrestecs++;

                model.addElement("PRÉSTEC " + contadorPrestecs + ":");

                String[] linies = prestec.split("\n");

                for (String linia : linies) {
                    model.addElement("   " + linia);
                }

                model.addElement("----------------------");
                model.addElement("");
            }
        }

        // Si queda buida
        if (contadorPrestecs == 0) {
            model.addElement("   No hi ha cap préstec per mostrar.");
        }

        // Ho apliquem a la llista
        lstPrestecs.setModel(model);
    }
}
