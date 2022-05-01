package gui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

import calculable.Calculadora;
import calculable.CalculadoraHombre;
import calculable.CalculadoraMujer;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;

import java.awt.GridLayout;

import trabajoEDS.*;
import calculable.*;

public class CalculadoraMacronutrientes {

	// -- Paneles -- //

	private JFrame JFrame;	
	private JPanel panelListaAlimentos;
	JScrollPane scroll;	
	
	// -- Fields Persona -- //

	private JTextField textFieldNombrePers;
	private JTextField textFieldEdad;
	private JTextField textFieldPeso;
	private JTextField textFieldImc;
	private JTextField textFieldAltura;
	private JComboBox<ActividadFisica> comboBoxActFisica;
	private JComboBox<Genero> comboBoxGenero;
	
	// -- Fields Alimento -- //

	private JTextField textFieldGrasas;
	private JTextField textFieldNombreAlimento;
	private JTextField textFieldSaturadas;
	private JTextField textFieldHidratos;
	private JTextField textFieldAzucares;
	private JTextField textFieldProteinas;
	private JTextField textFieldSal;
	private JTextField textFieldCalcio;
	private JTextField textFieldVitaminas;
	private JTextField textFieldHierro;
	private JTextField textFieldEnergia;
	
	// -- Fields Calculo -- //

	private JTextField textFieldGrasasTot;
	private JTextField textFieldAzucarTot;
	private JTextField textFieldSalTot;
	private JTextField textFieldEnergiaTot;
	
	private Persona usuario;
	private ArrayList<AlimentoCantidad> alimentosCantidad = new ArrayList<AlimentoCantidad>();
	private ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

	// -- Verifificadores -- //
	
