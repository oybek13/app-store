package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Input;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {
}
