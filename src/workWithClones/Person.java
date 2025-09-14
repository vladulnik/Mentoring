package workWithClones;

public final class Person implements Cloneable {

    private final String name;
    private final int age;
    private final Address address;
    private final int[] score;

    public Person(String name, int age, Address address, int[] score) {
        this.name = name;
        this.age = age;
        this.address = new Address(address.getStreet(), address.getCity());
        this.score = score.clone();
    }

    @Override
    public Person clone() {
        return new Person(this.name, this.age, this.address.clone(), this.score.clone());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address.getStreet(), address.getCity());
    }

    public int[] getScore() {
        return score.clone();
    }
}
