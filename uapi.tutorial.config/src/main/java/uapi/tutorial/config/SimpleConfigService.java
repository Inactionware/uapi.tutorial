package uapi.tutorial.config;

import uapi.config.annotation.Config;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("SimpleConfig")
public class SimpleConfigService {

    @Config(path = "cfg.string-value")
    protected String _stringValue;

    @Config(path = "cfg.int-value")
    protected int _intValue;

    @Config(path = "cfg.long-value")
    protected long _longValue;

    @Config(path = "cfg.float-value")
    protected float _floatValue;

    @Config(path = "cfg.double-value")
    protected double _doubleValue;

    @Config(path = "cfg.boolean-value")
    protected boolean _booleanValue;

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void activate() {
        this._logger.info("Config value:");
        this._logger.info("-> String Value is: {}", this._stringValue);
        this._logger.info("-> Integer Value is: {}", this._intValue);
        this._logger.info("-> Long Value is: {}", this._longValue);
        this._logger.info("-> Float Value is: {}", this._floatValue);
        this._logger.info("-> Double Value is: {}", this._doubleValue);
        this._logger.info("-> Boolean Value is: {}", this._booleanValue);
    }
}
