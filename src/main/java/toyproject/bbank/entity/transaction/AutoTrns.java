package toyproject.bbank.entity.transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AutoTrns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_trns_id", nullable = false)
    private Long id;

    private String oamt_acno;

    private String iamt_acno;

    private String reg_date;

    private String clos_date;

    private String resc_date;

    private String trns_gbcd;

    private String trns_cycle_gbcd;

    private String trns_day_gbcd;

    private Long trns_amt;

}
