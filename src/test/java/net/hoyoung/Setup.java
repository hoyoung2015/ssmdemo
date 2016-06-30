package net.hoyoung;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application-context*.xml"})
public class Setup {
	@Resource
    protected ApplicationContext ctx;
    
    @Test
    public void test() {
        System.out.println("setup success");
    }
}
