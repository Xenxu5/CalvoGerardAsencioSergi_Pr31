package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gesUsuaris extends JDialog {
    private JPanel usu;
    private JButton afegirUsuarisButton;
    private JButton visualitzarUsuarisButton;
    private JButton sortirButton;
    private Adaptador adaptador;

    public gesUsuaris(JDialog parent, Adaptador adaptador) {
        this.adaptador =adaptador;
        setTitle("Usuaris");
        setContentPane(usu);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        afegirUsuarisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gesAfegirUsu ventana = new gesAfegirUsu(gesUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
        visualitzarUsuarisButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gesVisualitUsu ventana = new gesVisualitUsu(gesUsuaris.this, adaptador);
                ventana.setVisible(true);
            }
        });
    }
}
