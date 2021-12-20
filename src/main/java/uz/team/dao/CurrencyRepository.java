package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
