package toyproject.bbank.service;

import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.repository.ProductRepository;
import toyproject.bbank.settings.GenerateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final GenerateCode generateCode;

    @Transactional  //  클래스가 readOnly 이기 때문에 트랜잭셔널로 오버라이딩
    public void registerProduct(Product product) {

        productRepository.register(product);
    }

    @Transactional // 변경 감지
    public void updateProduct(Long productId, String sav_prdt_nm, String prdt_stcd, String sale_bgdt, String sale_clsdt, Long min_amt, Long max_amt) {
        Product findProduct = productRepository.findOne(productId);
        findProduct.setSav_prdt_nm(sav_prdt_nm);
        findProduct.setPrdt_stcd(prdt_stcd);
        findProduct.setSale_bgdt(sale_bgdt);
        findProduct.setSale_clsdt(sale_clsdt);
        findProduct.setMin_amt(min_amt);
        findProduct.setMax_amt(max_amt);
    } // Transactional로 인해 커밋이 일어나면서 업데이트된 정보를 JPA가 찾아서 업데이트 시킴 : 변경 감지

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findOne(Long productId) {
        return productRepository.findOne(productId);
    }
}
