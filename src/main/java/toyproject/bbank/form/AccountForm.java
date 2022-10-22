package toyproject.bbank.form;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AccountForm {

    private String acno;

    @NotEmpty(message = "고객선택은 필수 입니다.")
    private Customer customer;

    @NotEmpty(message = "상품선택은 필수 입니다.")
    private Product product;

    @NotEmpty(message = "이율선택은 필수 입니다.")
    private BasicIyul basicIyul;

    private String sav_acscd;

    private String tax_gbcd;

    private String mk_date;

    private String clos_date;

    @NotEmpty(message = "계약금액은 필수 입니다.")
    private Long ldgr_tbal;
}
