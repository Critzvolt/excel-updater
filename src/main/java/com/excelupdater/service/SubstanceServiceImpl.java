package com.excelupdater.service;

import com.excelupdater.entity.Substance;
import com.excelupdater.repository.SubstanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstanceServiceImpl implements SubstanceService{

    private SubstanceRepository substanceRepository;

    public SubstanceServiceImpl(SubstanceRepository substanceRepository) {
        super();
        this.substanceRepository = substanceRepository;
    }

    @Override
    public List<Substance> getAllSubstances() {
        return substanceRepository.findAll();
    }

    @Override
    public Substance saveSubstance(Substance substance) {
        return substanceRepository.save(substance);
    }

    @Override
    public Substance getSubstanceById(Long id) {
        return substanceRepository.findById(id).get();
    }

    @Override
    public Substance updateSubstance(Substance substance) {
        return substanceRepository.save(substance);
    }

    @Override
    public void deleteSubstanceById(Long id) {
        substanceRepository.deleteById(id);
    }

}
