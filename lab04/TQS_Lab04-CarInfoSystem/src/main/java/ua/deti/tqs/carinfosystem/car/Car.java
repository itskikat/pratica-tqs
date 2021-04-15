package ua.deti.tqs.carinfosystem.car;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private long carID;

    private String maker;

    private String model;

    public Car(String maker, String model){
        this.maker = maker;
        this.model = model;
    }

    public Car(){

    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this != o){
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        return true;
    }
}
