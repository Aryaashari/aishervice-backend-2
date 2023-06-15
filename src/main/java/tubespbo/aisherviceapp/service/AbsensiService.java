package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Absensi;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.model.AbsensiCreateRequest;
import tubespbo.aisherviceapp.repository.AbsensiRepository;
import tubespbo.aisherviceapp.repository.MontirRepository;


@Service
public class AbsensiService {
    
    @Autowired
    private AbsensiRepository absensiRepo;

    @Autowired
    private MontirRepository montirRepository;

    @Transactional
    public List<Absensi> getAll() {
        return this.absensiRepo.findAll();
    }

    @Transactional
    public Absensi getById(Long idAbsensi) {
        return this.absensiRepo.findById(idAbsensi).orElse(null);
    }

    @Transactional
    public void createAbsensi(AbsensiCreateRequest request) {
        Montir montir = this.montirRepository.findById(request.getId_montir()).orElse(null);
        Absensi absensi = new Absensi();
        absensi.setMontir(montir);
        absensi.setTanggal(request.getTanggal());
        absensi.setStatus(request.getStatus());
        absensi.setKeterangan(request.getKeterangan());

        this.absensiRepo.save(absensi);
    }


}

