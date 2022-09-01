package br.com.rfatctech.cleancar.core.bo;

import br.com.rfatctech.cleancar.core.dao.VeiculoDAO;
import br.com.rfatctech.cleancar.core.entity.VeiculoEntity;
import br.com.rfatctech.cleancar.core.util.NegocioException;

public class VeiculoBO {

	public String salvarVeiculo(VeiculoEntity veiculo) throws NegocioException {
		System.out.println("Camada BO, processando informações");		
		
		VeiculoDAO udao = new VeiculoDAO();		
		return udao.salvarVeiculo(veiculo);
	}

}
