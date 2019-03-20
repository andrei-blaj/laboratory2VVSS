package Lab2_BobBlajMV;

import static org.junit.Assert.assertTrue;

import Lab2_BobBlajMV.domain.Student;
import Lab2_BobBlajMV.repository.StudentXMLRepository;
import Lab2_BobBlajMV.validation.ValidationException;
import Lab2_BobBlajMV.validation.Validator;


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

    @Test
    public void addStudentHappyFlow(){
        Student student = new Student("7", "Bob", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
        fileRepository1.save(student);
    }

    @Test
    public void addStudentError(){
        Student student = new Student("4", "Bob", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(validator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
        fileRepository1.save(student);
    }
}
