package toyproject.bbank.repository;

import toyproject.bbank.entity.management.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccRepository {

    /*
    * 계좌 개설에 대한 Repo
    * */

    private final EntityManager em;

    public void save(Account account) {
        em.persist(account);
    }

    public Account findOne(Long id) {
        return em.find(Account.class, id);
    }

    /**
     * JPA Criteria
     **/
    public List<Account> findAllByCriteria(AccSearch accSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> a = cq.from(Account.class);
        Join<Object, Object> m = a.join("customer", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        //계좌 상태 검색
        if (accSearch.getAccStatus() != null) {
            Predicate status = cb.equal(a.get("status"), accSearch.getAccStatus());
            criteria.add(status);
        }
        //계좌번호 검색
        if (StringUtils.hasText(accSearch.getAcno())) {
            Predicate acno =
                    cb.like(m.<String>get("acno"), "%" + accSearch.getAcno() + "%");
            criteria.add(acno);
        }

        //고객 이름 검색
        if (StringUtils.hasText(accSearch.getCus_nm())) {
            Predicate cus_nm =
                    cb.like(m.<String>get("cus_nm"), "%" + accSearch.getCus_nm() + "%");
            criteria.add(cus_nm);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Account> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }

}
