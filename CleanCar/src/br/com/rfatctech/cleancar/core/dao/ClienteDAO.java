package br.com.rfatctech.cleancar.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rfatctech.cleancar.core.dao.connection.ConexaoMySQL;
import br.com.rfatctech.cleancar.core.entity.ClienteEntity;
import br.com.rfatctech.cleancar.core.util.NegocioException;

public class ClienteDAO {
	public String salvarCliente(ClienteEntity cliente)  throws NegocioException{
		
 		String sql = "INSERT INTO CLIENTE (NOME_CLIENTE, TELEFONE_CLIENTE, EMAIL_CLIENTE, ENDERECO_CLIENTE, CPFCNPJ_CLIENTE) VALUES (?,?,?,?,?)";
 		
 		PreparedStatement ps = null;
 		
 	try {
		    ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCpfcnpj());
			ps.execute();
			
			
	} catch (SQLException e) {	
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar cliente");
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
 	return "Cliente cadastrado com sucesso no banco de dados";
	}
	
	public List<ClienteEntity> listarCliente() throws NegocioException{
		
		
		String sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE_CLIENTE, EMAIL_CLIENTE, ENDERECO_CLIENTE, CPFCNPJ_CLIENTE FROM CLIENTE";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ClienteEntity cli = new ClienteEntity();
				cli.setCodigo(rs.getLong("ID_CLIENTE"));
				cli.setNome(rs.getString("NOME_CLIENTE"));
				cli.setTelefone(rs.getString("TELEFONE_CLIENTE"));
				cli.setEmail(rs.getString("EMAIL_CLIENTE"));
				cli.setEndereco(rs.getString("ENDERECO_CLIENTE"));
				cli.setCpfcnpj(rs.getString("CPFCNPJ_CLIENTE"));
				clientes.add(cli);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NegocioException ("Erro ao listar os clientes");
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		return clientes;
		
	}
	public void excluirCliente(Long codigoCliente) throws NegocioException {
		
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps =  null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o cliente");
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public ClienteEntity buscarClientePorId(Long codigoCliente) throws NegocioException {
		
		String sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE_CLIENTE, EMAIL_CLIENTE, ENDERECO_CLIENTE, CPFCNPJ_CLIENTE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		ResultSet rs=null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			rs = ps.executeQuery();
			
			ClienteEntity clienteEncontrado = null;
			
			if(rs.next()) {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.setCodigo(rs.getLong("ID_CLIENTE"));
				clienteEncontrado.setNome(rs.getString("NOME_CLIENTE"));
				clienteEncontrado.setTelefone(rs.getString("TELEFONE_CLIENTE"));
				clienteEncontrado.setEmail(rs.getString("EMAIL_CLIENTE"));
				clienteEncontrado.setEndereco(rs.getString("ENDERECO_CLIENTE"));
				clienteEncontrado.setEndereco(rs.getString("CPFCNPJ_CLIENTE"));
			}
			return clienteEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar o cliente");	
		} finally {
			try {
				ps.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public String alterarCliente(ClienteEntity cliente) throws NegocioException{
		
		String sql = "UPDATE CLIENTE SET NOME_CLIENTE = ?, TELEFONE_CLIENTE = ?, EMAIL_CLIENTE = ?, ENDERECO_CLIENTE = ?, CPFCNPJ_CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCpfcnpj());
			ps.setLong(6, cliente.getCodigo());
			ps.execute();
		
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados de cliente");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O Cliente foi alterado com sucesso";
	}
}