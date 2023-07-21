package com.excelupdater.service;

import com.excelupdater.entity.Substance;
import java.util.List;

public interface SubstanceService {

    List<Substance> getAllSubstances();
    Substance saveSubstance(Substance substance);
    Substance getSubstanceById(Long id);
    Substance updateSubstance(Substance substance);
    void deleteSubstanceById(Long id);

}
