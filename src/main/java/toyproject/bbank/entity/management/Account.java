package toyproject.bbank.entity.management;

import toyproject.bbank.entity.BaseTime;
import toyproject.bbank.entity.customer.Customer;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.prdt_mgt.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 아무데서나 생성 방지
public class Account extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acno_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account") // account 테이블에 새로운 id컬럼 생성안됨.
    private AccountDtl accountDtl;

    private String acno;

    @Enumerated(EnumType.STRING)
    private AccStatus status; // 계좌상태

    private String tax_gbcd;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String mk_date;

    private String clos_date;

    private double aply_iyul;

    private Long ldgr_tbal;

    private String pay_stop_yn;

    /* 연관관계 메서드 */
    public void setCustomer(Customer customer) {    //  양방향 세팅
        this.customer = customer;
        customer.getAccounts().add(this);
    }

    /* 비즈니스 로직 */

    /* 생성 메소드 */


    // 계좌 개설
    public static Account openAccount(Customer customer, Product product, BasicIyul basicIyul, Long contr_amt) {
        Account account = new Account();
        account.setProduct(product);
        account.setCustomer(customer);
        account.setAply_iyul(basicIyul.getAply_iyul());
        String mkDate = String.valueOf(LocalDate.now());    //  '-' 처리해야 함.

        // 이율 객체 내에 적용시작일자와 신규일자 비교하여 이율 찾기

        account.setAcno("3000" + "2022" + "0001");
        account.setCustomer(customer);
        account.setStatus(AccStatus.NORMAL);
        account.setTax_gbcd("01");

        account.setMk_date(mkDate);
        account.setClos_date(" ");
        account.setPay_stop_yn("0");
        account.setLdgr_tbal(contr_amt);

        return account;
    }


    // 계좌 해지
    public void cancelAccount(Account account) {

        if(account.getStatus() != AccStatus.NORMAL) {
            throw new IllegalStateException("정상상태가 아닌 계좌는 취소가 불가능합니다.");
        }

        account.setStatus(AccStatus.CANCELED);
        account.setLdgr_tbal(0L);
        account.setClos_date(String.valueOf(LocalDate.now()));
    }

}
