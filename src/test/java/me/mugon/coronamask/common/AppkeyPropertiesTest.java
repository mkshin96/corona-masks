package me.mugon.coronamask.common;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class AppkeyPropertiesTest {

    @Autowired
    private AppkeyProperties appkeyProperties;

    @Test
    @Disabled
    void appKey() {
        assertNotNull(appkeyProperties.getKey());
    }
}