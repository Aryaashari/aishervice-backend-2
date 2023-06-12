package tubespbo.aisherviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tubespbo.aisherviceapp.entity.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    
}