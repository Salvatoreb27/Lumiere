package lumiere.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lumiere.central.model.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {

}
