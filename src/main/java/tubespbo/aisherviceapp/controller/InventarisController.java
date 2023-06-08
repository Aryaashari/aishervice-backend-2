package tubespbo.aisherviceapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tubespbo.aisherviceapp.model.InventarisCreateRequest;
import tubespbo.aisherviceapp.repository.InventarisRepository;
import tubespbo.aisherviceapp.service.InventarisService;
import tubespbo.aisherviceapp.entity.Inventaris;;

@Controller
public class InventarisController{
    
    @Autowired
    private InventarisService inventarisService;
    private InventarisRepository inventarisRepository;

    @GetMapping("/inventaris")
    public String index(Model model) {
        List<Inventaris> objInventaris = this.inventarisService.getAll();
        model.addAttribute("objInventaris", objInventaris);
        return "inventaris";
    }

    @PostMapping("/inventaris")
    public String create(@RequestParam("suku_cadang") String suku_cadang, @RequestParam("stok") int stok, @RequestParam("harga_satuan") int harga_satuan, RedirectAttributes redirectAttributes) {
        InventarisCreateRequest request = new InventarisCreateRequest(suku_cadang, stok, harga_satuan);
        this.inventarisService.createInventaris(request);
        return "redirect:/inventaris";
    }

    @PostMapping("/inventaris/{id}/tambah-stok")
    public String tambahStok(@PathVariable("id") Long id, @RequestParam("jumlahStok") int jumlahStok, RedirectAttributes redirectAttributes) {
        try {
            Optional<Inventaris> optionalInventaris = inventarisRepository.findById(id);
            if (optionalInventaris.isPresent()) {
                Inventaris inventaris = optionalInventaris.get();
                inventaris.setStok(inventaris.getStok() + jumlahStok);
                inventarisRepository.save(inventaris);
                redirectAttributes.addFlashAttribute("success", "Stok berhasil ditambahkan!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Data inventaris tidak ditemukan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/inventaris";
    }

    @PostMapping("/inventaris/{id}/hapus")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        this.inventarisService.deleteInventaris(id);
        return "redirect:/inventaris";
    }
}
