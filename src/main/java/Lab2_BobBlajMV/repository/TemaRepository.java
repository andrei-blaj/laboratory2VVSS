package Lab2_BobBlajMV.repository;

import Lab2_BobBlajMV.domain.Tema;
import Lab2_BobBlajMV.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

