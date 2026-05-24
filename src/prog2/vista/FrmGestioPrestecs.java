package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioPrestecs extends JDialog {
    private JPanel pnlGestioPrestecs;
    private JButton btnAfegirPrestec;
    private JButton btnVisualitzarPrestecs;
    private JButton btnRetornarPrestecs;
    private JButton btnSortir;
    private final Adaptador adaptador;

    public FrmGestioPrestecs(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Préstecs");
        setContentPane(pnlGestioPrestecs);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        btnAfegirPrestec.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirPrestec formulari = new FrmAfegirPrestec(FrmGestioPrestecs.this, adaptador);
                formulari.setVisible(true);
            }
        });
    }
}
