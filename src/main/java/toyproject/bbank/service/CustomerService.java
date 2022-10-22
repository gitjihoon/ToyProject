package toyproject.bbank.service;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityListeners;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 회원 가입
    @Transactional
    public Long join(Customer customer){

        customer.setJoin_date(String.valueOf(LocalDate.now()));
        customer.setCus_stcd("1");
        customer.setSc_date(" ");
        
        validateDuplicateCustomer(customer);
        customerRepository.save(customer);

        return customer.getId();
    }

    // 고객 중복 검증
    public void validateDuplicateCustomer(Customer customer){
        List<Customer> customerList = customerRepository.findByName(customer.getCus_nm());

        if(!customerList.isEmpty()){
            throw new IllegalStateException("이미 존재하는 고객입니다.");
        }
    }

    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Customer findOne(Long cus_id) {
        return customerRepository.findOne(cus_id);
    }


}
