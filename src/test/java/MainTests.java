import org.junit.jupiter.api.*;

public class MainTests {

    Main sut;

    @BeforeEach
    public void beforeEach() {
        sut = new Main();
    }

    @AfterEach
    public void afterEach() {
        sut = null;
    }

    @Test
    public void isPalindrome() {

        String text = "abba"; Boolean expected = true;

        Boolean actual = sut.isPalindrome(text);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void oneChar() {

        String text = "aaaa"; Boolean expected = true;

        Boolean actual = sut.oneChar(text);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isLexicograph() {

        String text = "abcd"; Boolean expected = true;

        Boolean actual = sut.isLexicograph(text);

        Assertions.assertEquals(expected, actual);
    }
}
