import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaRegistro extends JFrame{
	private JTextField textFieldDNI;
	private JTextField textFieldNum;
	private JTextField textFieldName;
	private JTextField textFieldApell;
	private JTextField textFieldPuntos;
	private JTextField textFieldAnyo;
	String[] mesArray = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	String[] diaArray31 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] diaArray30 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	String[] diaArray28 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
	JComboBox comboBoxMes;
	JComboBox comboBoxDia;
	
	public VentanaRegistro() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setSize(700, 400);
		this.setResizable(false);
		this.setTitle("Registro");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(290, 95, 177, 20);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldNum = new JTextField();
		textFieldNum.setColumns(10);
		textFieldNum.setBounds(290, 126, 177, 20);
		getContentPane().add(textFieldNum);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(290, 33, 177, 20);
		getContentPane().add(textFieldName);
		
		textFieldApell = new JTextField();
		textFieldApell.setColumns(10);
		textFieldApell.setBounds(290, 64, 177, 20);
		getContentPane().add(textFieldApell);
		
		String[] array = {"Normal", "VIP"};
		JComboBox comboBoxVIP = new JComboBox(array);
		comboBoxVIP.setBounds(339, 172, 98, 22);		
		getContentPane().add(comboBoxVIP);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(170, 296, 89, 23);
		getContentPane().add(btnSalir);
		
		btnSalir.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnAnyadir = new JButton("A\u00F1adir Usuario");
		btnAnyadir.setBounds(352, 296, 148, 23);
		getContentPane().add(btnAnyadir);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(101, 36, 110, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApell = new JLabel("Apellidos:");
		lblApell.setBounds(101, 67, 77, 14);
		getContentPane().add(lblApell);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(101, 98, 66, 14);
		getContentPane().add(lblDNI);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(101, 129, 98, 14);
		getContentPane().add(lblNumero);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(101, 176, 110, 14);
		getContentPane().add(lblTipo);
		
		textFieldPuntos = new JTextField();
		textFieldPuntos.setColumns(10);
		textFieldPuntos.setBounds(290, 246, 177, 20);
		getContentPane().add(textFieldPuntos);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(101, 218, 110, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblPuntos = new JLabel("Puntos: ");
		lblPuntos.setBounds(101, 249, 110, 14);
		getContentPane().add(lblPuntos);
		
		
		comboBoxDia = new JComboBox(diaArray31);
		comboBoxDia.setBounds(279, 213, 60, 22);
		getContentPane().add(comboBoxDia);
		
		comboBoxMes = new JComboBox(mesArray);
		comboBoxMes.setBounds(349, 213, 60, 22);
		getContentPane().add(comboBoxMes);
		
		textFieldAnyo = new JTextField();
		textFieldAnyo.setBounds(419, 215, 86, 20);
		getContentPane().add(textFieldAnyo);
		textFieldAnyo.setColumns(10);
		
		lblFecha.setVisible(false);
		lblPuntos.setVisible(false);
		textFieldPuntos.setVisible(false);
		comboBoxMes.setVisible(false);
		comboBoxDia.setVisible(false);
		textFieldAnyo.setVisible(false);
		
		comboBoxVIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxVIP.getSelectedItem().equals("VIP")) {
					lblFecha.setVisible(true);
					lblPuntos.setVisible(true);
					comboBoxMes.setVisible(true);
					comboBoxDia.setVisible(true);
					textFieldAnyo.setVisible(true);
					textFieldPuntos.setVisible(true);
				}else {
					lblFecha.setVisible(false);
					lblPuntos.setVisible(false);
					comboBoxMes.setVisible(false);
					comboBoxDia.setVisible(false);
					textFieldAnyo.setVisible(false);
					textFieldPuntos.setVisible(false);
				}
			}
		});
		
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comboBoxVIP.getSelectedItem().equals("Normal")) {
						if(textFieldDNI.getText().isEmpty() ||textFieldName.getText().isEmpty() ||textFieldNum.getText().isEmpty() ||textFieldApell.getText().isEmpty()) {
							throw new Exception();
						}else {
							String dni = textFieldDNI.getText();
							String name = textFieldName.getText();
							String num = textFieldNum.getText();
							ClienteNormal cn = new ClienteNormal(dni, name, Integer.parseInt(num));
							FileWriter file = null;
							try {
								file = new FileWriter(dni);
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							BufferedWriter bw = new BufferedWriter(file);
							for(char c : cn.toString().toCharArray()) {
								try {
									bw.append(c);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
					}else {
						if(textFieldDNI.getText().isEmpty() ||textFieldName.getText().isEmpty() ||textFieldNum.getText().isEmpty() ||textFieldApell.getText().isEmpty()||textFieldPuntos.getText().isEmpty() || textFieldAnyo.getText().isEmpty()) {
							throw new Exception();
						}else if(textFieldAnyo.getText().length()!=4) {
							throw new NumberFormatException();
						}else {
							String dni = textFieldDNI.getText();
							String name = textFieldName.getText();
							String num = textFieldNum.getText();
							String tipo = "VIP";
							Integer.parseInt(textFieldAnyo.getText());
							String fecha = comboBoxDia.getSelectedItem() + "-" + comboBoxMes.getSelectedItem() + "-" + textFieldAnyo.getText();						
							String puntos = textFieldPuntos.getText();
							ClienteVIP cv = new ClienteVIP(dni, name, Integer.parseInt(num), Integer.parseInt(puntos));
							FileWriter file = new FileWriter(dni);
							BufferedWriter bw = new BufferedWriter(file);
							for(char c : cv.toString().toCharArray()) {
								bw.append(c);
							}
							Calendar c = Calendar.getInstance();
							c.set(Integer.parseInt(textFieldAnyo.getText()),comboBoxMes.getSelectedIndex()+1, Integer.parseInt((String) comboBoxDia.getSelectedItem()) );
							Calendar c2 = Calendar.getInstance();
							long milisFecha = c.getTimeInMillis();
							long milisSys = c2.getTime().getTime();
							
							long milisDif = milisSys-milisFecha;
							
							if(milisDif<0) {
								JOptionPane.showMessageDialog(getContentPane(), "Fecha introducida incorrecta.");
							}else {
								int years = (int) (milisDif/1000/60/60/24/365);
								int dias = ((int) milisDif -  (years*365*24*60*60*1000))/1000/60/60/24;
								
								JOptionPane.showMessageDialog(getContentPane(), "Tiempo de VIP: " + years + " años y " + dias + "días.");
							}

						}
					}				
				}catch(NumberFormatException e2) {	
					JOptionPane.showMessageDialog(getContentPane(), "Por favor, rellena el año correctamente (YYYY).");
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(getContentPane(), "Por favor, rellena todos los campos correctamente.");
				}
				
			}
		});
		
		comboBoxMes.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cambioMes();
			}
		});
		
	}
	
	public void cambioMes() {
		if(comboBoxMes.getSelectedItem().equals("Abril") || comboBoxMes.getSelectedItem().equals("Mayo") || comboBoxMes.getSelectedItem().equals("Agosto") || comboBoxMes.getSelectedItem().equals("Octubre") || comboBoxMes.getSelectedItem().equals("Noviembre")) {
			DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(diaArray30);
			comboBoxDia.setModel(modelo);
		}else if(comboBoxMes.getSelectedItem().equals("Febrero")) {
			DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(diaArray28);
			comboBoxDia.setModel(modelo);
		}else {
			DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(diaArray31);
			comboBoxDia.setModel(modelo);
		}
	}
	
	public static void main(String[] args) {
		VentanaRegistro vr = new VentanaRegistro();
		vr.setVisible(true);
	}
}
