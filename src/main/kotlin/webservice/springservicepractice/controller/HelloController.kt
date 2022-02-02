package webservice.springservicepractice.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("hello")
    @ApiOperation(value = "hello index 페이지", notes = "hello spring return")
    fun hello(model : Model) : String {
        model.addAttribute("data", "spring!!")
        return "hello"
    }

    @GetMapping("hello-mvc")
    @ApiOperation(value = "hello mvc", notes = "hello name return")
    fun helloMvc(@RequestParam("name") name : String, model : Model) : String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ApiOperation(value = "hello string", notes = "hello name return")
    @ResponseBody
    fun helloString(name : String) : String = "Hello $name"

    @GetMapping("hello-api")
    @ApiOperation(value = "hello api", notes = "hello name return")
    @ApiResponses( value = [
        ApiResponse(code = 200, message = "ok"),
        ApiResponse(code = 404, message = "page not found!")
    ])
    @ResponseBody
    fun helloApi(@RequestParam("name") name : String) : Hello {
        val hello = Hello(name)
        
        return hello
    }

    class Hello(val name : String) {
         
    }
}