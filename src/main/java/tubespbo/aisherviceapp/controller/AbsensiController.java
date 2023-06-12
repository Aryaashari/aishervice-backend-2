package tubespbo.aisherviceapp.controller;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.entity.Absensi;
import tubespbo.aisherviceapp.model.AbsensiCreateRequest;
// import tubespbo.aisherviceapp.model.InventarisCreateRequest;
import tubespbo.aisherviceapp.service.MontirService;
import tubespbo.aisherviceapp.service.AbsensiService;

@Controller
public class AbsensiController {

    @Autowired
    private MontirService montirService;

    @Autowired
    private AbsensiService absensiService;
    
    @GetMapping("/absensi")
    public String index(Model model) {
        List<Montir> montirs = this.montirService.getAll();
        List<Absensi> absensis = this.absensiService.getAll();
        model.addAttribute("currentPage", "absensi");
        model.addAttribute("montirs", montirs);
        model.addAttribute("absensis", absensis);
        return "absensi";
    }

    @PostMapping("/absensi")
    public String create(@RequestParam("id_montir") Long montir, @RequestParam("tanggal") Timestamp tanggal, @RequestParam("status") int status, @RequestParam("keterangan") String keterangan, RedirectAttributes redirectAttributes) {
        AbsensiCreateRequest req = new AbsensiCreateRequest(montir, tanggal, status, keterangan);
        this.absensiService.createAbsensi(req);
        return "redirect:/absensi";
    }

}
