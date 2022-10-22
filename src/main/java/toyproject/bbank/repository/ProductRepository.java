package toyproject.bbank.repository;

import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public void register(Product product) {
        if(product.getId() == null) {  //  id값이 없다 => 신규로 등록하는 거다.
            em.persist(product);
        }
        else {
            em.merge(product); //  기존에 있는 것(id 있는 것) 가져오기 (업데이트와 유사)
        }
    }

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("select i from Product i", Product.class)
                .getResultList();
    }


}
