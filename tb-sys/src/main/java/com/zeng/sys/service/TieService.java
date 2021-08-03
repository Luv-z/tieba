package com.zeng.sys.service;

import com.zeng.sys.entity.Tie;

public interface TieService {

    Tie getTieById(long tieId);

    Tie publishNewTie(Tie tie);

    boolean updateTieLikeNum(Tie tie);
}
