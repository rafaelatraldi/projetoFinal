package br.com.rfatctech.cleancar.core.view.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.rfatctech.cleancar.core.entity.UsuarioEntity;
import br.com.rfatctech.cleancar.core.service.UsuarioService;
import br.com.rfatctech.cleancar.core.util.NegocioException;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<UsuarioEntity> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaUsuario frame = new TelaListaUsuario();
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
	public TelaListaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 590);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o usuário de código  " +usuarioSelecionado.getCodigo()) == JOptionPane.OK_OPTION ); {
					
					try {
						new UsuarioService().excluirUsuario(usuarioSelecionado.getCodigo());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				TelaCadastroUsuario tcu = new TelaCadastroUsuario();
				tcu.carregarUsuarioPorId(usuarioSelecionado.getCodigo());
				tcu.setVisible(true);				
			}
		});
		btnEditar.setEnabled(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnEditar)
							.addGap(28)
							.addComponent(btnExcluir)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Login", "Senha", "E-mail"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		 popularTabela();
	}
	
	private void popularTabela() {
		try {
			usuarios = new UsuarioService().listarUsuario();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.getDataVector().removeAllElements();
			
			for(UsuarioEntity usuarioEntity : usuarios) {
				model.addRow(new Object[] {usuarioEntity.getCodigo(), usuarioEntity.getNome(), usuarioEntity.getLogin(), usuarioEntity.getSenha(), usuarioEntity.getEmail()});
			}
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados"+ e.getMensagemDeErro());
			
		}
	}
}
