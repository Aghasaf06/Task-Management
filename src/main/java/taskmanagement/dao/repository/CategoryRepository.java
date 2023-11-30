package taskmanagement.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taskmanagement.dao.entity.Category;
import taskmanagement.model.dto.CategoryDto;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Transactional
    @Modifying
    @Query("update Category set name = :name where id = :id")
    void updateCategoryById(@Param("id") Long id, @Param("name") String name);

    Category getCategoryByName(String name);
}
