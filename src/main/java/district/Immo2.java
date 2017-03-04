package district;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Immo2 {

	private Street myStreet = new Street();
	private Scanner input;
	private PrintStream output;

	public static void main(String[] args) {
		new Immo2(System.in, System.out).run();
	}

	public Immo2(InputStream input, PrintStream output) {
		this.input = new Scanner(input);
		this.output = output;
	}

	public void run() {
		while (true) {
			output.println("1: New House");
			output.println("2: Find House");
			output.println("3: Exit");

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
				output.println("Input invalid");
			}
		}
	}

	private void findHouse() {
		output.println("Enter number: ");
		int number = Integer.parseInt(input.nextLine());
		House house = myStreet.searchHouseByNumber(number);
		if (house == null) {
			output.println("Not found");
		} else {
			output.println("Found: " + house);
		}
	}

	private void newHouse() {
		House newHouse = new House();

		output.println("Please enter number:");
		newHouse.setNumber(Integer.parseInt(input.nextLine()));
		output.println("Please enter height:");
		newHouse.setHeight(Double.parseDouble(input.nextLine()));
		output.println("Please enter roof type");
		for (int i = 0; i < RoofType.values().length; i++) {
			output.println(i + ": " + RoofType.values()[i].getDescription());
		}
		int roofSelection = Integer.parseInt(input.nextLine());
		newHouse.setRoof(RoofType.values()[roofSelection]);

		myStreet.addHouse(newHouse);
	}
}
