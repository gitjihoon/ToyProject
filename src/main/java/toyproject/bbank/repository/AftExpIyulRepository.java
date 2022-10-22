package toyproject.bbank.repository;

import toyproject.bbank.entity.product.iyul.AftExpIyul;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AftExpIyulRepository {

    private final EntityManager em;

    public void register(AftExpIyul aftExpIyul) {
        if(aftExpIyul.getId() == null) {  //  id값이 없다 => 신규로 등록하는 거다.
            em.persist(aftExpIyul);
        }
        else {
            em.merge(aftExpIyul); //  기존에 있는 것(id 있는 것) 가져오기 (업데이트와 유사)
        }
    }

    public AftExpIyul findOne(Long id) {
        return em.find(AftExpIyul.class, id);
    }

    public List<AftExpIyul> findAll() {
        return em.createQuery("select i from AftExpIyul i", AftExpIyul.class)
                .getResultList();
    }

}
