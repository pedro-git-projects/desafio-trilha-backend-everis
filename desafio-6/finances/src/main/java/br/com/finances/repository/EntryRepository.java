package br.com.finances.repository;

import br.com.finances.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Transactional(readOnly = true)
    List<Entry> findByPaid(Boolean paid);
}
