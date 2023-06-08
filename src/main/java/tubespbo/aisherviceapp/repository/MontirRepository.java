package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Montir;

@Repository
public interface MontirRepository extends JpaRepository<Montir, Long> {
    
}
