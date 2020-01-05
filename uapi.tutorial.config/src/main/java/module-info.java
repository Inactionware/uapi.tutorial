import uapi.IModulePortal;
import uapi.tutorial.config.TutorialConfigModulePortal;

module uapi.tutorial.config {
    requires static uapi.codegen;
    requires static uapi.service.apt;
    requires static uapi.config.apt;
    requires static uapi.behavior.apt;

    requires uapi.common;
    requires uapi.exception;
    requires uapi.service;
    requires uapi.config;
    requires uapi.log;
    requires uapi.event;
    requires uapi.behavior;
    requires uapi.app;
    requires uapi.app.terminal;

    exports uapi.tutorial.config.generated to uapi.service;

    provides IModulePortal with TutorialConfigModulePortal;
}