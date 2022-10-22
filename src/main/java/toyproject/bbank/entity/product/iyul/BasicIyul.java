package toyproject.bbank.entity.product.iyul;

import toyproject.bbank.entity.BaseTime;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BasicIyul extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basiciyul_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String aply_bgdt;

    private String aply_clsdt;

    private String min_depo_mmc;

    private String max_depo_mmc;

    private double aply_iyul;

}
