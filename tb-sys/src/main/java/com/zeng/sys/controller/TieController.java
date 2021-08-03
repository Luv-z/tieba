package com.zeng.sys.controller;

import com.api.service.RedisService;
import com.zeng.sys.entity.Tie;
import com.zeng.sys.pojo.ResultVo;
import com.zeng.sys.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@RestController
public class TieController {

    @Autowired
    private TieService tieService;

    @Resource
    private RedisService redisService;

    /**
     * 发帖
     * @param tieTopic
     * @param tieContent
     * @param token
     * @return
     */
    @RequestMapping("/tie/publishTie")
    public ResultVo publishTie(@RequestParam("tieTopic") String tieTopic,
                               @RequestParam("tieContent") String tieContent,
                               @RequestHeader("Authorization") String token){
        ResultVo resultVo;
        Tie tie = new Tie();
        tie.setTieTopic(tieTopic);
        tie.setTieContent(tieContent);
        tie.setCreatorId(redisService.getToken(token));
        tie.setLikeNum(0);
        tie.setCreateTime(new Timestamp(new Date().getTime()));
        tie = tieService.publishNewTie(tie);
        if(tie != null){
            resultVo = new ResultVo("200", "发帖成功", tie);
        }
        else{
            resultVo = new ResultVo("400", "发帖失败");
        }
        return resultVo;
    }


}
