package district;

import java.io.InputStream;
import java.util.Scanner;

public class Immo {

	private Street myStreet = new Street();
	private Scanner input;

	public static void main(String[] args) {
		new Immo(System.in).run();
	}

	public Immo(InputStream input) {
		this.input = new Scanner(input);
	}

	private void run() {
		while (true) {
			System.out.println("1: New House");
			System.out.println("2: Find House");
			System.out.println("3: Exit");

			switch (input.nextLine()) {
			case "1":
				newHouse();
				break;
			case "2":
				findHouse();
				break;
			case "3":
				return;
			default:
				System.out.println("Input invalid");
			}
		}
	}

	private void findHouse() {
		System.out.println("Enter number: ");
		int number = Integer.parseInt(input.nextLine());
		House house = myStreet.searchHouseByNumber(number);
		if (house == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found: " + house);
		}

	}

	private void newHouse() {
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

		myStreet.addHouse(newHouse);
	}
}
