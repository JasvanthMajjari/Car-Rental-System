package CarRentalSystem;

public class Car {

	private String carId;
	private String carBrand;
	private String carModel;
	private double rentPerDay;
	private boolean isAvailable;
	
	
	
	public Car(String carId, String carBrand, String carModel, double rentPerDay) {
		this.carId = carId;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.rentPerDay = rentPerDay;
		this.isAvailable = true;
	}



	public String getCarId() {
		return carId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public String getCarModel() {
		return carModel;
	}


	public double calculatePrice(int rentalDays) {
		return rentPerDay * rentalDays;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void rent() {
		boolean isAvaiable = false;
	}
	
	public void returnCar() {
		boolean isAvailable = true;
	}
}
