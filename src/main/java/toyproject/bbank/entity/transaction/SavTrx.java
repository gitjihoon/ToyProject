package toyproject.bbank.entity.transaction;

import toyproject.bbank.entity.management.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class SavTrx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trx_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acno_id")
    private Account account;

    private String tr_date;

    private Long tr_seq;

    private String can_gbcd;

    private String tr_knd_gbcd;

    private Long tr_amt;

    private String trns_acno;

    private Long trns_amt;

    private Long bef_tr_amt;

    private Long aft_tr_amt;
}
