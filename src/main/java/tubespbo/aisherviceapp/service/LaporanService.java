package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Laporan;
import tubespbo.aisherviceapp.model.LaporanCreateRequest;
import tubespbo.aisherviceapp.repository.LaporanRepository;

@Service
public class LaporanService{
    
    @Autowired
    private LaporanRepository laporanRepo;

    @Transactional
    public List<Laporan> getAll() {
        return this.laporanRepo.findAll();
    }

    @Transactional
    public Laporan getById(Long id) {
        return this.laporanRepo.findById(id).orElseThrow(null);
    }

    @Transactional
    public void createLaporan(LaporanCreateRequest request) {
        Laporan report = new Laporan();
        report.setKeterangan(request.getKeterangan());
        report.setTanggal(request.getTanggal());
        report.setTipe(request.getTipe());
        report.setTotal(request.getTotal());

        this.laporanRepo.save(report);
    }

    @Transactional
    public void deleteLaporan(Long id) {
        this.laporanRepo.deleteById(id);
    }

}