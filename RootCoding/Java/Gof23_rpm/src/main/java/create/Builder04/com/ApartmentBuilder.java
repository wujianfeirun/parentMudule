package create.Builder04.com;

/**
 * Created by asus on 2017/11/18.
 */
public class ApartmentBuilder implements HouseBuilder {
    private House house = new House();
    public void makeFloor() {
        house.setFloor("apartment floor");
    }

    public void makeWall() {
        house.setWall("apartment wall");
    }

    public void makeRoof() {
        house.setRoof("apartment roof");
    }

    public House getHouse() {
        return house;
    }
}
