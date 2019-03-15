package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.IBehavior;
import uapi.behavior.IResponsible;
import uapi.behavior.IResponsibleRegistry;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("SayGreeting")
public class GreetingApp {

    @Inject
    protected IResponsibleRegistry _respReg;

    @OnActivate
    public void activate() {
        IResponsible greeting = this._respReg.register("Greeting Maker");
        IBehavior makeGreeting = greeting.newBehavior("Make Greeting", String.class)
                .then(MakeGreetingAction.class)
                .build();

        greeting.newBehavior("Out Greeting", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(GetUserAction.class)
                .then(makeGreeting.getId())
                .then(OutGreetingAction.class)
                .build();
    }
}
