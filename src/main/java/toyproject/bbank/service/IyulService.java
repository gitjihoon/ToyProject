package toyproject.bbank.service;

import toyproject.bbank.entity.product.iyul.AftExpIyul;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.iyul.BfcIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.repository.AftExpIyulRepository;
import toyproject.bbank.repository.BasicIyulRepository;
import toyproject.bbank.repository.BfcIyulRepository;
import toyproject.bbank.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IyulService {

    private final ProductRepository productRepository;

    /* 기본이율 */
    private final BasicIyulRepository basicIyulRepository;

    @Transactional
    public void registerBasicIyul(Long productId, BasicIyul basicIyul) {

        Product product = productRepository.findOne(productId);
        basicIyul.setProduct(product);
        product.setBasicIyul(basicIyul);;

        basicIyulRepository.register(basicIyul);
    }

    @Transactional // 변경 감지
    public void updateBasicIyul(Long basicIyulId, Product product, double aply_iyul, String aply_bgdt, String aply_clsdt,
                                String min_depo_mmc, String max_depo_mmc) {
        BasicIyul findBasicIyul = basicIyulRepository.findOne(basicIyulId);
        findBasicIyul.setProduct(product);
        findBasicIyul.setAply_iyul(aply_iyul);
        findBasicIyul.setAply_bgdt(aply_bgdt);
        findBasicIyul.setAply_clsdt(aply_clsdt);
        findBasicIyul.setMin_depo_mmc(min_depo_mmc);
        findBasicIyul.setMax_depo_mmc(max_depo_mmc);
    }

    public List<BasicIyul> findBasicIyuls() {
        return basicIyulRepository.findAll();
    }

    public BasicIyul findBasicOne(Long basicIyulId) {
        return basicIyulRepository.findOne(basicIyulId);
    }


    /* 중도해지이율 */
    private final BfcIyulRepository bfcIyulRepository;

    @Transactional
    public void registerBfcIyul(Long productId, BfcIyul bfcIyul) {
        Product product = productRepository.findOne(productId);
        bfcIyul.setProduct(product);

        bfcIyulRepository.register(bfcIyul);
    }

    @Transactional // 변경 감지
    public void updateBfcIyul(Long bfcIyulId, Product product, double bfc_ratio, String aply_bgdt, String aply_clsdt,
                                 String min_depo_mmc, String max_depo_mmc) {
        BfcIyul findBfcIyul = bfcIyulRepository.findOne(bfcIyulId);
        findBfcIyul.setProduct(product);
        findBfcIyul.setBef_clos_iyul(bfc_ratio);
        findBfcIyul.setAply_bgdt(aply_bgdt);
        findBfcIyul.setAply_clsdt(aply_clsdt);
        findBfcIyul.setMin_depo_mmc(min_depo_mmc);
        findBfcIyul.setMax_depo_mmc(max_depo_mmc);
    }

    public List<BfcIyul> findBfcIyuls() {
        return bfcIyulRepository.findAll();
    }

    public BfcIyul findBfcOne(Long bfcIyulId) {
        return bfcIyulRepository.findOne(bfcIyulId);
    }



    /* 만기후이율 */
    private final AftExpIyulRepository aftExpIyulRepository;

    @Transactional
    public void registerAftExpIyul(Long productId, AftExpIyul aftExpIyul) {
        Product product = productRepository.findOne(productId);
        aftExpIyul.setProduct(product);

        aftExpIyulRepository.register(aftExpIyul);
    }

    @Transactional // 변경 감지
    public void updateAftExpIyul(Long aftExpIyulId, Product product, double exp_ratio, String aply_bgdt, String aply_clsdt,
                                String min_depo_mmc, String max_depo_mmc) {
        AftExpIyul findAftExpIyul = aftExpIyulRepository.findOne(aftExpIyulId);
        findAftExpIyul.setProduct(product);
        findAftExpIyul.setAft_clos_iyul(exp_ratio);
        findAftExpIyul.setAply_bgdt(aply_bgdt);
        findAftExpIyul.setAply_clsdt(aply_clsdt);
        findAftExpIyul.setMin_depo_mmc(min_depo_mmc);
        findAftExpIyul.setMax_depo_mmc(max_depo_mmc);
    }

    public List<AftExpIyul> findAftExpIyuls() {
        return aftExpIyulRepository.findAll();
    }

    public AftExpIyul findExpOne(Long aftExpIyulId) {
        return aftExpIyulRepository.findOne(aftExpIyulId);
    }

}
