package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gesAfegirUsu extends JDialog {

    private JPanel afegusu;
    private JTextField textNom;
    private JTextField textEmail;
    private JTextField textAdreca;
    private JCheckBox siCheckBox;
    private JButton acceptarButton;
    private JButton cancelarButton;
    private Adaptador adaptador;

    public gesAfegirUsu(JDialog parent, Adaptador adaptador){
        this.adaptador = adaptador;
        setTitle("Afegir usuari");
        setContentPane(afegusu);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });

        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textNom.getText();
                String email = textEmail.getText();
                String adreca = textAdreca.getText();
                boolean esEstudiant = siCheckBox.isSelected();

                if (nom.isEmpty() || email.isEmpty() || adreca.isEmpty()) {
                    JOptionPane.showMessageDialog(gesAfegirUsu.this,
                            "Tots els camps són obligatoris");
                    return;
                }
                try {

                    adaptador.afegirUsuari(email, nom, adreca, esEstudiant);

                    JOptionPane.showMessageDialog(gesAfegirUsu.this,
                            "Usuari afegit correctament"
                    );
                    dispose();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(gesAfegirUsu.this, ex.getMessage()
                    );
                }
            }

        });
    }
}
