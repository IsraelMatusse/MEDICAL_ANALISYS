package com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Province;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.RegionalZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Long> {
    Optional<Province> findByRegionalZone(RegionalZone regionalZone);

    Optional<Province> findByCode(String code);

    List<Province>findByIdIn(List<Long>ids);
}
