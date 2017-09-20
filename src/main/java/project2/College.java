package project2;

import project1.Course;
import project1.Module;
import project1.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class College {
    public static void main(String[] args){
        Student stu1 = new Student("Alex", 18, new DateTime(15000000), "123A");
        Student stu2 = new Student("Bob", 19, new DateTime(14000000), "124B");
        Student stu3 = new Student("Charles", 20, new DateTime(13000000), "125C");
        Student stu4 = new Student("David", 35, new DateTime(12000000), "126D");

        Student[] group1 = {stu1, stu2, stu3, stu4};
        Student[] group2 = {stu3};

        Module mod1 = new Module("Systems", "CT101", group1);
        Module mod2 = new Module("SoftEng", "CT213", group2);
        Module mod3 = new Module("HCI", "CT345", new Student[0]);

        Module[] modules = {mod1, mod2, mod3};
        Course cs = new Course("Computer Science", modules, new DateTime(12000000), new DateTime(15000000));

        // Create mapping of students to modules so we can see who studies what
        Map<Student, ArrayList<Module>> studies = new HashMap<Student, ArrayList<Module>>();
        for(Module m : cs.getModules()){
            for(Student s : m.getStudents()){
                if (studies.get(s) == null)
                    studies.put(s, new ArrayList<Module>());
                studies.get(s).add(m);
            }
        }

        for (Entry<Student, ArrayList<Module>> entry : studies.entrySet()) {
            System.out.println(entry.getKey().getName() + " in " + cs.getName() + " studies:");
            for(Module m : entry.getValue()){
                System.out.println("\t" + m.getId() + " " + m.getName());
            }
        }

    }
}
