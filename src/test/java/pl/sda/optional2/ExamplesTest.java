package pl.sda.optional2;

import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLOutput;
import java.util.Optional;

public class ExamplesTest {

    @Test
    public void whenCreateEmptyOptional_thenReturnTreu(){

        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull() {
        String name = "testowa wartość";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[testowa wartość]", opt.toString());
    }

    //@Test(expected = NullPointerException.class) - jeżeli oczekujemy że test wyrzuci określony wyjatek
    // to dopisujemy expected = ....
    @Test
    public void givenNull_whenErrorOnCreate_thenCorrect(){
            String name = null;
            Optional<String> opt = Optional.of(name);
        }


    @Test
    public void givenNull_whenCreateNullable_thenCorrect(){
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty",opt.toString());

    }

    @Test
    public void givenOptional_whenIfPresentOk_thenCorrect(){
        Optional<String> name = Optional.ofNullable(null);
        name.ifPresent(n -> System.out.println("Witaj: " + n));

        if(name.isPresent()){
            System.out.println("Witaj: " + name);
        }


    }


    //@Test
    @Test(expected = IllegalArgumentException.class)

    public void whenOrElseWorks_thenCorrect(){
        String name = null;
        //@Test + to co ponizej w przypadku pustego name-a - > "Nowe imie"
       // String nameGood = Optional.ofNullable(name).orElse("Nowe imie");


        //inaczej:
       // String nameGood = Optional.ofNullable(name).orElseThrow(() ->new IllegalArgumentException());
        String nameGood = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);

        Optional<String> opt = Optional.of("Wartość");
        opt.get();
        System.out.println(opt);
        //w klasie optional - metoda toString jest nadpisana - jak printujemy referencje - domyuslnie
        //wywolywana jest metoda to string


        assertEquals("Nowe imie",nameGood.toString());
    }





}