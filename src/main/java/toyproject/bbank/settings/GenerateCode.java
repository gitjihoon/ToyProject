package toyproject.bbank.settings;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateCode {



    public String GeneratePrdtCd() {

        Random random = new Random();

        String prdt_cd = "100S";
        int codeA = random.nextInt(1000); // 1000 미만의 3자리 난수 생성
        prdt_cd = prdt_cd + String.format("%05d", codeA);


        return prdt_cd;
    }
}
