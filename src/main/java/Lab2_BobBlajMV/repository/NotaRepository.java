package Lab2_BobBlajMV.repository;

import Lab2_BobBlajMV.domain.*;
import Lab2_BobBlajMV.validation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}
