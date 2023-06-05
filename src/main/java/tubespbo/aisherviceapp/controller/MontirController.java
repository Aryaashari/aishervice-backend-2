package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tubespbo.aisherviceapp.service.MontirService;

import tubespbo.aisherviceapp.entity.Montir;

@Controller
public class MontirController {
    
    @Autowired
    private MontirService montirService;

    @GetMapping("/montir")
    public String index(Model model) {
        List<Montir> montirs = this.montirService.getAll();
        model.addAttribute("currentPage", "montir");
        model.addAttribute("montirs", montirs);
        return "montir";
    }    

}
