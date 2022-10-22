package toyproject.bbank.entity.product.iyul;

import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AftExpIyul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aftexpiyul_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;;

    private String aply_bgdt;

    private String aply_clsdt;

    private String min_depo_mmc;

    private String max_depo_mmc;

    private double aft_clos_iyul;

}
