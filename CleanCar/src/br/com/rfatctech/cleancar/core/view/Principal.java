package br.com.rfatctech.cleancar.core.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.rfatctech.cleancar.core.entity.UsuarioEntity;
import br.com.rfatctech.cleancar.core.service.UsuarioService;
import br.com.rfatctech.cleancar.core.util.NegocioException;

public class Principal {

	public static void main(String[] args) {
		//montando o objeto com as informações da tela
//		UsuarioEntity usuario = new UsuarioEntity();
//		usuario.setNome("Rafaela");
//		usuario.setLogin ("rafa");
//		usuario.setSenha("1234");
//		usuario.setEmail("rafaelatraldic@gmail.com");
//		//estou chamando meu core/backend para salvar o usuario
//		UsuarioService us = new UsuarioService();
//		try {
//		System.out.println(us.salvarUsuario(usuario));
//		}catch(NegocioException e) {
//			JOptionPane.showMessageDialog(null, e.getMensagemDeErro());
//		}
		
		
//		try {
//			new UsuarioService().excluirUsuario(2L);
//		} catch (NegocioException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		List<UsuarioEntity> usuarios;
//		try {
//			usuarios = new UsuarioService().listarUsuario();	
//		for (UsuarioEntity usuarioEntity : usuarios) {
//			System.out.println("Nome"+ usuarioEntity.getNome() + " - Codigo " + usuarioEntity.getCodigo());
//		}
//		} catch (NegocioException e) {
//			// TODO Auto-generated catch block
// e.printStackTrace();
//		}
		
	/*	try {
			UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorId(3L);
			if(usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Não encontrou o usuario");
			}else {
				JOptionPane.showMessageDialog(null,"O usuário encontrado foi " + usuarioEncontrado.getNome());
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setCodigo(8L);
		usuario.setNome("Marcos");
		usuario.setLogin ("rafa");
		usuario.setSenha("1234");
		usuario.setEmail("rafaelatraldic@gmail.com");
		
		try {
			JOptionPane.showMessageDialog(null, new UsuarioService().alterarUsuario(usuario));
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
