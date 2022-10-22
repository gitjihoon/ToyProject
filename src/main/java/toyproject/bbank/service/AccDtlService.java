package toyproject.bbank.service;

import toyproject.bbank.entity.management.Account;
import toyproject.bbank.entity.management.AccountDtl;
import toyproject.bbank.repository.AccDtlRepository;
import toyproject.bbank.repository.AccRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccDtlService {

    private final AccRepository accRepository;
    private final AccDtlRepository accDtlRepository;

    @Transactional
    public Long reg_dtl(Long acnoId) {

        Account account = accRepository.findOne(acnoId);
        AccountDtl accountDtl = AccountDtl.register_dtl(account);

        accDtlRepository.save(accountDtl);
        return accountDtl.getId();
    }
}
