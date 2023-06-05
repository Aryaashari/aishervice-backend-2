package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.entity.Transportation;
import tubespbo.aisherviceapp.model.TransportationCreateRequest;
import tubespbo.aisherviceapp.service.CustomerService;
import tubespbo.aisherviceapp.service.TransportationService;

@Controller
public class TransportationController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransportationService transportationService;
    
    @GetMapping("/kendaraan")
    public String index(Model model) {
        List<Customer> customers = this.customerService.getAll();
        List<Transportation> transportations = this.transportationService.getAll();
        model.addAttribute("currentPage", "kendaraan");
        model.addAttribute("customers", customers);
        model.addAttribute("transportations", transportations);
        return "kendaraan";
    }

    @PostMapping("/kendaraan")
    public String create(@RequestParam("plat1") String plat1, @RequestParam("plat2") String plat2, @RequestParam("plat3") String plat3, @RequestParam("pelanggan") Long pelanggan, @RequestParam("jenisKendaraan") String jenisKendaraan, @RequestParam("nomorMesin") String nomorMesin) {

        String platNomor = plat1+plat2+plat3;
        this.transportationService.createTransportation(new TransportationCreateRequest(platNomor, pelanggan, jenisKendaraan, nomorMesin));
        return "redirect:/kendaraan";
    }

}
