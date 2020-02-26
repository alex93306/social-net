package org.mycompany.service;

import org.mycompany.entity.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LanguageServiceImpl implements LanguageService {
    @Override
    public List<Language> getAllLanguages() {
//        todo:
        Language language = new Language();
        language.setId(1L);
        language.setName("Русский");

        Language language2 = new Language();
        language2.setId(2L);
        language2.setName("English");

        return Arrays.asList(language, language2);
    }
}
