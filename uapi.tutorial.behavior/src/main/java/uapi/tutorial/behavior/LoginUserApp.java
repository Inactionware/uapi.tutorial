package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.IResponsibleRegistry;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("UserLogin")
public class LoginUserApp {

    @Inject
    protected IResponsibleRegistry _respReg;

    @OnActivate
    public void activate() {
        this._respReg.register("Login User")
                .newBehavior("Login User", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(FetchUserInfoAction.class)
                .then(LoginUserAction.class, "login")
                .then(LoginFailedAction.class)
                .navigator().moveTo("login")
                .when(attr -> attr.get("isSuccess"))
                .then(LoginSuccessAction.class)
                .build();
    }
}
