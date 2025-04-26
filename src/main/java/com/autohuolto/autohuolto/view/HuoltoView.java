package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.html.H1;
import com.autohuolto.autohuolto.model.Huolto;
import com.autohuolto.autohuolto.service.HuoltoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Route(value = "service-grid", layout = MainLayout.class)
public class HuoltoView extends VerticalLayout {


    private final HuoltoService huoltoService;

    private Grid<Huolto> grid = new Grid<>(Huolto.class);
    private TextField huoltopaivaField = new TextField("Huoltopäivämäärä");
    private TextField kuvausField = new TextField("Kuvaus");
    private TextField hintaField = new TextField("Hinta");
    private Button saveButton = new Button("Tallenna");

    @Autowired
    public HuoltoView(HuoltoService huoltoService) {
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
        this.huoltoService = huoltoService;

        add(new H1("Huoltorekisteri"));

        configureGrid();
        configureForm();

        updateList();
    }

    private void configureGrid() {
        grid.setColumns("huoltopaiva", "kuvaus", "hinta");
        add(grid);
    }

    private void configureForm() {
        saveButton.addClickListener(e -> saveHuolto());

        HorizontalLayout form = new HorizontalLayout(huoltopaivaField, kuvausField, hintaField, saveButton);
        add(form);
    }

    private void saveHuolto() {
        if (!huoltopaivaField.isEmpty() && !kuvausField.isEmpty() && !hintaField.isEmpty()) {
            Huolto huolto = new Huolto();
            huolto.setHuoltopaiva(LocalDate.parse(huoltopaivaField.getValue()));
            huolto.setKuvaus(kuvausField.getValue());
            huolto.setHinta(Double.parseDouble(hintaField.getValue()));

            huoltoService.save(huolto);
            updateList();

            huoltopaivaField.clear();
            kuvausField.clear();
            hintaField.clear();
        }
    }

    private void updateList() {
        grid.setItems(huoltoService.findAll());
    }
}
