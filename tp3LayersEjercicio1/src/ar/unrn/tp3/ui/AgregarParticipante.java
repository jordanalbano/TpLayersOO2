package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.excepciones.AppException;
import ar.unrn.tp3.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.tp3.excepciones.ExcepcionPorRegionDesconocida;
import ar.unrn.tp3.excepciones.ExcepcionPorStringNulo;
import ar.unrn.tp3.modelo.EntradaNuevoParticipante;

public class AgregarParticipante extends JFrame {
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private EntradaNuevoParticipante participantes;

	public AgregarParticipante(EntradaNuevoParticipante repositorio) {
		this.participantes = repositorio;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener((e) -> {
			try {
				onBotonCargar();
				JOptionPane.showMessageDialog(null, "Participante Cargado Con Exito", "Mensaje Informativo",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (ExcepcionPorStringNulo | ExcepcionPorMalFormaDeIngresoDeTelefono | ExcepcionPorRegionDesconocida
					| AppException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() throws ExcepcionPorStringNulo, ExcepcionPorMalFormaDeIngresoDeTelefono,
			ExcepcionPorRegionDesconocida, AppException {
		this.participantes.nuevoParticipante(nombre.getText(), telefono.getText(), region.getText());

	}

}
