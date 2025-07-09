package vista;

import controlador.Coordinador;
import modelo.PersonaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPersonas extends JFrame implements ActionListener {
    private JTextField campoDocumento, campoNombre, campoTelefono, campoDireccion;
    private JLabel advertenciaDocumento, advertenciaNombre, advertenciaTelefono, advertenciaDireccion;
    private JTextArea areaResultado;
    private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnListar, btnLimpiar;
    private Coordinador coordinador;

    public VentanaPersonas() {
        setTitle("Personas");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("fondoMascotas.jpg"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon fondo = new ImageIcon(imagenEscalada);
        JLabel fondoLabel = new JLabel(fondo);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());

        JPanel panelCampos = new JPanel(new GridLayout(8, 2, 10, 5));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Datos de la Persona"));
        panelCampos.setOpaque(false);

        campoDocumento = new JTextField();
        campoDocumento.setFont(new Font("Tahoma", Font.ITALIC, 10));
        campoNombre = new JTextField();
        campoNombre.setFont(new Font("Tahoma", Font.ITALIC, 10));
        campoTelefono = new JTextField();
        campoTelefono.setFont(new Font("Tahoma", Font.ITALIC, 10));
        campoDireccion = new JTextField();
        campoDireccion.setFont(new Font("Tahoma", Font.ITALIC, 10));

        advertenciaDocumento = new JLabel();
        advertenciaDocumento.setForeground(Color.BLACK);
        advertenciaNombre = new JLabel();
        advertenciaNombre.setForeground(Color.BLACK);
        advertenciaTelefono = new JLabel();
        advertenciaTelefono.setForeground(Color.BLACK);
        advertenciaDireccion = new JLabel();
        advertenciaDireccion.setForeground(Color.BLACK);

        JLabel label = new JLabel("Documento:");
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        panelCampos.add(label);
        panelCampos.add(campoDocumento);
        panelCampos.add(new JLabel(""));
        panelCampos.add(advertenciaDocumento);

        JLabel label_1 = new JLabel("Nombre:");
        label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        panelCampos.add(label_1);
        panelCampos.add(campoNombre);
        panelCampos.add(new JLabel(""));
        panelCampos.add(advertenciaNombre);

        JLabel label_2 = new JLabel("Teléfono:");
        label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        panelCampos.add(label_2);
        panelCampos.add(campoTelefono);
        panelCampos.add(new JLabel(""));
        panelCampos.add(advertenciaTelefono);

        JLabel label_3 = new JLabel("Dirección:");
        label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        panelCampos.add(label_3);
        panelCampos.add(campoDireccion);
        panelCampos.add(new JLabel(""));
        panelCampos.add(advertenciaDireccion);

        JPanel panelBotones = new JPanel(new GridLayout(1, 6, 5, 5));
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.ITALIC, 9));
        btnRegistrar.setBackground(new Color(255, 192, 203));
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBackground(new Color(255, 192, 203));
        btnConsultar.setFont(new Font("Tahoma", Font.ITALIC, 9));
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(255, 192, 203));
        btnActualizar.setFont(new Font("Tahoma", Font.ITALIC, 9));
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.ITALIC, 9));
        btnEliminar.setBackground(new Color(255, 192, 203));
        btnListar = new JButton("Listar");
        btnListar.setBackground(new Color(255, 192, 203));
        btnListar.setFont(new Font("Tahoma", Font.ITALIC, 9));
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Tahoma", Font.ITALIC, 10));
        btnLimpiar.setBackground(new Color(255, 192, 203));

        btnRegistrar.addActionListener(this);
        btnConsultar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnListar.addActionListener(this);
        btnLimpiar.addActionListener(this);

        panelBotones.setOpaque(false);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);
        panelBotones.add(btnLimpiar);

        areaResultado = new JTextArea();
        areaResultado.setLineWrap(true);
        areaResultado.setFont(new Font("Monospaced", Font.BOLD, 16));
        areaResultado.setBackground(new Color(255, 192, 203));
        areaResultado.setEditable(false);
        areaResultado.setOpaque(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        panelCampos.setBounds(30, 10, 430, 220);
        panelBotones.setBounds(30, 240, 430, 50);
        scroll.setBounds(30, 300, 430, 140);
        fondoLabel.setBounds(0, 0, 500, 500);

        layeredPane.add(fondoLabel, new Integer(0));
        layeredPane.add(panelCampos, new Integer(1));
        layeredPane.add(panelBotones, new Integer(1));
        layeredPane.add(scroll, new Integer(1));

        setContentPane(layeredPane);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    private void limpiarCampos() {
        campoDocumento.setText("");
        campoNombre.setText("");
        campoTelefono.setText("");
        campoDireccion.setText("");

        advertenciaDocumento.setText("");
        advertenciaNombre.setText("");
        advertenciaTelefono.setText("");
        advertenciaDireccion.setText("");

        areaResultado.setText("");
    }

    private boolean validarCampos() {
        boolean validado = true;
        advertenciaDocumento.setText("");
        advertenciaNombre.setText("");
        advertenciaTelefono.setText("");
        advertenciaDireccion.setText("");

        String docTexto = campoDocumento.getText().trim();
        if (!docTexto.matches("\\d{10}")) {
            advertenciaDocumento.setText("Documento inválido: debe tener 10 dígitos numéricos.");
            validado = false;
        }
        if (campoNombre.getText().isEmpty()) {
            advertenciaNombre.setText("Nombre obligatorio.");
            validado = false;
        }
        if (campoTelefono.getText().isEmpty()) {
            advertenciaTelefono.setText("Teléfono obligatorio.");
            validado = false;
        }
        if (campoDireccion.getText().isEmpty()) {
            advertenciaDireccion.setText("Dirección obligatoria.");
            validado = false;
        }
        return validado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String doc = campoDocumento.getText();

        if (e.getSource() == btnRegistrar) {
            if (!validarCampos()) {
                areaResultado.setText("Por favor corrige los campos marcados.");
                return;
            }
            PersonaVO persona = new PersonaVO(doc, campoNombre.getText(), campoTelefono.getText(), campoDireccion.getText());
            boolean exito = coordinador.registrarPersona(persona);
            areaResultado.setText(exito ? "Persona registrada." : "No se pudo registrar. ¿Ya existe?");

        } else if (e.getSource() == btnConsultar) {
            PersonaVO persona = coordinador.consultarPersona(doc);
            if (persona != null) {
                campoNombre.setText(persona.getNombre());
                campoTelefono.setText(persona.getTelefono());
                campoDireccion.setText(persona.getDireccion());
                areaResultado.setText("Persona encontrada:\n\n" + persona);
            } else {
                areaResultado.setText("Persona no encontrada.");
            }

        } else if (e.getSource() == btnActualizar) {
            PersonaVO persona = new PersonaVO(doc, campoNombre.getText(), campoTelefono.getText(), campoDireccion.getText());
            boolean exito = coordinador.actualizarPersona(persona);
            areaResultado.setText(exito ? "Persona actualizada." : "Error al actualizar.");

        } else if (e.getSource() == btnEliminar) {
            boolean exito = coordinador.eliminarPersona(doc);
            areaResultado.setText(exito ? "Persona eliminada." : "Error al eliminar.");

        } else if (e.getSource() == btnListar) {
            ArrayList<PersonaVO> personas = coordinador.listarPersonas();
            if (personas.isEmpty()) {
                areaResultado.setText("No hay personas registradas.");
            } else {
                StringBuilder resultado = new StringBuilder("Lista de Personas:\n\n");
                for (PersonaVO p : personas) {
                    resultado.append(p).append("\n\n");
                }
                areaResultado.setText(resultado.toString());
            }

        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        }
    }
}
