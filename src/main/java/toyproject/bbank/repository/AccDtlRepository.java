package toyproject.bbank.repository;

import toyproject.bbank.entity.management.AccountDtl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccDtlRepository extends JpaRepository<AccountDtl, Long> {

}
