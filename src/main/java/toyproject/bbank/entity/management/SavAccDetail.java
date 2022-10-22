package toyproject.bbank.entity.management;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SavAccDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_dtl_id", nullable = false)
    private Long id;

    private String acno;

    private String contr_period; // 계약기간

    private String int_pay_gbcd;

    private String int_pay_date;

    private String due_date;

    private Long pay_cnt; // 납입횟수

    private Long month_acc_amt; // 월납입누계

    private Long withdraw_cnt;

    private Long sav_dd; // 예치일수

    private String trns_acno;

}
