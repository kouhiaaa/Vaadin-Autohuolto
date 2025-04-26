package com.autohuolto.autohuolto.view;
import com.vaadin.flow.component.html.H1;

import com.autohuolto.autohuolto.model.Auto;
import com.autohuolto.autohuolto.service.AutoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "autot", layout = MainLayout.class)
public class AutoView extends VerticalLayout {



    private final AutoService autoService;

    private Grid<Auto> grid = new Grid<>(Auto.class);
    private TextField rekisterinumeroField = new TextField("Rekisterinumero");
    private TextField merkkiField = new TextField("Merkki");
    private TextField malliField = new TextField("Malli");
    private Button saveButton = new Button("Tallenna");

    @Autowired
    public AutoView(AutoService autoService) {
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
        this.autoService = autoService;

        add(new H1("Autorekisteri"));

        configureGrid();
        configureForm();

        updateList();
    }

    private void configureGrid() {
        grid.setColumns("rekisterinumero", "merkki", "malli");
        add(grid);
    }

    private void configureForm() {
        saveButton.addClickListener(e -> saveAuto());

        HorizontalLayout form = new HorizontalLayout(rekisterinumeroField, merkkiField, malliField, saveButton);
        add(form);
    }

    private void saveAuto() {
        if (!rekisterinumeroField.isEmpty() && !merkkiField.isEmpty() && !malliField.isEmpty()) {
            Auto auto = new Auto();
            auto.setRekisterinumero(rekisterinumeroField.getValue());
            auto.setMerkki(merkkiField.getValue());
            auto.setMalli(malliField.getValue());

            autoService.save(auto);
            updateList();

            rekisterinumeroField.clear();
            merkkiField.clear();
            malliField.clear();
        }
    }

    private void updateList() {
        grid.setItems(autoService.findAll());
    }
}