package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/requestswagger")
    public String getRequestParamSwagger(@ApiParam(value = "이름", required = true) @RequestParam String name,
                                         @ApiParam(value = "이메일", required = true) @RequestParam String email,
                                         @ApiParam(value = "회사", required = true) @RequestParam String organization){
        return name + " " + email + " " + organization;
    }
}
