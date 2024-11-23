package i.vk52.userprograms1;

class Person implements Cloneable {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding the clone() method to enable shallow cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public static void main(String[] args) {
        try {
            // Create the original person object
            Person originalPerson = new Person("John", 30);

            // Perform a shallow clone using the clone() method
            Person clonedPerson = (Person) originalPerson.clone();

            // Modify the cloned person's properties
            clonedPerson.name = "Jane";
            clonedPerson.age = 25;

            // Output the original and cloned person objects
            System.out.println("Original Person: " + originalPerson+"\t\t"+originalPerson.hashCode());
            System.out.println("Cloned Person: " + clonedPerson+"\t\t"+clonedPerson.hashCode());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
