package toyproject.bbank.entity.management;

public enum AccStatus {

    NORMAL("1"), CANCELED("2"), CLOSED("9");

    public final String sav_acscd;

    AccStatus(String sav_acscd) {
        this.sav_acscd = sav_acscd;
    }
}
