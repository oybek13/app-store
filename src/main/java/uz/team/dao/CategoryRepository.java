package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
