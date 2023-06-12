package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Absensi;

@Repository
public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
    
}
