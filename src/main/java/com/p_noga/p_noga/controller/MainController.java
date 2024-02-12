package com.p_noga.p_noga.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/hello")
    @ApiOperation(
            value = "api 메서드의 이름? 같은거 쓰는 란~"
            , notes = "메서드의 구체적인 내용~ 설명~"
    )
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "id"
                            , value = "자격증 아이디"
                            , required = true
                            , dataType = "string"
                            , paramType = "path" //PathVariable 일때
                            , defaultValue = "None"
                    )
                    ,
                    @ApiImplicitParam(
                            name = "fields"
                            , value = "응답 필드 종류"
                            , required = false
                            , dataType = "string"
                            , paramType = "query" // RequestParam일때
                            , defaultValue = ""
                    )
            })
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공입니다.")
            , @ApiResponse(code = 400, message = "접근이 올바르지 않습니다.")
    })
    // 추가적인 swagger 사용 법 https://velog.io/@gillog/Swagger-UI-Annotation-%EC%84%A4%EB%AA%85
    public String hello(){
        return "Heeeeellllllooooooo";
    }
}

