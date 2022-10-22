package toyproject.bbank.repository;

import toyproject.bbank.entity.management.AccStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccSearch {

    private String acno;
    private String cus_nm;
//    private String sav_acscd;
    private AccStatus accStatus;
}
