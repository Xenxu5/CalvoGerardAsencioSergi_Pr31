package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmDades extends JDialog {
    private JPanel pnlDades;
    private JButton btnGuardarDades;
    private JButton btnRecuperarDades;
    private JButton btnSortir;

    public FrmDades(JFrame parent, Adaptador adaptador) {
        setTitle("Dades");
        setContentPane(pnlDades);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnGuardarDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int resultat = fileChooser.showSaveDialog(FrmDades.this);

                if (resultat == JFileChooser.APPROVE_OPTION) {

                    String ruta = fileChooser.getSelectedFile().getAbsolutePath();

                    try {
                        adaptador.guardaDades(ruta);

                        JOptionPane.showMessageDialog(
                                FrmDades.this,
                                "Dades guardades correctament"
                        );

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(FrmDades.this, ex.getMessage());
                    }
                }

            }
        });
        btnRecuperarDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int resultat = fileChooser.showOpenDialog(FrmDades.this);

                if (resultat == JFileChooser.APPROVE_OPTION) {

                    String ruta = fileChooser.getSelectedFile().getAbsolutePath();

                    try {
                        adaptador.carregaDades(ruta);

                        JOptionPane.showMessageDialog(
                                FrmDades.this,
                                "Dades carregades correctament"
                        );

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(FrmDades.this, ex.getMessage());
                    }
                }

            }
        });
    }

}
