package vista;

import controlador.Coordinador;
import modelo.MascotaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMascotas extends JFrame implements ActionListener {
	private JTextField campoId, campoNombre, campoEspecie, campoRaza, campoEdad, campoDocumentoDueño;
	private JLabel advertenciaNombre, advertenciaEspecie, advertenciaRaza, advertenciaEdad, advertenciaDocumentoDueño;
	private JTextArea areaResultado;
	private JButton btnRegistrar, btnConsultar, btnActualizar, btnEliminar, btnListar, btnLimpiar;
	private Coordinador coordinador;

	@SuppressWarnings("removal")
	public VentanaMascotas() {
		setTitle("Mascotas");
		setSize(550, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("fondoPersonas.jpg"));
		Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(550, 500, Image.SCALE_SMOOTH);
		ImageIcon fondo = new ImageIcon(imagenEscalada);
		JLabel fondoLabel = new JLabel(fondo);
		fondoLabel.setBounds(0, 0, 550, 500);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(getSize());

		JPanel panelCampos = new JPanel(new GridLayout(11, 2, 10, 5));
		panelCampos.setBorder(BorderFactory.createTitledBorder("Datos de la Mascota"));
		panelCampos.setOpaque(false);

		campoId = new JTextField();
		campoId.setFont(new Font("Tahoma", Font.ITALIC, 10));
		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Tahoma", Font.ITALIC, 10));
		campoEspecie = new JTextField();
		campoEspecie.setFont(new Font("Tahoma", Font.ITALIC, 10));
		campoRaza = new JTextField();
		campoRaza.setFont(new Font("Tahoma", Font.ITALIC, 10));
		campoEdad = new JTextField();
		campoEdad.setFont(new Font("Tahoma", Font.ITALIC, 10));
		campoDocumentoDueño = new JTextField();
		campoDocumentoDueño.setFont(new Font("Tahoma", Font.ITALIC, 10));

		advertenciaNombre = new JLabel();
		advertenciaNombre.setForeground(Color.BLACK);
		advertenciaEspecie = new JLabel();
		advertenciaEspecie.setForeground(Color.BLACK);
		advertenciaRaza = new JLabel();
		advertenciaRaza.setForeground(Color.BLACK);
		advertenciaEdad = new JLabel();
		advertenciaEdad.setForeground(Color.BLACK);
		advertenciaDocumentoDueño = new JLabel();
		advertenciaDocumentoDueño.setForeground(Color.BLACK);

		JLabel label = new JLabel("ID (solo para consultar/editar):");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label);
		panelCampos.add(campoId);

		JLabel label_1 = new JLabel("Nombre de la mascota:");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label_1);
		panelCampos.add(campoNombre);
		panelCampos.add(new JLabel(""));
		panelCampos.add(advertenciaNombre);

		JLabel label_2 = new JLabel("Especie:");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label_2);
		panelCampos.add(campoEspecie);
		panelCampos.add(new JLabel(""));
		panelCampos.add(advertenciaEspecie);

		JLabel label_3 = new JLabel("Raza:");
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label_3);
		panelCampos.add(campoRaza);
		panelCampos.add(new JLabel(""));
		panelCampos.add(advertenciaRaza);

		JLabel label_4 = new JLabel("Edad:");
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label_4);
		panelCampos.add(campoEdad);
		panelCampos.add(new JLabel(""));
		panelCampos.add(advertenciaEdad);

		JLabel label_5 = new JLabel("Documento del dueño:");
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panelCampos.add(label_5);
		panelCampos.add(campoDocumentoDueño);
		panelCampos.add(new JLabel(""));
		panelCampos.add(advertenciaDocumentoDueño);

		JPanel panelBotones = new JPanel(new GridLayout(1, 6, 5, 5));
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(255, 192, 203));
		btnRegistrar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(255, 192, 203));
		btnConsultar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(255, 192, 203));
		btnActualizar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 192, 203));
		btnEliminar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(255, 192, 203));
		btnListar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(255, 192, 203));
		btnLimpiar.setFont(new Font("Tahoma", Font.ITALIC, 10));

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
		areaResultado.setWrapStyleWord(true);
		areaResultado.setEditable(false);
		areaResultado.setEnabled(false);
		areaResultado.setForeground(new Color(0, 0, 0));
		areaResultado.setFont(new Font("Monospaced", Font.BOLD, 16));
		areaResultado.setBackground(new Color(255, 192, 203));
		JScrollPane scroll = new JScrollPane(areaResultado);
		scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);

		panelCampos.setBounds(30, 10, 490, 310);
		panelBotones.setBounds(30, 330, 490, 50);
		scroll.setBounds(30, 390, 490, 80);

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
		campoId.setText("");
		campoNombre.setText("");
		campoEspecie.setText("");
		campoRaza.setText("");
		campoEdad.setText("");
		campoDocumentoDueño.setText("");

		advertenciaNombre.setText("");
		advertenciaEspecie.setText("");
		advertenciaRaza.setText("");
		advertenciaEdad.setText("");
		advertenciaDocumentoDueño.setText("");

		areaResultado.setText("");
	}

	private boolean validarCampos() {
		boolean validado = true;

		advertenciaNombre.setText("");
		advertenciaEspecie.setText("");
		advertenciaRaza.setText("");
		advertenciaEdad.setText("");
		advertenciaDocumentoDueño.setText("");

		if (campoNombre.getText().trim().isEmpty()) {
			advertenciaNombre.setText("Nombre obligatorio.");
			validado = false;
		}
		if (campoEspecie.getText().trim().isEmpty()) {
			advertenciaEspecie.setText("Especie obligatoria.");
			validado = false;
		}
		if (campoRaza.getText().trim().isEmpty()) {
			advertenciaRaza.setText("Raza obligatoria.");
			validado = false;
		}
		String edadTexto = campoEdad.getText().trim();
		if (edadTexto.isEmpty()) {
			advertenciaEdad.setText("Edad obligatoria.");
			validado = false;
		} else {
			try {
				int edad = Integer.parseInt(edadTexto);
				if (edad < 0) {
					advertenciaEdad.setText("Edad no puede ser negativa.");
					validado = false;
				}
			} catch (NumberFormatException ex) {
				advertenciaEdad.setText("Edad debe ser un número entero.");
				validado = false;
			}
		}
		String docDueño = campoDocumentoDueño.getText().trim();
		if (!docDueño.matches("\\d{10}")) {
			advertenciaDocumentoDueño.setText("Documento  inválido: 10 debe tener dígitos numéricos.");
			validado = false;
		}

		return validado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String idTexto = campoId.getText();

		if (e.getSource() == btnRegistrar) {
			if (!validarCampos()) {
				areaResultado.setText("Por favor corrige los campos marcados.");
				return;
			}
			MascotaVO mascota = new MascotaVO(campoNombre.getText(), campoEspecie.getText(), campoRaza.getText(),
					Integer.parseInt(campoEdad.getText()), campoDocumentoDueño.getText());
			boolean exito = coordinador.registrarMascota(mascota);
			areaResultado.setText(exito ? "Mascota registrada." : "No se pudo registrar.");

		} else if (e.getSource() == btnConsultar) {
			if (idTexto.isEmpty()) {
				areaResultado.setText("Debes ingresar un ID para consultar.");
				return;
			}
			try {
				int id = Integer.parseInt(idTexto);
				MascotaVO mascota = coordinador.consultarMascota(id);
				if (mascota != null) {
					campoNombre.setText(mascota.getNombreMascota());
					campoEspecie.setText(mascota.getEspecie());
					campoRaza.setText(mascota.getRaza());
					campoEdad.setText(String.valueOf(mascota.getEdad()));
					campoDocumentoDueño.setText(mascota.getDocumentoDueño());
					areaResultado.setText("Mascota encontrada:\n\n" + mascota);
				} else {
					areaResultado.setText("Mascota no encontrada.");
				}
			} catch (NumberFormatException ex) {
				areaResultado.setText("El ID debe ser un número entero.");
			}

		} else if (e.getSource() == btnActualizar) {
			if (idTexto.isEmpty()) {
				areaResultado.setText("Debes ingresar un ID para actualizar.");
				return;
			}
			if (!validarCampos()) {
				areaResultado.setText("Por favor corrige los campos marcados.");
				return;
			}
			try {
				int id = Integer.parseInt(idTexto);
				MascotaVO mascota = new MascotaVO(id, campoNombre.getText(), campoEspecie.getText(),
						campoRaza.getText(), Integer.parseInt(campoEdad.getText()), campoDocumentoDueño.getText());
				boolean exito = coordinador.actualizarMascota(mascota);
				areaResultado.setText(exito ? "Mascota actualizada." : "Error al actualizar.");
			} catch (NumberFormatException ex) {
				areaResultado.setText("El ID debe ser un número entero.");
			}

		} else if (e.getSource() == btnEliminar) {
			if (idTexto.isEmpty()) {
				areaResultado.setText("Debes ingresar un ID para eliminar.");
				return;
			}
			try {
				int id = Integer.parseInt(idTexto);
				boolean exito = coordinador.eliminarMascota(id);
				areaResultado.setText(exito ? "Mascota eliminada." : "Error al  Eliminar.");
			} catch (NumberFormatException ex) {
				areaResultado.setText("El ID debe ser un número entero.");
			}

		} else if (e.getSource() == btnListar) {
			ArrayList<MascotaVO> mascotas = coordinador.listarMascotas();
			if (mascotas.isEmpty()) {
				areaResultado.setText("No hay mascotas registradas.");
			} else {
				StringBuilder resultado = new StringBuilder("Mascotas Registradas:\n\n");
				for (MascotaVO m : mascotas) {
					resultado.append(m).append("\n\n");
				}
				areaResultado.setText(resultado.toString());
			}

		} else if (e.getSource() == btnLimpiar) {
			limpiarCampos();
		}
	}
}
