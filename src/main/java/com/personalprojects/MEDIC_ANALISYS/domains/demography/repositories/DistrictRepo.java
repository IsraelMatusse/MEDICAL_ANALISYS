package com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories;


import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.District;
import com.personalprojects.MEDIC_ANALISYS.domains.demography.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {

    Optional<District> findByCode(String code);
    List<District>findByProvince(Province province);
    Optional<District>findByProvinceAndCode(Province province, String code);

    List<District>findByIdIn(List<Long>ids);

}