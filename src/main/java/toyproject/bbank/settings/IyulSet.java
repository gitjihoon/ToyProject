package toyproject.bbank.settings;

import toyproject.bbank.entity.product.iyul.AftExpIyul;
import toyproject.bbank.entity.product.iyul.BasicIyul;
import toyproject.bbank.entity.product.iyul.BfcIyul;
import toyproject.bbank.form.IyulForm;
import org.springframework.stereotype.Component;

@Component
public class IyulSet {

    public BasicIyul BasicIyulSetting(BasicIyul basicIyul, IyulForm form) {

        basicIyul.setAply_bgdt(form.getAply_bgdt());
        basicIyul.setAply_clsdt(form.getAply_clsdt());
        basicIyul.setAply_iyul(form.getAply_iyul());
        basicIyul.setMin_depo_mmc(form.getMin_depo_mmc());
        basicIyul.setMax_depo_mmc(form.getMax_depo_mmc());

        return basicIyul;
    }

    public BfcIyul BfcIyulSetting(BfcIyul bfcIyul, IyulForm form) {

        bfcIyul.setAply_bgdt(form.getAply_bgdt());
        bfcIyul.setAply_clsdt(form.getAply_clsdt());
        bfcIyul.setBef_clos_iyul(form.getBef_clos_iyul());
        bfcIyul.setMin_depo_mmc(form.getMin_depo_mmc());
        bfcIyul.setMax_depo_mmc(form.getMax_depo_mmc());

        return bfcIyul;
    }

    public AftExpIyul AftIyulSetting(AftExpIyul aftExpIyul, IyulForm form) {

        aftExpIyul.setProduct(form.getProduct());
        aftExpIyul.setAply_bgdt(form.getAply_bgdt());
        aftExpIyul.setAply_clsdt(form.getAply_clsdt());
        aftExpIyul.setAft_clos_iyul(form.getAft_clos_iyul());
        aftExpIyul.setMin_depo_mmc(form.getMin_depo_mmc());
        aftExpIyul.setMax_depo_mmc(form.getMax_depo_mmc());

        return aftExpIyul;
    }
}
