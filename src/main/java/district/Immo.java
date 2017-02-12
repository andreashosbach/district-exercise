package district;

import java.util.Scanner;

public class Immo {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Street myStreet = new Street();

		while (true) {
			System.out.println("1: New House");
			System.out.println("2: Find House");
			System.out.println("3: Exit");

			switch (input.nextLine()) {
			case "1":
				newHouse(myStreet);
				break;
			case "2":
				findHouse(myStreet);
				break;
			case "3":
				return;
			default:
				System.out.println("Input invalid");
			}
		}
	}

	private static void findHouse(Street street) {
		System.out.println("Enter number: ");
		int number = Integer.parseInt(input.nextLine());
		House house = street.searchHouseByNumber(number);
		if (house == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found: " + house);
		}
	}

	private static void newHouse(Street street) {
		House newHouse = new House();

		System.out.println("Please enter number:");
		newHouse.setNumber(Integer.parseInt(input.nextLine()));
		System.out.println("Please enter height:");
		newHouse.setHeight(Integer.parseInt(input.nextLine()));
		System.out.println("Please enter roof type");
		for (int i = 0; i < RoofType.values().length; i++) {
			System.out.println(i + ": " + RoofType.values()[i].getDescription());
		}
		int roofSelection = Integer.parseInt(input.nextLine());
		newHouse.setRoof(RoofType.values()[roofSelection]);

		street.addHouse(newHouse);
	}
}
