package org.example.graduationprojectprocessmanagement.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessScore {
    @Id
    @CreatedBy
    private String id;
    private String studentId;
    private String processId;
    private String teacherId;
    private String detail;
    @ReadOnlyProperty
    private LocalDateTime insertTime;
    @ReadOnlyProperty
    private LocalDateTime updateTime;
}
