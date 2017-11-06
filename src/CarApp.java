import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Burger's Best Buys Car Shoppe");
		System.out.println("Would you like to see our amazing collection? y/n: ");
		String choice = userChoice(scan);
		ArrayList<Car> CarRoster = CarList();
		if (choice.equalsIgnoreCase("y")) {
			printArray(CarRoster);
			System.out.println("Please select the car you'd like to test drive!");
			int userNum = getInt(scan, "", 1, 6);
			System.out.println(CarRoster.get(userNum - 1));
			System.out.println("Is this the car you'd like to purchase? (y/n)");
			String carChoice = userChoice(scan);
			int finalChoice = buyCar(carChoice, userNum, scan, CarRoster);
			removeCar(CarRoster, finalChoice);
			System.out.println("Remaing stock:");
			printArray(CarRoster);
		} else {
			System.out.println(
					"Well, your loss, my manager just released some \namazing deals, but if you're really sure...");
		}
	}

	public static ArrayList<Car> CarList() {
		ArrayList<Car> CarList = new ArrayList<>();
		CarList.add(new Car("Ford", "Fusion", 2018, 40000));
		CarList.add(new Car("Toyota", "Camry", 2018, 35000));
		CarList.add(new Car("Volkswagon", "Jetta", 2018, 55600));
		CarList.add(new UsedCar("Ford", "Focus", 1995, 7527.50, 104568.8));
		CarList.add(new UsedCar("Toyota", "Tacoma", 2009, 10525.99, 86426));
		CarList.add(new UsedCar("Ford", "F-150", 2012, 28050, 64207.99));
		return CarList;
	}

	public static void printArray(ArrayList<Car> CarList) {
		for (int i = 0; i < CarList.size(); ++i) {
			System.out.print((i + 1) + ":");
			System.out.println(CarList.get(i));

		}
	}

	public static String userChoice(Scanner scan) {
		String s = scan.nextLine();
		while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
			System.out.println("Please only enter 'y' or 'n':");
			s = scan.next();
		}
		return s;
	}

	public static int getInt(Scanner scan, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner scan, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(scan, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static int buyCar(String carChoice, int userChoice, Scanner scan, ArrayList<Car> CarRoster) {
		while (carChoice.equalsIgnoreCase("n")) {
			System.out.println("Please select another car");
			printArray(CarRoster);
			userChoice = getInt(scan, "", 1, 6);
			System.out.println(CarList().get(userChoice - 1));
			System.out.println("Is this the car you'd like to purchase? (y/n)");
			carChoice = userChoice(scan);
		}
		return userChoice;
	}

	public static ArrayList<Car> removeCar(ArrayList<Car> CarList, int userChoice) {
		CarList.remove((userChoice - 1));

		return CarList;
	}
}

