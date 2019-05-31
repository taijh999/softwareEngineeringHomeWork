package cn.byau.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.byau.dao.LogInfoMapper;
import cn.byau.pojo.LogInfo;

@Service("logInfoService")
@Transactional
public class LogInfoService {
	@Autowired
	private LogInfoMapper logInfoMapper;

	public void save(int userId) {
		Date date = new Date();
		String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		LogInfo logInfo = new LogInfo();
		logInfo.setUserId(userId + "");
		logInfo.setLoginTime(sDate);
		logInfoMapper.save(logInfo);
	}

	public List<LogInfo> list(HashMap hm) {
		return logInfoMapper.list(hm);
	}

}
