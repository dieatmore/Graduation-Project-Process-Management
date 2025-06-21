package org.example.graduationprojectprocessmanagement.dox;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @CreatedBy
    private String id;
    private String name;
    @ReadOnlyProperty
    private LocalDateTime insertTime;
    @ReadOnlyProperty
    private LocalDateTime updateTime;
}
