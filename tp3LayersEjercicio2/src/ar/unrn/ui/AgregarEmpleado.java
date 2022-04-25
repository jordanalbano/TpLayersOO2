package ar.unrn.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.excepciones.ExcepcionPorStringNulo;
import ar.unrn.modelo.RepositorioDeEmpleado;

public class AgregarEmpleado extends JFrame {
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNacimiento;
	private JTextField email;
	private RepositorioDeEmpleado empleados;

	public AgregarEmpleado(RepositorioDeEmpleado repositorio) {
		this.empleados = repositorio;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Agregar Empleado");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.apellido = new JTextField(10);
		this.fechaNacimiento = new JTextField(10);
		this.email = new JTextField(30);

		this.nombre.setText("");
		this.apellido.setText("");
		this.fechaNacimiento.setText("");
		this.email.setText("");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Apellido: "));
		contentPane.add(this.apellido);
		contentPane.add(new JLabel("Fecha De nacimiento: "));
		contentPane.add(this.fechaNacimiento);
		contentPane.add(new JLabel("Email: "));
		contentPane.add(this.email);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener((e) -> {
			try {
				onBotonCargar();
				JOptionPane.showMessageDialog(null, "Empleado cargado con exito", "Mensaje informativo",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (ExcepcionPorStringNulo e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() throws ExcepcionPorStringNulo {
		/*
		 * mpleado empleado = new Empleado(this.nombre.getText(),
		 * this.apellido.getText(), this.fechaNacimiento.getText(),
		 * this.email.getText()); this.empleados.agregarEmpleado(empleado);
		 */
	}

}
