package tubespbo.aisherviceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.entity.Inventaris;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.entity.Progress;
import tubespbo.aisherviceapp.entity.Transaksi;
import tubespbo.aisherviceapp.repository.InventarisRepository;
import tubespbo.aisherviceapp.repository.ProgressRepository;
import tubespbo.aisherviceapp.repository.ServiceRepository;
import tubespbo.aisherviceapp.repository.TransaksiRepository;
import tubespbo.aisherviceapp.service.CustomerService;
import tubespbo.aisherviceapp.service.InventarisService;
import tubespbo.aisherviceapp.service.MontirService;
import tubespbo.aisherviceapp.service.ProgressService;
import tubespbo.aisherviceapp.service.ServiceService;
import tubespbo.aisherviceapp.service.ServicesService;
import tubespbo.aisherviceapp.service.TransaksiService;

@Controller
public class DashboardController {
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private MontirService montirService;

    @Autowired
    private InventarisRepository inventarisRepository;
    @Autowired
    private InventarisService inventarisService;

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private TransaksiService transaksiService;
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private ProgressService progressService;
    @Autowired
    private ProgressRepository progressRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentPage", "index");
        long countInventaris = inventarisRepository.count();
        model.addAttribute("countInventaris", countInventaris);
        long countService = serviceRepository.count();
        model.addAttribute("countService", countService);
        long countTransaksi = transaksiRepository.countByStatusLunas();
        model.addAttribute("countTransaksi", countTransaksi);
        long countProgress = progressRepository.countBySelesai();
        model.addAttribute("countProgress", countProgress);
        return "index";
    }

    @GetMapping("/to-progress")
    public String progress(Model model) {
        List<Progress> objProgress = this.progressService.getAll();
        model.addAttribute("currentPage", "progress");
        model.addAttribute("objProgress", objProgress);
        return "progress";
    }

    @GetMapping("/to-inventaris")
    public String inventaris(Model model) {
        List<Inventaris> objInventaris = this.inventarisService.getAll();
        model.addAttribute("objInventaris", objInventaris);
        return "inventaris";
    }

    @GetMapping("/to-service")
    public String service(Model model) {
        List<tubespbo.aisherviceapp.entity.Service> services = this.serviceService.getAll();
        List<Customer> customers = this.customerService.getAll();
        List<Montir> montirs = this.montirService.getAll();

        model.addAttribute("services", services);
        model.addAttribute("customers", customers);
        model.addAttribute("montirs", montirs);
        model.addAttribute("currentPage", "service");
        return "service";
    }

    @GetMapping("/to-transaksi")
    public String transaksi(Model model) {
        List<Transaksi> transaksis = this.transaksiService.getAll();
        model.addAttribute("transaksis", transaksis);
        return "transaksi";
    }



}
