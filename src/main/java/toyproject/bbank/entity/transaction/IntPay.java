package toyproject.bbank.entity.transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class IntPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_pay_id", nullable = false)
    private Long id;

    private String acno;

    private String tr_date;

    private Long tr_seq;

    private Long int_amt;

    private Long tax;

    private Long int_pay_cnt;   //  이자지급회차
}
