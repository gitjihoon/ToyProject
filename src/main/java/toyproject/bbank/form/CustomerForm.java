package toyproject.bbank.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CustomerForm {

    private String cus_no;

    @NotEmpty(message = "고객명은 필수 입니다.")
    private String cus_nm;

    @NotEmpty(message = "생년월일은 필수 입니다.")
    private String birth;

    private String cus_stcd;

    private String join_date;;
}
