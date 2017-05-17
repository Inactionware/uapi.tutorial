package uapi.tutorial.app;

import uapi.app.AppStartupEvent;
import uapi.behavior.ActionIdentify;
import uapi.behavior.IExecutionContext;
import uapi.behavior.IResponsibleRegistry;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("HumanApp")
public class Human {

    @Inject
    protected IResponsibleRegistry _respReg;

    @OnActivate
    public void activate() {
        this._respReg.register("Mike")
                .newBehavior("Say Hello", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(Greeting.actionId)
                .build();
    }

    @Service
    @Action
    @Tag("HumanApp")
    public static class Greeting {

        public static final ActionIdentify actionId = ActionIdentify.toActionId(Greeting.class);

        @Inject
        protected ILogger _logger;

        @ActionDo
        public void say(AppStartupEvent event, IExecutionContext execCtx) {
            this._logger.info("Hello from {}!", execCtx.responsibleName());
        }
    }
}