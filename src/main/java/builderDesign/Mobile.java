package builderDesign;

public class Mobile {
    private String name;
    private String color;
    private String ram;
    private String processor;

    private Mobile(String name, String color, String ram, String processor) {
        this.name = name;
        this.color = color;
        this.ram = ram;
        this.processor = processor;
    }

//if we want to assign value to these variable then we generally need setter but if want to make that variable then
// setter won't work properly

    /*public Mobile(String name) {
        this.name = name;
    }

    public Mobile(String name, String color) {
        this.name = name;
        this.processor = color;
    }

    public Mobile(String name, String color, String ram) {
        this.name = name;
        this.color = color;
        this.ram = ram;
    }

    public Mobile(String name, String color, String ram, String processor) {
        this.name = name;
        this.color = color;
        this.ram = ram;
        this.processor = processor;
    }*/
    //this is telescoping  constructor approach
}
