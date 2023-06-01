package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
    
}
