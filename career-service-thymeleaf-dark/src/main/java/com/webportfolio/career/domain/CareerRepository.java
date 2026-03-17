package com.webportfolio.career.domain;

import java.util.List;

public interface CareerRepository {
    List<Career> findAll();
}
