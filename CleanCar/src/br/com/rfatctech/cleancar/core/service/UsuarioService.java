package br.com.rfatctech.cleancar.core.service;
import br.com.rfatctech.cleancar.core.util.NegocioException;

import java.util.List;

import br.com.rfatctech.cleancar.core.bo.UsuarioBO;
import br.com.rfatctech.cleancar.core.dao.UsuarioDAO;
import br.com.rfatctech.cleancar.core.entity.UsuarioEntity;

public class UsuarioService {
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException  {
		System.out.println("Entrando no backend, camada service...");
	    UsuarioBO bo = new UsuarioBO();
	    return bo.salvarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException{
		return new UsuarioBO().listarUsuario();
	}
	
	public void excluirUsuario (Long codigoUsuario) throws NegocioException {
		new UsuarioBO().excluirUsuario(codigoUsuario);
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException {
		return new UsuarioBO().buscarUsuarioPorId(codigoUsuario);
	}
	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException {
		return new UsuarioBO().alterarUsuario(usuario);
	}
}
