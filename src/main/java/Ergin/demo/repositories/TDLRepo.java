package Ergin.demo.repositories;

import Ergin.demo.model.TDL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TDLRepo extends JpaRepository<TDL, Long> {
    Optional<TDL> findByName(String name);
}
