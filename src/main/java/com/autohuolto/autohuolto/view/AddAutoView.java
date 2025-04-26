package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "add-auto", layout = MainLayout.class)


public class AddAutoView extends VerticalLayout {

    public AddAutoView() {
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
        // Fields for Auto details
        TextField rekisterinumeroField = new TextField("Rekisterinumero");
        TextField merkkiField = new TextField("Merkki");
        TextField malliField = new TextField("Malli");
        TextField vuosiField = new TextField("Vuosi");

        // Save button
        Button saveButton = new Button("Save Auto", e -> {
            // Save the new Auto (you'll need to implement this logic)
        });

        // Add fields and button to the layout
        add(rekisterinumeroField, merkkiField, malliField, vuosiField, saveButton);
        setAlignItems(Alignment.CENTER);
    }
}
