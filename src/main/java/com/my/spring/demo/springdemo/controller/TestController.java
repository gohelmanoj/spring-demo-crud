package com.my.spring.demo.springdemo.controller;

import com.my.spring.demo.springdemo.dto.TestDto;
import com.my.spring.demo.springdemo.service.TestService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    private TestService testService;

    @GetMapping
    public ResponseEntity<List<TestDto>> getAllTest() {

        return ResponseEntity.ok(testService.getAllTest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDto> getTestById(@PathVariable("id") Long testId) {

        TestDto test = testService.getTestById(testId);
        return ResponseEntity.ok(test);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestById(@PathVariable("id") Long testId) {

        if(testService.deleteTestById(testId)) {
            return ResponseEntity.ok("Test Deleted Successfully ..!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TestDto> createTest(@RequestBody @Valid TestDto test) {

        return ResponseEntity.ok(testService.saveTest(test));
    }

    @PutMapping
    public ResponseEntity<TestDto> updateTest(@RequestParam("id") Long testId, @RequestBody @Valid TestDto test) {

        TestDto tempTest = testService.updateTest(testId, test);
        return ResponseEntity.ok(tempTest);
    }

}
