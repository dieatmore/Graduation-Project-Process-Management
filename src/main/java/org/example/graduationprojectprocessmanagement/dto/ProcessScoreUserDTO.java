package org.example.graduationprojectprocessmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessScoreUserDTO {
    private String id;
    private String name;
    private String number;
    private String student_id;
    private String process_id;
    private String teacher_id;
    private String detail;
}
