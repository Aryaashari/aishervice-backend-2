package tubespbo.aisherviceapp.controller;

import java.security.Timestamp;
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

import tubespbo.aisherviceapp.model.ServicesCreateRequest;
import tubespbo.aisherviceapp.repository.ServicesRepository;
import tubespbo.aisherviceapp.service.ServicesService;
import tubespbo.aisherviceapp.entity.Services;

@Controller
public class ServiceController{

    public static void autoTransaksi(double jumlah, String jenisTransaksi) {
    }

    public static void autoTransaksi(String jumlah, String autoTransaksi) {
    }
    
    // @Autowired
    // private ServicesService serviceService;
    // private ServicesRepository serviceRepository;

    // @GetMapping("/service")
    // public String index(Model model) {
    //     List<Services> services = this.serviceService.getAll();
    //     model.addAttribute("service", services);
    //     return "service";
    // }

    // @PostMapping("/service")
    // public String create(@RequestParam("Catatan_kerusakan") String Catatankerusakan, @RequestParam("Waktu_mulai") Timestamp Waktumulai, @RequestParam("Estimasi_selesai") Timestamp Estimasiselesai, RedirectAttributes redirectAttributes) {
    //     ServicesCreateRequest request = new ServicesCreateRequest(Catatankerusakan, Waktumulai, Estimasiselesai);
    //     this.serviceService.createService(request);
    //     return "redirect:/services";
    // }

    // @PostMapping("/services/{id}/waktu-mulai")
    // public Timestamp Waktumulai(@PathVariable("id") Long id, @RequestParam("waktu_awal") Timestamp Waktumulai, RedirectAttributes redirectAttributes) {
    //     try {
    //         Optional<Services> optionalServices = serviceRepository.findById(id);
            
    //         \
    //         if (optionalServices.isPresent()) {
    //             Services services = optionalServices.get();
    //             services.setWaktu(services.getWaktu() + jumlahwaktu);
    //             serviceRepository.save(services);
    //             redirectAttributes.addFlashAttribute("awal", "Waktu pertama!");
    //         } else {
    //             redirectAttributes.addFlashAttribute("akhir", "Waktu selesai.");
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     return "redirect:/service";
    // }

    // @PostMapping("/services/{id}/estimasiwaktu")
    // public Timestamp estimasiwaktu(@PathVariable("id") Long id, @RequestParam("Estimasi_selesai") Timestamp estimasiwaktu, RedirectAttributes redirectAttributes) {
    //     try {
    //         Optional<Services> optionalServices = serviceRepository.findById(id);
    //         if (optionalServices.isPresent()) {
    //             Services services = optionalServices.get();
    //             services.setEstiamsi(services.getEstimasi() -jumlahwaktu);
    //             serviceRepository.save(service);
    //             redirectAttributes.addFlashAttribute("Estimasi", "Lama Waktu Perbaikan");
    //         e.printStackTrace();
    //     }

    //     return "redirect:/service";
    // }

    // @PostMapping("/services/{id}/hapus")
    // public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
    //     this.ServicesService.deleteServices(id);
    //     return "redirect:/service";
    // }
}