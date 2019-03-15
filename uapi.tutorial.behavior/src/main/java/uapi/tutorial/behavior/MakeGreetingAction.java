package uapi.tutorial.behavior;

import uapi.behavior.ActionOutput;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.common.StringHelper;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("SayGreeting")
public class MakeGreetingAction {

    @ActionDo
    public void makeGreeting(
            final String name,
            final ActionOutput<String> greeting
    ) {
        String msg = StringHelper.makeString("Hi {}, how are you!", name);
        greeting.set(msg);
    }
}
