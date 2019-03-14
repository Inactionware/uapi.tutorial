package uapi.tutorial.behavior;

import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("UserLogin")
public class LoginSuccessAction {

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void doSuccess(boolean isSuccess) {
        if (isSuccess) {
            this._logger.info("Login user success");
        }
    }
}
