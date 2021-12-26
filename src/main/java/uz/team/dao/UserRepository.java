package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
