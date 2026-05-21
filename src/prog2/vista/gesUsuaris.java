package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gesUsuaris extends JDialog {
    private JPanel usu;
    private JButton afegirUsuarisButton;
    private JButton visualitzarUsuarisButton;
    private JButton sortirButton;

    public gesUsuaris(JDialog parent) {
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
                AfegirUsu ventana = new AfegirUsu(gesUsuaris.this);
                ventana.setVisible(true);
            }
        });
    }
}
