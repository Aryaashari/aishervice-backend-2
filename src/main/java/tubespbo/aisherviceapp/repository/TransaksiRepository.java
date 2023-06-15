package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    @Query("SELECT COUNT(t) FROM Transaksi t WHERE t.status = 'belum lunas'")
    long countByStatusLunas();
}