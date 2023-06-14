package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    
}