package br.com.financas.repository;

import br.com.financas.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName (String name);
    List<Category> findByDescription(String description);

    // Because this is an interface, we may use, save, findById, FindAll, Count, etc, without implementing them
}
