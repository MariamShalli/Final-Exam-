package finalexam.task2;

public class FactoryTester {

    public static void main(String[] args) {
        // Create a PaperFactory instance
        PaperFactory paperFactory = new PaperFactory();

        // Create some Person instances
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("Jane", "Doe", "987654321");

        // Add persons to the PaperFactory
        paperFactory.addPerson(person1);
        paperFactory.addPerson(person2);

        // Delete a person from the PaperFactory
        boolean isDeleted = paperFactory.deletePerson(person1);
        System.out.println("Person deleted: " + isDeleted);

        // Try to delete a non-existing person
        Person person3 = new Person("Jim", "Beam", "555555555");
        isDeleted = paperFactory.deletePerson(person3);
        System.out.println("Person deleted: " + isDeleted);
    }
}
