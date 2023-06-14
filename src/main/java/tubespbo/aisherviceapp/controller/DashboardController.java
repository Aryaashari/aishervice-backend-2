package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tubespbo.aisherviceapp.entity.Inventaris;
import tubespbo.aisherviceapp.repository.InventarisRepository;
import tubespbo.aisherviceapp.service.InventarisService;

@Controller
public class DashboardController {
    
    @Autowired
    private InventarisRepository inventarisRepository;
    
    @Autowired
    private InventarisService inventarisService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentPage", "index");
        long count = inventarisRepository.count();
        model.addAttribute("count", count);
        return "index";
    }

    @GetMapping("/to-inventaris")
    public String inventaris(Model model) {
        List<Inventaris> objInventaris = this.inventarisService.getAll();
        model.addAttribute("objInventaris", objInventaris);
        return "inventaris";
    }



}
