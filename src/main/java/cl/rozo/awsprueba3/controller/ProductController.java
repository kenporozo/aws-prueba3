package cl.rozo.awsprueba3.controller;

import cl.rozo.awsprueba3.model.Product;
import cl.rozo.awsprueba3.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/index")
    public String showProductList(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @GetMapping("/signup")
    public String showProductForm(Product product){
        return "add-product";
    }

    @PostMapping("/addproduct")
    public String addProduct(Product product, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-product";
        }
        productService.insertProduct(product);
        return "redirect:/index";
    }
}
