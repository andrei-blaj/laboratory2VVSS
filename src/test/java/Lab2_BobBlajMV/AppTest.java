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
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

//    @Test
//    public void addStudentHappyFlow(){
//        Student student = new Student("7", "Bob", 931);
//
//        Validator<Student> validator = new Validator<Student>() {
//            @Override
//            public void validate(Student entity) throws ValidationException {
//
//            }
//        };
//
//        StudentXMLRepository fileRepository1 = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
//        fileRepository1.save(student);
//    }
//
//    @Test
//    public void addStudentError(){
//        Student student = new Student("7", "Bob", 931);
//
//        Validator<Student> validator = new Validator<Student>() {
//            @Override
//            public void validate(Student entity) throws ValidationException {
//
//            }
//        };
//
//        StudentXMLRepository fileRepository1 = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
//        fileRepository1.save(student);
//    }

    @Test
    public void addAssignment(){
        Tema assignment = new Tema("6", "Description", 8, 2);

        Validator<Tema> validator = new Validator<Tema>() {
            @Override
            public void validate(Tema entity) throws ValidationException {

            }
        };

        TemaXMLRepository fileRepository = new TemaXMLRepository(validator, "teme.xml");
        fileRepository.save(assignment);

        Tema tema = fileRepository.findOne("6");

        Assert.assertTrue(tema.getDeadline()==8);
    }

    @Test
    public void addAssignmentError(){
        Tema assignment = new Tema("6", "Description", 8, 2);
        Tema assignmentSecond = new Tema("6", "Description-second", 7, 4);


        Validator<Tema> validator = new Validator<Tema>() {
            @Override
            public void validate(Tema entity) throws ValidationException {

            }
        };

        TemaXMLRepository fileRepository = new TemaXMLRepository(validator, "teme.xml");
        fileRepository.save(assignment);
        fileRepository.save(assignmentSecond);

        Tema tema = fileRepository.findOne("6");

        Assert.assertTrue(!(tema.getDeadline()==7));
    }
}
