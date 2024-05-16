package com.example.restservice.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Run(
    @Id
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime start,
    LocalDateTime completed,
    @Positive
    Integer miles,
    String location,
    @Version
    Integer version
) {}
