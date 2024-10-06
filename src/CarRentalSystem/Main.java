package CarRentalSystem;

import CarRentalSystem.Car;
import CarRentalSystem.CarRentalSystem;

public class Main {

	public static void main(String args[]) {
		CarRentalSystem CRS = new CarRentalSystem();
		
		Car c1 = new Car("C001","Toyota","Camry",60.0);
		Car c2 = new Car("C002","Honda","Accord",70.0);
		Car c3 = new Car("C003","Mahindra","Thar",150.0);
		
		CRS.addCar(c1);
		CRS.addCar(c2);
		CRS.addCar(c3);

		CRS.menu();
	}
}
