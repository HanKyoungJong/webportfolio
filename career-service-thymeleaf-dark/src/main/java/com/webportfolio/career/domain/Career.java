package com.webportfolio.career.domain;

public record Career(
        Long id,
        String company,
        String position,
        String period,
        String summary
) {
}
