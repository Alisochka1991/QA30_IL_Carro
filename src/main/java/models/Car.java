package models;


import lombok.*;

@Getter //tolko dlya lombok annotatsii
@Setter
@Builder
@ToString


public class Car {
    String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String calsS;
    String fuelConsumption ;
    String carRegNumber;
    String price;
    String distanceIncluded ;
    String typeFeature;
    String about;

}
