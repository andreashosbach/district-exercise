package district;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StreetTest {

	@Test
	public void test_SearchHouseByNumber_NotFound() {

		Street street = new Street();

		assertThat(street.searchHouseByNumber(1), is(nullValue()));

		House house1 = new House();
		house1.setNumber(1);
		street.addHouse(house1);

		assertThat(street.searchHouseByNumber(2), is(nullValue()));
	}

	@Test
	public void test_SearchHouseByNumber_Found() {

		Street street = new Street();

		House house2 = new House();
		house2.setNumber(2);
		street.addHouse(house2);

		assertThat(street.searchHouseByNumber(2), is(house2));

		House house1 = new House();
		house1.setNumber(1);
		street.addHouse(house1);

		assertThat(street.searchHouseByNumber(1), is(house1));
	}

}
