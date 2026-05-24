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
         * El btnAcceptar guarda tota la informació que s'ha introduït de l'usuari i l'afegeix.
         * Llença error si no s'omplen tots els camps.
         */
        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                String email = txtEmail.getText();
                String adreca = txtAdreca.getText();
                boolean esEstudiant = chkEstudiant.isSelected();
                // Si a l'hora de guardar la informació falta un paràmetre salta un missatge
                if (nom.isEmpty() || email.isEmpty() || adreca.isEmpty()) {
                    JOptionPane.showMessageDialog(FrmAfegirUsuari.this,
                            "Tots els camps són obligatoris");
                    return;
                }
                //Si tot està ple afegeix l'usuari o salta una excepció (Si l'usuari ja existeix)
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
