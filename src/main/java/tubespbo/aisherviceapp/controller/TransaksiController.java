package tubespbo.aisherviceapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tubespbo.aisherviceapp.model.TransaksiCreateRequest;
import tubespbo.aisherviceapp.repository.TransaksiRepository;
import tubespbo.aisherviceapp.service.TransaksiService;
import tubespbo.aisherviceapp.entity.Transaksi;

@Controller
public class TransaksiController{
    
    @Autowired
    private TransaksiService transaksiService;
    private TransaksiRepository transaksiRepository;

    @GetMapping("/transaksi")
    public String index(Model model) {
        List<Transaksi> transaksis = this.transaksiService.getAll();
        model.addAttribute("transaksis", transaksis);
        return "transaksi";
    }
    
    @PostMapping("/transaksi")
    public String create(@RequestParam("jumlah") Float jumlah, @RequestParam("total") String total, RedirectAttributes redirectAttributes) {
        TransaksiCreateRequest request = new TransaksiCreateRequest(total, jumlah);
        this.transaksiService.createTransaksi(request);
        return "redirect:/transaksi";
    }

}