package Lab2_BobBlajMV.repository;

import Lab2_BobBlajMV.domain.Student;
import Lab2_BobBlajMV.validation.*;
import Lab2_BobBlajMV.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

