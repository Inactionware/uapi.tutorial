package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("TypeBasedInjection")
public class TypeBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject
    protected TypedService _svc;

    @OnActivate
    public void activate() {
        if (this._svc != null) {
            this._logger.info("The TypedService is injected!");
        } else {
            this._logger.error("The TypedService is NOT injected!");
        }
    }
}
