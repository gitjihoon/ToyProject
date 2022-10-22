package toyproject.bbank.controller;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.form.CustomerForm;
import toyproject.bbank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

//@RestController
@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers/new")
    public String createForm(Model model) {

        model.addAttribute("customerForm", new CustomerForm());
        return "customers/createCustomerForm";
    }

    @PostMapping("/customers/new")
    public String create(@Valid CustomerForm form, BindingResult result) {
        // Valid : NotEmpty 체크할 수 있게 해줌.
        // BindingResult : 예외에 대한 안내

        if(result.hasErrors()) {
            return "customers/createCustomerForm"; // "고객 이름은 필수 입니다." 안내
        }

        Customer customer = new Customer();
        customer.setCus_nm(form.getCus_nm());
        customer.setBirth(form.getBirth());

        customerService.join(customer);
        return "redirect:/";
    }

    @GetMapping("/customers")
    public String list(Model model) {
        List<Customer> customers = customerService.findCustomers();

        model.addAttribute("customers", customers);
        return "/customers/customerList";
    }

}
