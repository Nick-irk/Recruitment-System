package com.fedag.recruitmentSystem.repository;

import com.fedag.recruitmentSystem.model.Vacancy;
import com.fedag.recruitmentSystem.repository.criteria.VacancyCriteriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long>, VacancyCriteriaRepository {

}
