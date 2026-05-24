package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirUsuari extends JDialog {

    private JPanel pnlAfegirUsuari;
    private JTextField txtNom;
    private JTextField txtEmail;
    private JTextField txtAdreca;
    private JCheckBox chkEstudiant;
    private JButton btnAcceptar;
    private JButton btnCancelar;
    private final Adaptador adaptador;

    public FrmAfegirUsuari(JDialog parent, Adaptador adaptador){
        this.adaptador = adaptador;
        setTitle("Afegir usuari");
        setContentPane(pnlAfegirUsuari);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });

        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                String email = txtEmail.getText();
                String adreca = txtAdreca.getText();
                boolean esEstudiant = chkEstudiant.isSelected();

                if (nom.isEmpty() || email.isEmpty() || adreca.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmAfegirUsuari.this,
                            "Tots els camps són obligatoris");
                    return;
                }
                try {

                    adaptador.afegirUsuari(email, nom, adreca, esEstudiant);

                    JOptionPane.showMessageDialog(FrmAfegirUsuari.this,
                            "Usuari afegit correctament"
                    );
                    dispose();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(FrmAfegirUsuari.this, ex.getMessage()
                    );
                }
            }

        });
    }
}
