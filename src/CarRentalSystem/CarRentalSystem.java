package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CarRentalSystem.Car;
import CarRentalSystem.Customer;
import CarRentalSystem.Rent;

public class CarRentalSystem {

private List<Car> cars; 
	
	private List<Customer> customers;
	
	private List<Rent> rents;

	private String anotherString;
	
	
	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rents = new ArrayList<>();
		
	}
	
	public void addCar(Car car) {
		cars.add(car);	
	}
	
	public void addCustomer (Customer customer) {
		customers.add(customer);
	}
	
	public void rentaCar(Car car,Customer customer, int days) {
		if(car.isAvailable()) {
			car.rent();
			rents.add(new Rent(car,customer,days));
		} else {
			System.out.println("So Sorry,,! Car is not available for Rent..."); 
		}
	}
	
	public void returnCar(Car car) {
		car.returnCar();
		Rent rentsToRemove = null;
		for( Rent rent : rents) {
			if(rent.getCar() == car) {
				rentsToRemove = rent;
				break;
			}
		}
		
		if (rentsToRemove != null) {
			rents.remove(rentsToRemove);
			System.out.println("Car returned Successfully...! Thank You and Visit Again..");
		} else {
			System.out.println("Car was not rented");
		}
	}
	
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("========CAR RENTAL SYSTEM========");
			System.out.println("1.RENT A CAR");
			System.out.println("2.RETURN A CAR");
			System.out.println("3.EXIT");
			System.out.println("Enter your choice: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			if(choice == 1) {
				System.out.println("\n== RENT A CAR ==");
				System.out.println("Enter your Name : ");
				String customerName = scanner.nextLine();
				
				System.out.println("\n Available cars: ");
				for(Car car : cars) {
					if(car.isAvailable()) {
						System.out.println(car.getCarId() + " - "+car.getCarBrand() + " - "+car.getCarModel());
					}
				}
				
				System.out.println("\n Enter the car ID you want to rent : ");
				String carId = scanner.nextLine();
				
				System.out.println("Enter the Number of days for rent a car : ");
				int days = scanner.nextInt();
				scanner.nextLine();
				
				Customer C = new Customer("CUS" + (customers.size() + 1),customerName);
				addCustomer(C);
				
				Car c = null;
				for(Car car : cars) {
					if(car.getCarId().equals(carId) && car.isAvailable()) {
						c = car;
						break;
					}
				}
				
				if(c != null) {
					double TotalPrice = c.calculatePrice(days);
					System.out.println("\n == Rental Information ==\n");
					System.out.println("Customer ID : "+C.getCustomerId());
					System.out.println("Customer Name : "+C.getCustomerName());
					System.out.println("Car : "+c.getCarBrand()+ "  " + c.getCarModel());
					System.out.println("Rent Days : "+days);
					System.out.printf("Total Price : $%.2f%n", TotalPrice);
					
					System.out.println("\n Confirm rental (Y/N) : ");
					String confirm = scanner.nextLine();
					
					
					if (confirm.equalsIgnoreCase("Y")) {
                        rentaCar(c, C, days);
                        System.out.println("\nHurrah..! Car rented successfully.\n");
                    } else {
                        System.out.println("\nOops...! Your rental is canceled.\n");
                    }
					  
				} else {
					System.out.println("Sorry.. Invalid car selection or car not available for rent..");
					
				}
				
			} else if (choice == 2) {
				System.out.println("== Return a Car ==");
				System.out.println("Enter the car Id you want ro return : ");
				String carId = scanner.nextLine();
				
				Car carToReturn = null;
				for(Car car : cars) {
					if(car.getCarId().equals(carId) && !car.isAvailable()) {
						carToReturn = car;
						break;
					}
				}
				
				if(carToReturn != null) {
					Customer customer = null;
					for (Rent rents : rents) {
						if(rents.getCar() == carToReturn) {
							customer = rents.getCustomer();
							break;
						}
					}
					
					if(customer != null) {
						returnCar(carToReturn);
						System.out.println("Car returned Successfully by "+ customer.getCustomerName());
						
					} else {
						System.out.println("Car was not rented or rental information is missing...");
					}
				} else {
					System.out.println("Invalid car ID or car is not rented..");
				}
			}else if(choice == 3) {
				break;
			}else {
				System.out.println("Invalid choice.. Please enter the valid choice..");
			}
		}
		System.out.println("Thank You for using the Car Rental System...!");
	}
}
