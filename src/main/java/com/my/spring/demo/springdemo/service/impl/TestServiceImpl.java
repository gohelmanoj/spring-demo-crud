package com.my.spring.demo.springdemo.service.impl;

import com.my.spring.demo.springdemo.dto.TestDto;
import com.my.spring.demo.springdemo.entity.Test;
import com.my.spring.demo.springdemo.exception.EmailAlreadyExistException;
import com.my.spring.demo.springdemo.exception.ResourceNotFoundException;
import com.my.spring.demo.springdemo.repository.TestRepository;
import com.my.spring.demo.springdemo.service.TestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;

    private ModelMapper modelMapper;

    @Override
    public List<TestDto> getAllTest() {

        List<Test> tests = testRepository.findAll();

        return tests.stream().map(test -> (modelMapper.map(test, TestDto.class))).collect(Collectors.toList());
    }

    @Override
    public TestDto getTestById(Long testId) {

        Test test = testRepository.findById(testId).orElseThrow(
                () -> new ResourceNotFoundException("Test", "id", testId)
        );

        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public TestDto saveTest(TestDto testDto) {

        Optional<Test> optionalTest = testRepository.findByEmail(testDto.getEmail());
        if (optionalTest.isPresent()) {
            throw new EmailAlreadyExistException(testDto.getEmail());
        }

        Test test = modelMapper.map(testDto, Test.class);

        Test savedTest = testRepository.save(test);

        return modelMapper.map(savedTest, TestDto.class);
    }

    @Override
    public TestDto updateTest(Long testId, TestDto test) {

        Test tempTest = testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", "id", testId));

        tempTest.setEmail(test.getEmail());
        tempTest.setFirstName(test.getFirstName());
        tempTest.setLastName(test.getLastName());
        tempTest.setPhone(test.getPhone());

        Test savedTest = testRepository.save(tempTest);
        return  modelMapper.map(savedTest, TestDto.class);
    }

    @Override
    public Boolean deleteTestById(Long testId) {

        Test tempTest = testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", "id", testId));
        if (tempTest != null) {
            testRepository.delete(tempTest);
            return true;
        }
        return false;
    }

}
