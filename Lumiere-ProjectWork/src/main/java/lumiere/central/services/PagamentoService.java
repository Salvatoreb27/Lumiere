package lumiere.central.services;

import java.util.List;

import lumiere.central.model.Pagamento;

public interface PagamentoService {
	//visualizzazione di tutti i pagamenti 
	List<Pagamento> getPagamenti();
	//visualizzazione di un pagamento specifico
	Pagamento getPagamento(Long id);
	//inserimento di un nuovo pagamento
	Long addPagamento(Pagamento pagamento);
	//modifica di un pagamento esistente
	Pagamento updatePagamento(Pagamento pagamento, Long id);
	//cancellazione di un pagamento esistente
	boolean deletePagamento(Long id);
}
