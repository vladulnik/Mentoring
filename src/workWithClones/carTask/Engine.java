package workWithClones.carTask;

public class Engine implements Cloneable {
    private String type;
    private int horsePower;

    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant clone: " + e);
        }
    }
}
