import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {
    private List<User> createUsers(User... users) {
        return new ArrayList<>(Arrays.asList(users));
    }

    @Test
    void MultipleConditionTest() {

        RuntimeException ex;

        // True, X, X
        User TXX = new User(null, null, null);
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(TXX, createUsers()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // False, True, X
        User FTX = new User("angela", null, "angela@yahoo.com");
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(FTX, createUsers()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // False, False, True
        User FFT = new User("angela", "password", null);
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(FFT, createUsers()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // False, False, False
        User FFF = new User("angela", "password", "angela@example.com");
        boolean result = SILab2.function(FFF, createUsers());
        assertFalse(result);
    }

    @Test
    void EveryBranchTest(){
        RuntimeException ex;
        // Exception 1-2
        User EXCEPTION = new User(null, null, null);
        ex = assertThrows(RuntimeException.class,
                () -> SILab2.function(EXCEPTION, createUsers()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //TRUE 22-24
        User TRUE = new User(null,"password#123","angela@yahoo.com");
        boolean result4 = SILab2.function(TRUE, createUsers());
        assertTrue(result4);

        //FALSE1 18-24
        User FALSE1 = new User("angela", "angela", "angela@yahoo.com");
        boolean result1 = SILab2.function(FALSE1, createUsers());
        assertFalse(result1);

        //FALSE2 19-23-24
        User FALSE2 = new User("angela","password 123","angela@yahoo.com");
        boolean result2 = SILab2.function(FALSE2, createUsers());
        assertFalse(result2);

        //FALSE3 20.2-23-24
        User FALSE3 = new User("angela","passwordpass","angela");
        boolean result3 = SILab2.function(FALSE2, createUsers());
        assertFalse(result3);

    }

}
