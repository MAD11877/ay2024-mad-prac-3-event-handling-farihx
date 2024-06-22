package sg.edu.np.mad.madpractical3;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testUserCreation() {
        User user = new User("John Doe", "MAD Developer", 1, false);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
        assertEquals("MAD Developer", user.getDescription());
        assertEquals(1, user.getId());
        assertFalse(user.isFollowed());
    }
}