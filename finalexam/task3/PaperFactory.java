package finalexam.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        if (!staff.contains(p)) {
            staff.add(p);
        }
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    // Method to save staff list to a file
    public void saveStaffToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person p : staff) {
                writer.write(p.name + "," + p.surname + "," + p.personalNumber);
                writer.newLine();
            }
        }
    }

    // Method to load staff list from a file
    public void loadStaffFromFile(String filename) throws IOException {
        staff.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Person p = new Person(parts[0], parts[1], parts[2]);
                    staff.add(p);
                }
            }
        }
    }

    // Method to retrieve the staff list for verification
    public List<Person> getStaff() {
        return staff;
    }
}
