package com.gabsthecreator.harnesssrmdemo.services;

import com.gabsthecreator.harnesssrmdemo.models.HarnessModuleModel;
import com.gabsthecreator.harnesssrmdemo.repositories.HarnessModuleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HarnessModuleService {

    final HarnessModuleRepository harnessModuleRepository;

    public HarnessModuleService(HarnessModuleRepository harnessModuleRepository){
        this.harnessModuleRepository = harnessModuleRepository;
    }

    @Transactional
    public HarnessModuleModel save(HarnessModuleModel harnessModuleModel) {
        return harnessModuleRepository.save(harnessModuleModel);
    }

    public boolean existsByShortName(String shortName) {
        return harnessModuleRepository.existsByShortName(shortName);
    }

    public List<HarnessModuleModel> findAll() {
        return harnessModuleRepository.findAll();
    }

    public Optional<HarnessModuleModel> findById(UUID id) {
        return harnessModuleRepository.findById(id);
    }

    public Optional<HarnessModuleModel> findByShortName(String shortName) {
        return harnessModuleRepository.findByShortName(shortName);
    }
    @Transactional
    public void delete(HarnessModuleModel harnessModuleModel) {
        harnessModuleRepository.deleteByShortName(harnessModuleModel.getShortName());
    }

    @Transactional
    public void saveByShortName(HarnessModuleModel harnessModuleModel) {
        harnessModuleRepository.saveByShortName(harnessModuleModel.getShortName(), harnessModuleModel.getImagePath(), harnessModuleModel.getUrl(), harnessModuleModel.getDescription());
    }
}
