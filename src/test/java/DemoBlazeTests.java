import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;


class DemoBlazeTests {

    @Test
    Karate testSignup() {
        return Karate.run("signup").relativeTo(getClass());
    }


    @Test
    Karate testLogin() {
        return Karate.run("login").relativeTo(getClass());
    }
}
