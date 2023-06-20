package com.example.http;

import com.example.http.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BodyController {
//    // '/body' 로 요청이 들어왔을 때,
//    // ResponseDto 데이터를 표현한 JSON 응답을 반환하는 메소드
//    @PostMapping("/body")
//    // HTTP 응답의 Body 임을 나타내는 어노테이션
//    public @ResponseBody ResponseDto body(
//            @RequestBody ArticleDto requestDto
//    ) {
//        log.info(requestDto.toString());
//        ResponseDto response = new ResponseDto();
//        response.setStatus(200);
//        response.setMessage("success");
//        return response;
//    }

    // '/body' 로 ArticleDto를 표현한 JSON 과 함께
    // 요청일 들어왔을 때
    // ResponseDto 를 표현한 JSON 을 포함해 응답하는 메소드
    @PostMapping("/body")
//    @ResponseBody
    public ResponseDto body(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /body " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/body-2")
//    @ResponseBody
    public ResponseDto body2(
            @RequestBody
            WriterDto dto
    ){
        log.info("POST /body-2 " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/body-3")
//    @ResponseBody
    public ResponseDto body3(
            @RequestBody
            ArticleWithCommentsDto dto
    ){
        log.info("POST /body-3 " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/body-4")
//    @ResponseBody
    public ResponseDto body4(
            @RequestBody
            ArticleComplexDto dto
    ){
        log.info("POST /body-4 " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    // @ResponseBody 는 요청의 HTTP Body 만 설정
    // Header 를 추가하거나
    // Status code 를 고르고 싶을 때
    // ResponseEntity<T>
    @PostMapping("/entity")
//    @ResponseBody
    public ResponseEntity<ResponseDto> entity(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /entity " + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        // 1. 새 ResponseEntity 객체 생성
        // ResponseEntity 객체 그냥 쓰기
        ResponseEntity<ResponseDto> responseEntity
                = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
//        return responseEntity;

        // 커스텀 헤더 만들고 함께 응답하기
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-likelion-custom", "Hello World!");
//        return new ResponseEntity<>(
//                response, headers, HttpStatus.ACCEPTED
//        );

        // 빌더 패턴
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-likelion-one", "1")
                .headers(headers)
                .body(response);
    }
}
