package sample.Localisation;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationManager {
        private static LocalizationManager instance;
        private ResourceBundle resourceBundle;

        private LocalizationManager() {
            // Загрузка ресурсов по умолчанию (английский язык)
            resourceBundle = ResourceBundle.getBundle("text");
        }

        public static LocalizationManager getInstance() {
            if (instance == null) {
                instance = new LocalizationManager();
            }
            return instance;
        }

        public void setLanguage(String language) {
            if (language.equals("Русский")) {
                resourceBundle = ResourceBundle.getBundle("text_ru_RU", new Locale("ru","RU"));
            }else if (language.equals("Чешский")) {
                resourceBundle = ResourceBundle.getBundle("text_cs_CZ", new Locale("cs","CZ"));
            } else if(language.equals("Греческий")){
                resourceBundle = ResourceBundle.getBundle("text_el_GR", new Locale("el","GR"));
            }else if(language.equals("Испанский")){
                resourceBundle = ResourceBundle.getBundle("text_es_ES", new Locale("es","ES"));
            }
        }

        public String getString(String key) {
            return resourceBundle.getString(key);
        }
    }
