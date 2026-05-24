package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirUsuari extends JDialog {

    /**
     * Atributs privats de la finestra per afegir usuari
     */
    private JPanel pnlAfegirUsuari;
    private JTextField txtNom;
    private JTextField txtEmail;
    private JTextField txtAdreca;
    private JCheckBox chkEstudiant;
    private JButton btnAcceptar;
    private JButton btnCancelar;
    private final Adaptador adaptador;
    /**
     * Constructor de la finestra per afegir usuari
     */
    public FrmAfegirUsuari(JDialog parent, Adaptador adaptador){
        this.adaptador = adaptador;
        setTitle("Afegir usuari");
        setContentPane(pnlAfegirUsuari);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        /**
         * El btnSortir tanca la finestra de dades i torna a la finestra de gestions d'usuaris
         */
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
        /**
         * El btnAcceptar guarda tota l'informació que s'ha introduit de l'usuari
         */
        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                String email = txtEmail.getText();
                String adreca = txtAdreca.getText();
                boolean esEstudiant = chkEstudiant.isSelected();
                // Si a l'hora de guardar l'informació falta un parametre salta un misatge
                if (nom.isEmpty() || email.isEmpty() || adreca.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmAfegirUsuari.this,
                            "Tots els camps són obligatoris");
                    return;
                }
                //Si tot esta ple afegeix l'usuari o salta una excepció (Si l'usuari ja existeix)
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
