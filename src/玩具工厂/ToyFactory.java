package 玩具工厂;

import java.util.Objects;

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        if (Objects.equals(type, "Dog")) {
            return new Dog();
        } else if (Objects.equals(type, "Cat")) {
            return new Cat();
        } else {
            return null;
        }
    }
}
