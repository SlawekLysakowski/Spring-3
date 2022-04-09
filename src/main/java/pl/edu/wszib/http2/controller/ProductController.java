package pl.edu.wszib.http2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.wszib.http2.service.ProduktService;
import pl.edu.wszib.http2.service.model.Produkt;
import pl.edu.wszib.http2.service.model.Profile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProduktService produktService;



    @GetMapping("/list")
    public String list(Model model) {
//        Produkt produkt = new Produkt();
//        produkt.setCena(3.0f);
//        produkt.setIlosc(56);
//        produkt.setNazwa("batonik");
//        produktService.create(produkt);
        model.addAttribute("produkty", produktService.list());  //przekaz list
        return "list-product"; //nazwa widoku
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newProduct", new Produkt());
        return "create-product";
    }

    @PostMapping("/create")
    public String createProductAction(Produkt produkt, Model model) {
     produkt =   produktService.create(produkt);
            return "redirect:/product/list?id=";
        }

    @GetMapping("/update")
    public String updateProduct(@RequestParam Integer id, Produkt updateProduct, Model model) {
        model.addAttribute("updateProduct", produktService.get(id));
        return "update-product";
    }

    @PostMapping("/update")
    public String updateProductAction(Produkt produkt, Model model)  {
            produktService.update(produkt);
            return "redirect:/product/list";
        }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, Model model) {
        model.addAttribute("product", produktService.get(id));
        return "delete-product";
    }

    @PostMapping("/delete")
    public String deleteProductView(Produkt produkt,  Model model) {
        produktService.delete(produkt.getId());
        return "redirect:/product/list";
    }






}
