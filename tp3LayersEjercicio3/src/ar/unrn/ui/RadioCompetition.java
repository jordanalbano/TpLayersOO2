package ar.unrn.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ar.unrn.excepciones.AppException;
import ar.unrn.excepciones.ExcepcionPorIdConcursoInvalido;
import ar.unrn.excepciones.ExcepcionPorMalFormaDeIngresoDeTelefono;
import ar.unrn.excepciones.ExcepcionPorMalIngresoDeEmail;
import ar.unrn.excepciones.ExcepcionPorNoEleccionDeConcurso;
import ar.unrn.excepciones.ExcepcionPorStringVacio;
import ar.unrn.modelo.Concursante;
import ar.unrn.modelo.Concurso;
import ar.unrn.modelo.RegistroConcursante;
import ar.unrn.modelo.RegistroConcursos;

public class RadioCompetition {
	private JPanel contentPane;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JComboBox<String> comboBox;
	private JButton btnOk;
	private JLabel lblCompetition;
	private RegistroConcursante registroConcursantes;
	private RegistroConcursos registroConcursos;

	private List<Integer> idConcursos = new ArrayList<Integer>();

	public RadioCompetition(RegistroConcursante registroConcursante, RegistroConcursos registroConcurso) {

		this.registroConcursantes = registroConcursante;
		this.registroConcursos = registroConcurso;
		var frame = new JFrame("Inscription to Competition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 451, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		lblName = new JLabel("Nombre:");
		txtName = new JTextField();
		txtName.setColumns(10);
		lblLastName = new JLabel("Apellido:");
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		lblId = new JLabel("Dni:");
		txtId = new JTextField();
		txtId.setColumns(10);
		lblPhone = new JLabel("Telefono:");
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		lblEmail = new JLabel("Email:");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOk.setEnabled(false);
				saveInscription();
				btnOk.setEnabled(true);
			}
		});
		lblCompetition = new JLabel("Concurso:");

		comboBox = new JComboBox<String>();
		try {
			for (Concurso c : this.registroConcursos.todosLosConcursos()) {
				comboBox.addItem(
						"id: " + c.idConcurso() + ",nombre:" + c.nombre() + "," + "Fecha Fin: " + c.fechaFin());
				idConcursos.add(c.idConcurso());
			}
		} catch (IOException | AppException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}
		todosLosConcursos();

	}

	private void todosLosConcursos() {
	}

	private void saveInscription() {
		try {
			Concursante concursante = new Concursante(this.txtName.getText(), this.txtLastName.getText(),
					this.txtPhone.getText(), this.txtEmail.getText(), this.txtId.getText(),
					this.idConcursos.get(comboBox.getSelectedIndex()));

			this.registroConcursantes.saveInscription(concursante);

			JOptionPane.showMessageDialog(null, "Concursante cargado con exito", "Mensaje Informativo",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException | ExcepcionPorStringVacio | ExcepcionPorMalIngresoDeEmail
				| ExcepcionPorMalFormaDeIngresoDeTelefono | ExcepcionPorNoEleccionDeConcurso
				| ExcepcionPorIdConcursoInvalido | AppException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void layout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblLastName)
								.addComponent(lblId).addComponent(lblPhone).addComponent(lblEmail).addComponent(lblName)
								.addComponent(lblCompetition))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtEmail, Alignment.TRAILING).addComponent(txtPhone, Alignment.TRAILING)
								.addComponent(txtId, Alignment.TRAILING).addComponent(txtLastName, Alignment.TRAILING)
								.addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
										Short.MAX_VALUE)))
						.addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblLastName).addComponent(
						txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblId).addComponent(txtId,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblEmail))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCompetition))))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk).addContainerGap(67, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
