package br.com.financas.repository;

import br.com.financas.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Transactional(readOnly = true)
    List<Entry> findByTitle(String title);

    @Transactional(readOnly = true)
    List<Entry> findByPaid(Boolean paid);

}
