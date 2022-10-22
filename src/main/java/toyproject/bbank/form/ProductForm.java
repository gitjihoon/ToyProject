package toyproject.bbank.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class ProductForm {

    private Long id;

    @NotEmpty(message = "상품명은 필수 입니다.")
    private String sav_prdt_nm;

    private String prdt_stcd;

    @NotEmpty(message = "판매시작일자는 필수 입니다.")
    private String sale_bgdt;

    @NotEmpty(message = "판매종료일자는 필수 입니다.")
    private String sale_clsdt;

    @NotNull(message = "최소가입금액은 필수 입니다.")
    private Long min_amt;

    @NotNull(message = "최대가입금액은 필수 입니다.")
    private Long max_amt;
}
