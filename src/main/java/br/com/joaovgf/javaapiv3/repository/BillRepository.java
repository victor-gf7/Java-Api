package br.com.joaovgf.javaapiv3.repository;

import br.com.joaovgf.javaapiv3.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
