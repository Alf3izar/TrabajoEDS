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
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

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

public class CalculadoraMacronutrientes {

	// -- Paneles -- //

	private JFrame JFrame;	
	private JPanel panelListaAlimentos;
	private JScrollPane scroll;
	private JPanel backgroundGeneralListaAlimentos;

	// -- Fields Persona -- //

	private JTextField textFieldNombrePers;
	private JTextField textFieldEdad;
	private JTextField textFieldPeso;
	private JLabel lblResultImc;
	private JTextField textFieldAltura;
	private JComboBox<ActividadFisica> comboBoxActFisica;
	private JComboBox<Genero> comboBoxSexo;

	// -- Fields Alimento -- //

	private JTextField textFieldGrasas;
	private JTextField textFieldNombreAlimento;
	private JTextField textFieldSaturadas;
	private JTextField textFieldHidratos;
	private JTextField textFieldAzucares;
	private JTextField textFieldProteinas;
	private JTextField textFieldSal;
	private JTextField textFieldCalcio;
	private JTextField textFieldHierro;
	private JTextField textFieldEnergia;

	// -- Fields Calculo -- //

	private JLabel lblEnergiaTotCalc;
	private JLabel lblSalTotCalc;
	private JLabel lblGrasasTotCalc;
	private JLabel lblGrasasSatTotCalc;
	private JLabel lblHidratosCarbTotCalc;
	private JLabel lblAzucarTotCalc;
	private JLabel lblHierroTotCalc;
	private JLabel lblCalcioTotCalc;

	// -- Otros atributos necesarios -- //

	private Persona usuario;
	private ArrayList<AlimentoCantidad> alimentosCantidad = new ArrayList<AlimentoCantidad>();
	private ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

