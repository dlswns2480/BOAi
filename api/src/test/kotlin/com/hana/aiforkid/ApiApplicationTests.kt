package com.hana.aiforkid

import com.hana.aiforkid.support.TestContainerSupport
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = [TestContainerSupport::class])
class ApiApplicationTests {

    @Test
    fun contextLoads() {
    }

}
