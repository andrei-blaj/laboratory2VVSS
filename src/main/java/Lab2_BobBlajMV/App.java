package Lab2_BobBlajMV;
import Lab2_BobBlajMV.console.*;
import Lab2_BobBlajMV.domain.*;
import Lab2_BobBlajMV.repository.*;
import Lab2_BobBlajMV.service.*;
import Lab2_BobBlajMV.validation.*;

public class App 
{
    public static void main( String[] args )
    { Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "/Users/andrei/IdeaProjects/_931_Lab2_BobBlaj/src/main/java/Lab2_BobBlajMV/note2.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura

    }
}
