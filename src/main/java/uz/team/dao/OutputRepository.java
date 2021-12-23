package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Output;

@Repository
public interface OutputRepository extends JpaRepository<Output, Integer> {
}
