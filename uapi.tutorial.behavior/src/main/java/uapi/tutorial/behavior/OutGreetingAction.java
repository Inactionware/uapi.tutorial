package uapi.tutorial.behavior;

import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("SayGreeting")
public class OutGreetingAction {

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void out(final String greeting) {
        this._logger.info(greeting);
    }
}
