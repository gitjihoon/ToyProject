package toyproject.bbank.entity;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.entity.management.Account;
import toyproject.bbank.entity.management.AccountDtl;
import toyproject.bbank.repository.CustomerRepository;
import toyproject.bbank.settings.DateSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
public class CustomerTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCreatedDate() {

        Customer customerA = new Customer("cusA", "19930331");
        customerRepository.save(customerA);

        customerA.setBirth("19930101");

        em.flush();
        em.clear();

        Customer findCustomer = customerRepository.findOne(customerA.getId());
        System.out.println("cusA birth : " + findCustomer.getBirth());
        System.out.println("cusA creadtedDate : " + findCustomer.getCreatedDate());
    }

    @Test
    public void testDateSetting() {
        String setDate = DateSetting.AddDate("2022-10-01", 0, 12, 0);
        System.out.println("날짜 확인 테스트 : " + setDate);
    }
}
