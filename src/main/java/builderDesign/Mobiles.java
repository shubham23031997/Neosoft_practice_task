package builderDesign;

import lombok.Getter;
import lombok.ToString;

//@Builder
@ToString
@Getter
public class Mobiles {
    private String name;
    private String color;
    private String ram;
    private String processor;

    private Mobiles(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.processor = builder.processor;
        this.ram = builder.ram;
    }
    //to access values of above fields need getters

    static class Builder {
        private String name;
        private String color;
        private String ram;
        private String processor;

        public Builder(String name) {
            this.name = name;
        }

//        public BuilderClass setName(String name) {
//            this.name = name;
//            return this;
//        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Mobiles build() {
            return new Mobiles(this);
        }
    }

    /*@Override
    public String toString() {
        return "Mobiles{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", ram='" + ram + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }*/
}
