package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.ActionOutput;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("UserLogin")
public class FetchUserInfoAction {

    @ActionDo
    public void execute(AppStartupEvent event, ActionOutput<String> name, ActionOutput<String> password) {
        name.set("Min");
        password.set("password");
    }
}
