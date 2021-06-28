package com.tms.TZ;public class Transport {
   int id;
   String name;
   int speed;
   int numberOfAccommodatedPeople;
   int numberOfAccommodatedCargo;
   Object typeOfTransport;
   int pricePerKilometer;

   public Transport(int id, String name, int speed, int numberOfAccommodatedPeople, int numberOfAccommodatedCargo, Object typeOfTransport, int pricePerKilometer) {
      this.id = id;
      this.name = name;
      this.speed = speed;
      this.numberOfAccommodatedPeople = numberOfAccommodatedPeople;
      this.numberOfAccommodatedCargo = numberOfAccommodatedCargo;
      this.typeOfTransport = typeOfTransport;
      this.pricePerKilometer = pricePerKilometer;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getSpeed() {
      return speed;
   }

   public void setSpeed(int speed) {
      this.speed = speed;
   }

   public int getNumberOfAccommodatedPeople() {
      return numberOfAccommodatedPeople;
   }

   public void setNumberOfAccommodatedPeople(int numberOfAccommodatedPeople) {
      this.numberOfAccommodatedPeople = numberOfAccommodatedPeople;
   }

   public double getNumberOfAccommodatedCargo() {
      return numberOfAccommodatedCargo;
   }

   public void setNumberOfAccommodatedCargo(int numberOfAccommodatedCargo) {
      this.numberOfAccommodatedCargo = numberOfAccommodatedCargo;
   }

   public Object getTypeOfTransport() {
      return typeOfTransport;
   }

   public void setTypeOfTransport(Object typeOfTransport) {
      this.typeOfTransport = typeOfTransport;
   }

   public int getPricePerKilometer() {
      return pricePerKilometer;
   }

   @Override
   public String toString() {
      return "Transport{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", speed=" + speed +
              ", numberOfAccommodatedPeople=" + numberOfAccommodatedPeople +
              ", numberOfAccommodatedCargo=" + numberOfAccommodatedCargo +
              ", typeOfTransport=" + typeOfTransport +
              ", pricePerKilometer=" + pricePerKilometer +
              '}';
   }

   public void setPricePerKilometer(int pricePerKilometer) {
      this.pricePerKilometer = pricePerKilometer;
   }
}
