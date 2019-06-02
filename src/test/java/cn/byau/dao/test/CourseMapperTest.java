package cn.byau.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.byau.dao.CourseMapper;
import cn.byau.pojo.Course;
/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)

/** 声明spring主配置文件位置，注意：以当前测试类的位置为基准,有多个配置文件以字符数组声明 **/
@ContextConfiguration(locations={"classpath:config/spring-core.xml","classpath:config/spring-tx.xml"})

/** 声明使用事务，不声明spring会使用默认事务管理 **/
@Transactional

/** 声明事务回滚，要不删除一个数据就没有了，注意：插入数据时可注掉，不让事务回滚 **/
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class CourseMapperTest {
	@Autowired
	private CourseMapper courseDao;
	@Test
	
	public void testSave() {
	  Course course=new Course("1040","java40","10","5","90","课程介绍1");
      int x=courseDao.save(course);
      assertEquals(1, x);
	}

	@Test
	public void testGetById() {
		Course course=courseDao.getById("1010");
		assertNotNull(course);
	}

	@Test
	public void testUpdate() {
		 Course course=new Course("1040","java40","10","6","90","课程介绍1");
	      int x=courseDao.update(course);
	      assertEquals(1, x);
	}

	

	@Test
	public void testListByPage() {
		List<Course> result =courseDao.listByPage("10");
		int size = result.size();
		Assert.assertNotSame(0, size);
	}

	@Test
	public void testList() {
		List<Course> result = courseDao.list();
		int size = result.size();
		Assert.assertNotSame(0, size);
	}

	@Test
	public void testInsertBatch() {
		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course("1090", "java1", "10", "5", "90", "课程介绍1"));
		courseList.add(new Course("1091", "java1", "10", "5", "90", "课程介绍1"));
		int x = courseDao.insertBatch(courseList);
		assertEquals(2, x);
	}

	

}
