package com.my.spring.demo.springdemo.service;

import com.my.spring.demo.springdemo.dto.TestDto;

import java.util.List;

public interface TestService {

    List<TestDto> getAllTest();

    TestDto getTestById(Long testId);

    TestDto saveTest(TestDto test);

    TestDto updateTest(Long testId, TestDto test);

    Boolean deleteTestById(Long testId);
}
