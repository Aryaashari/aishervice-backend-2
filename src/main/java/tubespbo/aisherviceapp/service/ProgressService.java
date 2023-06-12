package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Progress;
import tubespbo.aisherviceapp.model.ProgressCreateRequest;
import tubespbo.aisherviceapp.repository.ProgressRepository;

@Service
public class ProgressService{
    
    @Autowired
    private ProgressRepository progressRepo;

    @Transactional
    public List<Progress> getAll() {
        return this.progressRepo.findAll();
    }

    @Transactional
    public void createProgress(ProgressCreateRequest request) {
        Progress objProgress = new Progress();
        objProgress.setId_service(request.getId_service());
        objProgress.setCatatan_proses(request.getCatatan_progress());
        objProgress.setWaktu_progress(request.getWaktu_progress());

        this.progressRepo.save(objProgress);
    }

    @Transactional
    public void deleteProgress(Long id) {
        this.progressRepo.deleteById(id);
    }

}
