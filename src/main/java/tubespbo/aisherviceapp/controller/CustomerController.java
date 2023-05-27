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

import tubespbo.aisherviceapp.model.CustomerCreateRequest;
import tubespbo.aisherviceapp.service.CustomerService;
import tubespbo.aisherviceapp.entity.Customer;;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/pelanggan")
    public String index(Model model) {
        List<Customer> customers = this.customerService.getAll();
        model.addAttribute("customers", customers);
        return "pelanggan";
    }

    @PostMapping("/pelanggan")
    public String create(@RequestParam("nama") String nama, @RequestParam("email") String email, @RequestParam("no_hp") String noHp, @RequestParam("alamat") String alamat, RedirectAttributes redirectAttributes) {
        CustomerCreateRequest request = new CustomerCreateRequest(nama, noHp, alamat, email);
        this.customerService.createCustomer(request);
        return "redirect:/pelanggan";
    }

    @PostMapping("/pelanggan/{id}/hapus")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        this.customerService.deleteCustomer(id);
        return "redirect:/pelanggan";
    }

}
