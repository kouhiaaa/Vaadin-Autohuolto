package com.autohuolto.autohuolto.config;

import com.autohuolto.autohuolto.view.HeaderView;
import com.autohuolto.autohuolto.view.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.Component;

public class MainViewi extends VerticalLayout {

    public MainViewi() {
        // Create the header view
        HeaderView header = new HeaderView();

        // Button to toggle dark mode
        Button darkModeButton = new Button("Toggle Dark Mode", event -> toggleDarkMode());

        // Create the navigation bar with RouterLinks
        HorizontalLayout navBar = new HorizontalLayout();
        navBar.add(createNavButton("Home", MainView.class));

        // Add components to the main view
        add(header, navBar, darkModeButton);
        setSizeFull();
        setAlignItems(Alignment.CENTER);
    }

    private void toggleDarkMode() {
        // Toggle dark mode on the UI
        if (UI.getCurrent().getElement().getThemeList().contains("dark")) {
            UI.getCurrent().getElement().getThemeList().remove("dark");
        } else {
            UI.getCurrent().getElement().getThemeList().add("dark");
        }
    }

    private RouterLink createNavButton(String text, Class<? extends Component> view) {
        // Create navigation buttons
        return new RouterLink(text, view);
    }
}
