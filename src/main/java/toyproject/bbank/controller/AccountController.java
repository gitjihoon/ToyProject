package toyproject.bbank.controller;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.entity.management.Account;
import toyproject.bbank.repository.AccSearch;
import toyproject.bbank.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final IyulService iyulService;
    private final AccService accService;
    private final AccDtlService accDtlService;

    @GetMapping("/accounts/new")
    public String createForm(Model model) {

        List<Customer> customers = customerService.findCustomers();
        List<Product> products = productService.findProducts();
        List<BasicIyul> basicIyuls = iyulService.findBasicIyuls();

        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        model.addAttribute("basicIyuls", basicIyuls);

        return "accounts/openAccForm";
    }

    @PostMapping("/accounts/new")
    public String openAccount(@RequestParam("cusId") Long cusId,
                        @RequestParam("productId") Long productId,
                        @RequestParam("iyulId") Long iyulId,
                        @RequestParam("contr_amt") Long contr_amt) {


        accDtlService.reg_dtl(accService.open(cusId, productId, iyulId, contr_amt));

        return "redirect:/";
    }

    @GetMapping("/accounts")
    public String accountList(@ModelAttribute("accSearch")AccSearch accSearch, Model model) {
        List<Account> accounts = accService.findAccounts(accSearch);
        model.addAttribute("accounts", accounts);

        return "accounts/accountList";
    }

    @PostMapping("/accounts/{acnoId}/cancel")
    public String closeAccount(@PathVariable("acnoId") Long acnoId) {
        accService.cancel(acnoId);
        return "redirect:/accounts";
    }

}
