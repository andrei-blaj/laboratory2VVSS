package Lab2_BobBlajMV.validation;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}