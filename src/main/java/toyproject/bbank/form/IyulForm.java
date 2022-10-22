package toyproject.bbank.form;

import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IyulForm {

    private Long id;

    @NotNull(message = "상품선택은 필수 입니다.")
    private Product product;

    @NotEmpty(message = "적용시작일자는 필수 입니다.")
    private String aply_bgdt;

    @NotEmpty(message = "적용종료일자는 필수 입니다.")
    private String aply_clsdt;

    @NotEmpty(message = "최소계약월수는 필수 입니다.")
    private String min_depo_mmc;

    @NotEmpty(message = "최대계약월수는 필수 입니다.")
    private String max_depo_mmc;

    @NotNull(message = "적용이율은 필수 입니다.")
    private double aply_iyul;

    @NotNull(message = "중도해지이율은 필수 입니다.")
    private double bef_clos_iyul;

    @NotNull(message = "만기후해지이율은 필수 입니다.")
    private double aft_clos_iyul;

}
