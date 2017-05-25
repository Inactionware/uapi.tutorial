package uapi.tutorial.app;

import uapi.app.AppShutdownEvent;
import uapi.app.AppStartupEvent;
import uapi.app.terminal.ExitSystemRequest;
import uapi.behavior.*;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
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
    protected ILogger _logger;

    @OnActivate
    public void activate() {
        IResponsible resp = this._respReg.register("Terminator");
        resp.newBehavior("Do Something", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(StartUp.actionId)
                .onSuccess((input, ctx) -> new ExitSystemRequest("Terminator"))
                .build();
        resp.newBehavior("Shutdown flow", AppShutdownEvent.class, AppShutdownEvent.TOPIC)
                .then(CleanUp.actionId)
                .build();
    }

    @OnDeactivate
    public void deactivate() {
        this._logger.info("The service is deactivated - {}", Terminator.class.getName());
    }

    @Service
    @Action
    @Tag("Terminator")
    public static class StartUp {

        private static final ActionIdentify actionId = ActionIdentify.toActionId(StartUp.class);

        @Inject
        protected ILogger _logger;

        @ActionDo
        public void doSomething(AppStartupEvent event) throws Exception {
            this._logger.info("Do start up action");
            Thread.sleep(1000);
        }
    }

    @Service
    @Action
    @Tag("Terminator")
    public static class CleanUp {

        private static final ActionIdentify actionId = ActionIdentify.toActionId(CleanUp.class);

        @Inject
        protected ILogger _logger;

        @ActionDo
        public void cleanUp(AppShutdownEvent event) {
            this._logger.info("Do clean up action");
        }
    }
}
