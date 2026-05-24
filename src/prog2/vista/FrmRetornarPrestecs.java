package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmRetornarPrestecs extends JDialog {
    /**
     * Atributs de la finestra que retorna els préstecs
     */
    private JPanel pnlRetornarPrestecs;
    private JComboBox cmbPrestecs;
    private JButton btnAcceptar;
    private JButton btnCancelar;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra de retorn dels préstecs
     */
    public FrmRetornarPrestecs(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Retornar Préstec");
        setContentPane(pnlRetornarPrestecs);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setModal(true);

        // Omplim el combo box amb els préstecs
        int index = 1;
        for (String prestecComplet : adaptador.recuperaPrestecs()) {
            // Tallem el text per línies
            String[] linies = prestecComplet.split("\n");

            if (linies.length > 2) {
                // Agafem la línia de l'exemplar i de l'usuari per saber quin préstec és
                String exemplar = linies[1].replace("Exemplar: ", "").trim();
                String usuari = linies[2].replace("Usuari: ", "").trim();

                // Ho afegim de forma visual: "1 - hunter x hunter (Gerard)"
                cmbPrestecs.addItem(index + " - " + exemplar + " (" + usuari + ")");
            } else {
                cmbPrestecs.addItem("Préstec " + index);
            }
            index++;
        }
        btnCancelar.addActionListener(new ActionListener() {
            /**
             * Listener per tancar la finestra actual i tornar a les gestions dels préstecs
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAcceptar.addActionListener(new ActionListener() {
            /**
             * Guarda i retorna el préstec que s'ha seleccionat
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agafem la posició exacta del desplegable
                int posicioPrestec = cmbPrestecs.getSelectedIndex();

                if (posicioPrestec == -1) {
                    JOptionPane.showMessageDialog(FrmRetornarPrestecs.this,
                            "No hi ha cap préstec seleccionat.",
                            "Avís", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    // Cridem al mètode de l'adaptador passant-li l'índex
                    adaptador.retornarPrestec(posicioPrestec);

                    JOptionPane.showMessageDialog(FrmRetornarPrestecs.this,
                            "Préstec retornat correctament");
                    dispose(); // Tanquem la finestra

                } catch (Exception ex) {
                    // Si el préstec ja estava retornat
                    JOptionPane.showMessageDialog(FrmRetornarPrestecs.this,
                            ex.getMessage(),
                            "Error al retornar",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
