package toyproject.bbank.entity.product.prdt_mgt;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("F")
public class Deposit extends Product{

}
