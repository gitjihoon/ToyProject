package toyproject.bbank.repository;

import toyproject.bbank.entity.product.iyul.BasicIyul;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BasicIyulRepository {

    private final EntityManager em;

    public void register(BasicIyul basicIyul) {
        if(basicIyul.getId() == null) {  //  id값이 없다 => 신규로 등록하는 거다.
            em.persist(basicIyul);
        }
        else {
            em.merge(basicIyul); //  기존에 있는 것(id 있는 것) 가져오기 (업데이트와 유사)
        }
    }

    public BasicIyul findOne(Long id) {
        return em.find(BasicIyul.class, id);
    }

    public List<BasicIyul> findAll() {
        return em.createQuery("select i from BasicIyul i", BasicIyul.class)
                .getResultList();
    }

}
