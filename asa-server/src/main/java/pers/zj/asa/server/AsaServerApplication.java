package pers.zj.asa.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author asa
 * @since 1.0.1
 */
@SuppressWarnings("SpringComponentScan")
@SpringBootApplication(scanBasePackages = {
        "${asa.base-package}.framework",
        "${asa.base-package}.server",
        "${asa.base-package}.module"
    }
)
@Slf4j
public class AsaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsaServerApplication.class, args);
        log.info("========== 项目启动成功 ==========");
    }

}
