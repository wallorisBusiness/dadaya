package com.mohmolloris.dadaya.controller;

import com.mohmolloris.dadaya.dto.UserWithBigPinus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ArrayList<String> getUser() {
        return new ArrayList<String>() {{
            add("Hello");
            add("World");
        }};
    }

    @GetMapping("/{userId}")
    public String getUserBYid(@PathVariable("userId") int userIdPidora) {
        return "Pidor nomer " + userIdPidora;
    }

    @GetMapping("/byIdFromHeader")
    public String getUserByIdFromHeader(@RequestHeader("userId") int userIdPidora) {
        return "Pidor nomer " + userIdPidora;
    }

    @GetMapping("/byParam")
    public String getUserByParam(@RequestParam int userId){
        return "Pidor nomer " + userId;
    }

    @PostMapping("/id")
    public String postIdForSearchUser(@RequestBody String id){
        return id;
    }

    @PostMapping(value = "/byJson",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserWithBigPinus postUserByJson(@RequestBody UserWithBigPinus user){
        return user;
    }
}
