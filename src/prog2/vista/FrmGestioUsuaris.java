package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioUsuaris extends JDialog {
    private JPanel pnlGestioUsuaris;
    private JButton btnAfegirUsuari;
    private JButton btnVisualitzarUsuaris;
    private JButton btnSortir;
    private final Adaptador adaptador;

    public FrmGestioUsuaris(JDialog parent, Adaptador adaptador) {
        this.adaptador =adaptador;
        setTitle("Usuaris");
        setContentPane(pnlGestioUsuaris);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnAfegirUsuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari ventana = new FrmAfegirUsuari(FrmGestioUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
        btnVisualitzarUsuaris.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FrmVisualitzarUsuaris ventana = new FrmVisualitzarUsuaris(FrmGestioUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }
}
