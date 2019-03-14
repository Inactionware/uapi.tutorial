package uapi.tutorial.behavior;

import uapi.behavior.ActionOutput;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("UserLogin")
public class LoginUserAction {

    private static final String USER_NAME   = "Min";
    private static final String USER_PWD    = "password";

    @ActionDo
    public void login(final String name, final String password, ActionOutput<Boolean> isSuccess) {
        boolean matched = USER_NAME.equals(name) && USER_PWD.equals(password);
        isSuccess.set(matched);
    }
}
