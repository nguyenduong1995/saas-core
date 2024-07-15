package co.ipicorp.saas.core.model;

public enum TwoFactorType {
    GG("GG"), FB("FB");
	
	private String value;
	
	private TwoFactorType(String value) {
		this.value = value;
	}
	
	public String getValue() {
        return value;
    }
	
	public static TwoFactorType fromValue(String value) {
        switch (value) {
            case "GG":
                return GG;
            default:
                return FB;
        }
    }
	
}
