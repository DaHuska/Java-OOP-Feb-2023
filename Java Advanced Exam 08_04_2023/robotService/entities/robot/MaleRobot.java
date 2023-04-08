package robotService.entities.robot;

public class MaleRobot extends BaseRobot {

    // Can only live in MainService!
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, 9, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 3);
    }
}
