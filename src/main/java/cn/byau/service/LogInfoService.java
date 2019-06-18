package cn.byau.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.byau.dao.LogInfoDAO;
import cn.byau.entity.LogInfo;

@Service("logInfoService")
@Transactional
public class LogInfoService {
	@Autowired
	private LogInfoDAO logInfoDAO;

	public void save(int userId) {
		Date date = new Date();
		String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		LogInfo logInfo = new LogInfo();
		logInfo.setUserId(userId + "");
		logInfo.setLoginTime(sDate);
		logInfoDAO.save(logInfo);
	}


	  
    /**
     *   这个方法中用到了分页插件pagehelper
     *   很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum 开始页数
     * @param pageSize 每页显示的数据条数
     * @param hm 封装了 查询的起始日期和截止额日期
     * @return
     */
	
	public PageInfo<LogInfo> listByPage(Integer pageNum, Integer pageSize,HashMap hm) {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<LogInfo> list = logInfoDAO.list(hm);
		PageInfo<LogInfo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
