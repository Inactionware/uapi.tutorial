package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.ActionOutput;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("SayGreeting")
public class GetUserAction {

    @ActionDo
    public void get(
            final AppStartupEvent event,
            final ActionOutput<String> name
    ) {
        name.set("Min");
    }
}
