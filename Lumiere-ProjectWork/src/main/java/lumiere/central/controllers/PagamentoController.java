package lumiere.central.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lumiere.central.model.Pagamento;
import lumiere.central.services.PagamentoService;

@CrossOrigin
@RestController 
@RequestMapping("/lumiere/pagamenti")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping("/all")
	public List<Pagamento> getAllPagamenti() {
		return pagamentoService.getPagamenti();
	}
	
	@GetMapping("/{id}")
	public Pagamento getPagamentoById(@PathVariable Long id) {
		Pagamento pagamento = pagamentoService.getPagamento(id);
		if (pagamento == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento non trovato");
		}
		return pagamento;
	}

	@PostMapping("/makePagamento") 
	public Long makePagamento(@RequestBody Pagamento pagamento) {
		Long idPagamento = pagamentoService.addPagamento(pagamento);
		return idPagamento;
	}
	
	@PutMapping("/update/{id}")
	public Pagamento updatePagamentoById(@PathVariable Long id, @RequestBody Pagamento pagamento) {
		Pagamento a = pagamentoService.updatePagamento(pagamento, id);
		if (a == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento non trovato");
		}
		return a;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePagamentoById(@PathVariable Long id) {
		boolean b = pagamentoService.deletePagamento(id);
		if (b == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento non trovato");
		} 
		return true;
	}
}
