package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "service-management", layout = MainLayout.class)
public class ServiceManagementView extends VerticalLayout {

    public ServiceManagementView() {
        Button viewServicesButton = new Button("Näytä Huollot", e ->
                getUI().ifPresent(ui -> ui.navigate("service-grid"))); // Create this view later

        add(viewServicesButton);
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
    }
}
