package me.cd.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.languages.models.Language;
import me.cd.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language getById(Long id) {
        Optional<Language> language = languageRepository.findById(id);
        if (!language.isPresent()) {
            return null;
        }
        return language.get();
    }

    public Language save(Language language) {
        return languageRepository.save(language);
    }

    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }

    public Language update(Long id, Language newData) {
        Language l = getById(id);
        l.setName(newData.getName());
        l.setCreator(newData.getCreator());
        l.setVersion(newData.getVersion());
        return languageRepository.save(l);
    }
}
