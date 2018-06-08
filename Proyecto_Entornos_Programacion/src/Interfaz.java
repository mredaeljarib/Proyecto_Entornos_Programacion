import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Interfaz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int posicion=0;
	int posicionprincipal=0;
	int par_boton_propiedad=0;
	int par_boton_otros=0;
	int par_boton_recomendado=0;
	int par_boton_favoritos=0;
	boolean metodo=true;
	ArrayList<Empresa> propiedades = new ArrayList<Empresa>();
	ArrayList<Empresa> favoritos = new ArrayList<Empresa>();
	ArrayList<Empresa> otros = new ArrayList<Empresa>();
	ArrayList<Empresa> recomendado = new ArrayList<Empresa>();
	private JTextField txtcantidad_empresa;
	private JTextField textField_1;
	public Interfaz() throws JSONException {
		System.out.println("Si va");
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		
		
		
		
		
		try {
			API_Acciones.lista_empresas(empresas);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario=new Usuario();
		
		Comprado Comprado=new Comprado();
		
		
		
		propiedades= Comprado.paravender();
		
		for(int i=0;i<propiedades.size();i++) {
			System.out.println(propiedades.get(i));
		}
		
		
		Comprado.recomendaciones10(empresas);
		
		JLabel label_5 = new JLabel(Comprado.favoritas1());
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(12, 12, 157, 35);
		
		
		JLabel label_6 = new JLabel(Comprado.favoritas2());
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(12, 62, 157, 35);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_usuario = new JPanel();
		panel_usuario.setBounds(12, 0, 325, 312);
		panel_usuario.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), null, null, null));
		contentPane.add(panel_usuario);
		panel_usuario.setLayout(null);
		
		JLabel saldo = new JLabel("saldo :");
		saldo.setBounds(12, 103, 301, 15);
		saldo.setVerticalAlignment(SwingConstants.BOTTOM);
		saldo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(saldo);
		
		JLabel gastado = new JLabel("gastado :");
		gastado.setBounds(12, 157, 301, 15);
		gastado.setVerticalAlignment(SwingConstants.BOTTOM);
		gastado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(gastado);
		
		JLabel ganado = new JLabel("ganado :");
		ganado.setBounds(12, 217, 301, 15);
		ganado.setVerticalAlignment(SwingConstants.BOTTOM);
		ganado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(ganado);
		
		JLabel lblSaldo = new JLabel(String.valueOf(usuario.getSaldo()));
		lblSaldo.setBounds(12, 130, 301, 15);
		lblSaldo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(lblSaldo);
		
		JLabel lblGastado = new JLabel(String.valueOf(usuario.getGasto()));
		lblGastado.setBounds(12, 184, 301, 15);
		lblGastado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGastado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(lblGastado);
		
		JLabel lblGanado = new JLabel(String.valueOf(usuario.getGanado()));
		lblGanado.setBounds(12, 244, 301, 15);
		lblGanado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGanado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_usuario.add(lblGanado);
		
		
		
		JLabel lblUsuario = new JLabel("usuario");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(12, 12, 301, 42);
		panel_usuario.add(lblUsuario);
		
		JButton btnGuardar = new JButton("guardar");
		btnGuardar.setBounds(12, 66, 301, 25);
		panel_usuario.add(btnGuardar);
		
		JPanel panel_listados = new JPanel();
		panel_listados.setBounds(1008, 0, 229, 727);
		panel_listados.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, null, null, null));
		contentPane.add(panel_listados);
		panel_listados.setLayout(null);
		
		JPanel propiedad = new JPanel();
		propiedad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		propiedad.setBounds(12, 12, 205, 170);
		panel_listados.add(propiedad);
		propiedad.setLayout(null);
		
		JToggleButton boton_propiedad = new JToggleButton("propiedad");
		
		boton_propiedad.setBounds(12, 12, 181, 25);
		propiedad.add(boton_propiedad);
		
		JPanel panel_propiedad = new JPanel();
		panel_propiedad.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		panel_propiedad.setBounds(12, 49, 181, 109);
		propiedad.add(panel_propiedad);
		panel_propiedad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Comprado.empresa1());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 157, 35);
		panel_propiedad.add(lblNewLabel);
		
		JLabel label = new JLabel(Comprado.empresa2());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 62, 157, 35);
		panel_propiedad.add(label);
		
		JPanel jpanel_favoritos = new JPanel();
		jpanel_favoritos.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		jpanel_favoritos.setBounds(12, 545, 205, 170);
		panel_listados.add(jpanel_favoritos);
		jpanel_favoritos.setLayout(null);
		
		JToggleButton boton_favoritos = new JToggleButton("favoritos");
		
		boton_favoritos.setBounds(12, 12, 181, 25);
		jpanel_favoritos.add(boton_favoritos);
		
		JPanel panel_favoritos = new JPanel();
		panel_favoritos.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		panel_favoritos.setBounds(12, 49, 181, 109);
		jpanel_favoritos.add(panel_favoritos);
		panel_favoritos.setLayout(null);
		
		panel_favoritos.add(label_6);
		
		panel_favoritos.add(label_5);
		
		JPanel jpanel_recomendado = new JPanel();
		jpanel_recomendado.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		jpanel_recomendado.setBounds(12, 186, 205, 170);
		panel_listados.add(jpanel_recomendado);
		jpanel_recomendado.setLayout(null);
		
		JToggleButton boton_recomendado = new JToggleButton("recomendados");
		
		boton_recomendado.setBounds(12, 12, 181, 25);
		jpanel_recomendado.add(boton_recomendado);
		
		JPanel panel_recomendado = new JPanel();
		panel_recomendado.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		panel_recomendado.setBounds(12, 49, 181, 109);
		jpanel_recomendado.add(panel_recomendado);
		panel_recomendado.setLayout(null);
		
		JLabel label_1 = new JLabel(Comprado.recomendado1());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 12, 157, 35);
		panel_recomendado.add(label_1);
		
		JLabel label_2 = new JLabel(Comprado.recomendado2());
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 62, 157, 35);
		panel_recomendado.add(label_2);
		
		JPanel jpanel_otros = new JPanel();
		jpanel_otros.setVisible(false);
		jpanel_otros.setBounds(12, 371, 205, 170);
		panel_listados.add(jpanel_otros);
		jpanel_otros.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		jpanel_otros.setLayout(null);
		
		JToggleButton boton_otros = new JToggleButton("otros usuarios");
		
		boton_otros.setBounds(12, 12, 181, 25);
		jpanel_otros.add(boton_otros);
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panel_otros = new JPanel();
		panel_otros.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), null, null, null));
		panel_otros.setBounds(12, 49, 181, 109);
		jpanel_otros.add(panel_otros);
		panel_otros.setLayout(null);
		
		JLabel label_3 = new JLabel(Comprado.otros1());
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(12, 12, 157, 35);
		panel_otros.add(label_3);
		
		JLabel label_4 = new JLabel(Comprado.otros2());
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(12, 62, 157, 35);
		panel_otros.add(label_4);
		
		JPanel panel_empresas = new JPanel();
		panel_empresas.setBounds(349, 0, 647, 727);
		panel_empresas.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.CYAN, null, null, null));
		contentPane.add(panel_empresas);
		panel_empresas.setLayout(null);
		
		JPanel panel_empresa_seleccionada = new JPanel();
		panel_empresa_seleccionada.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, null, null));
		panel_empresa_seleccionada.setBounds(12, 64, 623, 314);
		panel_empresas.add(panel_empresa_seleccionada);
		panel_empresa_seleccionada.setLayout(null);
		
		JPanel panel_empresa = new JPanel();
		panel_empresa.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, null, null));
		panel_empresa.setBounds(12, 12, 599, 245);
		panel_empresa_seleccionada.add(panel_empresa);
		panel_empresa.setLayout(null);
		
		JLabel lblnombre = new JLabel("nombre :");
		lblnombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblnombre.setBounds(119, 12, 75, 25);
		panel_empresa.add(lblnombre);
		
		JLabel lblsector = new JLabel("sector :");
		lblsector.setVerticalAlignment(SwingConstants.BOTTOM);
		lblsector.setHorizontalAlignment(SwingConstants.LEFT);
		lblsector.setBounds(119, 49, 75, 25);
		panel_empresa.add(lblsector);
		
		JLabel lblmercado = new JLabel("mercado :");
		lblmercado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblmercado.setHorizontalAlignment(SwingConstants.LEFT);
		lblmercado.setBounds(119, 86, 75, 25);
		panel_empresa.add(lblmercado);
		
		JLabel lblopen = new JLabel("apertura :");
		lblopen.setVerticalAlignment(SwingConstants.BOTTOM);
		lblopen.setHorizontalAlignment(SwingConstants.LEFT);
		lblopen.setBounds(12, 124, 75, 25);
		panel_empresa.add(lblopen);
		
		JLabel lblclose = new JLabel("cerrada :");
		lblclose.setVerticalAlignment(SwingConstants.BOTTOM);
		lblclose.setHorizontalAlignment(SwingConstants.LEFT);
		lblclose.setBounds(12, 161, 75, 25);
		panel_empresa.add(lblclose);
		
		JLabel lblhigh = new JLabel("alto :");
		lblhigh.setVerticalAlignment(SwingConstants.BOTTOM);
		lblhigh.setHorizontalAlignment(SwingConstants.LEFT);
		lblhigh.setBounds(206, 124, 49, 25);
		panel_empresa.add(lblhigh);
		
		JLabel lbllow = new JLabel("bajo :");
		lbllow.setVerticalAlignment(SwingConstants.BOTTOM);
		lbllow.setHorizontalAlignment(SwingConstants.LEFT);
		lbllow.setBounds(206, 161, 49, 25);
		panel_empresa.add(lbllow);
		
		JLabel lblprice = new JLabel("precio :");
		lblprice.setVerticalAlignment(SwingConstants.BOTTOM);
		lblprice.setHorizontalAlignment(SwingConstants.LEFT);
		lblprice.setBounds(12, 198, 75, 25);
		panel_empresa.add(lblprice);
		
		JLabel lblnombreapi = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
		lblnombreapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombreapi.setBounds(206, 22, 381, 15);
		panel_empresa.add(lblnombreapi);
		
		JLabel lblsectorapi = new JLabel(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
		lblsectorapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblsectorapi.setBounds(206, 59, 381, 15);
		panel_empresa.add(lblsectorapi);
		
		JLabel lblmercadoapi = new JLabel(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
		lblmercadoapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblmercadoapi.setBounds(206, 97, 381, 15);
		panel_empresa.add(lblmercadoapi);
		
		JLabel lblhighapi = new JLabel(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
		lblhighapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblhighapi.setBounds(267, 134, 100, 15);
		panel_empresa.add(lblhighapi);
		
		JLabel lbllowapi = new JLabel(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
		lbllowapi.setHorizontalAlignment(SwingConstants.LEFT);
		lbllowapi.setBounds(267, 171, 100, 15);
		panel_empresa.add(lbllowapi);
		
		JLabel lblopenapi = new JLabel(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
		lblopenapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblopenapi.setBounds(99, 134, 121, 15);
		panel_empresa.add(lblopenapi);
		
		JLabel lblcloseapi = new JLabel(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
		lblcloseapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblcloseapi.setBounds(99, 171, 116, 15);
		panel_empresa.add(lblcloseapi);
		
		JLabel lblpriceapi = new JLabel(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
		lblpriceapi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblpriceapi.setHorizontalAlignment(SwingConstants.LEFT);
		lblpriceapi.setBounds(99, 198, 95, 25);
		panel_empresa.add(lblpriceapi);
		
		JLabel lblgasto = new JLabel("");
		lblgasto.setHorizontalAlignment(SwingConstants.LEFT);
		lblgasto.setBounds(379, 134, 70, 15);
		panel_empresa.add(lblgasto);
		
		JLabel lblcantidad = new JLabel(" ");
		lblcantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblcantidad.setBounds(379, 171, 75, 15);
		panel_empresa.add(lblcantidad);
		
		JLabel lblBeneficio = new JLabel(" ");
		lblBeneficio.setHorizontalAlignment(SwingConstants.LEFT);
		lblBeneficio.setBounds(267, 208, 83, 15);
		panel_empresa.add(lblBeneficio);
		
		JLabel lblDinero = new JLabel(" ");
		lblDinero.setHorizontalAlignment(SwingConstants.LEFT);
		lblDinero.setBounds(362, 208, 199, 15);
		panel_empresa.add(lblDinero);
		
		JLabel lblCantidad = new JLabel("");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setBounds(466, 171, 121, 15);
		panel_empresa.add(lblCantidad);
		
		JLabel lblGasto = new JLabel("");
		lblGasto.setBounds(461, 134, 126, 15);
		panel_empresa.add(lblGasto);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(231, 262, 157, 40);
		panel_empresa_seleccionada.add(panel);
		
		JLabel cantidad_empresa = new JLabel(String.valueOf((empresas.size()-1)));
		cantidad_empresa.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad_empresa.setBounds(87, 12, 58, 15);
		panel.add(cantidad_empresa);
		
		txtcantidad_empresa = new JTextField("0");
		txtcantidad_empresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
		              Toolkit.getDefaultToolkit().beep();   
		              System.out.println("ENTER pressed");
		              if((Integer.valueOf(txtcantidad_empresa.getText())<0)||(Integer.valueOf(txtcantidad_empresa.getText())>empresas.size())) {}else {
		              try {posicionprincipal=Integer.valueOf(txtcantidad_empresa.getText());
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
						txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		              }
		              
		              
		              
		              }
		           
			}
		});
		txtcantidad_empresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtcantidad_empresa.setColumns(10);
		txtcantidad_empresa.setBounds(0, 0, 82, 40);
		panel.add(txtcantidad_empresa);
		
		
		
		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(boton_propiedad.isSelected()) {
					if(posicionprincipal<propiedades.size()) {
						try {posicionprincipal++;
							lblnombreapi.setText(API_Acciones.quota_empresa_nombre(propiedades.get(posicionprincipal).getSimbolo()));
							lblsectorapi.setText(API_Acciones.quota_empresa_sector(propiedades.get(posicionprincipal).getSimbolo()));
							lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(propiedades.get(posicionprincipal).getSimbolo()));
							lblhighapi.setText(API_Acciones.quota_empresa_high(propiedades.get(posicionprincipal).getSimbolo()));
							lbllowapi.setText(API_Acciones.quota_empresa_low(propiedades.get(posicionprincipal).getSimbolo()));
							lblopenapi.setText(API_Acciones.quota_empresa_open(propiedades.get(posicionprincipal).getSimbolo()));
							lblcloseapi.setText(API_Acciones.quota_empresa_close(propiedades.get(posicionprincipal).getSimbolo()));
							lblpriceapi.setText(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()));
							txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
							lblgasto.setText("gasto :");
							lblcantidad.setText("cantidad :");
							lblBeneficio.setText("beneficio :");
							lblDinero.setText(String.valueOf((Float.valueOf(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()))*propiedades.get(posicionprincipal).getcantidad())));
							lblCantidad.setText(String.valueOf(propiedades.get(posicionprincipal).getcantidad()));
							lblGasto.setText(String.valueOf(propiedades.get(posicionprincipal).getgastado()));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						System.out.println("No mas");
					}
				}else {
					if(boton_favoritos.isSelected()) {
						if(posicionprincipal<favoritos.size()) {
							try {posicionprincipal++;
								lblnombreapi.setText(API_Acciones.quota_empresa_nombre(favoritos.get(posicionprincipal).getSimbolo()));
								lblsectorapi.setText(API_Acciones.quota_empresa_sector(favoritos.get(posicionprincipal).getSimbolo()));
								lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(favoritos.get(posicionprincipal).getSimbolo()));
								lblhighapi.setText(API_Acciones.quota_empresa_high(favoritos.get(posicionprincipal).getSimbolo()));
								lbllowapi.setText(API_Acciones.quota_empresa_low(favoritos.get(posicionprincipal).getSimbolo()));
								lblopenapi.setText(API_Acciones.quota_empresa_open(favoritos.get(posicionprincipal).getSimbolo()));
								lblcloseapi.setText(API_Acciones.quota_empresa_close(favoritos.get(posicionprincipal).getSimbolo()));
								lblpriceapi.setText(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo()));
								txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
							} catch (JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							System.out.println("No mas");
						}
					}else {
						if(boton_otros.isSelected()) {
							if(posicionprincipal<otros.size()) {
								try {posicionprincipal++;
									lblnombreapi.setText(API_Acciones.quota_empresa_nombre(otros.get(posicionprincipal).getSimbolo()));
									lblsectorapi.setText(API_Acciones.quota_empresa_sector(otros.get(posicionprincipal).getSimbolo()));
									lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(otros.get(posicionprincipal).getSimbolo()));
									lblhighapi.setText(API_Acciones.quota_empresa_high(otros.get(posicionprincipal).getSimbolo()));
									lbllowapi.setText(API_Acciones.quota_empresa_low(otros.get(posicionprincipal).getSimbolo()));
									lblopenapi.setText(API_Acciones.quota_empresa_open(otros.get(posicionprincipal).getSimbolo()));
									lblcloseapi.setText(API_Acciones.quota_empresa_close(otros.get(posicionprincipal).getSimbolo()));
									lblpriceapi.setText(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo()));
									txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
								} catch (JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								System.out.println("No mas");
							}
						}else {
							if(boton_recomendado.isSelected()) {
								if(posicionprincipal<recomendado.size()) {
									try {posicionprincipal++;
										lblnombreapi.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal).getSimbolo()));
										lblsectorapi.setText(API_Acciones.quota_empresa_sector(recomendado.get(posicionprincipal).getSimbolo()));
										lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(recomendado.get(posicionprincipal).getSimbolo()));
										lblhighapi.setText(API_Acciones.quota_empresa_high(recomendado.get(posicionprincipal).getSimbolo()));
										lbllowapi.setText(API_Acciones.quota_empresa_low(recomendado.get(posicionprincipal).getSimbolo()));
										lblopenapi.setText(API_Acciones.quota_empresa_open(recomendado.get(posicionprincipal).getSimbolo()));
										lblcloseapi.setText(API_Acciones.quota_empresa_close(recomendado.get(posicionprincipal).getSimbolo()));
										lblpriceapi.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()));
										txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									System.out.println("No mas");
								}
							}else {
								
								if(posicionprincipal<empresas.size()) {
									try {posicionprincipal++;
										lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
										lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
										lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
										lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
										lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
										lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
										lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
										lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
										txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									System.out.println("No mas");
								}
							}
						}
					}
				}
			}
		});
		
		JButton anterior = new JButton("<");
		anterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(boton_propiedad.isSelected()) {
					if(posicionprincipal>0) {
						try {posicionprincipal--;
							lblnombreapi.setText(API_Acciones.quota_empresa_nombre(propiedades.get(posicionprincipal).getSimbolo()));
							lblsectorapi.setText(API_Acciones.quota_empresa_sector(propiedades.get(posicionprincipal).getSimbolo()));
							lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(propiedades.get(posicionprincipal).getSimbolo()));
							lblhighapi.setText(API_Acciones.quota_empresa_high(propiedades.get(posicionprincipal).getSimbolo()));
							lbllowapi.setText(API_Acciones.quota_empresa_low(propiedades.get(posicionprincipal).getSimbolo()));
							lblopenapi.setText(API_Acciones.quota_empresa_open(propiedades.get(posicionprincipal).getSimbolo()));
							lblcloseapi.setText(API_Acciones.quota_empresa_close(propiedades.get(posicionprincipal).getSimbolo()));
							lblpriceapi.setText(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()));
							txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
							lblgasto.setText("gasto :");
							lblcantidad.setText("cantidad :");
							lblBeneficio.setText("beneficio :");
							lblDinero.setText(String.valueOf((Float.valueOf(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()))*propiedades.get(posicionprincipal).getcantidad())));
							lblCantidad.setText(String.valueOf(propiedades.get(posicionprincipal).getcantidad()));
							lblGasto.setText(String.valueOf(propiedades.get(posicionprincipal).getgastado()));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						System.out.println("No mas");
					}
				}else {
					if(boton_favoritos.isSelected()) {
						if(posicionprincipal>0) {
							try {posicionprincipal--;
								lblnombreapi.setText(API_Acciones.quota_empresa_nombre(favoritos.get(posicionprincipal).getSimbolo()));
								lblsectorapi.setText(API_Acciones.quota_empresa_sector(favoritos.get(posicionprincipal).getSimbolo()));
								lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(favoritos.get(posicionprincipal).getSimbolo()));
								lblhighapi.setText(API_Acciones.quota_empresa_high(favoritos.get(posicionprincipal).getSimbolo()));
								lbllowapi.setText(API_Acciones.quota_empresa_low(favoritos.get(posicionprincipal).getSimbolo()));
								lblopenapi.setText(API_Acciones.quota_empresa_open(favoritos.get(posicionprincipal).getSimbolo()));
								lblcloseapi.setText(API_Acciones.quota_empresa_close(favoritos.get(posicionprincipal).getSimbolo()));
								lblpriceapi.setText(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo()));
								txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
							} catch (JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							System.out.println("No mas");
						}
					}else {
						if(boton_otros.isSelected()) {
							if(posicionprincipal>0) {
								try {posicionprincipal--;
									lblnombreapi.setText(API_Acciones.quota_empresa_nombre(otros.get(posicionprincipal).getSimbolo()));
									lblsectorapi.setText(API_Acciones.quota_empresa_sector(otros.get(posicionprincipal).getSimbolo()));
									lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(otros.get(posicionprincipal).getSimbolo()));
									lblhighapi.setText(API_Acciones.quota_empresa_high(otros.get(posicionprincipal).getSimbolo()));
									lbllowapi.setText(API_Acciones.quota_empresa_low(otros.get(posicionprincipal).getSimbolo()));
									lblopenapi.setText(API_Acciones.quota_empresa_open(otros.get(posicionprincipal).getSimbolo()));
									lblcloseapi.setText(API_Acciones.quota_empresa_close(otros.get(posicionprincipal).getSimbolo()));
									lblpriceapi.setText(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo()));
									txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
								} catch (JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								System.out.println("No mas");
							}
						}else {
							if(boton_recomendado.isSelected()) {
								if(posicionprincipal>0) {
									try {posicionprincipal--;
										lblnombreapi.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal).getSimbolo()));
										lblsectorapi.setText(API_Acciones.quota_empresa_sector(recomendado.get(posicionprincipal).getSimbolo()));
										lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(recomendado.get(posicionprincipal).getSimbolo()));
										lblhighapi.setText(API_Acciones.quota_empresa_high(recomendado.get(posicionprincipal).getSimbolo()));
										lbllowapi.setText(API_Acciones.quota_empresa_low(recomendado.get(posicionprincipal).getSimbolo()));
										lblopenapi.setText(API_Acciones.quota_empresa_open(recomendado.get(posicionprincipal).getSimbolo()));
										lblcloseapi.setText(API_Acciones.quota_empresa_close(recomendado.get(posicionprincipal).getSimbolo()));
										lblpriceapi.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()));
										txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									System.out.println("No mas");
								}
							}else {
								
								if(posicionprincipal<empresas.size()) {
									try {posicionprincipal--;
										lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
										lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
										lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
										lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
										lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
										lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
										lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
										lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
										txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}else {
									System.out.println("No mas");
								}
							}
						}
					}
				}
			}
		});
		
		
		anterior.setBounds(12, 262, 60, 40);
		panel_empresa_seleccionada.add(anterior);
		button.setBounds(553, 262, 58, 40);
		panel_empresa_seleccionada.add(button);
		
		JPanel panel_empresas_otros = new JPanel();
		panel_empresas_otros.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, null, null));
		panel_empresas_otros.setBounds(12, 390, 623, 325);
		panel_empresas.add(panel_empresas_otros);
		panel_empresas_otros.setLayout(null);
		
		JPanel pagina = new JPanel();
		pagina.setBorder(new LineBorder(new Color(0, 0, 0)));
		pagina.setBounds(235, 272, 157, 40);
		panel_empresas_otros.add(pagina);
		pagina.setLayout(null);
		
		JLabel cantidad_paginas = new JLabel(String.valueOf(empresas.size()-1));
		cantidad_paginas.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad_paginas.setBounds(87, 12, 58, 15);
		pagina.add(cantidad_paginas);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 12, 70, 15);
		pagina.add(lblNewLabel_1);
		
		JPanel empresa_2 = new JPanel();
		empresa_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_2.setBounds(12, 12, 289, 40);
		panel_empresas_otros.add(empresa_2);
		empresa_2.setLayout(null);
		
		JLabel lblnombre_2 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
		lblnombre_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_2.setBounds(12, 0, 146, 40);
		empresa_2.add(lblnombre_2);
		
		JLabel lblprecio_2 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
		lblprecio_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_2.setBounds(170, 0, 119, 40);
		empresa_2.add(lblprecio_2);
		
		JPanel empresa_3 = new JPanel();
		empresa_3.setLayout(null);
		empresa_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_3.setBounds(12, 64, 289, 40);
		panel_empresas_otros.add(empresa_3);
		
		JLabel lblnombre_3 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
		lblnombre_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_3.setBounds(12, 0, 146, 40);
		empresa_3.add(lblnombre_3);
		
		JLabel lblprecio_3 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
		lblprecio_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_3.setBounds(170, 0, 119, 40);
		empresa_3.add(lblprecio_3);
		
		JPanel empresa4 = new JPanel();
		empresa4.setLayout(null);
		empresa4.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa4.setBounds(12, 116, 289, 40);
		panel_empresas_otros.add(empresa4);
		
		JLabel lblnombre_4 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
		lblnombre_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_4.setBounds(12, 0, 146, 40);
		empresa4.add(lblnombre_4);
		
		JLabel lblprecio_4 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
		lblprecio_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_4.setBounds(170, 0, 119, 40);
		empresa4.add(lblprecio_4);
		
		JPanel empresa_5 = new JPanel();
		empresa_5.setLayout(null);
		empresa_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_5.setBounds(12, 168, 289, 40);
		panel_empresas_otros.add(empresa_5);
		
		JLabel lblnombre_5 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
		lblnombre_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_5.setBounds(12, 0, 146, 40);
		empresa_5.add(lblnombre_5);
		
		JLabel lblprecio_5 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
		lblprecio_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_5.setBounds(170, 0, 119, 40);
		empresa_5.add(lblprecio_5);
		
		JPanel empresa_6 = new JPanel();
		empresa_6.setLayout(null);
		empresa_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_6.setBounds(12, 220, 289, 40);
		panel_empresas_otros.add(empresa_6);
		
		JLabel lblnombre_6 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
		lblnombre_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_6.setBounds(12, 0, 146, 40);
		empresa_6.add(lblnombre_6);
		
		JLabel lblprecio_6 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
		lblprecio_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_6.setBounds(170, 0, 119, 40);
		empresa_6.add(lblprecio_6);
		
		JPanel empresa_7 = new JPanel();
		empresa_7.setLayout(null);
		empresa_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_7.setBounds(322, 12, 289, 40);
		panel_empresas_otros.add(empresa_7);
		
		JLabel lblnombre_7 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
		lblnombre_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_7.setBounds(12, 0, 146, 40);
		empresa_7.add(lblnombre_7);
		
		JLabel lblprecio_7 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
		lblprecio_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_7.setBounds(170, 0, 119, 40);
		empresa_7.add(lblprecio_7);
		
		JPanel empresa_8 = new JPanel();
		empresa_8.setLayout(null);
		empresa_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_8.setBounds(322, 64, 289, 40);
		panel_empresas_otros.add(empresa_8);
		
		JLabel lblnombre_8 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
		lblnombre_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_8.setBounds(12, 0, 146, 40);
		empresa_8.add(lblnombre_8);
		
		JLabel lblprecio_8 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
		lblprecio_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_8.setBounds(170, 0, 119, 40);
		empresa_8.add(lblprecio_8);
		
		JPanel empresa_9 = new JPanel();
		empresa_9.setLayout(null);
		empresa_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_9.setBounds(322, 116, 289, 40);
		panel_empresas_otros.add(empresa_9);
		
		JLabel lblnombre_9 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
		lblnombre_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_9.setBounds(12, 0, 146, 40);
		empresa_9.add(lblnombre_9);
		
		JLabel lblprecio_9 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
		lblprecio_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_9.setBounds(170, 0, 119, 40);
		empresa_9.add(lblprecio_9);
		
		JPanel empresa_10 = new JPanel();
		empresa_10.setLayout(null);
		empresa_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_10.setBounds(322, 168, 289, 40);
		panel_empresas_otros.add(empresa_10);
		
		JLabel lblnombre_10 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
		lblnombre_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_10.setBounds(12, 0, 146, 40);
		empresa_10.add(lblnombre_10);
		
		JLabel lblprecio_10 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
		lblprecio_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_10.setBounds(170, 0, 119, 40);
		empresa_10.add(lblprecio_10);
		
		JPanel empresa_11 = new JPanel();
		empresa_11.setLayout(null);
		empresa_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		empresa_11.setBounds(322, 220, 289, 40);
		panel_empresas_otros.add(empresa_11);
		
		JLabel lblnombre_11 = new JLabel(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
		lblnombre_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblnombre_11.setBounds(12, 0, 146, 40);
		empresa_11.add(lblnombre_11);
		
		JLabel lblprecio_11 = new JLabel(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
		lblprecio_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio_11.setBounds(170, 0, 119, 40);
		empresa_11.add(lblprecio_11);
		
		JButton anterior_pagina = new JButton("<");
		anterior_pagina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(posicion>0) {
					try {posicion=posicion-10;
					lblNewLabel_1.setText(String.valueOf(posicion));
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					System.out.println("No mas_2");
				}
			}
		});
		anterior_pagina.setBounds(162, 273, 61, 41);
		panel_empresas_otros.add(anterior_pagina);
		
		JButton siguiente_pagina = new JButton(">");
		siguiente_pagina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(posicion<empresas.size()) {
					try {posicion=posicion+10;
					lblNewLabel_1.setText(String.valueOf(posicion));
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					System.out.println("No mas_2");
				}
			}
		});
		siguiente_pagina.setBounds(404, 272, 61, 41);
		panel_empresas_otros.add(siguiente_pagina);
		
		JPanel titulo = new JPanel();
		titulo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), null, null, null));
		titulo.setBounds(12, 12, 623, 40);
		panel_empresas.add(titulo);
		titulo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbltitulo = new JLabel("Comprar");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.add(lbltitulo);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, null, null, null));
		panel_1.setBounds(12, 324, 325, 403);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, null, null, null));
		panel_2.setBounds(118, 168, 89, 39);
		panel_1.add(panel_2);
		
		JLabel label_7 = new JLabel("1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(12, 12, 70, 15);
		panel_2.add(label_7);
		
		JButton button_8 = new JButton("dinero");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(metodo){
					button_8.setText("cantidad");
					metodo=false;
				}else {
					button_8.setText("dinero");
					metodo=true;
				}
			}
		});
		button_8.setBounds(12, 15, 301, 39);
		panel_1.add(button_8);
		
		textField_1 = new JTextField("0");
		textField_1.setColumns(10);
		textField_1.setBounds(12, 66, 301, 39);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("favorito");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Comprado.añadir_favoritas(empresas.get(posicionprincipal).getSimbolo());
				try {
					label_5.setText(Comprado.favoritas1());
					label_6.setText(Comprado.favoritas2());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		button_1.setBounds(12, 339, 301, 52);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("vender");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int tamaño=propiedades.size();
					String d=Comprado.vender_cantidad(propiedades.get(posicionprincipal).getSimbolo(), Float.valueOf(textField_1.getText()), Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo())));
					if(tamaño!=propiedades.size()) {
							posicionprincipal--;
						
					}
						
					txtcantidad_empresa.setText(String.valueOf(posicionprincipal));
					txtcantidad_empresa.getText();
						
						
					if(propiedades.size()==0) {
						lblnombreapi.setText("-");
						lblsectorapi.setText("-");
						lblmercadoapi.setText("-");
						lblhighapi.setText("-");
						lbllowapi.setText("-");
						lblopenapi.setText("-");
						lblcloseapi.setText("-");
						lblpriceapi.setText("-");
						lblgasto.setText("gasto :");
						lblcantidad.setText("cantidad :");
						lblBeneficio.setText("beneficio :");
						lblDinero.setText("-");
						lblCantidad.setText("-");
						lblGasto.setText("-");
						
					}	else {
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(propiedades.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(propiedades.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(propiedades.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(propiedades.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(propiedades.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(propiedades.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(propiedades.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()));
						lblgasto.setText("gasto :");
						lblcantidad.setText("cantidad :");
						lblBeneficio.setText("beneficio :");
						lblDinero.setText(String.valueOf((Float.valueOf(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()))*propiedades.get(posicionprincipal).getcantidad())));
						lblCantidad.setText(String.valueOf(propiedades.get(posicionprincipal).getcantidad()));
						lblGasto.setText(String.valueOf(propiedades.get(posicionprincipal).getgastado()));
					}
					lblGanado.setText(String.valueOf(Float.valueOf(lblGanado.getText())+Float.valueOf(d)));
					lblSaldo.setText(String.valueOf(Float.valueOf(lblSaldo.getText())+Float.valueOf(d)));;	
					lblNewLabel.setText(Comprado.empresa1());
					label.setText(Comprado.empresa2());
						
				} catch (NumberFormatException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setEnabled(false);
		button_2.setBounds(12, 279, 301, 52);
		panel_1.add(button_2);
		
		JButton button_comprar = new JButton("comprar");
		button_comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recomendado=Comprado.pararecomendados();otros=Comprado.paraotros();favoritos=Comprado.parafavoritas();
				if(boton_favoritos.isSelected()==true) {
					if(metodo) {
						if(Float.valueOf(textField_1.getText())!=0) {
						try {
							if(Comprado.comprar_precio(favoritos.get(posicionprincipal).getSimbolo(), Float.valueOf(textField_1.getText()),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo())))==true) {
								lblSaldo.setText(String.valueOf((Float.valueOf(lblSaldo.getText())-(Float.valueOf(textField_1.getText())+Float.valueOf(Comprado.diferencia())))));
								lblGastado.setText(String.valueOf((Float.valueOf(lblGastado.getText())-(Float.valueOf(textField_1.getText())-Float.valueOf(Comprado.diferencia())))));
							}
							lblNewLabel.setText(Comprado.empresa1());
							label.setText(Comprado.empresa2());
							
						} catch (NumberFormatException | JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						}
						else {

							if(Float.valueOf(textField_1.getText())!=0) {
							try {
								if((Float.valueOf(textField_1.getText())* Float.valueOf(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo())))>(Float.valueOf(usuario.getSaldo()))) {
									
								}else {
									if(Float.valueOf(textField_1.getText())!=0) {
										try {
											Comprado.comprar_cantidad(favoritos.get(posicionprincipal).getSimbolo(),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo())), Float.valueOf(textField_1.getText()));
											lblSaldo.setText(String.valueOf(Float.valueOf(lblSaldo.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo()))));
											lblGastado.setText(String.valueOf(Float.valueOf(lblGastado.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo()))));
											
											
											
											lblNewLabel.setText(Comprado.empresa1());
											label.setText(Comprado.empresa2());
										} catch (NumberFormatException | JSONException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										}
								}
							} catch (NumberFormatException | JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}else {
					if(boton_recomendado.isSelected()) {
						if(metodo) {
							if(Float.valueOf(textField_1.getText())!=0) {
							try {
								if(Comprado.comprar_precio(recomendado.get(posicionprincipal).getSimbolo(), Float.valueOf(textField_1.getText()),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo())))==true) {
									lblSaldo.setText(String.valueOf((Float.valueOf(lblSaldo.getText())-(Float.valueOf(textField_1.getText())+Float.valueOf(Comprado.diferencia())))));
									lblGastado.setText(String.valueOf((Float.valueOf(lblGastado.getText())-(Float.valueOf(textField_1.getText())-Float.valueOf(Comprado.diferencia())))));
								}
								lblNewLabel.setText(Comprado.empresa1());
								label.setText(Comprado.empresa2());
								
							} catch (NumberFormatException | JSONException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
							}
							else {

								if(Float.valueOf(textField_1.getText())!=0) {
								try {
									if((Float.valueOf(textField_1.getText())* Float.valueOf(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo())))>(Float.valueOf(usuario.getSaldo()))) {
										
									}else {
										if(Float.valueOf(textField_1.getText())!=0) {
											try {
												Comprado.comprar_cantidad(recomendado.get(posicionprincipal).getSimbolo(),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo())), Float.valueOf(textField_1.getText()));
												lblSaldo.setText(String.valueOf(Float.valueOf(lblSaldo.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()))));
												lblGastado.setText(String.valueOf(Float.valueOf(lblGastado.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()))));
												
												
												
												lblNewLabel.setText(Comprado.empresa1());
												label.setText(Comprado.empresa2());
											} catch (NumberFormatException | JSONException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											}
									}
								} catch (NumberFormatException | JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}else {
						if(boton_otros.isSelected()) {
							if(metodo) {
								if(Float.valueOf(textField_1.getText())!=0) {
								try {
									if(Comprado.comprar_precio(otros.get(posicionprincipal).getSimbolo(), Float.valueOf(textField_1.getText()),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo())))==true) {
										lblSaldo.setText(String.valueOf((Float.valueOf(lblSaldo.getText())-(Float.valueOf(textField_1.getText())+Float.valueOf(Comprado.diferencia())))));
										lblGastado.setText(String.valueOf((Float.valueOf(lblGastado.getText())-(Float.valueOf(textField_1.getText())-Float.valueOf(Comprado.diferencia())))));
									}
									lblNewLabel.setText(Comprado.empresa1());
									label.setText(Comprado.empresa2());
									
								} catch (NumberFormatException | JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
								}
								else {

									if(Float.valueOf(textField_1.getText())!=0) {
									try {
										if((Float.valueOf(textField_1.getText())* Float.valueOf(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo())))>(Float.valueOf(usuario.getSaldo()))) {
											
										}else {
											if(Float.valueOf(textField_1.getText())!=0) {
												try {
													Comprado.comprar_cantidad(otros.get(posicionprincipal).getSimbolo(),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo())), Float.valueOf(textField_1.getText()));
													lblSaldo.setText(String.valueOf(Float.valueOf(lblSaldo.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo()))));
													lblGastado.setText(String.valueOf(Float.valueOf(lblGastado.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo()))));
													
													
													
													lblNewLabel.setText(Comprado.empresa1());
													label.setText(Comprado.empresa2());
												} catch (NumberFormatException | JSONException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												}
										}
									} catch (NumberFormatException | JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}else {
							
							if(metodo) {
								if(Float.valueOf(textField_1.getText())!=0) {
								try {
									if(Comprado.comprar_precio(empresas.get(posicionprincipal).getSimbolo(), Float.valueOf(textField_1.getText()),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo())))==true) {
										lblSaldo.setText(String.valueOf((Float.valueOf(lblSaldo.getText())-(Float.valueOf(textField_1.getText())+Float.valueOf(Comprado.diferencia())))));
										lblGastado.setText(String.valueOf((Float.valueOf(lblGastado.getText())-(Float.valueOf(textField_1.getText())-Float.valueOf(Comprado.diferencia())))));
									}
									lblNewLabel.setText(Comprado.empresa1());
									label.setText(Comprado.empresa2());
									
								} catch (NumberFormatException | JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
								}
								else {

									if(Float.valueOf(textField_1.getText())!=0) {
									try {
										if((Float.valueOf(textField_1.getText())* Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo())))>(Float.valueOf(usuario.getSaldo()))) {
											
										}else {
											if(Float.valueOf(textField_1.getText())!=0) {
												try {
													Comprado.comprar_cantidad(empresas.get(posicionprincipal).getSimbolo(),Float.valueOf(usuario.getSaldo()) , Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo())), Float.valueOf(textField_1.getText()));
													lblSaldo.setText(String.valueOf(Float.valueOf(lblSaldo.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()))));
													lblGastado.setText(String.valueOf(Float.valueOf(lblGastado.getText())-Float.valueOf(textField_1.getText())*Float.valueOf(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()))));
													
													
													
													lblNewLabel.setText(Comprado.empresa1());
													label.setText(Comprado.empresa2());
												} catch (NumberFormatException | JSONException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												}
										}
									} catch (NumberFormatException | JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		});
		button_comprar.setBounds(12, 219, 301, 52);
		panel_1.add(button_comprar);
		
		JButton button_4 = new JButton("disminuir");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText(String.valueOf(Float.valueOf(textField_1.getText())-Float.valueOf(label_7.getText())));
			}
		});
		button_4.setBounds(12, 117, 143, 39);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("aumentar");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textField_1.setText(String.valueOf(Float.valueOf(textField_1.getText())+Float.valueOf(label_7.getText())));
				
				
				
				
			}
		});
		button_5.setBounds(167, 117, 146, 39);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("mas");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(label_7.getText().toString().equals("1")) {
					label_7.setText("10");
				}else {if(label_7.getText().toString().equals("10")) {
					label_7.setText("100");
				}}
				
				
			}
		});
		button_6.setBounds(219, 168, 94, 39);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("menos");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(label_7.getText().toString().equals("100")) {
					label_7.setText("10");
				}else {if(label_7.getText().toString().equals("10")) {
					label_7.setText("1");
				}}
			}
		});
		button_7.setBounds(12, 168, 94, 39);
		panel_1.add(button_7);
		
		
		
		//////////////////////////////////////////////////////
		
		JToggleButton boton_nada = new JToggleButton("");
		ButtonGroup bg = new ButtonGroup();
		boton_nada.setBounds(0, 0, 0, 0);
		panel_favoritos.add(boton_nada);
		bg.add(boton_propiedad);
		bg.add(boton_otros);
		bg.add(boton_recomendado);
		bg.add(boton_favoritos);
		bg.add(boton_nada);
		boton_propiedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(boton_propiedad.isSelected()) {
					lbltitulo.setText("vender");
					button_1.setEnabled(false);
					panel_empresas_otros.setVisible(false);
					par_boton_propiedad++;
					posicionprincipal=0;
					button_comprar.setEnabled(false);
					button_2.setEnabled(true);
					
						button_8.setText("cantidad");
						metodo=false;
						button_8.setEnabled(false);
						try {if(propiedades.size()!=0) {

							txtcantidad_empresa.setText("0");
							txtcantidad_empresa.getText();
							lblnombreapi.setText(API_Acciones.quota_empresa_nombre(propiedades.get(posicionprincipal).getSimbolo()));
							lblsectorapi.setText(API_Acciones.quota_empresa_sector(propiedades.get(posicionprincipal).getSimbolo()));
							lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(propiedades.get(posicionprincipal).getSimbolo()));
							lblhighapi.setText(API_Acciones.quota_empresa_high(propiedades.get(posicionprincipal).getSimbolo()));
							lbllowapi.setText(API_Acciones.quota_empresa_low(propiedades.get(posicionprincipal).getSimbolo()));
							lblopenapi.setText(API_Acciones.quota_empresa_open(propiedades.get(posicionprincipal).getSimbolo()));
							lblcloseapi.setText(API_Acciones.quota_empresa_close(propiedades.get(posicionprincipal).getSimbolo()));
							lblpriceapi.setText(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()));
							lblgasto.setText("gasto :");
							lblcantidad.setText("cantidad :");
							lblBeneficio.setText("beneficio :");
							lblDinero.setText(String.valueOf((Float.valueOf(API_Acciones.precio_empresa(propiedades.get(posicionprincipal).getSimbolo()))*propiedades.get(posicionprincipal).getcantidad())));
							lblCantidad.setText(String.valueOf(propiedades.get(posicionprincipal).getcantidad()));
							lblGasto.setText(String.valueOf(propiedades.get(posicionprincipal).getgastado()));
						}else {
							lblnombreapi.setText("-");
							lblsectorapi.setText("-");
							lblmercadoapi.setText("-");
							lblhighapi.setText("-");
							lbllowapi.setText("-");
							lblopenapi.setText("-");
							lblcloseapi.setText("-");
							lblpriceapi.setText("-");
							lblgasto.setText("gasto :");
							lblcantidad.setText("cantidad :");
							lblBeneficio.setText("beneficio :");
							lblDinero.setText("-");
							lblCantidad.setText("-");
							lblGasto.setText("-");
						}
						cantidad_empresa.setText(String.valueOf((propiedades.size()-1)));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					if(par_boton_propiedad%2==0) {

						lbltitulo.setText("comprar");
						button_1.setEnabled(true);
						panel_empresas_otros.setVisible(true);
						button_8.setEnabled(true);
						boton_nada.setSelected(true);
						button_comprar.setEnabled(true);
						button_2.setEnabled(false);
						button_8.setText("dinero");
						metodo=true;

						posicionprincipal=0;
						try {
							lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
						lblgasto.setText(" ");
						lblcantidad.setText(" ");
						lblBeneficio.setText(" ");
						lblDinero.setText(" ");
						lblCantidad.setText(" ");
						lblGasto.setText(" ");
						cantidad_empresa.setText(String.valueOf((empresas.size()-1)));
						txtcantidad_empresa.setText("0");
						
						siguiente_pagina.setVisible(true);
						anterior_pagina.setVisible(true);
						pagina.setVisible(true);
						lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
						lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
						lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
						lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
						lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
						lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
						lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
						lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
						lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
						lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
						
						lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
						lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
						lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
						lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
						lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
						lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
						lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
						lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
						lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
						lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}else {
					
				}
			}
		});
		
		boton_otros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(boton_otros.isSelected()) {
					button_1.setEnabled(false);
					otros=Comprado.paraotros();
				par_boton_otros++;
				posicionprincipal=0;
				button_2.setEnabled(false);
				button_comprar.setEnabled(true);
				
					
					metodo=false;
					button_8.setEnabled(true);
					try {if(otros.size()!=0) {

						txtcantidad_empresa.setText("0");
						txtcantidad_empresa.getText();
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(otros.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(otros.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(otros.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(otros.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(otros.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(otros.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(otros.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(otros.get(posicionprincipal).getSimbolo()));
						lblgasto.setText(" ");
						lblcantidad.setText(" ");
						lblBeneficio.setText(" ");
						lblDinero.setText(" ");
						lblCantidad.setText(" ");
						lblGasto.setText(" ");
					}else {
						lblnombreapi.setText("-");
						lblsectorapi.setText("-");
						lblmercadoapi.setText("-");
						lblhighapi.setText("-");
						lbllowapi.setText("-");
						lblopenapi.setText("-");
						lblcloseapi.setText("-");
						lblpriceapi.setText("-");
						lblgasto.setText("gasto :");
						lblcantidad.setText("cantidad :");
						lblBeneficio.setText("beneficio :");
						lblDinero.setText("-");
						lblCantidad.setText("-");
						lblGasto.setText("-");
					}
					cantidad_empresa.setText(String.valueOf((otros.size()-1)));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(par_boton_otros%2==0) {
					button_1.setEnabled(true);
					button_8.setEnabled(true);
					boton_nada.setSelected(true);
					button_comprar.setEnabled(true);
					button_2.setEnabled(false);
					button_8.setText("dinero");
					metodo=true;

					posicionprincipal=0;
					try {
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
					lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
					lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
					lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
					lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
					lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
					lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
					lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
					lblgasto.setText(" ");
					lblcantidad.setText(" ");
					lblBeneficio.setText(" ");
					lblDinero.setText(" ");
					lblCantidad.setText(" ");
					lblGasto.setText(" ");
					cantidad_empresa.setText(String.valueOf((empresas.size()-1)));
					txtcantidad_empresa.setText("0");
					
					siguiente_pagina.setVisible(true);
					anterior_pagina.setVisible(true);
					pagina.setVisible(true);
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
					
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}else {
				
			}
		}
		});
		
		boton_recomendado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(boton_recomendado.isSelected()) {
					lbltitulo.setText("recomendado");
					button_1.setEnabled(false);
					recomendado=Comprado.pararecomendados();
				par_boton_recomendado++;
				posicionprincipal=0;
				button_2.setEnabled(false);
				button_comprar.setEnabled(true);
				
					
					metodo=false;
					button_8.setEnabled(true);
					try {if(recomendado.size()!=0) {

						txtcantidad_empresa.setText("0");
						txtcantidad_empresa.getText();
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(recomendado.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(recomendado.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(recomendado.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(recomendado.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(recomendado.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(recomendado.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()));
						lblgasto.setText(" ");
						lblcantidad.setText(" ");
						lblBeneficio.setText(" ");
						lblDinero.setText(" ");
						lblCantidad.setText(" ");
						lblGasto.setText(" ");
					}else {
						lblnombreapi.setText("-");
						lblsectorapi.setText("-");
						lblmercadoapi.setText("-");
						lblhighapi.setText("-");
						lbllowapi.setText("-");
						lblopenapi.setText("-");
						lblcloseapi.setText("-");
						lblpriceapi.setText("-");
						lblgasto.setText("gasto :");
						lblcantidad.setText("cantidad :");
						lblBeneficio.setText("beneficio :");
						lblDinero.setText("-");
						lblCantidad.setText("-");
						lblGasto.setText("-");
					}
					siguiente_pagina.setVisible(false);
					anterior_pagina.setVisible(false);
					pagina.setVisible(false);
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(recomendado.get(posicionprincipal+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(recomendado.get(posicionprincipal+9).getSimbolo()));
					
					
					
					
					cantidad_empresa.setText(String.valueOf((recomendado.size()-1)));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(par_boton_recomendado%2==0) {

					panel_empresas_otros.setVisible(true);
					lbltitulo.setText("comprar");
					button_1.setEnabled(true);
					button_8.setEnabled(true);
					boton_nada.setSelected(true);
					button_comprar.setEnabled(true);
					button_2.setEnabled(false);
					button_8.setText("dinero");
					metodo=true;

					posicionprincipal=0;
					try {
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
					lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
					lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
					lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
					lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
					lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
					lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
					lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
					lblgasto.setText(" ");
					lblcantidad.setText(" ");
					lblBeneficio.setText(" ");
					lblDinero.setText(" ");
					lblCantidad.setText(" ");
					lblGasto.setText(" ");
					cantidad_empresa.setText(String.valueOf((empresas.size()-1)));
					txtcantidad_empresa.setText("0");
					
					siguiente_pagina.setVisible(true);
					anterior_pagina.setVisible(true);
					pagina.setVisible(true);
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}else {
				
			}
		
				
			}
		});
		
		boton_favoritos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				favoritos=Comprado.parafavoritas();
				
				if(boton_favoritos.isSelected()) {
					lbltitulo.setText("favoritos");
					button_1.setEnabled(false);
					panel_empresas_otros.setVisible(false);
				par_boton_favoritos++;
				posicionprincipal=0;
				button_2.setEnabled(false);
				button_comprar.setEnabled(true);
				
					
					metodo=false;
					button_8.setEnabled(true);
					try {if(favoritos.size()!=0) {

						txtcantidad_empresa.setText("0");
						txtcantidad_empresa.getText();
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(favoritos.get(posicionprincipal).getSimbolo()));
						lblsectorapi.setText(API_Acciones.quota_empresa_sector(favoritos.get(posicionprincipal).getSimbolo()));
						lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(favoritos.get(posicionprincipal).getSimbolo()));
						lblhighapi.setText(API_Acciones.quota_empresa_high(favoritos.get(posicionprincipal).getSimbolo()));
						lbllowapi.setText(API_Acciones.quota_empresa_low(favoritos.get(posicionprincipal).getSimbolo()));
						lblopenapi.setText(API_Acciones.quota_empresa_open(favoritos.get(posicionprincipal).getSimbolo()));
						lblcloseapi.setText(API_Acciones.quota_empresa_close(favoritos.get(posicionprincipal).getSimbolo()));
						lblpriceapi.setText(API_Acciones.precio_empresa(favoritos.get(posicionprincipal).getSimbolo()));
						lblgasto.setText(" ");
						lblcantidad.setText(" ");
						lblBeneficio.setText(" ");
						lblDinero.setText(" ");
						lblCantidad.setText(" ");
						lblGasto.setText(" ");
					}else {
						lblnombreapi.setText("-");
						lblsectorapi.setText("-");
						lblmercadoapi.setText("-");
						lblhighapi.setText("-");
						lbllowapi.setText("-");
						lblopenapi.setText("-");
						lblcloseapi.setText("-");
						lblpriceapi.setText("-");
						lblgasto.setText("gasto :");
						lblcantidad.setText("cantidad :");
						lblBeneficio.setText("beneficio :");
						lblDinero.setText("-");
						lblCantidad.setText("-");
						lblGasto.setText("-");
					}
					cantidad_empresa.setText(String.valueOf((favoritos.size()-1)));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(par_boton_favoritos%2==0) {
					lbltitulo.setText("comprar");
					button_1.setEnabled(true);
					panel_empresas_otros.setVisible(true);
					button_8.setEnabled(true);
					boton_nada.setSelected(true);
					button_comprar.setEnabled(true);
					button_2.setEnabled(false);
					button_8.setText("dinero");
					metodo=true;

					posicionprincipal=0;
					try {
						lblnombreapi.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicionprincipal).getSimbolo()));
					lblsectorapi.setText(API_Acciones.quota_empresa_sector(empresas.get(posicionprincipal).getSimbolo()));
					lblmercadoapi.setText(API_Acciones.quota_empresa_mercado(empresas.get(posicionprincipal).getSimbolo()));
					lblhighapi.setText(API_Acciones.quota_empresa_high(empresas.get(posicionprincipal).getSimbolo()));
					lbllowapi.setText(API_Acciones.quota_empresa_low(empresas.get(posicionprincipal).getSimbolo()));
					lblopenapi.setText(API_Acciones.quota_empresa_open(empresas.get(posicionprincipal).getSimbolo()));
					lblcloseapi.setText(API_Acciones.quota_empresa_close(empresas.get(posicionprincipal).getSimbolo()));
					lblpriceapi.setText(API_Acciones.precio_empresa(empresas.get(posicionprincipal).getSimbolo()));
					lblgasto.setText(" ");
					lblcantidad.setText(" ");
					lblBeneficio.setText(" ");
					lblDinero.setText(" ");
					lblCantidad.setText(" ");
					lblGasto.setText(" ");
					cantidad_empresa.setText(String.valueOf((empresas.size()-1)));
					txtcantidad_empresa.setText("0");
					
					siguiente_pagina.setVisible(true);
					anterior_pagina.setVisible(true);
					pagina.setVisible(true);
					lblnombre_2.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion).getSimbolo()));
					lblnombre_3.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+1).getSimbolo()));
					lblnombre_4.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+2).getSimbolo()));
					lblnombre_5.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+3).getSimbolo()));
					lblnombre_6.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+4).getSimbolo()));
					lblnombre_7.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+5).getSimbolo()));
					lblnombre_8.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+6).getSimbolo()));
					lblnombre_9.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+7).getSimbolo()));
					lblnombre_10.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+8).getSimbolo()));
					lblnombre_11.setText(API_Acciones.quota_empresa_nombre(empresas.get(posicion+9).getSimbolo()));
					
					lblprecio_2.setText(API_Acciones.precio_empresa(empresas.get(posicion).getSimbolo()));
					lblprecio_3.setText(API_Acciones.precio_empresa(empresas.get(posicion+1).getSimbolo()));
					lblprecio_4.setText(API_Acciones.precio_empresa(empresas.get(posicion+2).getSimbolo()));
					lblprecio_5.setText(API_Acciones.precio_empresa(empresas.get(posicion+3).getSimbolo()));
					lblprecio_6.setText(API_Acciones.precio_empresa(empresas.get(posicion+4).getSimbolo()));
					lblprecio_7.setText(API_Acciones.precio_empresa(empresas.get(posicion+5).getSimbolo()));
					lblprecio_8.setText(API_Acciones.precio_empresa(empresas.get(posicion+6).getSimbolo()));
					lblprecio_9.setText(API_Acciones.precio_empresa(empresas.get(posicion+7).getSimbolo()));
					lblprecio_10.setText(API_Acciones.precio_empresa(empresas.get(posicion+8).getSimbolo()));
					lblprecio_11.setText(API_Acciones.precio_empresa(empresas.get(posicion+9).getSimbolo()));
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}else {
				
			}
		
				
			}
		});	
		
		
		
		
		
		JButton reiniciar = new JButton("reiniciar");
		reiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(boton_recomendado.isSelected() || boton_otros.isSelected() || boton_propiedad.isSelected() || boton_favoritos.isSelected()) {}else {
					Comprado.borrar_todo();
					
					try {
						Comprado.recomendaciones10(empresas);
						label_5.setText(Comprado.favoritas1());
						label_6.setText(Comprado.favoritas2());
						label_2.setText(Comprado.recomendado2());
						label_1.setText(Comprado.recomendado1());
						lblNewLabel.setText(Comprado.empresa1());
						label.setText(Comprado.empresa2());
						lblSaldo.setText("1000");
						lblGastado.setText("0");
						lblGanado.setText("0");
						
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
				
			}
		});
		reiniciar.setBounds(12, 271, 301, 29);
		panel_usuario.add(reiniciar);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}