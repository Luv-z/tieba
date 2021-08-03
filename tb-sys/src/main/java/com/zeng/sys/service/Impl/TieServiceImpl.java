package com.zeng.sys.service.Impl;

import com.zeng.sys.entity.Tie;
import com.zeng.sys.mapper.TieMapper;
import com.zeng.sys.service.TieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TieServiceImpl implements TieService {

    @Autowired
    private TieMapper tieMapper;

    @Override
    public Tie getTieById(long tieId) {
        return tieMapper.getTieById(tieId);
    }

    @Override
    public Tie publishNewTie(Tie tie) {
        long tieId = tieMapper.publishNewTie(tie);
        tie.setTieId(tieId);
        return tie;
    }

    @Override
    public boolean updateTieLikeNum(Tie tie) {
        if(tieMapper.updateTieLikeNum(tie) == 1){
            return true;
        }
        return false;
    }
}
