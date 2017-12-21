package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("IdBasedInjection")
public class IdBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject(value = "MyService")
    protected IdentifiedService _svc;

    @OnActivate
    protected void activate() {
        if (this._svc != null) {
            this._logger.info("The IdentifiedService is injected!");
        } else {
            this._logger.error("The IdentifiedService is NOT injected!");
        }
    }
}
