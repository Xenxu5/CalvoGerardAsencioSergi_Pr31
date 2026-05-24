package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioPrestecs extends JDialog {
    /**
     * Atributs de la finestra de gestió de préstecs
     */
    private JPanel pnlGestioPrestecs;
    private JButton btnAfegirPrestec;
    private JButton btnVisualitzarPrestecs;
    private JButton btnRetornarPrestecs;
    private JButton btnSortir;
    private final Adaptador adaptador;

    /**
     * Constructor de la finestra de gestions de préstecs
     */
    public FrmGestioPrestecs(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Préstecs");
        setContentPane(pnlGestioPrestecs);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            /**
             * Tanca la finestra actual i torna a la de gestions
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAfegirPrestec.addActionListener(new ActionListener() {
            /**
             * Obre la finestra d'afegir préstecs
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirPrestec formulari = new FrmAfegirPrestec(FrmGestioPrestecs.this, adaptador);
                formulari.setVisible(true);
            }
        });
        btnVisualitzarPrestecs.addActionListener(new ActionListener() {
            /**
             * Obre la finestra de visualitzar préstecs
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarPrestecs formulari = new FrmVisualitzarPrestecs(FrmGestioPrestecs.this, adaptador);
                formulari.setVisible(true);
            }
        });
        btnRetornarPrestecs.addActionListener(new ActionListener() {
            /**
             * Obre la finestra de retornar préstecs
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmRetornarPrestecs formulari = new FrmRetornarPrestecs(FrmGestioPrestecs.this, adaptador);
                formulari.setVisible(true);
            }
        });
    }
}
