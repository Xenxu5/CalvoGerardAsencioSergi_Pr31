package prog2.vista;

import prog2.adaptador.Adaptador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioExemplars extends JDialog {
    private JPanel pnlGestioExemplars;
    private JButton btnAfegirExemplar;
    private JButton btnVisualitzarExemplars;
    private JButton btnSortir;
    private final Adaptador adaptador;

    public FrmGestioExemplars(JDialog parent, Adaptador adaptador) {
        this.adaptador = adaptador;
        setTitle("Exemplars");
        setContentPane(pnlGestioExemplars);
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
        btnAfegirExemplar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
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
             * Invoked when an action occurs.
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
