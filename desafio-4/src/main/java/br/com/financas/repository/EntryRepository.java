package br.com.financas.repository;

import br.com.financas.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry,Long> {
    List<Entry> findByPayment(boolean paid);
    List<Entry> findByContaining (String name);

}
