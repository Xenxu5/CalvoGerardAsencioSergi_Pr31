package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestions extends JDialog {

    private JPanel pnlGestions;
    private JButton btnUsuaris;
    private JButton btnExemplars;
    private JButton btnPrestecs;
    private JButton btnSortir;
    private final Adaptador adaptador;

    public FrmGestions(JFrame parent, Adaptador adaptador) {

        this.adaptador = adaptador;
        setTitle("Gestions");
        setContentPane(pnlGestions);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioUsuaris formulari = new FrmGestioUsuaris(FrmGestions.this, adaptador);
                formulari.setVisible(true);
            }
        });
        btnExemplars.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioExemplars formulari = new FrmGestioExemplars(FrmGestions.this, adaptador);
                formulari.setVisible(true);
            }
        });
        btnPrestecs.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioPrestecs formulari = new FrmGestioPrestecs(FrmGestions.this, adaptador);
                formulari.setVisible(true);
            }
        });
    }

}
