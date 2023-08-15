package client;

public class CarDTO {

		private String licensePlate;

		private boolean available;

		private CarModelDTO carModel;

		public CarDTO() {
		}

		public CarDTO(String licensePlate, boolean available) {
			this.licensePlate = licensePlate;
			this.available = available;
		}

		public String getLicensePlate() {
			return licensePlate;
		}

		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}

	@Override
	public String toString() {
		return "CarDTO{" +
				"licensePlate='" + licensePlate + '\'' +
				", available=" + available +
				'}';
	}
}
