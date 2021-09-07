package views;

import java.awt.BorderLayout;
import controllers.controller_medico;
import controllers.ConexaoBD;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import models.Medico;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTable table;
	private JTextField txtNomeMedicoPesquisa;
	

	controller_medico cont_med = new controller_medico();
	ConexaoBD conec = new ConexaoBD();
	private JTextField txtCodMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroMedico frame = new cadastroMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void formatarCampo(JFormattedTextField crm) {
		try {
			MaskFormatter mascara = new MaskFormatter("#####");
			mascara.install(crm);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar CRM: \n" + e);
		}
	}

	/**
	 * Create the frame.
	 */
	public cadastroMedico() {
		setSize(new Dimension(621, 582));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 5, 25, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 20));
		
		JButton btnNovoMedico = new JButton("Novo");
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 326, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(138, 325, 201, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		
		
		
		JFormattedTextField ftxtCrm = 	new JFormattedTextField();
		formatarCampo(ftxtCrm);
		ftxtCrm.setEnabled(false);
		ftxtCrm.setBounds(512, 325, 201, 20);
		panel.add(ftxtCrm);
		
		JLabel lblNewLabel_2 = new JLabel("CRM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(456, 326, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Especialidade");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(20, 381, 108, 14);
		panel.add(lblNewLabel_2_1);
		
		JComboBox cbEspecialidade = new JComboBox();
		cbEspecialidade.setEnabled(false);
		cbEspecialidade.setToolTipText("");
		cbEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Dentista", "Radiologia", "Oncologia", "Oftalmologia", "Pediatria"}));
		cbEspecialidade.setBounds(138, 379, 201, 22);
		panel.add(cbEspecialidade);
		
		JButton btnSalvarMedico = new JButton("Salvar");
		btnSalvarMedico.setEnabled(false);
		btnSalvarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico med = new Medico();
				med.setCodigo(Integer.parseInt(txtCodMedico.getText()));
				med.setNome(txtNome.getText());
				med.setEspecilaidade(cbEspecialidade.getSelectedItem().toString());
				med.setCrm(Integer.parseInt(ftxtCrm.getText()));
				
				cont_med.EditarMedico(med);
				
				txtNome.setEnabled(false);
				txtNome.setText("");
				ftxtCrm.setEnabled(false);
				ftxtCrm.setText("");
				cbEspecialidade.setSelectedIndex(0);;
				cbEspecialidade.setEnabled(false);
				txtCodMedico.setText("");
				btnSalvarMedico.setEnabled(false);
				btnNovoMedico.setEnabled(true);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				//Remove as linhas da pesquisa anterior
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}
			}
		});
		btnSalvarMedico.setBounds(20, 580, 201, 23);
		panel.add(btnSalvarMedico);
		
		JButton btnExluirMedico = new JButton("Excluir");
		btnExluirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont_med.ExcluirMedico(Integer.parseInt(txtCodMedico.getText()));
				
				txtNome.setEnabled(false);
				txtNome.setText("");
				ftxtCrm.setEnabled(false);
				ftxtCrm.setText("");
				cbEspecialidade.setSelectedIndex(0);;
				cbEspecialidade.setEnabled(false);
				txtCodMedico.setText("");
				btnSalvarMedico.setEnabled(false);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				//Remove as linhas da pesquisa anterior
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}

			}
		});
		btnExluirMedico.setEnabled(false);
		btnExluirMedico.setBounds(20, 614, 201, 23);
		panel.add(btnExluirMedico);
		
		JButton btnCadatroMedico = new JButton("Cadastrar");
		btnCadatroMedico.setEnabled(false);
		btnCadatroMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico med = new Medico();
				
				med.setNome(txtNome.getText());
				med.setEspecilaidade(cbEspecialidade.getSelectedItem().toString());
				med.setCrm(Integer.parseInt(ftxtCrm.getText()));
				
				cont_med.Gravar(med);
				
				txtNome.setText("");
				ftxtCrm.setText("");
				txtNome.setEnabled(false);
				ftxtCrm.setEnabled(false);
				cbEspecialidade.setEnabled(false);
				btnCadatroMedico.setEnabled(false);
				btnNovoMedico.setEnabled(true);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				//Remove as linhas da pesquisa anterior
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}
			}
		});
		btnCadatroMedico.setBounds(20, 512, 201, 23);
		panel.add(btnCadatroMedico);
		
		
		JButton btnEditarMedico = new JButton("Editar");
		btnEditarMedico.setEnabled(false);
		btnEditarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setEnabled(true);
				ftxtCrm.setEnabled(true);
				cbEspecialidade.setEnabled(true);
				btnSalvarMedico.setEnabled(true);
				btnEditarMedico.setEnabled(false);
				btnExluirMedico.setEnabled(false);
				btnNovoMedico.setEnabled(false);
			}
		});
		btnEditarMedico.setBounds(20, 546, 201, 23);
		panel.add(btnEditarMedico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 126, 693, 129);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cod_Medico");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(20, 281, 105, 14);
		panel.add(lblNewLabel_1_1);
		
		txtCodMedico = new JTextField();
		txtCodMedico.setEnabled(false);
		txtCodMedico.setBounds(135, 278, 56, 20);
		panel.add(txtCodMedico);
		txtCodMedico.setColumns(10);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnEditarMedico.setEnabled(true);
				btnExluirMedico.setEnabled(true);
				
				//Mostrando a linha selecionada
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int linha = table.getSelectedRow();	
				txtCodMedico.setText(model.getValueAt(linha, 0).toString());
				txtNome.setText(model.getValueAt(linha, 1).toString());
				ftxtCrm.setText(model.getValueAt(linha, 2).toString());
				cbEspecialidade.setSelectedItem(model.getValueAt(linha, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod_Medico", "Nome", "CRM", "Especialidade"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Pesquisa:");
		lblNewLabel_3.setBounds(276, 11, 67, 14);
		panel.add(lblNewLabel_3);
		

		btnNovoMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNovoMedico.setEnabled(false);
				btnCadatroMedico.setEnabled(true);
				txtNome.setEnabled(true);
				txtNome.setText("");
				ftxtCrm.setText("");
				cbEspecialidade.setSelectedIndex(0);
				ftxtCrm.setEnabled(true);
				cbEspecialidade.setEnabled(true);
				txtCodMedico.setText("");
				btnEditarMedico.setEnabled(false);
				btnExluirMedico.setEnabled(false);
			}
		});
		btnNovoMedico.setBounds(20, 478, 201, 23);
		panel.add(btnNovoMedico);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(20, 28, 693, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setBounds(64, 15, 71, 14);
		panel_1.add(lblNewLabel_4);
		
		txtNomeMedicoPesquisa = new JTextField();
		txtNomeMedicoPesquisa.setBounds(137, 12, 226, 20);
		panel_1.add(txtNomeMedicoPesquisa);
		txtNomeMedicoPesquisa.setColumns(10);
		
		JButton btnPesquisarMedico = new JButton("Pesquisar");
		btnPesquisarMedico.setBounds(284, 43, 147, 23);
		panel_1.add(btnPesquisarMedico);
		btnPesquisarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer cod;
				String nome;
				String especialidade;
				Integer crm;
				
				ArrayList<Medico> lista = new ArrayList<Medico>();
				
				lista = cont_med.PesquisaMedico(txtNomeMedicoPesquisa.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				//Remove as linhas da pesquisa anterior
				int rowCount = model.getRowCount();
				for (int i = rowCount - 1; i >= 0; i--) {
				    model.removeRow(i);
				}
				
				//Adiciona as linhas do array retornado na tabela
				for(int i = 0; i < lista.size(); i++)
				{		
					cod = lista.get(i).getCodigo();
					nome = lista.get(i).getNome();
					crm = lista.get(i).getCrm();
					especialidade = lista.get(i).getEspecilaidade();
					model.addRow(new String[] {cod.toString(), nome, crm.toString(),especialidade});
				}
			}
		});
		
		
		
		
		JLabel lblNewLabel = new JLabel("Formul\u00E1rio de Cadastro de M\u00E9dicos:");
		lblNewLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
}
