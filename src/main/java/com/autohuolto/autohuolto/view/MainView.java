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

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    private ResourceBundle bundle;

    public MainView() {
        updateTexts();

        VerticalLayout content = new VerticalLayout(new H1(bundle.getString("welcome")));
        content.setSizeFull();
        content.setAlignItems(Alignment.CENTER);
        content.setJustifyContentMode(JustifyContentMode.CENTER);

        // Footer
        Footer footer = new Footer(new Paragraph(bundle.getString("footer.text")));
        footer.getStyle().set("text-align", "center")
                .set("padding", "1em")
                .set("background-color", "#f1f1f1")
                .set("width", "100%");

        // Header
        HeaderView header = new HeaderView();

        // Dark mode toggle
        Button darkModeButton = new Button(bundle.getString("button.darkmode"), event -> toggleDarkMode());

        // Language switch buttons
        Button fiButton = new Button("Suomeksi", e -> switchLanguage(new Locale("fi")));
        Button enButton = new Button("In English", e -> switchLanguage(Locale.ENGLISH));

        HorizontalLayout languageBar = new HorizontalLayout(fiButton, enButton);

        // Navigation bar
        HorizontalLayout navBar = new HorizontalLayout();
        navBar.add(createNavButton(bundle.getString("nav.home"), MainView.class));
        navBar.add(createNavButton(bundle.getString("nav.cars"), AutoManagementView.class));
        navBar.add(createNavButton(bundle.getString("nav.services"), ServiceManagementView.class));

        // Add components
        add(header, navBar, darkModeButton, languageBar, content, footer);
        expand(content);

        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.BETWEEN);
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
    private String getTranslation(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return "!" + key; // Default value to indicate missing translation
        }
    }

    private void switchLanguage(Locale locale) {
        UI.getCurrent().setLocale(locale);
        updateTexts(); // Päivitä tekstit sen mukaan, mikä kieli on valittu
    }

    private void updateTexts() {
        Locale currentLocale = UI.getCurrent() != null && UI.getCurrent().getLocale() != null
                ? UI.getCurrent().getLocale()
                : Locale.ENGLISH; // Default fallback
        bundle = ResourceBundle.getBundle("messages", currentLocale);
    }

}
