package edu.unl.raikes.BinarySearchTreeLab;

/**
 * A container class for Person data.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
     * Initializes a Person object.
     * 
     * @param NUID the specific ID of the person.
     * @param name the name of the person.
     */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    /**
     * Gets a string representation of this person object.
     * 
     * @return the string representation.
     */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
     * Compares this person object with another person object based on their specific NUID.4
     * 
     * @param  other the person to compare with.
     * @return       the result of the comparison.
     */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}
