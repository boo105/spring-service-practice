package webservice.springservicepractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class SpringServicePracticeApplication

fun main(args: Array<String>) {
	runApplication<SpringServicePracticeApplication>(*args)
}
