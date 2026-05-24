package prog2.vista;

import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioExemplars extends JDialog {
    /**
     * Atributs privats de la finestra gestio exemplars
     */
    private JPanel pnlGestioExemplars;
    private JButton btnAfegirExemplar;
    private JButton btnVisualitzarExemplars;
    private JButton btnSortir;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra de gestions d'exemplars
     */
    public FrmGestioExemplars(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Exemplars");
        setContentPane(pnlGestioExemplars);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            /**
             * El btnSortir tanca la finestra actual i torna a la finestra de gestions
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAfegirExemplar.addActionListener(new ActionListener() {
            /**
             * El btnAfegirExemplar obra la nova finestra d'afegir exemplar
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirExemplar formulari = new FrmAfegirExemplar(FrmGestioExemplars.this, adaptador);
                formulari.setVisible(true);
            }
        });
        btnVisualitzarExemplars.addActionListener(new ActionListener() {
            /**
             * El btnVisualitzarExemplars obra la nova finestra per visualitzar els exemplars
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarExemplars formulari = new FrmVisualitzarExemplars(FrmGestioExemplars.this, adaptador);
                formulari.setVisible(true);
            }
        });
    }
}
