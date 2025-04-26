package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.server.PWA;

@Theme("mytheme")
@PWA(name = "My App", shortName = "App") // jos käytössä
public class AppShellConfig implements AppShellConfigurator {
}
