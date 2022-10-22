package toyproject.bbank.entity.customer;

import toyproject.bbank.entity.BaseTime;
import toyproject.bbank.entity.management.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Customer extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id", nullable = false)
    private Long id;

    private String cus_nm;

    private String birth;

    private String cus_stcd;

    private String join_date;

    private String sc_date; //  탈퇴일자

    @OneToMany(mappedBy = "customer")  //  일대다
    private List<Account> accounts = new ArrayList<>();

    public Customer(String cus_nm, String birth) {
        this.cus_nm = cus_nm;
        this.birth = birth;
    }
}
