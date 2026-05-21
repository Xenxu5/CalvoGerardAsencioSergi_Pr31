package prog2.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBiblioUB extends JFrame{
    private JPanel panel1;
    private JButton btnDades;
    private JButton btnSortir;
    private JButton btnGestio;


    public AppBiblioUB() {
        setTitle("Biblioteca UB");
        setContentPane(panel1);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnGestio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestio ventana = new FrmGestio(AppBiblioUB.this);
                ventana.setVisible(true);

            }
        });
        btnDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmDades ventana = new FrmDades(AppBiblioUB.this);
                ventana.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new AppBiblioUB().setVisible(true);
        });
    }
}
