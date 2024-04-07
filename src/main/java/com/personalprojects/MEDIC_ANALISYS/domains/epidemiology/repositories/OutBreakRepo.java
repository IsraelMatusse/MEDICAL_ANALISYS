package com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.repositories;

import com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.models.OutBreak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutBreakRepo extends JpaRepository<OutBreak, String> {
}
