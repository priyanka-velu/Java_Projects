import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // default constructor
    public Automobile() {
        this.make = " ";
        this.model = " ";
        this.color = " ";
        this.year = 0;
        this.mileage = 0;
    }

    // parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }


    // add vehicle
    public boolean addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.mileage = mileage;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // remove vehicle
    public boolean removeVehicle() {
        try {
            this.make = " ";
            this.model = " ";
            this.color = " ";
            this.year = 0;
            this.mileage = 0;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // update vehicle
    public boolean updateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.mileage = mileage;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // list vehicle info
    public String[] listVehicle() {
        String[] info = new String[5];
        info[0] = "Make: " + make;
        info[1] = "Model: " + model;
        info[2] = "Color: " + color;
        info[3] = "Year: " + year;
        info[4] = "Mileage: " + mileage;
        return info;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // calling Automobile class parameterized constructor
        Automobile car = new Automobile();

        // add vehicle
        car.addVehicle("Toyoto", "Camry", "Red", 2020, 10000);

        // listing info with loop
        String[] carInfo = car.listVehicle();
        System.out.println("Vehicle Information:");
        for (String info : carInfo) {
            System.out.println(info);
        }

        // remove vehicle
       boolean removed = car.removeVehicle();
       System.out.println("Vehicle Removed: " + (removed ? "Success" : "Failure"));

       // add vehicle
       boolean added = car.addVehicle("Ford", "Focus", "Red", 2023, 8000);
       System.out.println("New Vehicle Added: " + (added ? "Success" : "Failure"));

        // listing updated info with loop
       String[] newCarInfo = car.listVehicle();

       System.out.println("New Vehicle Information:");
       for (String info : newCarInfo) {
           System.out.println(info);
       }

       // update vehicle
       boolean updated = car.updateVehicle("Honda", "Accord", "Silver", 2021, 25000);
       System.out.println("Vehicle Updated: " + (updated ? "Success" : "Failure"));

       // listing updated info with loop
       String[] updatedCarInfo = car.listVehicle();
       System.out.println("Updated Vehicle Information:");
       for (String info : updatedCarInfo) {
           System.out.println(info);
       }

       // asking user to print info to a file
       System.out.print("Do you want to print the information to a file? (Y/N): ");
       String answer = scan.nextLine();

       if (answer.equalsIgnoreCase("Y")) {
           printToFile(updatedCarInfo);
           System.out.println("Information has been printed to C:\\Temp\\Autos.txt.");
       } 
       else if (answer.equalsIgnoreCase("N")) {
           System.out.println("No file will be printed.");
       } 
       else {
           System.out.println("Invalid answer. No file will be printed.");
       }
       scan.close();
    }

    // method for file
    private static void printToFile(String[] carInfo) {
        try {
           FileWriter writer = new FileWriter("C:\\Temp\\Autos.txt");
           for (String info : carInfo) {
               writer.write(info + "\n");
           }
           writer.close();
        } 
        catch (IOException e) {
           System.out.println("Error writing to the file.");
       }
    }
}