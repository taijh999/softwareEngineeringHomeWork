package cn.byau.dao;

import java.util.HashMap;
import java.util.List;

import cn.byau.entity.LogInfo;

public interface LogInfoDAO {
        int save(LogInfo logInfo);

  
       List<LogInfo> list(HashMap hm);
}