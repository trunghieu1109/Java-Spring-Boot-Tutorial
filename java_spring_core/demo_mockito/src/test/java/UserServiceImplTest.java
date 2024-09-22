import org.example.UserDao;
import org.example.UserService;
import org.example.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @Spy
    List<Integer> list;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userDao);
    }

    @Test
    public void createUser_False() {
        Mockito.when(userDao.createUser("hieukunno@gmail.com")).thenReturn(false);

        Assert.assertEquals("Can't create user with this email", userService.createUser("hieukunno@gmail.com"));

    }

    @Test
    public void createUser_True() {
        Mockito.when(userDao.createUser("datnguyen@gmail.com")).thenReturn(true);

        Assert.assertEquals("Create user successfully", userService.createUser("datnguyen@gmail.com"));
    }

    @Test
    public void createUser_True2() {
        UserDao userDao1 = Mockito.mock(UserDao.class);

        Mockito.when(userDao1.createUser("hieu@gmail.com")).thenReturn(true);

        UserService userService1 = new UserServiceImpl(userDao1);

        Assert.assertEquals("Create user successfully", userService1.createUser("hieu@gmail.com"));

    }

    @Test
    public void createUser_False2() {

        Mockito.when(list.get(0)).thenReturn(6);

        Assert.assertEquals((Integer)6, list.get(0));

    }
}
