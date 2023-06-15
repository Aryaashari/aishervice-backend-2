package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    
}
