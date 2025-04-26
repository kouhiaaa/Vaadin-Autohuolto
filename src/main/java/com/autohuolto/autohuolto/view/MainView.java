package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Component;

@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout content = new VerticalLayout(new H1("Tervetuloa!"));
        content.setSizeFull();
        content.setAlignItems(Alignment.CENTER);
        content.setJustifyContentMode(JustifyContentMode.CENTER);

        // Footer
        Footer footer = new Footer(new Paragraph("© 2025 Autohuolto Oy"));
        footer.getStyle().set("text-align", "center")
                .set("padding", "1em")
                .set("background-color", "#f1f1f1")
                .set("width", "100%");

        add(content, footer);
        expand(content); // Vie kaiken muun tilan paitsi footerin
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        // Create the header view (assuming you have a HeaderView class)
        HeaderView header = new HeaderView();

        // Button to toggle dark mode
        Button darkModeButton = new Button("Toggle Dark Mode", event -> toggleDarkMode());

        // Create the navigation bar with RouterLinks
        HorizontalLayout navBar = new HorizontalLayout();
        navBar.add(createNavButton("Home", MainView.class));
        navBar.add(createNavButton("Auto Management", AutoManagementView.class));
        navBar.add(createNavButton("Service Management", ServiceManagementView.class));

        // Create the footer using FooterView class

        // Add components to the main view
        add(header, navBar, darkModeButton);
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.BETWEEN);  // Space out items: header at top, footer at bottom
    }

    private void toggleDarkMode() {
        if (UI.getCurrent().getElement().getThemeList().contains("dark")) {
            UI.getCurrent().getElement().getThemeList().remove("dark");
        } else {
            UI.getCurrent().getElement().getThemeList().add("dark");
        }
    }

    private RouterLink createNavButton(String text, Class<? extends Component> view) {
        return new RouterLink(text, view);
    }
}
