import uapi.IModulePortal;
import uapi.tutorial.app.TutorialAppModulePortal;

module uapi.tutorial.app {
    requires static uapi.codegen;
    requires static uapi.service.apt;
    requires static uapi.behavior.apt;

    requires uapi.common;
    requires uapi.exception;
    requires uapi.service;
    requires uapi.config;
    requires uapi.event;
    requires uapi.behavior;
    requires uapi.log;
    requires uapi.app;
    requires uapi.app.terminal;

    exports uapi.tutorial.app.generated to uapi.service;

    provides IModulePortal with TutorialAppModulePortal;
}