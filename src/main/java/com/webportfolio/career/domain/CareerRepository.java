package com.webportfolio.career.domain;

import java.util.List;

public interface CareerRepository {
    java.util.List<Career> findAllOrderById();
    long count();
    Career save(Career career);
}
