package com.model.servico;

import java.util.List;
import com.model.entidades.base.TipoServicoAutomotivo;

public interface ITipoServicoAutomotivoService {
	void salvar(TipoServicoAutomotivo obj);
	void remover(TipoServicoAutomotivo obj);
	void alterar(TipoServicoAutomotivo obj);
	List<TipoServicoAutomotivo> lista();
	TipoServicoAutomotivo procurarPorId(Long id);
}
