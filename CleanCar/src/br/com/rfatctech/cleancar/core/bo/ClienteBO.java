package br.com.rfatctech.cleancar.core.bo;

import java.util.List;

import br.com.rfatctech.cleancar.core.dao.ClienteDAO;
import br.com.rfatctech.cleancar.core.entity.ClienteEntity;
import br.com.rfatctech.cleancar.core.util.NegocioException;

public class ClienteBO {
	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		System.out.println("Camada BO, processando informações");
	
		ClienteDAO udao = new ClienteDAO();		
		return udao.salvarCliente(cliente);
	}
	public List<ClienteEntity> listarCliente() throws NegocioException{
		return new ClienteDAO().listarCliente();
	}
	
	public void excluirCliente(Long codigoCliente) throws NegocioException {
		new ClienteDAO().excluirCliente(codigoCliente);
	}
	public ClienteEntity buscarClientePorId(Long codigoCliente) throws NegocioException {
		return new ClienteDAO().buscarClientePorId(codigoCliente);
	}
	public String alterarCliente(ClienteEntity cliente) throws NegocioException {
			
		return new ClienteDAO().alterarCliente(cliente);
	}
}	