package factories;

import businessobjects.User;

public class UserStaticFactory {

    public static User createNominator() {
        User user = new User();
        user.setUsername("adam_admin");
        user.setPassword("pass");
        return user;
    }

    public static User createConfigAppUser() {
        User user = new User();
        user.setUsername("bhkb.jshcw@gqfozpkzgb.kbk");
        user.setPassword("password1");
        return user;
    }

    public static User createRedeemUser() {
        User user = new User();
        user.setUsername("renee_recipient1");
        user.setPassword("renee_recipient11");
        return user;
    }

    public static User createApproverUser() {
        User user = new User();
        user.setUsername("manfred_manager2");
        user.setPassword("manfred_manager21");
        return user;
    }
}
