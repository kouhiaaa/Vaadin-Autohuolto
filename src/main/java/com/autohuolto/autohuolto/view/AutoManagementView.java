package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "auto-management", layout = MainLayout.class)

public class AutoManagementView extends VerticalLayout {

    public AutoManagementView() {
        setAlignItems(Alignment.CENTER);
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        // Your main page content
        VerticalLayout content = new VerticalLayout();
        content.setAlignItems(Alignment.CENTER);
        content.setJustifyContentMode(JustifyContentMode.CENTER);
        content.setWidthFull();
        content.setHeightFull();

        // Add your content and footer
        add(content, new FooterView());
        expand(content); // pushes the footer to the bottom
        Button viewAutosButton = new Button("Näytä Autot", e ->
                getUI().ifPresent(ui -> ui.navigate("auto-grid")));

        add(viewAutosButton);
        setAlignItems(Alignment.CENTER);
    }
}
