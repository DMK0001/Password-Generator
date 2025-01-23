import io.github.dmk0001.passgen.LetterType;
import io.github.dmk0001.passgen.PasswordGenerator;
import io.github.dmk0001.passgen.PasswordException;
import io.github.dmk0001.passgen.utils.CharUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {

    @Test
    void shouldGeneratePasswordWithCorrectLength() throws PasswordException {
        PasswordGenerator passwordGenerator = new PasswordGenerator(16, LetterType.MIXED, true, true);
        String password = passwordGenerator.generate();

        assertEquals(16, password.length());
    }

    @Test
    void shouldGeneratePasswordWithOnlySmallLetterType() throws PasswordException{
        PasswordGenerator passwordGenerator = new PasswordGenerator(16, LetterType.ONLY_SMALL, true, true);
        String password = passwordGenerator.generate();

        for (int i = 0; i < password.length(); i++){
            int charId = password.charAt(i);
            assertFalse(CharUtils.getBigLetter().contains(charId));
        }
    }

    @Test
    void shouldGeneratePasswordWithOnlyBigLetterType() throws PasswordException{
        PasswordGenerator passwordGenerator = new PasswordGenerator(16, LetterType.ONLY_BIG, true, true);
        String password = passwordGenerator.generate();

        for (int i = 0; i < password.length(); i++){
            int charId = password.charAt(i);
            assertFalse(CharUtils.getSmallLetter().contains(charId));
        }
    }

    @Test
    void shouldThrowExceptionForInvalidLength(){
        assertThrows(PasswordException.class, () -> new PasswordGenerator(0, LetterType.MIXED, true, true));
    }

    @Test
    void shouldThrowExceptionForNullLetterType(){
        assertThrows(PasswordException.class, () -> new PasswordGenerator(32, null, true, true));
    }
}