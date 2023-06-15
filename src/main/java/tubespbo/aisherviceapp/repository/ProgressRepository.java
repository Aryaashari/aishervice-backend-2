package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long>{
    @Query("SELECT COUNT(t) FROM Progress t WHERE t.catatan_proses = 'Sedang dikerjakan'")
    long countBySelesai();
}
