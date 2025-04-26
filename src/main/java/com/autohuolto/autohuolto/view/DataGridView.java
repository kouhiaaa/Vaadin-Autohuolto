package com.autohuolto.autohuolto.view;
import com.autohuolto.autohuolto.model.Auto;
import com.autohuolto.autohuolto.service.AutoService;
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
import java.util.List;

@Route(value = "auto-grid", layout = MainLayout.class)// Access at http://localhost:8080/auto-grid
public class DataGridView extends VerticalLayout {

    private final AutoService autoService;
    private final Grid<Auto> grid = new Grid<>(Auto.class);
    private List<Auto> allAutot;

    @Autowired
    public DataGridView(AutoService autoService) {
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
        initializeUI();
    }

    private void initializeUI() {
        try {
            add(createAddAutoButton());

            // 1. Get data from service
            allAutot = autoService.findAll();
            if (allAutot == null || allAutot.isEmpty()) {
                add(new Paragraph("Ei autoja saatavilla"));
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
        grid.addColumn(Auto::getRekisterinumero)
                .setHeader("Rekisterinumero")
                .setSortable(true)
                .setResizable(true);

        grid.addComponentColumn(auto -> {
            Button editButton = new Button("Muokkaa");
            editButton.addClickListener(e -> openEditDialog(auto));
            return editButton;
        }).setHeader("Toiminnot");
        grid.addColumn(Auto::getMerkki)
                .setHeader("Merkki")
                .setSortable(true);

        grid.addColumn(Auto::getVuosi)
                .setHeader("Valmistusvuosi")
                .setSortable(true);
        grid.addColumn(Auto::getMalli)
                .setHeader("Malli")
                .setSortable(true);
        grid.setItems(allAutot);
        grid.setAllRowsVisible(true);
        grid.addComponentColumn(auto -> {
            Button deleteButton = new Button("Poista");
            deleteButton.getElement().getThemeList().add("error");
            deleteButton.addClickListener(click -> {
                autoService.delete(auto.getId()); // oletetaan että Auto:lla on getId()
                allAutot = autoService.findAll(); // päivitetään lista
                grid.setItems(allAutot); // päivitetään gridi
            });
            return deleteButton;
            
            
        }).setHeader("Toiminnot");
    }

    private void openEditDialog(Auto auto) {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Muokkaa autoa");

        TextField rekisterinumero = new TextField("Rekisterinumero");
        rekisterinumero.setValue(auto.getRekisterinumero());

        TextField merkki = new TextField("Merkki");
        merkki.setValue(auto.getMerkki());

        TextField malli = new TextField("Malli");
        malli.setValue(auto.getMalli());

        TextField vuosi = new TextField("Valmistusvuosi");
        vuosi.setValue(String.valueOf(auto.getVuosi()));

        Button save = new Button("Tallenna", event -> {
            auto.setRekisterinumero(rekisterinumero.getValue());
            auto.setMerkki(merkki.getValue());
            auto.setMalli(malli.getValue());
            auto.setVuosi(Integer.parseInt(vuosi.getValue()));

            autoService.save(auto);
            grid.setItems(autoService.findAll());
            dialog.close();
        });

        Button cancel = new Button("Peruuta", e -> dialog.close());

        dialog.getFooter().add(save, cancel);

        dialog.add(new VerticalLayout(rekisterinumero, merkki, malli, vuosi));
        dialog.open();
    }

    private Button createAddAutoButton() {
        Button addButton = new Button("Lisää auto", e -> openAddAutoDialog());
        return addButton;
    }

    private void openAddAutoDialog() {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Lisää uusi auto");

        TextField rekisterinumero = new TextField("Rekisterinumero");
        TextField merkki = new TextField("Merkki");
        TextField malli = new TextField("Malli");
        TextField vuosi = new TextField("Valmistusvuosi");

        FormLayout formLayout = new FormLayout(rekisterinumero, merkki, malli, vuosi);
        dialog.add(formLayout);

        Button saveButton = new Button("Tallenna", event -> {
            try {
                Auto auto = new Auto();
                auto.setRekisterinumero(rekisterinumero.getValue());
                auto.setMerkki(merkki.getValue());
                auto.setMalli(malli.getValue());
                auto.setVuosi(Integer.parseInt(vuosi.getValue()));

                autoService.save(auto); // save to DB
                allAutot = autoService.findAll(); // reload list
                grid.setItems(allAutot); // refresh grid

                Notification.show("Auto lisätty!");
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
        filterField.setPlaceholder("Suodata rekisterinumeroa...");
        filterField.setWidth("50%");
        filterField.setClearButtonVisible(true);

        filterField.addValueChangeListener(e -> {
            String filterText = e.getValue().toLowerCase();
            grid.setItems(allAutot.stream()
                    .filter(auto -> auto.getRekisterinumero().toLowerCase().contains(filterText))
                    .toList());
        });

        return filterField;
    }
}