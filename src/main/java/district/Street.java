package district;

import java.util.ArrayList;
import java.util.List;

public class Street {

	private List<House> houses = new ArrayList<>();

	public void addHouse(House house) {
		houses.add(house);
	}

	public House searchHouseByNumber(int number) {
		for (House item : houses) {
			if (item.getNumber() == number) {
				return item;
			}
		}
		return null;
	}
}
