package lumiere.central.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lumiere.central.model.Pagamento;
import lumiere.central.repository.PagamentoRepository;

@Service
public class PagamentoServiceDB implements PagamentoService {

	@Autowired 
	private PagamentoRepository pagamentirepository;

	@Override
	public List<Pagamento> getPagamenti() {
		return (List<Pagamento>) pagamentirepository.findAll();
	}

	@Override
	public Pagamento getPagamento(Long id) {
		Optional<Pagamento> p = pagamentirepository.findById(id);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}

	@Override
	public Long addPagamento(Pagamento pagamento) {
		Pagamento p = pagamentirepository.save(pagamento);
		return p.getId();
	}

	@Override
	public Pagamento updatePagamento(Pagamento pagamento, Long id) {
		if (pagamentirepository.existsById(id)) {
			Pagamento p = pagamentirepository.findById(id).get(); 
			p.setTipo(pagamento.getTipo());
			p.setUtenti(pagamento.getUtenti());
			pagamentirepository.save(p);
			return p;
		}
		return null;
	}

	@Override
	public boolean deletePagamento(Long id) {
		if (pagamentirepository.existsById(id)) {
			pagamentirepository.deleteById(id);
			return true;
		}
		return false;
	}

}

