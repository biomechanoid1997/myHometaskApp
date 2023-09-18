package mysql.animals;

import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String animalName;
    private String animalType;
    private String animalColor;
    private int animalAge;
    private String animalHost;
    public Animal(){ }

    public Animal(int id, String animalName, String animalType, String animalColor, int animalAge, String animalHost) {
        this.id = id;
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalColor = animalColor;
        this.animalAge = animalAge;
        this.animalHost = animalHost;
    }
    public Animal( String animalName, String animalType, String animalColor, int animalAge, String animalHost) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalColor = animalColor;
        this.animalAge = animalAge;
        this.animalHost = animalHost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalHost(String animalHost) {
        this.animalHost = animalHost;
    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public String getAnimalHost() {
        return animalHost;
    }
}
