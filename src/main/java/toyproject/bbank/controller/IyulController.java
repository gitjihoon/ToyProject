package toyproject.bbank.controller;

import toyproject.bbank.entity.product.iyul.AftExpIyul;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.iyul.BfcIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.form.IyulForm;
import toyproject.bbank.service.IyulService;
import toyproject.bbank.service.ProductService;
import toyproject.bbank.settings.IyulSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
@Controller
@RequiredArgsConstructor
public class IyulController {

    private final ProductService productService;
    private final IyulService iyulService;
    private final IyulSet iyulSet;

    @RequestMapping("/iyuls/iyulPage")
    public String iyulPage() {
        return "iyuls/iyulPage";
    }

    @GetMapping("/iyuls/iyulPage/new_basic")
    public String createBasicForm(Model model) {

        List<Product> products= productService.findProducts();
        model.addAttribute("products", products);

        model.addAttribute("iyulForm", new IyulForm());
        return "iyuls/createBasicIyulForm";
    }

    @PostMapping("/iyuls/iyulPage/new_basic")
    public String createBasicIyul(@RequestParam("productId") Long productId, @Valid IyulForm form, BindingResult result) {

        BasicIyul basicIyul = new BasicIyul();

        basicIyul = iyulSet.BasicIyulSetting(basicIyul, form);

        iyulService.registerBasicIyul(productId, basicIyul);

        return "redirect:/iyuls/iyulPage";
    }

    @GetMapping("/iyuls/iyulPage/new_bfc")
    public String createBfcForm(Model model) {

        List<Product> products= productService.findProducts();
        model.addAttribute("products", products);

        model.addAttribute("iyulForm", new IyulForm());
        return "iyuls/createBfcIyulForm";
    }

    @PostMapping("/iyuls/iyulPage/new_bfc")
    public String createBfcIyul(@RequestParam("productId") Long productId, @Valid IyulForm form, BindingResult result) {

        BfcIyul bfcIyul = new BfcIyul();

        bfcIyul = iyulSet.BfcIyulSetting(bfcIyul, form);

        iyulService.registerBfcIyul(productId, bfcIyul);

        return "redirect:/iyuls/iyulPage";
    }

    @GetMapping("/iyuls/iyulPage/new_aft")
    public String createAftExpForm(Model model) {

        List<Product> products= productService.findProducts();
        model.addAttribute("products", products);

        model.addAttribute("iyulForm", new IyulForm());
        return "iyuls/createAftExpIyulForm";
    }

    @PostMapping("/iyuls/iyulPage/new_aft")
    public String createAftExpIyul(@RequestParam("productId") Long productId, @Valid IyulForm form, BindingResult result) {

        AftExpIyul aftExpIyul = new AftExpIyul();

        aftExpIyul = iyulSet.AftIyulSetting(aftExpIyul, form);

        iyulService.registerAftExpIyul(productId, aftExpIyul);

        return "redirect:/iyuls/iyulPage";
    }

    @GetMapping("/iyuls")
    public String iyulList(Model model) {
        List<BasicIyul> basicIyuls = iyulService.findBasicIyuls();
        List<BfcIyul> bfcIyuls = iyulService.findBfcIyuls();
        List<AftExpIyul> aftExpIyuls = iyulService.findAftExpIyuls();

        model.addAttribute("basicIyuls", basicIyuls);
        model.addAttribute("bfcIyuls", bfcIyuls);
        model.addAttribute("aftExpIyuls", aftExpIyuls);
        return "iyuls/iyulList";
    }

}

