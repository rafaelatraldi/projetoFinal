package br.com.rfatctech.cleancar.core.bo;


import java.util.List;

import br.com.rfatctech.cleancar.core.dao.UsuarioDAO;
import br.com.rfatctech.cleancar.core.entity.UsuarioEntity;
import br.com.rfatctech.cleancar.core.util.NegocioException;
//import br.com.rfatctech.cleancar.core.util.exception.NegocioException;

public class UsuarioBO {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
		System.out.println("Camada BO, processando informações");
		if(!usuario.getEmail().contains("@")) {
			throw new NegocioException("O email está no formato inválido, favor verificar!");
			//return "O email está no formato inválido, favor verificar!";
		}
		//TODO Poderia criptografar a senha
		//TODO Poderia validar o restante das informações
		
		if(usuario.getNome() != null && usuario.getNome().equals("")) {
			//throw new NegocioException("O nome do usuário precisa ser preenchido");
			return "O nome do usuário precisa ser preenchido";
			
		}
		
		UsuarioDAO udao = new UsuarioDAO();		
		return udao.salvarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException{
		return new UsuarioDAO().listarUsuario();
	}
	
	public void excluirUsuario(Long codigoUsuario) throws NegocioException {
		new UsuarioDAO().excluirUsuario(codigoUsuario);
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException {
		return new UsuarioDAO().buscarUsuarioPorId(codigoUsuario);
	}
	
}
