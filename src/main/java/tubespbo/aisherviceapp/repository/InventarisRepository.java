package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Inventaris;

@Repository
public interface InventarisRepository extends JpaRepository<Inventaris, Long>{
    
}
