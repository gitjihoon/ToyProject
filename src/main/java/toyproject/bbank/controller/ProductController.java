package toyproject.bbank.controller;

import org.springframework.validation.BindingResult;
import toyproject.bbank.entity.product.prdt_mgt.Deposit;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.form.ProductForm;
import toyproject.bbank.service.IyulService;
import toyproject.bbank.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final IyulService iyulService;

    @GetMapping("/products/new")
    public String createForm(Model model) {
        model.addAttribute("productForm", new Deposit());
        return "products/createProductForm";
    }

    @PostMapping("/products/new")
    public String create(@Valid ProductForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "products/createProductForm";
        }

        Deposit deposit = new Deposit();
        deposit.setSav_prdt_nm(form.getSav_prdt_nm());
        deposit.setSale_bgdt(form.getSale_bgdt());
        deposit.setSale_clsdt(form.getSale_clsdt());
        deposit.setPrdt_stcd("1");
        deposit.setMin_amt(form.getMin_amt());
        deposit.setMax_amt(form.getMax_amt()); // => 나중에 createProduct 해서 setter 안보이게 하기

        productService.registerProduct(deposit);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String list(Model model) {
        List<Product> products = productService.findProducts();

        model.addAttribute("products", products);

        return "products/productList";
    }

    @GetMapping("products/{productId}/edit")
    public String updateProductForm(@PathVariable("productId") Long productId, Model model) {

        Deposit item = (Deposit) productService.findOne(productId);

        ProductForm form = new ProductForm();
        form.setSav_prdt_nm(item.getSav_prdt_nm());
        form.setPrdt_stcd(item.getPrdt_stcd());
        form.setSale_bgdt(item.getSale_bgdt());
        form.setSale_clsdt(item.getSale_clsdt());
        form.setMin_amt(item.getMin_amt());
        form.setMax_amt(item.getMax_amt());

        model.addAttribute("form", form);   //  담아주기

        return "products/updateProductForm";
    }

    @PostMapping("products/{productId}/edit")
    public String updateProduct(@PathVariable Long productId, @Valid @ModelAttribute("form") ProductForm form) {

        productService.updateProduct(productId, form.getSav_prdt_nm(),
                                     form.getPrdt_stcd(), form.getSale_bgdt(), form.getSale_clsdt(), form.getMin_amt(), form.getMax_amt());
        return "redirect:/products";
    }
}
