package cn.byau.dao;

import java.util.HashMap;
import java.util.List;

import cn.byau.pojo.LogInfo;

public interface LogInfoMapper {
        int save(LogInfo logInfo);

  
       List<LogInfo> list(HashMap hm);
}