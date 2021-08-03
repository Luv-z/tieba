package com.zeng.sys.mapper;

import com.zeng.sys.entity.Tie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TieMapper {

    public Tie getTieById(@Param("tieId") long tieId);

    public long publishNewTie(@Param("tie") Tie tie);

    public int updateTieLikeNum(@Param("tie") Tie tie);
}
