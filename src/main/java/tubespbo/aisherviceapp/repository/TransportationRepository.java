package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Transportation;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, String> {
    
}
