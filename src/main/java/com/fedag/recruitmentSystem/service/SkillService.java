package com.fedag.recruitmentSystem.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillService<T, R> extends AbstractServiceInterface<T, R> {

  List<T> getAllSkills();

  Page<T> getAllSkills(Pageable pageable);
}
