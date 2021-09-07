package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField psSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/img/perfil4.png")));
		lblNewLabel_2.setBounds(179, 53, 80, 80);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(136, 180, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setBounds(136, 133, 46, 14);
		contentPane.add(lblNewLabel);
		
		psSenha = new JPasswordField();
		psSenha.setBounds(136, 198, 184, 20);
		contentPane.add(psSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(136, 149, 184, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(137, 280, 183, 23);
		contentPane.add(btnSair);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				principal tela = new principal();
				tela.setVisible(true);
				dispose();
				
				
			}
		});
		btnLogin.setBounds(137, 246, 183, 23);
		contentPane.add(btnLogin);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(login.class.getResource("/img/fundotelaLogin.png")));
		lblFundo.setBounds(0, 0, 434, 379);
		contentPane.add(lblFundo);
	}
}
