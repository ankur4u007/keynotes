package ank.mvcspring.web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class HelloController {

    @GetMapping("/")
    @ResponseBody
    fun getHello(): String {
        blocking()
        return "hello"
    }

    fun blocking() {
        Thread.sleep(4000)
    }
}