package tubespbo.aisherviceapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Laporan;
import tubespbo.aisherviceapp.entity.Transaksi;
import tubespbo.aisherviceapp.model.TransaksiCreateRequest;
import tubespbo.aisherviceapp.repository.LaporanRepository;
import tubespbo.aisherviceapp.repository.TransaksiRepository;

@Service
public class TransaksiService{
    
    @Autowired
    private TransaksiRepository transaksiRepo;

    @Autowired
    private LaporanRepository laporanRepo;

    @Transactional
    public List<Transaksi> getAll() {
        return this.transaksiRepo.findAll();
    }

    @Transactional
    public void createTransaksi(TransaksiCreateRequest request) {
        Transaksi transaksi = new Transaksi();
        transaksi.setStatus(request.getStatus());
        transaksi.setTotal(request.getTotal());

        this.transaksiRepo.save(transaksi);
    }

    @Transactional
    public void updateLunas(Long id) {
        Transaksi transaksi = this.transaksiRepo.findById(id).orElse(null);
        transaksi.setStatus("lunas");

        // create laporan
        Laporan laporan = new Laporan();
        laporan.setKeterangan("Selesai Service. ID Transaksi: "+transaksi.getId_transaksi());
        laporan.setTanggal(LocalDateTime.now());
        laporan.setTipe("pemasukan");
        laporan.setTotal(transaksi.getTotal());
        this.laporanRepo.save(laporan);
        
        this.transaksiRepo.save(transaksi);
    }

}