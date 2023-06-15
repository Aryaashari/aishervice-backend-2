package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.model.MontirCreateRequest;
import tubespbo.aisherviceapp.service.MontirService;

@Controller
public class MontirController {
    
    @Autowired
    private MontirService montirService;

    @GetMapping("/montir")
    public String index(Model model) {
        List<Montir> montirs = this.montirService.getAll();
        for (int i=0;i<montirs.size();i++) {
            
            if (montirs.get(i).getShift().equals("shift1")) {
                montirs.get(i).setShift("06:00 - 12:00");
            } else {
                montirs.get(i).setShift("12:00 - 18:00");
            }
            
        }
        model.addAttribute("currentPage", "montir");
        model.addAttribute("montirs", montirs);
        return "montir";
    }    


    @PostMapping("/montir")
    public String create(
        @RequestParam("nama") String nama, 
        @RequestParam("noHp") String noHp, 
        @RequestParam("email") String email, 
        @RequestParam("alamat") String alamat, 
        @RequestParam("shift") String shift) {

        MontirCreateRequest request = new MontirCreateRequest(nama, noHp, email, alamat, shift);
        
        this.montirService.create(request);

        return "redirect:/montir";

    }
}
