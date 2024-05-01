package views;

import org.junit.jupiter.api.Test;
import views.LogIn.LoginView;

class LoginViewTest {

    @Test
    void createLoginFrame() throws Exception {
        new LoginView().createLoginFrame();
    }
}