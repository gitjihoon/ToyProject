package toyproject.bbank.entity.management;

import toyproject.bbank.entity.BaseTime;
import toyproject.bbank.settings.DateSetting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 아무데서나 생성 방지
public class AccountDtl extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acno_id")
    private Account account;

    private String due_date;

    private String contr_mmc;

    private String int_pay_gbcd;

    private String int_pay_date;

    private int pay_cnt;

    private long tot_pay_amt;

    private String trns_acno;

    public static AccountDtl register_dtl(Account account) {

        AccountDtl accountDtl = new AccountDtl();
        accountDtl.setAccount(account);
        accountDtl.setContr_mmc(account.getProduct().getBasicIyul().getMax_depo_mmc());
        accountDtl.setInt_pay_date(" ");
        accountDtl.setInt_pay_gbcd("01");
        accountDtl.setPay_cnt(1);
        accountDtl.setTot_pay_amt(account.getLdgr_tbal());
        accountDtl.setTrns_acno(" ");
        accountDtl.setDue_date(DateSetting.AddDate(account.getMk_date(), 0, Integer.parseInt(account.getProduct().getBasicIyul().getMax_depo_mmc()), 0));

        return accountDtl;

    }

}
