package district;

public enum RoofType {

	FLAT("flat"),
	STEEP("steep");

	private String description;
	
	private RoofType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
