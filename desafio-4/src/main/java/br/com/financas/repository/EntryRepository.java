package br.com.financas.repository;

import br.com.financas.model.Category;
import br.com.financas.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long> {
    /*
      THIS LINE CRASHES THE APPLICATION
        List<Entry> findByPayment(boolean paid);
      WHY THO?
    */
    List<Entry> findByTitle(String title);

    @Query( value = "SELECT * FROM ENTRIES PAID",
            nativeQuery = true)
    List<Entry> findByPaid(@Param("paid") boolean paid);

}
