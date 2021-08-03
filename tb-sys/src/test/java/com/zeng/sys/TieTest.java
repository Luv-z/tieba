package com.zeng.sys;

import com.zeng.sys.entity.Tie;
import com.zeng.sys.service.TieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class TieTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TieService tieService;

    @Test
    public void publishTieTest(){
        Tie tie = new Tie();

        tie.setTieTopic("发帖测试");
        tie.setTieContent("第一次发帖");
        tie.setCreateTime(new Timestamp(new Date().getTime()));
        tie.setCreatorId("111111");
        tie.setLikeNum(0);
        tie = tieService.publishNewTie(tie);
        System.out.println(tie.getTieId());
    }
}
