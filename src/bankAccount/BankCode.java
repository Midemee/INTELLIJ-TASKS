package bankAccount;

public enum BankCode {
    ACCESS_BANK("044"),
    AFRIBANK("014"),
    CITIBANK("023"),
    DIAMOND_BANK("063"),
    ECOBANK("050"),
    EQUITORIAL_TRUST("040"),
    FIRST_BANK("011"),
    FCMB("214"),
    FIDELITY_BANK("070"),
    FINBANK("085"),
    GUARANTY_TRUST_BANK("058"),
    INTERCONTINENTAL_BANK("069"),
    OCEANIC_BANK("056"),
    BANK_PHB("082"),
    SKYE_BANK("076"),
    SPRINGBANK("084"),
    STANBIC_IBTC("221"),
    STANDARD_CHARTERED_BANK("068"),
    STERLING_BANK("232"),
    UNITED_BANK_FOR_AFRICA("033"),
    UNION_BANK("032"),
    WEMA_BANK("035"),
    ZENITH_BANK("057"),
    UNITY_BANK("215");

    private final String code;

    BankCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
