package br.com.financas.repository;

import br.com.financas.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Transactional(readOnly = true)
    List<Category> findByTitle(String name);
}