		InputVerifier positiveDoubleVerifier;
		InputVerifier positiveIntVerifier;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraMacronutrientes window = new CalculadoraMacronutrientes();
					window.JFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraMacronutrientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		inicializarVentana();
		inicializarPanelPersona();
		inicializarPanelAlimento();
		inicializarPanelListaAlimentos();
		intializePanelListaAlimentos();
	}
	
	/**
	 * Inicializa la ventana principal del programa.
	 * 
	 * @author Ana
	 */
	private void inicializarVentana() {
		JFrame = new JFrame();
		JFrame.setTitle("Calculadora de nutrientes");
		JFrame.setBounds(100, 100, 1340, 773);
		JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.getContentPane().setLayout(null);
	}
	
	/**
	 * Inicializa todos los componentes del panel de la persona.
	 * 
	 * @author Ana
	 */
	private void inicializarPanelPersona() {
			
	// -- Información -- //
		
			JLabel lblInfoPers = new JLabel("1.- Introduzca sus datos para obtener un cálculo personalizado sobre sus ingestas diarias: ");
			lblInfoPers.setFont(new Font("Dialog", Font.BOLD, 13));
			lblInfoPers.setBounds(349, 11, 598, 41);
			JFrame.getContentPane().add(lblInfoPers);
		
		
	// -- Nombre de la persona -- //
		
		JLabel lblNombrePers = new JLabel("Nombre:");
		lblNombrePers.setForeground(Color.BLACK);
		lblNombrePers.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNombrePers.setBounds(21, 64, 66, 14);
		JFrame.getContentPane().add(lblNombrePers);
		
		textFieldNombrePers = new JTextField();
		textFieldNombrePers.setBounds(82, 61, 97, 20);
		JFrame.getContentPane().add(textFieldNombrePers);
		textFieldNombrePers.setColumns(10);
		
		
	// -- Genero de la persona -- //
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setBounds(193, 64, 52, 14);
		JFrame.getContentPane().add(lblGenero);
		
		comboBoxGenero = new JComboBox<Genero>();
		comboBoxGenero.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		comboBoxGenero.setBounds(250, 61, 104, 20);
		JFrame.getContentPane().add(comboBoxGenero);
		
	
	// -- Edad de la persona -- //
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEdad.setBounds(385, 64, 46, 14);
		JFrame.getContentPane().add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(428, 61, 66, 20);
		JFrame.getContentPane().add(textFieldEdad);
		
		JLabel lblAnyos = new JLabel("a\u00F1os");
		lblAnyos.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblAnyos.setBounds(497, 64, 46, 14);
		JFrame.getContentPane().add(lblAnyos);
		
		
	// -- Peso de la persona -- //
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPeso.setBounds(553, 64, 52, 14);
		JFrame.getContentPane().add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(595, 61, 66, 20);
		JFrame.getContentPane().add(textFieldPeso);
		
		JLabel lblkg = new JLabel("kg");
		lblkg.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblkg.setBounds(665, 64, 34, 14);
		JFrame.getContentPane().add(lblkg);
		
		
	// -- Altura de la persona -- //
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAltura.setBounds(720, 64, 62, 14);
		JFrame.getContentPane().add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(774, 61, 52, 20);
		JFrame.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCm.setBounds(830, 64, 34, 14);
		JFrame.getContentPane().add(lblCm);
		
		
	// -- Actividad Física de la persona -- //
		
		JLabel lblActFisica = new JLabel("Actividad f\u00EDsica:");
		lblActFisica.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblActFisica.setBounds(885, 64, 122, 14);
		JFrame.getContentPane().add(lblActFisica);
		
		comboBoxActFisica = new JComboBox<ActividadFisica>();
		comboBoxActFisica.setModel(new DefaultComboBoxModel<ActividadFisica>(ActividadFisica.values()));
		comboBoxActFisica.setBounds(1003, 61, 130, 20);
		JFrame.getContentPane().add(comboBoxActFisica);
		
		
	// -- IMC de la persona (autocalculable) -- //
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblImc.setBounds(1158, 64, 46, 14);
		JFrame.getContentPane().add(lblImc);
		
		textFieldImc = new JTextField();
		textFieldImc.setEditable(false);
		textFieldImc.setBounds(1201, 61, 86, 20);
		JFrame.getContentPane().add(textFieldImc);
		textFieldImc.setColumns(10);
		
		
	// -- Panel (backrground) de la persona -- //
		
		JTextPane backroundPers = new JTextPane();
		backroundPers.setEditable(false);
		backroundPers.setBackground(new Color(251, 248, 204));
		backroundPers.setBounds(10, 11, 1304, 94);
		JFrame.getContentPane().add(backroundPers);
	}
	
	/**
	 * Inicializa todos los componentes del panel del alimento.
	 * 
	 * @author Ana
	 */
	private void inicializarPanelAlimento() {
		
	// -- Información -- / /
		
		JLabel lblInfoAlimOp = new JLabel("OPCIONAL");
		lblInfoAlimOp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAlimOp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoAlimOp.setBounds(1126, 117, 86, 14);
		JFrame.getContentPane().add(lblInfoAlimOp);
		
		JLabel lblInfoAl1 = new JLabel("Añadir un alimento a la lista:");
		lblInfoAl1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoAl1.setBounds(1069, 133, 200, 14);
		JFrame.getContentPane().add(lblInfoAl1);
		
		JLabel lblInfoNutricional = new JLabel("Información nutricional                    100gr.");
		lblInfoNutricional.setFont(new Font("Dialog", Font.BOLD, 11));
		lblInfoNutricional.setBounds(1043, 223, 252, 14);
		JFrame.getContentPane().add(lblInfoNutricional);
		
		
	// -- Nombre del alimento -- //
		
		JLabel lblNombreAlimento = new JLabel("Nombre:");
		lblNombreAlimento.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNombreAlimento.setBounds(1074, 177, 104, 14);
		JFrame.getContentPane().add(lblNombreAlimento);
		
		textFieldNombreAlimento = new JTextField();
		textFieldNombreAlimento.setBounds(1145, 174, 142, 20);
		JFrame.getContentPane().add(textFieldNombreAlimento);
		textFieldNombreAlimento.setColumns(10);
		
		
	// -- Energía del alimento -- //
		
		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEnergia.setBounds(1035, 265, 78, 14);
		JFrame.getContentPane().add(lblEnergia);

		textFieldEnergia = new JTextField();
		textFieldEnergia.setColumns(10);
		textFieldEnergia.setBounds(1214, 262, 57, 20);
		JFrame.getContentPane().add(textFieldEnergia);
		
		JLabel lblKcal1 = new JLabel("kcal");
		lblKcal1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblKcal1.setBounds(1276, 265, 34, 14);
		JFrame.getContentPane().add(lblKcal1);

		
	// -- Grasas del alimento -- //
		
		JLabel lblGrasas = new JLabel("Grasas:");
		lblGrasas.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasas.setBounds(1035, 308, 78, 14);
		JFrame.getContentPane().add(lblGrasas);
		
		textFieldGrasas = new JTextField();
		textFieldGrasas.setBounds(1214, 305, 57, 20);
		JFrame.getContentPane().add(textFieldGrasas);
		textFieldGrasas.setColumns(10);
		
		JLabel lblGr4 = new JLabel("gr");
		lblGr4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr4.setBounds(1276, 305, 34, 20);
		JFrame.getContentPane().add(lblGr4);
		
		
	// -- Grasas saturadas del alimento -- //
		
		JLabel lblGrasasSat = new JLabel("de las cuales saturadas:");
		lblGrasasSat.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasSat.setBounds(1035, 354, 184, 14);
		JFrame.getContentPane().add(lblGrasasSat);
		
		textFieldSaturadas = new JTextField();
		textFieldSaturadas.setColumns(10);
		textFieldSaturadas.setBounds(1214, 351, 57, 20);
		JFrame.getContentPane().add(textFieldSaturadas);
		
		JLabel lblGr5 = new JLabel("gr");
		lblGr5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr5.setBounds(1276, 352, 33, 20);
		JFrame.getContentPane().add(lblGr5);
		
		
	// -- Hidratos de carbono del alimento -- //
		
		JLabel lblHidratos = new JLabel("Hidratos de carbono:");
		lblHidratos.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHidratos.setBounds(1035, 402, 166, 14);
		JFrame.getContentPane().add(lblHidratos);
		
		textFieldHidratos = new JTextField();
		textFieldHidratos.setColumns(10);
		textFieldHidratos.setBounds(1214, 399, 57, 20);
		JFrame.getContentPane().add(textFieldHidratos);
		
		JLabel lblGr6 = new JLabel("gr");
		lblGr6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr6.setBounds(1276, 400, 34, 20);
		JFrame.getContentPane().add(lblGr6);
		
		
	// -- Azúcares del alimento -- //
		
		JLabel lblAzucar = new JLabel("de los cuales azúcares:");
		lblAzucar.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAzucar.setBounds(1035, 446, 166, 14);
		JFrame.getContentPane().add(lblAzucar);
		
		textFieldAzucares = new JTextField();
		textFieldAzucares.setColumns(10);
		textFieldAzucares.setBounds(1214, 443, 57, 20);
		JFrame.getContentPane().add(textFieldAzucares);
		
		JLabel lblGr7 = new JLabel("gr");
		lblGr7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr7.setBounds(1276, 444, 33, 20);
		JFrame.getContentPane().add(lblGr7);
		
		
	// -- Proteínas del alimento -- //
		
		JLabel lblProteinas = new JLabel("Prote\u00EDnas:");
		lblProteinas.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProteinas.setBounds(1035, 490, 86, 14);
		JFrame.getContentPane().add(lblProteinas);
		
		textFieldProteinas = new JTextField();
		textFieldProteinas.setColumns(10);
		textFieldProteinas.setBounds(1214, 487, 57, 20);
		JFrame.getContentPane().add(textFieldProteinas);
		
		JLabel lblGr8 = new JLabel("gr");
		lblGr8.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr8.setBounds(1276, 487, 35, 20);
		JFrame.getContentPane().add(lblGr8);
		
		
	// -- Sal del alimento -- //
		
		JLabel lblSal = new JLabel("Sal:");
		lblSal.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSal.setBounds(1035, 537, 46, 14);
		JFrame.getContentPane().add(lblSal);
		
		textFieldSal = new JTextField();
		textFieldSal.setColumns(10);
		textFieldSal.setBounds(1214, 534, 57, 20);
		JFrame.getContentPane().add(textFieldSal);
		
		JLabel lblGr9 = new JLabel("gr");
		lblGr9.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr9.setBounds(1276, 533, 35, 20);
		JFrame.getContentPane().add(lblGr9);
		
		
	// -- Calcio del alimento -- //
		
		JLabel lblCalcio = new JLabel("Calcio:");
		lblCalcio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCalcio.setBounds(1035, 583, 60, 14);
		JFrame.getContentPane().add(lblCalcio);
		
		textFieldCalcio = new JTextField();
		textFieldCalcio.setColumns(10);
		textFieldCalcio.setBounds(1214, 580, 57, 20);
		JFrame.getContentPane().add(textFieldCalcio);
		
		JLabel lblGr10 = new JLabel("gr");
		lblGr10.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr10.setBounds(1276, 580, 34, 20);
		JFrame.getContentPane().add(lblGr10);
		
	// -- Hierro del alimento -- //
		
		JLabel lblHierro = new JLabel("Hierro:");
		lblHierro.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHierro.setBounds(1035, 626, 60, 14);
		JFrame.getContentPane().add(lblHierro);
		
		textFieldHierro = new JTextField();
		textFieldHierro.setColumns(10);
		textFieldHierro.setBounds(1214, 624, 57, 20);
		JFrame.getContentPane().add(textFieldHierro);
		
		JLabel lblGr11 = new JLabel("gr");
		lblGr11.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr11.setBounds(1276, 624, 32, 20);
		JFrame.getContentPane().add(lblGr11);
		
		
	// -- Botón para añadir el alimento -- //
		
		JButton btnAddAlimento = new JButton("Añadir");
		btnAddAlimento.addActionListener(new ActionListener() {
			/**
			 * Añade un alimento al objeto Alimento y pinta una nueva fila en el panel
			 * de la lista de alimentos. A continuación limpia todos los textFields del Alimento.
			 * 
			 * @author Ana
			 */
			public void actionPerformed(ActionEvent arg0) {
				Alimento alimento = crearAlimento();		
				alimentos.add(alimento);
				addRowAlimento(alimento);
				scroll.revalidate();
				scroll.repaint();
				limpiarPanelAlimento();
			}
		});
		btnAddAlimento.setBackground(new Color(191, 234, 237));
		btnAddAlimento.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAddAlimento.setBounds(1125, 683, 89, 23);
		JFrame.getContentPane().add(btnAddAlimento);
		
		
	// -- Panel (backrground) del alimento -- //
		
		JTextPane backroundAddAlim = new JTextPane();
		backroundAddAlim.setEditable(false);
		backroundAddAlim.setBackground(new Color(192, 250, 255));
		backroundAddAlim.setBounds(1025, 104, 289, 628);
		JFrame.getContentPane().add(backroundAddAlim);
		
	}
	
	/**
	 * Inicializa todos los componentes del panel de la lista de alimentos.
	 * 
	 * @author Ana
	 */
	private void inicializarPanelListaAlimentos() {
		
	// -- Información -- //
		
		JLabel lblInfoLista = new JLabel("2.- Listado de los alimentos:");
		lblInfoLista.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoLista.setBounds(438, 132, 184, 14);
		JFrame.getContentPane().add(lblInfoLista);
		
		JLabel lblTotMacro = new JLabel("Valores totales de los macronutrientes:");
		lblTotMacro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTotMacro.setBounds(386, 572, 262, 14);
		JFrame.getContentPane().add(lblTotMacro);
		
		
	// -- Lista de los alimentos -- //
		
		panelListaAlimentos = new JPanel();		
		scroll = new JScrollPane(panelListaAlimentos);
		panelListaAlimentos.setBackground(new Color(250, 209, 255));
		panelListaAlimentos.setBackground(new Color(250, 209, 255));
		panelListaAlimentos.setLayout(new GridLayout(0, 12, 5, 0));
		scroll.setBounds(37, 174, 960, 333);		
		JFrame.getContentPane().add(scroll);
		
		
	// -- Energía total calculada -- //
		
		JLabel lblEngTot = new JLabel("Energ\u00EDa:");
		lblEngTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEngTot.setBounds(263, 615, 74, 19);
		JFrame.getContentPane().add(lblEngTot);
		
		textFieldEnergiaTot = new JTextField();
		textFieldEnergiaTot.setForeground(Color.BLACK);
		textFieldEnergiaTot.setEditable(false);
		textFieldEnergiaTot.setColumns(10);
		textFieldEnergiaTot.setBackground(Color.WHITE);
		textFieldEnergiaTot.setBounds(370, 614, 86, 20);
		JFrame.getContentPane().add(textFieldEnergiaTot);
		
		JLabel lblNewLabelKcal = new JLabel("kcal");
		lblNewLabelKcal.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabelKcal.setBounds(459, 617, 46, 14);
		JFrame.getContentPane().add(lblNewLabelKcal);
		
	// -- Grasas totales calculadas -- //
		
		JLabel lblGrasasTot = new JLabel("Grasas:");
		lblGrasasTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasTot.setBounds(571, 648, 74, 14);
		JFrame.getContentPane().add(lblGrasasTot);
		
		textFieldGrasasTot = new JTextField();
		textFieldGrasasTot.setBackground(Color.WHITE);
		textFieldGrasasTot.setForeground(Color.BLACK);
		textFieldGrasasTot.setEditable(false);
		textFieldGrasasTot.setBounds(663, 645, 86, 20);
		JFrame.getContentPane().add(textFieldGrasasTot);
		textFieldGrasasTot.setColumns(10);
		
		JLabel lblGr = new JLabel("gr");
		lblGr.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr.setBounds(459, 645, 46, 20);
		JFrame.getContentPane().add(lblGr);
		
		
	// -- Azúcares totales calculadas -- //
		
		JLabel lblAzucaresTot = new JLabel("Az\u00FAcares:");
		lblAzucaresTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAzucaresTot.setBounds(263, 648, 74, 14);
		JFrame.getContentPane().add(lblAzucaresTot);
		
		textFieldAzucarTot = new JTextField();
		textFieldAzucarTot.setBackground(Color.WHITE);
		textFieldAzucarTot.setForeground(Color.BLACK);
		textFieldAzucarTot.setEditable(false);
		textFieldAzucarTot.setColumns(10);
		textFieldAzucarTot.setBounds(370, 645, 86, 20);
		JFrame.getContentPane().add(textFieldAzucarTot);
		
		JLabel lblGr2 = new JLabel("gr");
		lblGr2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr2.setBounds(752, 615, 46, 19);
		JFrame.getContentPane().add(lblGr2);
		
		
	// -- Sales totales calculadas -- //
		
		JLabel lblSalTot = new JLabel("Sal:");
		lblSalTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSalTot.setBounds(571, 617, 74, 14);
		JFrame.getContentPane().add(lblSalTot);
		
		textFieldSalTot = new JTextField();
		textFieldSalTot.setBackground(Color.WHITE);
		textFieldSalTot.setForeground(Color.BLACK);
		textFieldSalTot.setEditable(false);
		textFieldSalTot.setColumns(10);
		textFieldSalTot.setBounds(663, 614, 86, 20);
		JFrame.getContentPane().add(textFieldSalTot);
		
		JLabel lblGr3 = new JLabel("gr");
		lblGr3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr3.setBounds(752, 646, 46, 19);
		JFrame.getContentPane().add(lblGr3);
		
		
	// -- Botón calcular -- //
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			/**
			 * Comprueba que los TextField del panel persona estan todos rellenos sino muestra una ventana de dialogo para informar al usuario
			 * Inicializa el usuario con los datos en el panel persona
			 * Calcula el desglose de los macronutrientes adecuado para la persona creada
			 * Pinta el desglose en los campos correspondientes de la GUI
			 * 
			 * @author Marta
			 */
			public void actionPerformed(ActionEvent arg0) {
				boolean isAnyTextFieldInvalid = checkTextFieldsPanelPersona();

				if(isAnyTextFieldInvalid) {
					JOptionPane.showMessageDialog(null, "Por favor, introduzca todos sus datos");
				}
				else {
					usuario = crearPersona();				
					Calculadora calculadora;

					if(usuario.getGenero().equals(Genero.FEMENINO)) {
						calculadora = new CalculadoraMujer();
					}
					else {
						calculadora = new CalculadoraHombre();
						System.out.println("Soy hombre");
					}
					
					DistribucionMacronutrientes desgloseMacrosUsuario = calculadora.calculoHabitosCorrectos(usuario);
					paintDesgloseMacrosUsuario(desgloseMacrosUsuario);
				}
			}
		});
		btnCalcular.setBackground(new Color(209, 211, 242));
		btnCalcular.setBounds(499, 520, 89, 23);
		JFrame.getContentPane().add(btnCalcular);
		
		
	// -- Panel (backrground) de la lista de alimentos -- //
		
		JTextPane backroundCalculo = new JTextPane();
		backroundCalculo.setEditable(false);
		backroundCalculo.setBackground(new Color(250, 209, 255));
		backroundCalculo.setBounds(37, 554, 960, 143);
		JFrame.getContentPane().add(backroundCalculo);
		
		JTextPane backgroundListado = new JTextPane();
		backgroundListado.setEditable(false);
		backgroundListado.setBackground(new Color(207, 186, 240));
		backgroundListado.setBounds(10, 104, 1015, 628);
		JFrame.getContentPane().add(backgroundListado);
		
	}
	
	private void initializeVerifiers() {
		positiveDoubleVerifier = new PositiveDoubleVerifier();
		positiveIntVerifier = new PositiveIntVerifier();
	}
	
	/**
	 * Recoge la información de los textFields y crea un nuevo objeto de la clase Persona
	 * para poder settearle la información recogida de los textFields.
	 * 
	 * @return objeto persona creada con la información correspondiente.
	 * @author Ana
	 */
	private Persona crearPersona() {		
		Persona persona = new Persona();


	// --Obtener la información de los TextFields-- //

		String nombreS = textFieldNombrePers.getText();
		String edadS = textFieldEdad.getText();
		String pesoS = textFieldPeso.getText();
		String alturaS = textFieldAltura.getText();
		ActividadFisica actFisicaS = (ActividadFisica) comboBoxActFisica.getSelectedItem();
		Genero generoS = (Genero) comboBoxGenero.getSelectedItem();


	// --Convertir Strings en ints-- //

		Integer edad = Integer.parseInt(edadS);
		Integer peso = Integer.parseInt(pesoS);
		Integer altura = Integer.parseInt(alturaS);


	// --Settear la información para el objeto Persona-- //

		persona.setNombre(nombreS);
		persona.setEdad(edad);
		persona.setPeso(peso);
		persona.setAltura(altura);
		persona.setActividadFisica(actFisicaS);
		persona.setGenero(generoS);
		persona.setAlimentosDiarios(alimentosCantidad);

		return persona;
	}
	
	/**
	 * Recoge la información de los textFields y crea un nuevo objeto de la clase Alimento
	 * para poder settearle la información recogida de los textFields.
	 * 
	 * @return objeto alimento creado con la información correspondiente.
	 * @author Ana
	 */
	private Alimento crearAlimento() {
		Alimento alimento = new Alimento();
		String nombre = textFieldNombreAlimento.getText();
		String energiaS = textFieldEnergia.getText();
		String hidratosS = textFieldHidratos.getText(); 
		String azucarS = textFieldAzucares.getText();
		String grasasS = textFieldGrasas.getText();
		String saturadasS = textFieldSaturadas.getText();
		String proteinasS = textFieldProteinas.getText();
		String salS = textFieldSal.getText();
		
		
		Double energia = Double.parseDouble(energiaS);
		Double hidratos = Double.parseDouble(hidratosS);
		Double azucar = Double.parseDouble(azucarS);
		Double grasas = Double.parseDouble(grasasS);
		Double saturadas = Double.parseDouble(saturadasS);
		Double proteinas = Double.parseDouble(proteinasS);
		Double sal = Double.parseDouble(salS);
		
		alimento.setNombre(nombre);
		alimento.setEnergia(energia);
		alimento.setHidratosCarbono(hidratos);
		alimento.setAzucar(azucar);
		alimento.setGrasas(grasas);
		alimento.setGrasasSaturadas(saturadas);
		alimento.setProteinas(proteinas);
		alimento.setSal(sal);		

		return alimento;
	}

	/**
	 * Limpia los texField de los atributos del Alimento.
	 * 
	 * @author Ana
	 */
	private void limpiarPanelAlimento() {
		textFieldNombreAlimento.setText("");
		textFieldEnergia.setText("");
		textFieldHidratos.setText("");
		textFieldAzucares.setText("");
		textFieldGrasas.setText("");
		textFieldSaturadas.setText("");
		textFieldProteinas.setText("");
		textFieldSal.setText("");
		textFieldCalcio.setText("");
		textFieldHierro.setText("");
	}

	private void intializePanelListaAlimentos() {
		paintCabeceraPanelListaAlimentos();
		inicializarListaAlimentosDefault();
		//Pintar lista alimentos		
		disableButtonsPanelListaAlimentos(); 
	}
	
	/**
	 * Pinta en la GUI la cabecera de panelListaAlimentos
	 * @author Marta
	 */
	private void paintCabeceraPanelListaAlimentos() {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblNombre);

		JLabel lblCantidad = new JLabel("Gramos consumidos");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblCantidad);

		JLabel lblEnergia = new JLabel("Kcal");
		lblEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblEnergia);

		JLabel lblHidratosCarbono = new JLabel("Hidratos de Carbono");
		lblHidratosCarbono.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHidratosCarbono);

		JLabel lblAzucar = new JLabel("Azucar");
		lblAzucar.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblAzucar);

		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasas);

		JLabel lblGrasasSaturadas = new JLabel("Grasas saturadas");
		lblGrasasSaturadas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasasSaturadas);

		JLabel lblProteinas = new JLabel("Proteinas");
		lblProteinas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblProteinas);

		JLabel lblSal = new JLabel("Sal");
		lblSal.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblSal);

		JLabel lblCalcio = new JLabel("Calcio");
		lblCalcio.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblCalcio);

		JLabel lblHierro = new JLabel("Hierro");
		lblHierro.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHierro);

		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblEliminar);
	}
	
	/**
	 * Deshabilita todos los botones de panelListaAlimentos creados antes de la llamada a este metodo
	 * @author Marta
	 */
	private void disableButtonsPanelListaAlimentos() {
		Component[] comp = panelListaAlimentos.getComponents();
		for(int i = 0; i < comp.length; i++) {
			if(comp[i] instanceof JButton) {
				JButton button = (JButton) comp[i];
				button.setEnabled(false);
			}
		}
	}

	/**
	 * Aï¿½ade una nueva fila al panelListaAlimentos con la informacion del alimento
	 * 
	 * Crea un AlimentoCantidad asignando alimento y 0 a los gramos.
	 * Crea un TextField para introducir los gramos consumidos, un JCheckBox con el nombre del alimento y JLabel con la informacion del alimento
	 *  
	 * @param alimento alimento a aï¿½adir
	 * @author Marta
	 */
	private void addRowAlimento(Alimento alimento) {		
		AlimentoCantidad alimentoCantidad = new AlimentoCantidad(alimento, 0);
		alimentosCantidad.add(alimentoCantidad);

		//Conversion atributos alimento a String
		double energia = alimento.getEnergia();
		String textEnergia = Double.toString(energia);

		double hidratos = alimento.getHidratosCarbono();
		String textHidratos = Double.toString(hidratos);

		double azucar = alimento.getAzucar();
		String textAzucar = Double.toString(azucar);

		double grasas = alimento.getGrasas();
		String textGrasas = Double.toString(grasas);

		double grasasSaturadas = alimento.getGrasasSaturadas();
		String textGrasasSaturadas = Double.toString(grasasSaturadas);

		double proteinas = alimento.getProteinas();
		String textProteinas = Double.toString(proteinas);

		double sal = alimento.getSal();
		String textSal = Double.toString(sal);

		double calcio = alimento.getCalcio();
		String textCalcio = Double.toString(calcio);

		double hierro = alimento.getHierro();
		String textHierro = Double.toString(hierro);

		//Aï¿½adir elementos GUI
		JCheckBox chckbxAlimento = new JCheckBox(alimento.getNombre());
		chckbxAlimento.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlimento.setBackground(new Color(250,209,255));
		panelListaAlimentos.add(chckbxAlimento);

		JTextField gramosConsumidos = new JTextField();
		gramosConsumidos.setInputVerifier(positiveDoubleVerifier);
		gramosConsumidos.setText("0");
		gramosConsumidos.setHorizontalAlignment(SwingConstants.CENTER);		
		gramosConsumidos.setColumns(10);		
		gramosConsumidos.setEditable(false);
		gramosConsumidos.setBackground(new Color(250,209,255));
		gramosConsumidos.setBorder(BorderFactory.createEmptyBorder());
		panelListaAlimentos.add(gramosConsumidos);

		JLabel lblEnergia = new JLabel(textEnergia);
		lblEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblEnergia);

		JLabel lblHidratosCarbono = new JLabel(textHidratos);
		lblHidratosCarbono.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHidratosCarbono);

		JLabel lblAzucar = new JLabel(textAzucar);
		lblAzucar.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblAzucar);

		JLabel lblGrasas = new JLabel(textGrasas);
		lblGrasas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasas);

		JLabel lblGrasasSaturadas = new JLabel(textGrasasSaturadas);
		lblGrasasSaturadas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasasSaturadas);

		JLabel lblProteinas = new JLabel(textProteinas);
		lblProteinas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblProteinas);

		JLabel lblSal = new JLabel(textSal);
		lblSal.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblSal);

		JLabel lblCalcio = new JLabel(textCalcio);
		lblCalcio.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblCalcio);

		JLabel lblHierro = new JLabel(textHierro);
		lblHierro.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHierro);

		JButton btnBorrar = new JButton("Eliminar");
		btnBorrar.setHorizontalAlignment(SwingConstants.CENTER);
		btnBorrar.setBackground(new Color(248, 195, 237));
		panelListaAlimentos.add(btnBorrar);

		gramosConsumidos.addFocusListener(new FocusAdapter() {
			/**
			 * Al perder el foco se actualizan los gramos de alimentoCantidad por el valor introducido
			 * 
			 * @author Marta
			 */
			@Override
			public void focusLost(FocusEvent e) {
				String gramosConsumidosText = gramosConsumidos.getText();
				int gramosConsumidos = Integer.parseInt(gramosConsumidosText);
				alimentoCantidad.setGramos(gramosConsumidos);
			}
		});		

		/**
		 * Si el checkbox es true el TextField se habilita sino se deshabilita, se pone el valor del TextField a 0
		 * y se actualizan los gramos de alimentoCantidad a 0
		 * 
		 * @author Marta
		 */
		chckbxAlimento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					gramosConsumidos.setEditable(true);
					gramosConsumidos.setBackground(new Color(254, 247, 255));
				}
				else if(e.getStateChange() == ItemEvent.DESELECTED){
					alimentoCantidad.setGramos(0);
					gramosConsumidos.setText("0");
					gramosConsumidos.setEditable(false);
					gramosConsumidos.setBackground(new Color(250,209,255));
				}
			}
		});

		/**
		 * Elimina el alimentoCantidad de la lista alimentosCantidad, el alimento de la lista alimentos, los elementos de la GUI que componen la fila y repinta el scroll
		 * 
		 * @author Marta
		 */
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelListaAlimentos.remove(chckbxAlimento);
				panelListaAlimentos.remove(gramosConsumidos);
				panelListaAlimentos.remove(lblEnergia);
				panelListaAlimentos.remove(lblHidratosCarbono);
				panelListaAlimentos.remove(lblAzucar);
				panelListaAlimentos.remove(lblGrasas);
				panelListaAlimentos.remove(lblGrasasSaturadas);
				panelListaAlimentos.remove(lblProteinas);
				panelListaAlimentos.remove(lblSal);
				panelListaAlimentos.remove(lblCalcio);
				panelListaAlimentos.remove(lblHierro);
				panelListaAlimentos.remove(btnBorrar);
				scroll.revalidate();
				scroll.repaint();
				alimentosCantidad.remove(alimentoCantidad);	
				alimentos.remove(alimento);
			}
		});
	}	

	/**
	 * Devuelve true si el string de algun TextField del panel persona esta vacio o solo contiene espacios en blanco, sino false
	 * 
	 * @return true si el string de algun TextField del panel persona esta vacio o solo contiene espacios en blanco, sino false
	 * @author Marta
	 */
	private boolean checkTextFieldsPanelPersona() {
		String nombre = textFieldNombrePers.getText();
		String edad = textFieldEdad.getText();
		String altura = textFieldAltura.getText();
		String peso = textFieldPeso.getText();

		boolean nombreNotValid = nombre.isBlank() || nombre.isEmpty();
		boolean edadNotValid   = edad.isBlank()   || edad.isEmpty();
		boolean alturaNotValid = altura.isBlank() || altura.isEmpty();
		boolean pesoNotValid   = peso.isBlank()   || peso.isEmpty();

		return nombreNotValid || edadNotValid || alturaNotValid || pesoNotValid;		
	}
	
	/**
	 * Calcula el total de macronutrientes ingeridos por el usuario teniendo en cuenta si es hombre o mujer
	 * 
	 * @return desglose de macronutrientes totales del usuario
	 * @author Marta
	 */
	private DistribucionMacronutrientes calculateDesgloseMacrosUsuario() {					
		Calculadora calculadora;
		Genero generoUsuario = usuario.getGenero();

		if(generoUsuario.equals(Genero.FEMENINO)) {
			calculadora = new CalculadoraMujer();
		}
		else {
			calculadora = new CalculadoraHombre();			
		}

		DistribucionMacronutrientes desgloseMacrosUsuario = calculadora.calculoHabitosCorrectos(usuario);

		return desgloseMacrosUsuario;
	}
	
	/**
	 * Muestra en la GUI el desglose de macronutrientes del usuario y su IMC. 
	 * Los valores se mostraran con el formato decimal "#.##"
	 * Si los valores son mayores a los recomendados seran mostrados en rojo si no seran mostrados en negro
	 * 
	 * @param desgloseMacrosUsuario el desglose de los macronutrientes del usuario 
	 * @author Marta
	 */
	private void paintDesgloseMacrosUsuario(DistribucionMacronutrientes desgloseMacrosUsuario) {
		DecimalFormat dformat = new DecimalFormat("#.##");

		//Energia
		double energiaTotal = desgloseMacrosUsuario.getEnergiaTotal();
		String energiaTotalText = dformat.format(energiaTotal);
		textFieldEnergiaTot.setText(energiaTotalText);

		if(!desgloseMacrosUsuario.isCantidadEnergiaAdecuada()) {
			textFieldEnergiaTot.setForeground(Color.red);
		}
		else textFieldEnergiaTot.setForeground(Color.black);

		//Azucar
		double azucarTotal = desgloseMacrosUsuario.getAzucarTotal();
		String azucarTotalText = dformat.format(azucarTotal);
		textFieldAzucarTot.setText(azucarTotalText);

		if(!desgloseMacrosUsuario.isCantidadAzucarAdecuada()) {
			textFieldAzucarTot.setForeground(Color.red);
		}
		else textFieldAzucarTot.setForeground(Color.black);

		//Grasas
		double grasasTotales = desgloseMacrosUsuario.getGrasasTotales();
		String grasasTotalesText = dformat.format(grasasTotales);
		textFieldGrasasTot.setText(grasasTotalesText);

		if(!desgloseMacrosUsuario.isCantidadGrasasAdecuada()) {
			textFieldGrasasTot.setForeground(Color.red);
		}
		else textFieldGrasasTot.setForeground(Color.black);

		//Sal
		double salTotal = desgloseMacrosUsuario.getSalTotal();
		String salTotalText = dformat.format(salTotal);
		textFieldSalTot.setText(salTotalText);

		if(!desgloseMacrosUsuario.isCantidadSalAdecuada()) {
			textFieldSalTot.setForeground(Color.red);
		}
		else textFieldSalTot.setForeground(Color.black);

		//IMC
		double imc = usuario.getImc();
		String imcText = dformat.format(imc);
		textFieldImc.setText(imcText);
	}
	
	
	/**
	 * Crea los alimentos que por defecto estarñan en la lista de alimentos.
	 * 
	 * @return 
	 * @author Ana
	 */
	private void inicializarListaAlimentosDefault() {
		
		// -- Alimento default macarrones -- //
		
		Alimento macarrones = new Alimento();
		macarrones.setNombre("Macarrones");
        macarrones.setEnergia(349);
        macarrones.setGrasas(1.5);
        macarrones.setGrasasSaturadas(0.3);
        macarrones.setHidratosCarbono(70);
        macarrones.setAzucar(2.9);
        macarrones.setProteinas(12);
        macarrones.setSal(0.03);
        
        
     // -- Alimento default leche vaca semidesnatada -- //
		
        Alimento lecheVacaSemi = new Alimento();
        lecheVacaSemi.setNombre("Leche de Vaca Semidesnatada");
        lecheVacaSemi.setEnergia(45);
        lecheVacaSemi.setGrasas(1.5);
        lecheVacaSemi.setGrasasSaturadas(1);
        lecheVacaSemi.setHidratosCarbono(4.7);
        lecheVacaSemi.setAzucar(4.7);
        lecheVacaSemi.setProteinas(3.2);
        lecheVacaSemi.setSal(0.13);
        
        
        // -- Alimento default pan -- //
        
        Alimento pan = new Alimento();
        pan.setNombre("Pan");
        pan.setEnergia(277);
        pan.setGrasas(1);
        pan.setGrasasSaturadas(0.66);
        pan.setHidratosCarbono(58);
        pan.setAzucar(5);
        pan.setProteinas(7.8);
        pan.setSal(540);
        
        // -- Alimento default platano -- //
        
        Alimento platano = new Alimento();
        platano.setNombre("Platano");
        platano.setEnergia(94);
        platano.setGrasas(0.3);
        platano.setGrasasSaturadas(0.24);
        platano.setHidratosCarbono(20);
        platano.setAzucar(12);
        platano.setProteinas(1.2);
        platano.setSal(1);
        
        
        // -- Alimento default cereales arroz chocolate -- //
        
        Alimento cerealesArrozChocolate = new Alimento();
        cerealesArrozChocolate.setNombre("Cereales de arroz con chocolate");
        cerealesArrozChocolate.setEnergia(345);
        cerealesArrozChocolate.setGrasas(2.6);
        cerealesArrozChocolate.setGrasasSaturadas(1.0);
        cerealesArrozChocolate.setHidratosCarbono(70);
        cerealesArrozChocolate.setAzucar(22);
        cerealesArrozChocolate.setProteinas(7.2);
        cerealesArrozChocolate.setSal(0.23);
        
        
        // -- Alimento default ketchup -- //
        
        Alimento ketchup = new Alimento();
        ketchup.setNombre("Ketchup");
        ketchup.setEnergia(106);
        ketchup.setGrasas(0.2);
        ketchup.setGrasasSaturadas(0.0);
        ketchup.setHidratosCarbono(24);
        ketchup.setAzucar(20);
        ketchup.setProteinas(1.6);
        ketchup.setSal(2.0);
        

        // -- Añadir alimentos al ArrayList -- //

        alimentos.add(macarrones);
        alimentos.add(lecheVacaSemi);
        alimentos.add(pan);
        alimentos.add(platano);
        alimentos.add(cerealesArrozChocolate);
        alimentos.add(ketchup);
        
        
        // -- Pintar los alimentos deffault -- //
       
        paintRowsAlimentosDefault();

	}
	
	private void paintRowsAlimentosDefault() {
		for(int i= 0; i < alimentos.size(); i++) {
			 Alimento alimento = alimentos.get(i);
			addRowAlimento(alimento);
		}
	}
	
}