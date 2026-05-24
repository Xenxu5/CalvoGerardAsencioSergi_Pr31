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
                FrmGestioUsuaris ventana = new FrmGestioUsuaris(FrmGestions.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }

}
