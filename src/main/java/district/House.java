package district;

public class House {

	int number;
	int height;
	RoofType roof;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public RoofType getRoof() {
		return roof;
	}

	public void setRoof(RoofType roof) {
		this.roof = roof;
	}

	public HouseType houseType() {
		switch (roof) {
		case FLAT:
			if (height < 5) {
				return HouseType.BUNGALOW;
			} else if (height > 60) {
				return HouseType.SKYSCRAPER;
			}
		case STEEP:
			if (height < 15) {
				return HouseType.SUBURBAN;
			}
		default:
			return HouseType.APARTMENT_HOUSE;
		}
	}

	@Override
	public String toString() {
		return "House No " + number + " has " + height + " stories and a " + roof.getDescription() + " roof is a "
				+ houseType() + " type of House";
	}
}
