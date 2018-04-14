package create.Builder04;

import create.Builder04.com.ApartmentBuilder;
import create.Builder04.com.House;
import create.Builder04.com.HouseBuilder;
import create.Builder04.com.HouseDirector;

/**
 * Created by asus on 2017/11/18.
 */
public class MainClass {
    public static void main(String[] args) {
        HouseBuilder builder= new ApartmentBuilder();

        HouseDirector direcotr = new HouseDirector();
        direcotr.makeHouse(builder);

        House house = builder.getHouse();
        System.out.println(house.getFloor());
    }
}
