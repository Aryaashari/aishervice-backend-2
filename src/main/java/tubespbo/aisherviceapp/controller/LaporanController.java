package tubespbo.aisherviceapp.controller;

import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Laporan;
import tubespbo.aisherviceapp.model.LaporanCreateRequest;
import tubespbo.aisherviceapp.service.LaporanService;

@Controller
public class LaporanController {
    
    @Autowired
    private LaporanService laporanService;

    @GetMapping("/laporan")
    public String index(Model model) {
        List<Laporan> laporanList = this.laporanService.getAll();
        model.addAttribute("currentPage", "laporan");
        model.addAttribute("laporanList", laporanList);
        return "laporan";
    }

    @PostMapping("/laporan")
    public String create(Model model, @RequestParam("keterangan") String keterangan, @RequestParam("tanggal") DateTimeAtCreation tanggal, @RequestParam("tipe") String tipe, @RequestParam("total") float total) {
        LaporanCreateRequest request = new LaporanCreateRequest();
        request.setKeterangan(keterangan);
        request.setTanggal(tanggal);
        request.setTipe(tipe);
        request.setTotal(total);
        this.laporanService.createLaporan(request);
        return "redirect:/laporan";
    }

}
