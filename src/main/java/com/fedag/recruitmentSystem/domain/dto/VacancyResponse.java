package com.fedag.recruitmentSystem.domain.dto;

import com.fedag.recruitmentSystem.enums.ResumeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyResponse {

  private String header;
  private String description;
  private int salary;
  private String experience;
  private ResumeStatus status;
  private Long companyId;
}
