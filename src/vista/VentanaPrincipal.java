package vista;

import controlador.Coordinador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JButton botonPersonas, botonMascotas;
    private Coordinador coordinador;

    public VentanaPrincipal() {
        setTitle("Veterinaria JDBC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Panel de fondo
        JLabel fondoLabel = new JLabel();
        fondoLabel.setIcon(new ImageIcon("C:\\Users\\PAULA\\OneDrive - SENA\\Imágenes\\fondo.jpg"));
        fondoLabel.setBounds(10, -456, 590, 846);
        fondoLabel.setOpaque(true);
        fondoLabel.setBackground(new Color(255, 192, 203)); // temporal en lugar de imagen

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.setOpaque(false);
        panelBotones.setBounds(100, 300, 400, 50);

        botonPersonas = new JButton("Gestionar Personas");
        botonPersonas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        botonPersonas.setBackground(new Color(255, 192, 203));
        botonMascotas = new JButton("Gestionar Mascotas");
        botonMascotas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        botonMascotas.setBackground(new Color(255, 192, 203));

        botonPersonas.addActionListener(this);
        botonMascotas.addActionListener(this);

        panelBotones.add(botonPersonas);
        panelBotones.add(botonMascotas);

        // Panel en capas
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 400));
        layeredPane.add(fondoLabel, Integer.valueOf(0));
        layeredPane.add(panelBotones, Integer.valueOf(1));

        setContentPane(layeredPane);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonPersonas) {
            coordinador.mostrarVentanaPersonas();
        } else if (e.getSource() == botonMascotas) {
            coordinador.mostrarVentanaMascotas();
        }
    }
}
