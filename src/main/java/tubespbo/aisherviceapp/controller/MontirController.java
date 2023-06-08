package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.model.MontirCreateRequest;
import tubespbo.aisherviceapp.service.MontirService;;

@Controller
public class MontirController {

    @Autowired
    private MontirService montirService;

    @GetMapping("/montir")
    public String index(Model model) {
        List<Montir> montirList = this.montirService.getAll();
        model.addAttribute("montirList", montirList);
        return "montir";
    }

    @PostMapping("/montir")
    public String create(@RequestParam("nama") String nama, @RequestParam("email") String email, @RequestParam("no_hp") String noHp, @RequestParam("alamat") String alamat, @RequestParam("shift") String shift, RedirectAttributes redirectAttributes) {
        MontirCreateRequest request = new MontirCreateRequest(nama, noHp, alamat, email, shift);
        this.montirService.createMontir(request);
        return "redirect:/montir";
    }

    @PostMapping("/montir/{id}/hapus")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        this.montirService.deleteMontir(id);
        return "redirect:/montir";
    }

}
