package toyproject.bbank.service;

import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import toyproject.bbank.entity.management.Account;
import toyproject.bbank.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccService {

    private final AccRepository accRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final BasicIyulRepository basicIyulRepository;

    // 계좌 개설
    @Transactional
    public Long open(Long cusId, Long productId, Long basicIyulId, Long contr_amt) {

        // 엔티티 조회
        Customer customer = customerRepository.findOne(cusId);
        Product item = productRepository.findOne(productId);
        BasicIyul basicIyul = basicIyulRepository.findOne(basicIyulId);
        Account account = Account.openAccount(customer, item, basicIyul, contr_amt);

        accRepository.save(account);
        return account.getId();
    }

    // 취소
    @Transactional
    public void cancel(Long accountId) {

        // 개설 계좌 조회
        Account account = accRepository.findOne(accountId);

        // 주문 취소
        account.cancelAccount(account);
    }

    // 계좌 조회
    public List<Account> findAccounts(AccSearch accSearch) {
        return accRepository.findAllByCriteria(accSearch);
    }
}