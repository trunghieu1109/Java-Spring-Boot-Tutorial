import org.example.UserDao;
import org.example.UserDaoImpl;
import org.example.UserService;
import org.example.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest2 {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void createUser_False3() {
        Mockito.when(userDao.createUser("kunno@gmail.com")).thenReturn(false);

        Assert.assertEquals("Can't create user with this email", userService.createUser("kunno@gmail.com"));
    }

    @Test
    public void captor_capture_test() {
        List<String> str = Arrays.asList("a", "b", "c");

        List<String> mockList = Mockito.mock(List.class);

        mockList.addAll(str);

        Mockito.verify(mockList).addAll(captor.capture());

        List<String> result = captor.getValue();

        Assert.assertEquals(3, result.size());

    }

    @Test(expected = IllegalAccessError.class)
    public void test_exception() {
        UserDao userDao2 = Mockito.mock(UserDao.class);

        Mockito.when(userDao2.createUser("tt")).thenThrow(new IllegalAccessError("false"));

        UserService userService1 = new UserServiceImpl(userDao2);

        userService1.createUser("tt");

    }
    
    @Test
    public void test_answer() {
        UserDao userDao1 = Mockito.mock(UserDao.class);
        
        Mockito.when(userDao1.createUser("tt")).thenAnswer(new Answer<Boolean>() {

            public Boolean answer(InvocationOnMock invocation) {
                return Boolean.TRUE;
            }

        });

        UserService userService1 = new UserServiceImpl(userDao1);

        Assert.assertEquals("Create user successfully", userService1.createUser("tt"));

    }

    @Test
    public void test_call_method() {
        UserDao userDao1 = Mockito.mock(UserDaoImpl.class);

        Mockito.when(userDao1.createUser("tt")).thenCallRealMethod();

        UserService userService1 = new UserServiceImpl(userDao1);

        Assert.assertEquals("Can't create user with this email", userService1.createUser("tt"));

        Mockito.verify(userDao1, times(2)).createUser("tt");

    }

}
