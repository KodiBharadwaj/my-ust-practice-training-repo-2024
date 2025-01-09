package com.example.demo.dto;

import java.time.LocalDate;

public record TaskDto(int id, String username, String description, LocalDate date, String status) {
}
