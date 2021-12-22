package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
