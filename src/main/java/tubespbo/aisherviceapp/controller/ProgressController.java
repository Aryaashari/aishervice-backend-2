package tubespbo.aisherviceapp.controller;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Progress;
import tubespbo.aisherviceapp.model.ProgressCreateRequest;
import tubespbo.aisherviceapp.service.ProgressService;

@Controller
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    
    @GetMapping("/progress")
    public String index(Model model) {
        List<Progress> objProgress = this.progressService.getAll();
        model.addAttribute("currentPage", "progress");
        model.addAttribute("objProgress", objProgress);
        return "progress";
    }

    @PostMapping("/progress/{id}")
    public String selesai(@PathVariable("id") Long id_proses){
        this.progressService.updateCatatan(id_proses);
        return "redirect:/progress";
    }

}
