package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Laporan;

@Repository
public interface LaporanRepository extends JpaRepository<Laporan, Long> {

}