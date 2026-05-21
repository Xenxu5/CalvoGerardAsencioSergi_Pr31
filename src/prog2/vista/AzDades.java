package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AzDades extends JDialog {
    private JPanel jpanel;
    private JButton guardarDadesButton;
    private JButton recuperarDadesButton;
    private JButton sortirButton;

    public AzDades(JFrame parent, Adaptador adaptador) {
        setTitle("Dades");
        setContentPane(jpanel);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setModal(true);
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        guardarDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int resultat = fileChooser.showSaveDialog(AzDades.this);

                if (resultat == JFileChooser.APPROVE_OPTION) {

                    String ruta = fileChooser.getSelectedFile().getAbsolutePath();

                    try {
                        adaptador.guardaDades(ruta);

                        JOptionPane.showMessageDialog(
                                AzDades.this,
                                "Dades guardades correctament"
                        );

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AzDades.this, ex.getMessage());
                    }
                }

            }
        });
        recuperarDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int resultat = fileChooser.showOpenDialog(AzDades.this);

                if (resultat == JFileChooser.APPROVE_OPTION) {

                    String ruta = fileChooser.getSelectedFile().getAbsolutePath();

                    try {
                        adaptador.carregaDades(ruta);

                        JOptionPane.showMessageDialog(
                                AzDades.this,
                                "Dades carregades correctament"
                        );

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AzDades.this, ex.getMessage());
                    }
                }

            }
        });
    }

}
