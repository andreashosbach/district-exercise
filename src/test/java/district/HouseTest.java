package district;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HouseTest {

	@Test
	public void test_HouseType() {
		House house = new House();

		house.setRoof(RoofType.FLAT);

		house.setHeight(1);
		assertThat(house.houseType(), is(HouseType.BUNGALOW));

		house.setHeight(3);
		assertThat(house.houseType(), is(HouseType.BUNGALOW));

		house.setHeight(10);
		assertThat(house.houseType(), is(HouseType.SUBURBAN));

		house.setHeight(20);
		assertThat(house.houseType(), is(HouseType.APARTMENT_HOUSE));

		house.setHeight(100);
		assertThat(house.houseType(), is(HouseType.SKYSCRAPER));

		house.setRoof(RoofType.FLAT);
		house.setHeight(10);
		assertThat(house.houseType(), is(HouseType.SUBURBAN));

		house.setHeight(30);
		assertThat(house.houseType(), is(HouseType.APARTMENT_HOUSE));
	}

	@Test
	public void test_FloorCount() {

		House house = new House();

		house.setRoof(RoofType.FLAT);

		house.setHeight(2);
		assertThat(house.calculateFloorCount(), is(1));

		house.setHeight(3);
		assertThat(house.calculateFloorCount(), is(1));

		house.setHeight(5);
		assertThat(house.calculateFloorCount(), is(2));

		house.setHeight(7);
		assertThat(house.calculateFloorCount(), is(2));

		house.setRoof(RoofType.STEEP);

		house.setHeight(4);
		assertThat(house.calculateFloorCount(), is(1));

		house.setHeight(5);
		assertThat(house.calculateFloorCount(), is(1));

		house.setHeight(9);
		assertThat(house.calculateFloorCount(), is(3));
	}

}