	// -- Verificadores -- //

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
		initializeVerifiers();
		inicializarVentana();
		inicializarPanelPersona();
		inicializarPanelAlimento();
		intializePanelListaAlimentos();
		inicializarPanelCalculo();
	}

	/**
	 * Inicializa la ventana principal del programa.
	 * 
	 * @author Ana
	 */
	private void inicializarVentana() {
		JFrame = new JFrame();
		JFrame.setTitle("Calculadora de nutrientes");
		JFrame.setBounds(100, 100, 1338, 773);
		JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JFrame.getContentPane().setLayout(null);
	}

	/**
	 * Inicializa los verificadores 
	 * 
	 * @author Ana
	 */
	private void initializeVerifiers() {
		positiveDoubleVerifier = new PositiveDoubleVerifier();
		positiveIntVerifier = new PositiveIntVerifier();
	}

	/**
	 * Inicializa todos los componentes del panel de la persona.
	 * 
	 * @author Ana
	 */
	private void inicializarPanelPersona() {

		// -- Panel (backrground) de la persona -- //

		JPanel backroundPers = new JPanel();
		backroundPers.setBackground(new Color(251, 248, 204));
		backroundPers.setBounds(10, 11, 1304, 94);
		JFrame.getContentPane().add(backroundPers);
		backroundPers.setLayout(null);

		// -- Información -- //

		JLabel lblInfoPers = new JLabel("1.- Introduzca sus datos para obtener un cálculo personalizado sobre sus ingestas diarias: ");
		lblInfoPers.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoPers.setBounds(349, 11, 616, 31);
		backroundPers.add(lblInfoPers);

		// -- Nombre de la persona -- //

		JLabel lblNombrePers = new JLabel("Nombre:");
		lblNombrePers.setForeground(Color.BLACK);
		lblNombrePers.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNombrePers.setBounds(44, 56, 77, 14);
		backroundPers.add(lblNombrePers);

		textFieldNombrePers = new JTextField();
		textFieldNombrePers.setBounds(116, 53, 97, 20);
		backroundPers.add(textFieldNombrePers);
		textFieldNombrePers.setColumns(10);

		// -- Genero de la persona -- //

		JLabel lblGenero = new JLabel("Género:");
		lblGenero.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setBounds(239, 56, 61, 14);
		backroundPers.add(lblGenero);

		comboBoxSexo = new JComboBox<Genero>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<Genero>(Genero.values()));
		comboBoxSexo.setBounds(305, 53, 104, 20);
		backroundPers.add(comboBoxSexo);

		// -- Edad de la persona -- //

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEdad.setBounds(445, 56, 52, 14);
		backroundPers.add(lblEdad);

		textFieldEdad = new JTextField();
		textFieldEdad.setInputVerifier(positiveIntVerifier);
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(494, 53, 66, 20);
		backroundPers.add(textFieldEdad);

		JLabel lblAnyos = new JLabel("años");
		lblAnyos.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblAnyos.setBounds(563, 56, 46, 14);
		backroundPers.add(lblAnyos);

		// -- Peso de la persona -- //

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPeso.setBounds(627, 56, 61, 14);
		backroundPers.add(lblPeso);

		textFieldPeso = new JTextField();
		textFieldPeso.setInputVerifier(positiveDoubleVerifier);
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(678, 53, 66, 20);
		backroundPers.add(textFieldPeso);

		JLabel lblkg = new JLabel("kg");
		lblkg.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblkg.setBounds(748, 56, 34, 14);
		backroundPers.add(lblkg);

		// -- Altura de la persona -- //

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAltura.setBounds(781, 54, 52, 19);
		backroundPers.add(lblAltura);

		textFieldAltura = new JTextField();
		textFieldAltura.setInputVerifier(positiveIntVerifier);
		textFieldAltura.setBounds(837, 53, 86, 20);
		backroundPers.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCm.setBounds(927, 56, 20, 15);
		backroundPers.add(lblCm);

		// -- Actividad Física de la persona -- //

		JLabel lblActFisica = new JLabel("Actividad física:");
		lblActFisica.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblActFisica.setBounds(967, 54, 111, 19);
		backroundPers.add(lblActFisica);

		comboBoxActFisica = new JComboBox<ActividadFisica>();
		comboBoxActFisica.setModel(new DefaultComboBoxModel<ActividadFisica>(ActividadFisica.values()));
		comboBoxActFisica.setBounds(1068, 53, 83, 20);
		backroundPers.add(comboBoxActFisica);

		// -- IMC de la persona (autocalculable) -- //

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblImc.setBounds(1173, 54, 37, 19);
		backroundPers.add(lblImc);

		lblResultImc = new JLabel("0");
		lblResultImc.setBounds(1217, 54, 53, 18);
		backroundPers.add(lblResultImc);
	}

	/**
	 * Inicializa todos los componentes del panel del alimento.
	 * 
	 * @author Ana
	 */
	private void inicializarPanelAlimento() {

		// -- Paneles (backrground) del alimento -- //

		JPanel backroundAddAlim = new JPanel();
		backroundAddAlim.setBackground(new Color(192, 250, 255));
		backroundAddAlim.setBounds(1025, 104, 289, 628);
		JFrame.getContentPane().add(backroundAddAlim);
		backroundAddAlim.setLayout(null);

		JPanel backgroundInfoNutricional = new JPanel();
		backgroundInfoNutricional.setBackground(new Color(192, 250, 255));
		backgroundInfoNutricional.setBounds(0, 162, 289, 466);
		backroundAddAlim.add(backgroundInfoNutricional);

		// -- Información -- //

		JLabel lblInfoAlimOp = new JLabel("OPCIONAL");
		lblInfoAlimOp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAlimOp.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoAlimOp.setBounds(105, 11, 83, 18);
		backroundAddAlim.add(lblInfoAlimOp);

		JLabel lblInfoAl1 = new JLabel("Añadir un alimento a la lista:");
		lblInfoAl1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoAl1.setBounds(44, 40, 205, 18);
		backroundAddAlim.add(lblInfoAl1);

		JLabel lblInfoNutricional = new JLabel("Información nutricional                     100gr.");
		lblInfoNutricional.setFont(new Font("Dialog", Font.BOLD, 11));
		lblInfoNutricional.setBounds(10, 136, 269, 15);
		backroundAddAlim.add(lblInfoNutricional);

		// -- Nombre del alimento -- //

		JLabel lblNombreAlimento = new JLabel("Nombre:");
		lblNombreAlimento.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNombreAlimento.setBounds(20, 88, 73, 19);
		backroundAddAlim.add(lblNombreAlimento);

		textFieldNombreAlimento = new JTextField();
		textFieldNombreAlimento.setBounds(103, 87, 159, 20);
		backroundAddAlim.add(textFieldNombreAlimento);
		textFieldNombreAlimento.setColumns(10);
		backgroundInfoNutricional.setLayout(null);

		// -- Energía del alimento -- //

		JLabel lblEnergia = new JLabel("Energía:");
		lblEnergia.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEnergia.setBounds(10, 11, 64, 19);
		backgroundInfoNutricional.add(lblEnergia);

		textFieldEnergia = new JTextField();
		textFieldEnergia.setColumns(10);
		textFieldEnergia.setBounds(168, 10, 86, 20);
		textFieldEnergia.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldEnergia);

		JLabel lblKcal1 = new JLabel("kcal");
		lblKcal1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblKcal1.setBounds(258, 11, 31, 19);
		backgroundInfoNutricional.add(lblKcal1);

		// -- Grasas del alimento -- //

		JLabel lblGrasas = new JLabel("Grasas:");
		lblGrasas.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasas.setBounds(10, 56, 64, 19);
		backgroundInfoNutricional.add(lblGrasas);

		textFieldGrasas = new JTextField();
		textFieldGrasas.setBounds(168, 55, 86, 20);
		textFieldGrasas.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldGrasas);
		textFieldGrasas.setColumns(10);

		JLabel lblGr4 = new JLabel("gr");
		lblGr4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr4.setBounds(258, 56, 25, 19);
		backgroundInfoNutricional.add(lblGr4);

		// -- Grasas saturadas del alimento -- //

		JLabel lblGrasasSat = new JLabel("de las cuales saturadas:");
		lblGrasasSat.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasSat.setBounds(10, 100, 179, 19);
		backgroundInfoNutricional.add(lblGrasasSat);

		textFieldSaturadas = new JTextField();
		textFieldSaturadas.setColumns(10);
		textFieldSaturadas.setBounds(168, 99, 86, 20);
		textFieldSaturadas.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldSaturadas);

		JLabel lblGr5 = new JLabel("gr");
		lblGr5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr5.setBounds(258, 100, 25, 19);
		backgroundInfoNutricional.add(lblGr5);

		// -- Hidratos de carbono del alimento -- //

		JLabel lblHidratos = new JLabel("Hidratos de carbono:");
		lblHidratos.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHidratos.setBounds(10, 144, 148, 19);
		backgroundInfoNutricional.add(lblHidratos);

		textFieldHidratos = new JTextField();
		textFieldHidratos.setColumns(10);
		textFieldHidratos.setBounds(168, 143, 86, 20);
		textFieldHidratos.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldHidratos);

		JLabel lblGr6 = new JLabel("gr");
		lblGr6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr6.setBounds(258, 144, 25, 19);
		backgroundInfoNutricional.add(lblGr6);

		// -- Azúcares del alimento -- //

		JLabel lblAzucar = new JLabel("de los cuales azúcares:");
		lblAzucar.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAzucar.setBounds(10, 192, 160, 19);
		backgroundInfoNutricional.add(lblAzucar);

		textFieldAzucares = new JTextField();
		textFieldAzucares.setColumns(10);
		textFieldAzucares.setBounds(168, 191, 86, 20);
		textFieldAzucares.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldAzucares);

		JLabel lblGr7 = new JLabel("gr");
		lblGr7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr7.setBounds(258, 192, 25, 19);
		backgroundInfoNutricional.add(lblGr7);

		// -- Proteínas del alimento -- //

		JLabel lblProteinas = new JLabel("Proteínas:");
		lblProteinas.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProteinas.setBounds(10, 235, 86, 19);
		backgroundInfoNutricional.add(lblProteinas);

		textFieldProteinas = new JTextField();
		textFieldProteinas.setColumns(10);
		textFieldProteinas.setBounds(168, 234, 86, 20);
		textFieldProteinas.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldProteinas);

		JLabel lblGr8 = new JLabel("gr");
		lblGr8.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr8.setBounds(258, 235, 25, 19);
		backgroundInfoNutricional.add(lblGr8);

		// -- Sal del alimento -- //

		JLabel lblSal = new JLabel("Sal:");
		lblSal.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSal.setBounds(10, 276, 43, 19);
		backgroundInfoNutricional.add(lblSal);

		textFieldSal = new JTextField();
		textFieldSal.setColumns(10);
		textFieldSal.setBounds(168, 275, 86, 20);
		textFieldSal.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldSal);

		JLabel lblGr9 = new JLabel("gr");
		lblGr9.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr9.setBounds(258, 276, 25, 19);
		backgroundInfoNutricional.add(lblGr9);

		// -- Calcio del alimento -- //

		JLabel lblCalcio = new JLabel("Calcio:");
		lblCalcio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCalcio.setBounds(10, 322, 64, 19);
		backgroundInfoNutricional.add(lblCalcio);

		textFieldCalcio = new JTextField();
		textFieldCalcio.setColumns(10);
		textFieldCalcio.setBounds(168, 321, 86, 20);
		textFieldCalcio.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldCalcio);

		JLabel lblGr10 = new JLabel("gr");
		lblGr10.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr10.setBounds(258, 322, 25, 19);
		backgroundInfoNutricional.add(lblGr10);

		// -- Hierro del alimento -- //

		JLabel lblHierro = new JLabel("Hierro:");
		lblHierro.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHierro.setBounds(10, 373, 64, 19);
		backgroundInfoNutricional.add(lblHierro);

		textFieldHierro = new JTextField();
		textFieldHierro.setColumns(10);
		textFieldHierro.setBounds(168, 372, 86, 20);
		textFieldHierro.setInputVerifier(positiveDoubleVerifier);
		backgroundInfoNutricional.add(textFieldHierro);

		JLabel lblGr11 = new JLabel("gr");
		lblGr11.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr11.setBounds(258, 373, 25, 19);
		backgroundInfoNutricional.add(lblGr11);

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
				try {
					Alimento alimento = crearAlimento();		
					alimentos.add(alimento);

					addRowAlimento(alimento);
					scroll.revalidate();
					scroll.repaint();
					limpiarPanelAlimento();
				}
				catch(IllegalArgumentException e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnAddAlimento.setBackground(new Color(191, 234, 237));
		btnAddAlimento.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAddAlimento.setBounds(109, 415, 80, 25);
		backgroundInfoNutricional.add(btnAddAlimento);
	}

	/**
	 * Inicializa todos los componentes del panel de la lista de alimentos.
	 * 
	 * @author Ana
	 */
	private void inicializarElementosGUIPanelPersona() {

		// -- Panel general de la lista de los alimentos -- //

		backgroundGeneralListaAlimentos = new JPanel();
		backgroundGeneralListaAlimentos.setBackground(new Color(207, 186, 240));
		backgroundGeneralListaAlimentos.setBounds(10, 104, 1015, 628);
		JFrame.getContentPane().add(backgroundGeneralListaAlimentos);
		backgroundGeneralListaAlimentos.setLayout(null);

		// -- Información -- //

		JLabel lblInfoLista = new JLabel("2.- Listado de los alimentos:");
		lblInfoLista.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInfoLista.setBounds(406, 11, 204, 14);
		backgroundGeneralListaAlimentos.add(lblInfoLista);

		// -- Panel que contiene los alimentos creados -- //

		panelListaAlimentos = new JPanel();		
		scroll = new JScrollPane(panelListaAlimentos);
		panelListaAlimentos.setBackground(new Color(250, 209, 255));
		panelListaAlimentos.setBackground(new Color(250, 209, 255));
		panelListaAlimentos.setLayout(new GridLayout(0, 12, 0, 5));
		scroll.setBounds(26, 52, 967, 362);		
		backgroundGeneralListaAlimentos.add(scroll);
	}

	private void inicializarPanelCalculo() {
		// -- Panel que contiene los resultados del calculo -- //	

		JPanel backroundCalculo = new JPanel();
		backroundCalculo.setBounds(26, 461, 963, 140);
		backgroundGeneralListaAlimentos.add(backroundCalculo);
		backroundCalculo.setBackground(new Color(250, 209, 255));
		backroundCalculo.setLayout(null);

		// -- Información del calculo -- //

		JLabel lblTotMacro = new JLabel("Valores totales de los nutrientes:");
		lblTotMacro.setBounds(383, 14, 268, 18);
		backroundCalculo.add(lblTotMacro);
		lblTotMacro.setFont(new Font("Dialog", Font.BOLD, 13));

		// -- Energía total calculada -- //

		JLabel lblEngTot = new JLabel("Energ\u00EDa:");
		lblEngTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEngTot.setBounds(34, 63, 74, 19);
		backroundCalculo.add(lblEngTot);

		lblEnergiaTotCalc = new JLabel("-");
		lblEnergiaTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergiaTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEnergiaTotCalc.setBounds(88, 65, 74, 14);
		backroundCalculo.add(lblEnergiaTotCalc);

		JLabel lblKcal = new JLabel("kcal");
		lblKcal.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblKcal.setBounds(172, 65, 46, 14);
		backroundCalculo.add(lblKcal);

		// -- Sales totales calculadas -- //

		JLabel lblSalTot = new JLabel("Sal:");
		lblSalTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSalTot.setBounds(34, 93, 74, 14);
		backroundCalculo.add(lblSalTot);

		lblSalTotCalc = new JLabel("-");
		lblSalTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSalTotCalc.setBounds(88, 93, 74, 14);
		backroundCalculo.add(lblSalTotCalc);

		JLabel lblGr = new JLabel("gr");
		lblGr.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr.setBounds(172, 91, 46, 19);
		backroundCalculo.add(lblGr);		

		// -- Grasas totales calculadas -- //

		JLabel lblGrasasTot = new JLabel("Grasas:");
		lblGrasasTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasTot.setBounds(222, 65, 74, 14);
		backroundCalculo.add(lblGrasasTot);

		lblGrasasTotCalc = new JLabel("-");
		lblGrasasTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrasasTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasTotCalc.setBounds(333, 65, 74, 14);
		backroundCalculo.add(lblGrasasTotCalc);

		JLabel lblGr2 = new JLabel("gr");
		lblGr2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr2.setBounds(417, 62, 46, 20);
		backroundCalculo.add(lblGr2);

		// -- Grasas saturadas totales calculadas -- //

		JLabel lblGrasasSatTot = new JLabel("Grasas saturadas:");
		lblGrasasSatTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasSatTot.setBounds(222, 93, 153, 14);
		backroundCalculo.add(lblGrasasSatTot);

		lblGrasasSatTotCalc = new JLabel("-");
		lblGrasasSatTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrasasSatTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGrasasSatTotCalc.setBounds(333, 93, 74, 14);
		backroundCalculo.add(lblGrasasSatTotCalc);

		JLabel lblGr3 = new JLabel("gr");
		lblGr3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr3.setBounds(417, 90, 46, 20);
		backroundCalculo.add(lblGr3);

		// -- Hidratos de carbono totales calculados -- //

		JLabel lblHidratosCarbonoTot = new JLabel("Hidratos de carbono:");
		lblHidratosCarbonoTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHidratosCarbonoTot.setBounds(459, 65, 147, 14);
		backroundCalculo.add(lblHidratosCarbonoTot);

		lblHidratosCarbTotCalc = new JLabel("-");
		lblHidratosCarbTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHidratosCarbTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHidratosCarbTotCalc.setBounds(590, 65, 74, 14);
		backroundCalculo.add(lblHidratosCarbTotCalc);

		JLabel lblGr4 = new JLabel("gr");
		lblGr4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr4.setBounds(674, 63, 46, 19);
		backroundCalculo.add(lblGr4);

		// -- Azúcares totales calculadas -- //

		JLabel lblAzucaresTot = new JLabel("Az\u00FAcares:");
		lblAzucaresTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAzucaresTot.setBounds(459, 93, 74, 14);
		backroundCalculo.add(lblAzucaresTot);

		lblAzucarTotCalc = new JLabel("-");
		lblAzucarTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAzucarTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAzucarTotCalc.setBounds(590, 93, 74, 14);
		backroundCalculo.add(lblAzucarTotCalc);

		JLabel lblGr5 = new JLabel("gr");
		lblGr5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr5.setBounds(674, 91, 46, 19);
		backroundCalculo.add(lblGr5);

		// -- Total de hierros calculados -- //

		JLabel lblHierroTot = new JLabel("Hierro:");
		lblHierroTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHierroTot.setBounds(722, 65, 74, 14);
		backroundCalculo.add(lblHierroTot);

		lblHierroTotCalc = new JLabel("-");
		lblHierroTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierroTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblHierroTotCalc.setBounds(787, 65, 74, 14);
		backroundCalculo.add(lblHierroTotCalc);

		JLabel lblGr6 = new JLabel("gr");
		lblGr6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr6.setBounds(871, 63, 46, 19);
		backroundCalculo.add(lblGr6);

		// -- Total de calcios calculados -- //

		JLabel lblCalcioTot = new JLabel("Calcio:");
		lblCalcioTot.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCalcioTot.setBounds(722, 93, 74, 14);
		backroundCalculo.add(lblCalcioTot);

		lblCalcioTotCalc = new JLabel("-");
		lblCalcioTotCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalcioTotCalc.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCalcioTotCalc.setBounds(787, 93, 74, 14);
		backroundCalculo.add(lblCalcioTotCalc);

		JLabel lblGr7 = new JLabel("gr");
		lblGr7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGr7.setBounds(871, 91, 46, 19);
		backroundCalculo.add(lblGr7);

		// -- Botón calcular -- //

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(460, 427, 96, 23);
		backgroundGeneralListaAlimentos.add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			/**
			 * Comprueba que los TextField del panel persona estan todos rellenos sino muestra una ventana de dialogo para informar al usuario
			 * Inicializa el usuario con los datos en el panel persona
			 * Calcula el desglose de los macronutrientes para la persona creada
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

					DistribucionMacronutrientes desgloseMacrosUsuario = calculateDesgloseMacrosUsuario();
					paintDesgloseMacrosUsuario(desgloseMacrosUsuario);
				}
			}
		});
		btnCalcular.setBackground(new Color(209, 211, 242));
	}

	/**
	 * Inicializa el panelListaAlimentos
	 * @author Marta
	 */
	private void intializePanelListaAlimentos() {
		inicializarElementosGUIPanelPersona();
		paintCabeceraPanelListaAlimentos();
		inicializarListaAlimentosDefault();
		paintRowsAlimentosDefault();		
		disableButtonsPanelListaAlimentos();
	}

	/**
	 * Recoge la información de los textFields y crea un nuevo objeto de la clase Alimento
	 * para poder settearle la información recogida de los textFields.
	 * 
	 * @return objeto alimento creado con la información correspondiente.
	 * @author Ana
	 */
	private Alimento crearAlimento() throws IllegalArgumentException{		
		Alimento alimento = new Alimento();
		String nombre = textFieldNombreAlimento.getText();
		String energiaS = textFieldEnergia.getText();
		String hidratosS = textFieldHidratos.getText(); 
		String azucarS = textFieldAzucares.getText();
		String grasasS = textFieldGrasas.getText();
		String saturadasS = textFieldSaturadas.getText();
		String proteinasS = textFieldProteinas.getText();
		String salS = textFieldSal.getText();
		String hierroS = textFieldHierro.getText();
		String calcioS = textFieldCalcio.getText();


		Double energia = Double.parseDouble(energiaS);
		Double hidratos = Double.parseDouble(hidratosS);
		Double azucar = Double.parseDouble(azucarS);
		Double grasas = Double.parseDouble(grasasS);
		Double saturadas = Double.parseDouble(saturadasS);
		Double proteinas = Double.parseDouble(proteinasS);
		Double sal = Double.parseDouble(salS);
		Double hierro = Double.parseDouble(hierroS);
		Double calcio = Double.parseDouble(calcioS);

		alimento.setNombre(nombre);
		alimento.setEnergia(energia);
		alimento.setHidratosCarbono(hidratos);
		alimento.setAzucar(azucar);
		alimento.setGrasas(grasas);
		alimento.setGrasasSaturadas(saturadas);
		alimento.setProteinas(proteinas);
		alimento.setSal(sal);
		alimento.setHierro(hierro);
		alimento.setCalcio(calcio);

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
		Genero generoS = (Genero) comboBoxSexo.getSelectedItem();


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
	 * Añade una nueva fila al panelListaAlimentos con la informacion del alimento
	 * 
	 * Crea un AlimentoCantidad asignando alimento y 0 a los gramos.
	 * Crea un TextField para introducir los gramos consumidos, un JCheckBox con el nombre del alimento y JLabel con la informacion del alimento
	 *  
	 * @param alimento alimento a añadir
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
		chckbxAlimento.setHorizontalAlignment(SwingConstants.LEADING);
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
		lblEnergiaTotCalc.setText(energiaTotalText);

		if(!desgloseMacrosUsuario.isCantidadEnergiaAdecuada()) {
			lblEnergiaTotCalc.setForeground(Color.red);
		}
		else lblEnergiaTotCalc.setForeground(Color.black);

		// Hidratos de Carbono

		double hidratosTotal = desgloseMacrosUsuario.getHidratosCarbonoTotales();
		String hidratosTotalText = dformat.format(hidratosTotal);
		lblHidratosCarbTotCalc.setText(hidratosTotalText);

		if(!desgloseMacrosUsuario.isCantidadHidratosCarbonoAdecuada()) {
			lblHidratosCarbTotCalc.setForeground(Color.red);
		}
		else lblHidratosCarbTotCalc.setForeground(Color.black);

		//Azucar
		double azucarTotal = desgloseMacrosUsuario.getAzucarTotal();
		String azucarTotalText = dformat.format(azucarTotal);
		lblAzucarTotCalc.setText(azucarTotalText);

		if(!desgloseMacrosUsuario.isCantidadAzucarAdecuada()) {
			lblAzucarTotCalc.setForeground(Color.red);
		}
		else lblAzucarTotCalc.setForeground(Color.black);

		//Grasas
		double grasasTotales = desgloseMacrosUsuario.getGrasasTotales();
		String grasasTotalesText = dformat.format(grasasTotales);
		lblGrasasTotCalc.setText(grasasTotalesText);

		if(!desgloseMacrosUsuario.isCantidadGrasasAdecuada()) {
			lblGrasasTotCalc.setForeground(Color.red);
		}
		else lblGrasasTotCalc.setForeground(Color.black);

		//Grasas Saturadas
		double grasasSaturadasTotales = desgloseMacrosUsuario.getGrasasSaturadasTotales();
		String grasasSaturadasTotalesText = dformat.format(grasasSaturadasTotales);
		lblGrasasSatTotCalc.setText(grasasSaturadasTotalesText);

		if(!desgloseMacrosUsuario.isCantidadGrasasSaturadasAdecuada()) {
			lblGrasasSatTotCalc.setForeground(Color.red);
		}
		else lblGrasasSatTotCalc.setForeground(Color.black);		

		//Sal
		double salTotal = desgloseMacrosUsuario.getSalTotal();
		String salTotalText = dformat.format(salTotal);
		lblSalTotCalc.setText(salTotalText);

		if(!desgloseMacrosUsuario.isCantidadSalAdecuada()) {
			lblSalTotCalc.setForeground(Color.red);
		}
		else lblSalTotCalc.setForeground(Color.black);

		//Calcio
		double calcioTotal = desgloseMacrosUsuario.getCalcioTotal();
		String calcioTotalText = dformat.format(calcioTotal);
		lblCalcioTotCalc.setText(calcioTotalText);

		if(!desgloseMacrosUsuario.isCantidadCalcioAdecuada()) {
			lblCalcioTotCalc.setForeground(Color.red);
		}
		else lblCalcioTotCalc.setForeground(Color.black);

		//Hierro
		double hierroTotal = desgloseMacrosUsuario.getHierroTotal();
		String hierroTotalText = dformat.format(hierroTotal);
		lblHierroTotCalc.setText(hierroTotalText);

		if(!desgloseMacrosUsuario.isCantidadHierroAdecuada()) {
			lblHierroTotCalc.setForeground(Color.red);
		}
		else lblHierroTotCalc.setForeground(Color.black);

		//IMC
		double imc = usuario.getImc();
		String imcText = dformat.format(imc);
		lblResultImc.setText(imcText);
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
	 * Pinta en la GUI la cabecera de panelListaAlimentos
	 * @author Marta
	 */
	private void paintCabeceraPanelListaAlimentos() {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblNombre);

		JLabel lblCantidad = new JLabel("Gramos consumidos");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblCantidad);

		JLabel lblEnergia = new JLabel("Kcal");
		lblEnergia.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEnergia.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblEnergia);

		JLabel lblHidratosCarbono = new JLabel("Hidratos de Carbono");
		lblHidratosCarbono.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHidratosCarbono.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHidratosCarbono);

		JLabel lblAzucar = new JLabel("Azúcar");
		lblAzucar.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAzucar.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblAzucar);

		JLabel lblGrasas = new JLabel("Grasas");
		lblGrasas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGrasas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasas);

		JLabel lblGrasasSaturadas = new JLabel("Grasas saturadas");
		lblGrasasSaturadas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGrasasSaturadas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblGrasasSaturadas);

		JLabel lblProteinas = new JLabel("Proteínas");
		lblProteinas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblProteinas.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblProteinas);

		JLabel lblSal = new JLabel("Sal");
		lblSal.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSal.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblSal);

		JLabel lblCalcio = new JLabel("Calcio");
		lblCalcio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCalcio.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblCalcio);

		JLabel lblHierro = new JLabel("Hierro");
		lblHierro.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHierro.setHorizontalAlignment(SwingConstants.CENTER);
		panelListaAlimentos.add(lblHierro);

		JLabel lblEliminar = new JLabel("");
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

	}

	/**
	 * Pinta los alimentos creados por defecto.
	 * 
	 * @author Ana
	 */
	private void paintRowsAlimentosDefault() {
		for(int i= 0; i < alimentos.size(); i++) {
			Alimento alimento = alimentos.get(i);
			addRowAlimento(alimento);
		}
	}
}


