package br.com.rfatctech.cleancar.core.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.rfatctech.cleancar.core.entity.ClienteEntity;
import br.com.rfatctech.cleancar.core.service.ClienteService;
import br.com.rfatctech.cleancar.core.util.NegocioException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfCliCodigo;
	private JTextField tfCliNome;
	private JTextField tfCliTelefone;
	private JTextField tfCliEmail;
	private JTextField tfCliEndereco;
	private JTextField tfCliCpfcnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblEndereco = new JLabel("Endereco");
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		
		tfCliCodigo = new JTextField();
		tfCliCodigo.setEnabled(false);
		tfCliCodigo.setEditable(false);
		tfCliCodigo.setColumns(10);
		
		tfCliNome = new JTextField();
		tfCliNome.setColumns(10);
		
		tfCliTelefone = new JTextField();
		tfCliTelefone.setColumns(10);
		
		tfCliEmail = new JTextField();
		tfCliEmail.setColumns(10);
		
		tfCliEndereco = new JTextField();
		tfCliEndereco.setColumns(10);
		
		tfCliCpfcnpj = new JTextField();
		tfCliCpfcnpj.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity cli = new ClienteEntity();
				cli.setNome(tfCliNome.getText());
				cli.setTelefone(tfCliTelefone.getText());
				cli.setEmail(tfCliEmail.getText());
				cli.setEndereco(tfCliEndereco.getText());
				cli.setCpfcnpj(tfCliCpfcnpj.getText());
				
				try {
					String msg = new ClienteService().salvarCliente(cli);
					limparCampos();
					JOptionPane.showMessageDialog(null, msg);
				}catch(NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro ao cadastrar cliente aqui", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(247)
							.addComponent(lblCadastroCliente, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCodigo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCliCodigo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCliNome, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCliTelefone, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCliEmail, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCliEndereco, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCpfcnpj, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCliCpfcnpj, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblCadastroCliente)
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(tfCliCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(tfCliNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(tfCliTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(tfCliEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereco)
						.addComponent(tfCliEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCpfcnpj)
						.addComponent(tfCliCpfcnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btnSalvar)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void limparCampos() {
		tfCliCodigo.setText("");
		tfCliNome.setText("");
		tfCliTelefone.setText("");
		tfCliEmail.setText("");
		tfCliEndereco.setText("");
		tfCliCpfcnpj.setText("");
	}
	
	public void carregarClientePorId(Long codigoCliente) {
		try {
			ClienteEntity clienteEncontrado =  new ClienteService().buscarClientePorId(codigoCliente);
			
			if(clienteEncontrado == null) {
				JOptionPane.showMessageDialog(null,"O cliente não foi localizado","Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				tfCliCodigo.setText(""+clienteEncontrado.getCodigo());
				tfCliNome.setText(clienteEncontrado.getNome());
				tfCliTelefone.setText(clienteEncontrado.getTelefone());
				tfCliEmail.setText(clienteEncontrado.getEmail());
				tfCliEndereco.setText(clienteEncontrado.getEndereco());	
				tfCliCpfcnpj.setText(clienteEncontrado.getCpfcnpj());		
			}
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
			
		}
				
	}
}
