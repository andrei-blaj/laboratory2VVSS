package Lab2_BobBlajMV;

import static org.junit.Assert.assertTrue;

import Lab2_BobBlajMV.domain.Nota;
import Lab2_BobBlajMV.domain.Pair;
import Lab2_BobBlajMV.domain.Student;
import Lab2_BobBlajMV.domain.Tema;
import Lab2_BobBlajMV.repository.NotaXMLRepository;
import Lab2_BobBlajMV.repository.StudentXMLRepository;
import Lab2_BobBlajMV.repository.TemaXMLRepository;
import Lab2_BobBlajMV.validation.ValidationException;
import Lab2_BobBlajMV.validation.Validator;


import org.junit.Assert;
import org.junit.Test;

public class Lab4ICAppTest {

    @Test
    public void addStudent() {
        Student student = new Student("7", "Bob", 931);

        Validator<Student> validator = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };

        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validator, "studenti.xml");
        studentFileRepository.save(student);

        Student studentFound = studentFileRepository.findOne("7");
        Assert.assertTrue(studentFound.getNume().equals("Bob"));
    }

    @Test
    public void addAssignment() {

        Validator<Tema> validator = new Validator<Tema>() {
            @Override
            public void validate(Tema entity) throws ValidationException {

            }
        };
        TemaXMLRepository fileRepository = new TemaXMLRepository(validator, "teme.xml");

        Tema assignment = new Tema("6", "Test assignment", 8, 6);
        fileRepository.save(assignment);

        Tema tema = fileRepository.findOne("6");
        Assert.assertTrue(tema.getDeadline() == 8);
    }

    @Test
    public void addGrade() {
        Pair<String, String> gradeId = new Pair<>("7", "8");
        Nota currentGrade = new Nota(gradeId, 8, 8, "It is ok");

        Validator<Nota> validator = new Validator<Nota>() {
            @Override
            public void validate(Nota entity) throws ValidationException {

            }
        };
        NotaXMLRepository gradeRepository = new NotaXMLRepository(validator, "note.xml");

        gradeRepository.save(currentGrade);

        Assert.assertTrue(gradeRepository.findOne(gradeId).getNota() == 8);
    }

    @Test
    public void integrationTest() {

        //Add student
        Student student = new Student("7", "Bob", 931);
        Validator<Student> validatorStudent = new Validator<Student>() {
            @Override
            public void validate(Student entity) throws ValidationException {

            }
        };
        StudentXMLRepository studentFileRepository = new StudentXMLRepository(validatorStudent, "studenti.xml");
        studentFileRepository.save(student);


        //Add assignment
        Tema assignment = new Tema("6", "Test assignment", 8, 6);
        Validator<Tema> validatorAssign = new Validator<Tema>() {
            @Override
            public void validate(Tema entity) throws ValidationException {

            }
        };
        TemaXMLRepository fileRepository = new TemaXMLRepository(validatorAssign, "teme.xml");
        fileRepository.save(assignment);


        //Add grade
        Pair<String, String> gradeId = new Pair<>("7", "8");
        Nota currentGrade = new Nota(gradeId, 8, 8, "It is ok");
        Validator<Nota> validator = new Validator<Nota>() {
            @Override
            public void validate(Nota entity) throws ValidationException {

            }
        };
        NotaXMLRepository gradeRepository = new NotaXMLRepository(validator, "note.xml");
        gradeRepository.save(currentGrade);


        Assert.assertTrue(studentFileRepository.findOne("7").getNume().equals("Bob"));

        Assert.assertTrue(fileRepository.findOne("6").getDeadline() == 8);

        Assert.assertTrue(gradeRepository.findOne(gradeId).getNota() == 8);
    }
}
