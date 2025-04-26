package com.autohuolto.autohuolto.view;

import com.autohuolto.autohuolto.model.Huolto;
import com.autohuolto.autohuolto.service.HuoltoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Route(value = "huolto-grid", layout = MainLayout.class) // Access at http://localhost:8080/huolto-grid
public class HuoltoGridView extends VerticalLayout {

    private final HuoltoService huoltoService;
    private final Grid<Huolto> grid = new Grid<>(Huolto.class);
    private List<Huolto> allHuollot;

    @Autowired
    public HuoltoGridView(HuoltoService huoltoService) {
        this.huoltoService = huoltoService;
        initializeUI();
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

    private void initializeUI() {
        try {
            add(createAddHuoltoButton());

            // 1. Get data from service
            allHuollot = huoltoService.findAll();
            if (allHuollot == null || allHuollot.isEmpty()) {
                add(new Paragraph("Ei huoltoja saatavilla"));
                return;
            }

            // 2. Configure grid
            configureGrid();

            // 3. Create and add filter
            add(createFilterField(), grid);
            setSizeFull();

        } catch (Exception e) {
            add(new Paragraph("Virhe datan haussa: " + e.getMessage()));
        }
    }

    private void configureGrid() {
        grid.removeAllColumns(); // Clear auto-generated columns

        // Add custom columns
        grid.addColumn(Huolto::getHuoltopaiva)
                .setHeader("Huoltopäivämäärä")
                .setSortable(true)
                .setResizable(true);

        grid.addComponentColumn(huolto -> {
            Button editButton = new Button("Muokkaa");
            editButton.addClickListener(e -> openEditDialog(huolto));
            return editButton;
        }).setHeader("Toiminnot");

        grid.addColumn(Huolto::getKuvaus)
                .setHeader("Kuvaus")
                .setSortable(true);

        grid.addColumn(Huolto::getHinta)
                .setHeader("Hinta")
                .setSortable(true);

        grid.setItems(allHuollot);
        grid.setAllRowsVisible(true);

        grid.addComponentColumn(huolto -> {
            Button deleteButton = new Button("Poista");
            deleteButton.getElement().getThemeList().add("error");
            deleteButton.addClickListener(click -> {
                huoltoService.delete(huolto.getId());
                allHuollot = huoltoService.findAll(); // päivitämme listan
                grid.setItems(allHuollot); // päivitämme gridi
            });
            return deleteButton;
        }).setHeader("Toiminnot");
    }

    private void openEditDialog(Huolto huolto) {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Muokkaa huoltoa");

        TextField huoltopaiva = new TextField("Huoltopäivämäärä");
        huoltopaiva.setValue(String.valueOf(huolto.getHuoltopaiva()));

        TextField kuvaus = new TextField("Kuvaus");
        kuvaus.setValue(huolto.getKuvaus());

        TextField hinta = new TextField("Hinta");
        hinta.setValue(String.valueOf(huolto.getHinta()));

        Button save = new Button("Tallenna", event -> {
            huolto.setHuoltopaiva(LocalDate.parse(huoltopaiva.getValue()));
            huolto.setKuvaus(kuvaus.getValue());
            huolto.setHinta(Double.parseDouble(hinta.getValue()));

            huoltoService.save(huolto);
            grid.setItems(huoltoService.findAll());
            dialog.close();
        });

        Button cancel = new Button("Peruuta", e -> dialog.close());

        dialog.getFooter().add(save, cancel);

        dialog.add(new VerticalLayout(huoltopaiva, kuvaus, hinta));
        dialog.open();
    }

    private Button createAddHuoltoButton() {
        Button addButton = new Button("Lisää huolto", e -> openAddHuoltoDialog());
        return addButton;
    }

    private void openAddHuoltoDialog() {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Lisää uusi huolto");

        TextField huoltopaiva = new TextField("Huoltopäivämäärä");
        TextField kuvaus = new TextField("Kuvaus");
        TextField hinta = new TextField("Hinta");

        FormLayout formLayout = new FormLayout(huoltopaiva, kuvaus, hinta);
        dialog.add(formLayout);

        Button saveButton = new Button("Tallenna", event -> {
            try {
                Huolto huolto = new Huolto();
                huolto.setHuoltopaiva(LocalDate.parse(huoltopaiva.getValue()));
                huolto.setKuvaus(kuvaus.getValue());
                huolto.setHinta(Double.parseDouble(hinta.getValue()));

                huoltoService.save(huolto);
                allHuollot = huoltoService.findAll();
                grid.setItems(allHuollot);

                Notification.show("Huolto lisätty!");
                dialog.close();
            } catch (Exception ex) {
                Notification.show("Virhe tallennuksessa: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        Button cancelButton = new Button("Peruuta", event -> dialog.close());

        dialog.getFooter().add(cancelButton, saveButton);
        dialog.open();
    }

    private TextField createFilterField() {
        TextField filterField = new TextField();
        filterField.setPlaceholder("Suodata huoltopäivämäärää...");
        filterField.setWidth("50%");
        filterField.setClearButtonVisible(true);

        filterField.addValueChangeListener(e -> {
            String filterText = e.getValue().toLowerCase();
            grid.setItems(allHuollot.stream()
                    .filter(huolto -> huolto.getKuvaus().toLowerCase().contains(filterText))
                    .toList());
        });

        return filterField;
    }
}
