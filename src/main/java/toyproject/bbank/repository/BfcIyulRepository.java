package toyproject.bbank.repository;

import toyproject.bbank.entity.product.iyul.BfcIyul;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BfcIyulRepository {
    private final EntityManager em;

    public void register(BfcIyul bfcIyul) {
        if(bfcIyul.getId() == null) {  //  id값이 없다 => 신규로 등록하는 거다.
            em.persist(bfcIyul);
        }
        else {
            em.merge(bfcIyul); //  기존에 있는 것(id 있는 것) 가져오기 (업데이트와 유사)
        }
    }

    public BfcIyul findOne(Long id) {
        return em.find(BfcIyul.class, id);
    }

    public List<BfcIyul> findAll() {
        return em.createQuery("select i from BfcIyul i", BfcIyul.class)
                .getResultList();
    }
}
