package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.service.CustomerService;

@Controller
public class TransportationController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/kendaraan")
    public String index(Model model) {
        List<Customer> customers = this.customerService.getAll();
        model.addAttribute("currentPage", "kendaraan");
        model.addAttribute("customers", customers);
        return "kendaraan";
    }

    @PostMapping("/kendaraan")
    public String create(@RequestParam("plat1") String plat1, @RequestParam("plat2") String plat2, @RequestParam("plat3") String plat3, @RequestParam("pelanggan") Long pelanggan, @RequestParam("jenisKendaraan") String jenisKendaraan, @RequestParam("nomorKendaraan") String nomorKendaraan) {

        String platNomor = plat1+plat2+plat3;
        return "redirect:/kendaraan";
    }

}
