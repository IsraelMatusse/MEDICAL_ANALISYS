package com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.RegionalZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalZoneRepo extends JpaRepository<RegionalZone, Long> {

}
