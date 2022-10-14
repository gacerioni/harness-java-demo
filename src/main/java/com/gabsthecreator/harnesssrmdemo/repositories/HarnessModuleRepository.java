package com.gabsthecreator.harnesssrmdemo.repositories;

import com.gabsthecreator.harnesssrmdemo.models.HarnessModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HarnessModuleRepository extends JpaRepository<HarnessModuleModel, UUID> {

    boolean existsByShortName(String shortName);


    @Query("SELECT s FROM HarnessModuleModel s WHERE s.shortName = ?1")
    Optional<HarnessModuleModel> findByShortName(String shortName);

    @Modifying
    @Query("DELETE FROM HarnessModuleModel s WHERE s.shortName = ?1")
    void deleteByShortName(String shortName);
    @Modifying
    @Query("UPDATE FROM HarnessModuleModel s SET s.imagePath = ?2, s.url = ?3, s.description = ?4 WHERE s.shortName = ?1")
    void saveByShortName(String shortName, String imagePath, String url, String description);
}
