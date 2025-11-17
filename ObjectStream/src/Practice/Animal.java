package Practice;

import java.io.Serializable;

public class Animal implements Serializable,Comparable<Animal>{
    String name;
    int legs;
    double age;

    public Animal(String name, int legs, double age) {
        this.name = name;
        this.legs = legs;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", legs=" + legs +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        int comp = o.name.compareTo(this.name);
        if(comp ==0 ){
            if(o.age>this.age) return -1;
        }
        return comp;
    }

}
