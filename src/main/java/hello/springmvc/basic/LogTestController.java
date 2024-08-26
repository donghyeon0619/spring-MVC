package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(LogTestController.class); 아래랑 같은 코드
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        // 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 로그를 쓸 떄 이런 방식으로는 절대 사용하면 안됨
        log.debug("String concat log=" + name);
        return "ok";
    }
}
