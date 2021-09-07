package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controllers.ConexaoBD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal extends JFrame {
	
	ConexaoBD conecta = new ConexaoBD();
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		
		conecta.conexao();
		
		setTitle("Menu Principal");
		setMinimumSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmMedico = new JMenuItem("M\u00E9dicos");
		mntmMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroMedico cadMed = new cadastroMedico();
				cadMed.setVisible(true);
			}
		});
		mnCadastro.add(mntmMedico);
		
		
		JMenuItem mntmPaciente = new JMenuItem("Pacientes");
		mnCadastro.add(mntmPaciente);
		
		JMenuItem mntmEnfermeiro = new JMenuItem("Enfermeiros");
		mnCadastro.add(mntmEnfermeiro);
		
		JMenuItem mntmUsuario = new JMenuItem("Usu\u00E1rios");
		mnCadastro.add(mntmUsuario);
		
		JMenu mnRelatorio = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorio);
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("Bem-Vindo");
		internalFrame.setMinimumSize(new Dimension(500, 34));
		internalFrame.setBounds(0, 168, 784, 327);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(500, 500));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 51, 768, 234);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCadMedico = new JButton("");
		btnCadMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroMedico cadMed = new cadastroMedico();
				cadMed.setVisible(true);
			}
		});
		btnCadMedico.setToolTipText("Cadsatro de M\u00E9dicos");
		btnCadMedico.setIcon(new ImageIcon(principal.class.getResource("/img/CadMedicos.png")));
		btnCadMedico.setBounds(45, 36, 110, 133);
		panel.add(btnCadMedico);
		
		JButton btnPacientes = new JButton("");
		btnPacientes.setToolTipText("Cadastro de Pacientes");
		btnPacientes.setIcon(new ImageIcon(principal.class.getResource("/img/cadPacientes.png")));
		btnPacientes.setBounds(194, 36, 110, 133);
		panel.add(btnPacientes);
		
		JButton btnAgenda = new JButton("");
		btnAgenda.setToolTipText("Agenda");
		btnAgenda.setIcon(new ImageIcon(principal.class.getResource("/img/Agenda.png")));
		btnAgenda.setBounds(351, 36, 116, 133);
		panel.add(btnAgenda);
		
		JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 16, 246, 24);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JButton btnFechar = new JButton("");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conecta.desconecta();
				System.exit(0);
			}
		});
		btnFechar.setIcon(new ImageIcon(principal.class.getResource("/img/exit.png")));
		btnFechar.setBounds(724, 11, 38, 40);
		contentPane.add(btnFechar);
		internalFrame.setVisible(true);

	}
}
