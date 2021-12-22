package uz.team.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.team.entity.Warehouse;

@Repository
public interface WarehouseRepository  extends JpaRepository<Warehouse, Integer> {
}
