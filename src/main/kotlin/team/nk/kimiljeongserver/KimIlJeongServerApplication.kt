package team.nk.kimiljeongserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KimIlJeongServerApplication

fun main(args: Array<String>) {
	runApplication<KimIlJeongServerApplication>(*args)
}
