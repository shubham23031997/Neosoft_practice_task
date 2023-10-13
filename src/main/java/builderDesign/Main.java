package builderDesign;

public class Main {
    public static void main(String[] args) {
//        Mobiles mobiles=new Mobiles(); we can not access contructor bcz it is private
        Mobiles mobile1 = new Mobiles.Builder("onePlus")
                .setColor("black")
                .setProcessor("android")
                .setRam("8gb").build();
        System.out.println(mobile1);

        Mobiles mobile2 = new Mobiles.Builder("iphone")
                .setProcessor("ios")
                .setRam("4gb").build();
        System.out.println(mobile2);

        Mobiles mobile3 = new Mobiles.Builder("samsung")
                .setProcessor("android")
                .setColor("black").build();
        System.out.println(mobile3);

//Mobile mobile=new Mobile();
    }
}
