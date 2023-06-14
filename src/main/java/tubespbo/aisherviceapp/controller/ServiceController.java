package tubespbo.aisherviceapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.model.ServiceCreateRequest;
import tubespbo.aisherviceapp.service.CustomerService;
import tubespbo.aisherviceapp.service.MontirService;
import tubespbo.aisherviceapp.service.ServiceService;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MontirService montirService;
    
    @GetMapping("/service")
    public String index(Model model) {
        List<tubespbo.aisherviceapp.entity.Service> services = this.serviceService.getAll();
        List<Customer> customers = this.customerService.getAll();
        List<Montir> montirs = this.montirService.getAll();

        model.addAttribute("services", services);
        model.addAttribute("customers", customers);
        model.addAttribute("montirs", montirs);
        model.addAttribute("currentPage", "service");
        return "service";
    }

    @PostMapping("/service")
    public String create(@RequestParam("pelanggan") Long pelanggan, @RequestParam("montir") Long montir, @RequestParam("catatanKerusakan") String catatanKerusakan, @RequestParam("waktuMulai")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime waktuMulai, @RequestParam("estimasiSelesai")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime estimasiSelesai) {
        ServiceCreateRequest request = new ServiceCreateRequest();
        request.setCatatanKerusakan(catatanKerusakan);
        request.setEstimasiSelesai(estimasiSelesai);
        request.setWaktuMulai(waktuMulai);
        request.setIdMontir(montir);
        request.setIdPelanggan(pelanggan);

        this.serviceService.create(request);

        return "redirect:/service";
    }

}
