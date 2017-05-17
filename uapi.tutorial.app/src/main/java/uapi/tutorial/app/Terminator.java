package uapi.tutorial.app;

import uapi.app.AppStartupEvent;
import uapi.app.ExitSystemRequest;
import uapi.behavior.*;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.event.IEventBus;
import uapi.service.annotation.*;

/**
 * A Terminator can send an event to terminate application
 */
@Service(autoActive = true)
@Tag("Terminator")
public class Terminator {

    @Inject
    protected IResponsibleRegistry _respReg;

    @Inject
    protected IEventBus _eventBus;

    @OnActivate
    public void activate() {
        IResponsible resp = this._respReg.register("Terminator");
        resp.newBehavior("Do Something", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(TerminateApp.actionId)
                .traceable(true)
                .build();
        BehaviorFinishedEventHandler finHandler = (event) -> new ExitSystemRequest("Terminator");
        resp.on(finHandler);
    }

    @Service
    @Action
    @Tag("Terminator")
    public static class TerminateApp {

        private static final ActionIdentify actionId = ActionIdentify.toActionId(TerminateApp.class);

        @ActionDo
        public boolean doSomething(AppStartupEvent event) throws Exception {
            Thread.sleep(1000);
            return true;
        }
    }

    @Service
    @Action
    @Tag("Terminator")
    public static class CleanUp {

        private static final ActionIdentify actionId = ActionIdentify.toActionId(CleanUp.class);

        @ActionDo
        public void cleanUp(String tt) {}

    }
}
