package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}

//@Bean으로 등록한 component 가 하나도 없다

/*
컴포넌트 스캔 대상
@Component
@Controller
@Service
@Repository
@Configuration

애노테이션은 상속관계가 없다. 스프링이 지원하는 것
 */