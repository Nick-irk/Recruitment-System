package com.fedag.recruitmentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {

    private Long id;
    private int score;
    private Long userId;
}