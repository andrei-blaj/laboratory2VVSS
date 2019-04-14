package Lab2_BobBlajMV;

import static org.junit.Assert.assertTrue;

import Lab2_BobBlajMV.domain.Student;
import Lab2_BobBlajMV.domain.Tema;
import Lab2_BobBlajMV.repository.StudentXMLRepository;
import Lab2_BobBlajMV.repository.TemaXMLRepository;
import Lab2_BobBlajMV.validation.ValidationException;
import Lab2_BobBlajMV.validation.Validator;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /*
     Laboratory 2
     */

    @Test
    public void addStudentHappyFlow() {
        Student student = new Student("7", "Bob", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };

        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
        studentFileRepository.save(student);

        Student studentFound = studentFileRepository.findOne("7");
        Assert.assertTrue(studentFound.getNume().equals("Bob"));
    }

    /*
        Test cases for id field.
    */
    @Test
    public void addStudentWithExistingId() {
        Student student1 = new Student("7", "Bob", 931);
        Student student2 = new Student("7", "Diana", 932);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
        studentFileRepository.save(student1);
        studentFileRepository.save(student2);

        Student studentFound = studentFileRepository.findOne("7");
        Assert.assertTrue(studentFound.getNume().equals("Bob"));
    }

    @Test
    public void addStudentWithIdNull() {
        Student student = new Student(null, "Blaj Andrei Sorin 2", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        int initialLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            initialLengthOfRepository++;
        }

        studentFileRepository.save(student);

        int finalLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            finalLengthOfRepository++;
        }

        Assert.assertTrue(initialLengthOfRepository == finalLengthOfRepository - 1);
    }

    @Test
    public void addStudentWithIdAsNumber() {
        Student student = new Student("test", "Blaj Andrei Sorin 2", 931);
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        int initialLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            initialLengthOfRepository++;
        }

        studentFileRepository.save(student);

        int finalLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            finalLengthOfRepository++;
        }

        Assert.assertTrue(initialLengthOfRepository == finalLengthOfRepository);
    }

    @Test
    public void addStudentWithIdEmptyString() {
        Student student = new Student("", "Blaj Andrei Sorin 3", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        int initialLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            initialLengthOfRepository++;
        }

        studentFileRepository.save(student);

        int finalLengthOfRepository = 0;
        for (Student currentStudent : studentFileRepository.findAll()) {
            finalLengthOfRepository++;
        }

        Assert.assertTrue(initialLengthOfRepository == finalLengthOfRepository);
    }

    /*
      Test cases for name field.
    */
    @Test
    public void addStudentWithNameNull() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("16", null, 931);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("16");
        Assert.assertTrue(foundStudent != null);
    }

    @Test
    public void addStudentWithNameEmptyString() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("19", "", 931);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("19");
        Assert.assertTrue(foundStudent != null);
    }

    @Test
    public void addStudentWithNameOfHighLength() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("21", "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn", 931);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("21");
        Assert.assertTrue(foundStudent != null);
    }

    /*
       Test cases for group field.
    */
    @Test
    public void addStudentWithGroupLessThan110() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("23", "Bob", 100);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("23");
        Assert.assertTrue(foundStudent != null);
    }

    @Test
    public void addStudentWithGroupBiggerThan938() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("24", "Bob", 100);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("24");
        Assert.assertTrue(foundStudent != null);
    }

    @Test
    public void addStudentWithGroupAsArithExp() {
        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");

        Student student = new Student("25", "Bob", 900 + 1);
        studentFileRepository.save(student);

        Student foundStudent = studentFileRepository.findOne("25");
        Assert.assertTrue(foundStudent != null);
    }


//    @Test
//    public void addAssignment(){
//        Tema assignment = new Tema("6", "Description", 8, 2);
//
//        Validator<Tema> validator = new Validator<Tema>() {
//            @Override
//            public void validate(Tema entity) throws ValidationException {
//
//            }
//        };
//
//        TemaXMLRepository fileRepository = new TemaXMLRepository(validator, "teme.xml");
//        fileRepository.save(assignment);
//
//        Tema tema = fileRepository.findOne("6");
//
//        Assert.assertTrue(tema.getDeadline()==8);
//    }
//
//    @Test
//    public void addAssignmentError(){
//        Tema assignment = new Tema("6", "Description", 8, 2);
//        Tema assignmentSecond = new Tema("6", "Description-second", 7, 4);
//
//
//        Validator<Tema> validator = new Validator<Tema>() {
//            @Override
//            public void validate(Tema entity) throws ValidationException {
//
//            }
//        };
//
//        TemaXMLRepository fileRepository = new TemaXMLRepository(validator, "teme.xml");
//        fileRepository.save(assignment);
//        fileRepository.save(assignmentSecond);
//
//        Tema tema = fileRepository.findOne("6");
//
//        Assert.assertTrue(!(tema.getDeadline()==7));
//    }
}
