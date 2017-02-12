package district;

public class House {

	private final static int FLOOR_HEIGHT = 3;

	private int number;
	private double height;
	private RoofType roof = RoofType.FLAT;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public RoofType getRoof() {
		return roof;
	}

	public void setRoof(RoofType roof) {
		this.roof = roof;
	}

	public int calculateFloorCount() {
		double floorCount = height / FLOOR_HEIGHT;
		if (RoofType.FLAT.equals(roof)) {
			floorCount += 0.5;
		}
		return (int) floorCount;
	}

	public HouseType houseType() {
		int floorCount = calculateFloorCount();
		switch (roof) {
		case FLAT:
			if (floorCount < 2) {
				return HouseType.BUNGALOW;
			} else if (floorCount > 10) {
				return HouseType.SKYSCRAPER;
			}
		case STEEP:
			if (floorCount < 4) {
				return HouseType.SUBURBAN;
			}
		default:
			return HouseType.APARTMENT_HOUSE;
		}
	}

	@Override
	public String toString() {
		return "House No " + number + " has " + height / FLOOR_HEIGHT + " floors and a " + roof.getDescription()
				+ " roof is a " + houseType() + " type of House";
	}
}
