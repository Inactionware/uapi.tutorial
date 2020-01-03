import uapi.IModulePortal;
import uapi.tutorial.profile.TutorialProfileModulePortal;

module uapi.tutorial.profile {
    requires static uapi.codegen;
    requires static uapi.service.apt;

    requires uapi.common;
    requires uapi.exception;
    requires uapi.service;
    requires uapi.config;
    requires uapi.log;
    requires uapi.app;
    requires uapi.app.terminal;

    provides IModulePortal with TutorialProfileModulePortal;
}