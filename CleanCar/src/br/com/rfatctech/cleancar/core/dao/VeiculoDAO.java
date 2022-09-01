package br.com.rfatctech.cleancar.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rfatctech.cleancar.core.dao.connection.ConexaoMySQL;
import br.com.rfatctech.cleancar.core.entity.VeiculoEntity;
import br.com.rfatctech.cleancar.core.util.NegocioException;

public class VeiculoDAO {
	public String salvarVeiculo(VeiculoEntity usuario)  throws NegocioException{
		
 		String sql = "INSERT INTO VEICULO (ano_veiculo, placa_veiculo, cor_veiculo) VALUES (?,?,?)";
 		
 		PreparedStatement ps = null;
 		
 	try {
		    ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, veiculo.getNome());
			ps.setString(2, veiculo.getLogin());
			ps.setString(3, veiculo.getSenha());
			ps.setString(4, veiculo.getEmail());
			
			ps.execute();
 	} catch (SQLException e) {	
		e.printStackTrace();
		throw new NegocioException("Erro ao cadastrar veiculo");
		
	} finally {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	return "Veiculo cadastrado com sucesso no banco de dados";
}