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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Process {
    @Id
    @CreatedBy
    private String id;
    private String name;
    private String items;
    private int point;
    private String departmentId;
    private String auth;
    private String student_attach;
    @ReadOnlyProperty
    private LocalDateTime insertTime;
    @ReadOnlyProperty
    private LocalDateTime updateTime;

}
