package org.example.graduationprojectprocessmanagement.dox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final String STUDENT = "uWq2";
    public static final String TEACHER = "bU3e";
    public static final String ADMIN = "Qe1p";

    @Id
    @CreatedBy
    private String id;
    private String name;
    private String number;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String departmentId;
    private String role;
    private String description;
    private Integer groupNumber;
    private String student;
    private String teacher;
    @ReadOnlyProperty
    private LocalDateTime insertTime;
    @ReadOnlyProperty
    private LocalDateTime updateTime;
}
