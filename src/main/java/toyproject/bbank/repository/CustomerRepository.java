package toyproject.bbank.repository;

import toyproject.bbank.entity.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createQuery("select m from Customer m", Customer.class).getResultList();
    }

    public List<Customer> findByName(String cus_nm) {
        return em.createQuery("select m from Customer m where m.cus_nm = :cus_nm", Customer.class)
                .setParameter("cus_nm", cus_nm)
                .getResultList();
    }

}
