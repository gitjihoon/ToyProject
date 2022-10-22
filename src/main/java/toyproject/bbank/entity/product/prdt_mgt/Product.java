package toyproject.bbank.entity.product.prdt_mgt;

import toyproject.bbank.entity.product.iyul.AftExpIyul;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 전략 지정 (싱글테이블은 한 테이블에 다 때려넣는것)
@DiscriminatorColumn(name = "dtype") // 싱글테이블이기때문에 구분하는 용도
@Getter
@Setter
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BasicIyul basicIyul;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AftExpIyul aftExpIyul;

    private String sav_prdt_nm;

    private String prdt_stcd;

    private String sale_bgdt;

    private String sale_clsdt;

    private Long min_amt;

    private Long max_amt;
}
