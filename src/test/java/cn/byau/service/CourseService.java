package cn.byau.service;

import cn.byau.dao.CourseMapper;
import cn.byau.pojo.Course;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tjh on 2017/5/13.
 */
@Service("CourseService")
public class CourseService {

	@Autowired
	private CourseMapper courseDao;

//	public int pageCount(String courseId) {
//		int rowCount = courseDao.count(courseId);
//		int count = 0;
//		if (rowCount % 5 == 0) {
//			count = rowCount / 5;
//		} else {
//			count = rowCount / 5 + 1;
//		}
//		return count;
//	}

	public List<Course> listByPage(String courseId) {
		return courseDao.listByPage(courseId);
	}

	public void save(Course course) {
		courseDao.save(course);
	}

	public Course getById(String courseId) {
		return courseDao.getById(courseId);
	}

	public void update(Course course) {
		courseDao.update(course);
	}

	

	public void deleteBatch(String ids[]) {
		courseDao.deleteBatch(ids);
	}

	public void importFile(MultipartFile mFile, String rootPath) {
		List<Course> courseList = new ArrayList<Course>();

		String fileName = mFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		String ym = new SimpleDateFormat("yyyy-MM").format(new Date());
		String filePath = ym + fileName;
		// System.out.println(rootPath+filePath);
		try {
			File file = new File(rootPath + filePath);
			mFile.transferTo(file);
			courseList = importXls(file);
			courseDao.insertBatch(courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Course> importXls(File file) {
		List<Course> courseList = new ArrayList<Course>();

		InputStream is = null;
		HSSFWorkbook hWorkbook = null;
		try {
			is = new FileInputStream(file);
			hWorkbook = new HSSFWorkbook(is);
			HSSFSheet hSheet = hWorkbook.getSheetAt(0);

			if (null != hSheet) {
				for (int i = 1; i < hSheet.getPhysicalNumberOfRows(); i++) {
					Course course = new Course();
					HSSFRow hRow = hSheet.getRow(i);
					course.setCourseId(hRow.getCell(0).toString());
					course.setCourseName(hRow.getCell(1).toString());
					course.setCourseKindId(hRow.getCell(2).toString());
					course.setCourseScore(hRow.getCell(3).toString());
					course.setCourseHour(hRow.getCell(4).toString());
					course.setCourseRemark(hRow.getCell(5).toString());

					courseList.add(course);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (null != hWorkbook) {
				try {
					hWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return courseList;
	}

	public void exportFile(HttpServletResponse response) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		OutputStream os = null;
		XSSFWorkbook xWorkbook = null;
		try {
			String fileName = "course" + df.format(new Date()) + ".xlsx";

			os = response.getOutputStream();
			response.reset();

			response.setHeader("Content-disposition", "attachment; filename = " + URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/octet-streem");

			xWorkbook = new XSSFWorkbook();
			XSSFSheet xSheet = xWorkbook.createSheet("courseList");

			// set Sheet页头部
			setSheetHeader(xWorkbook, xSheet);

			// set Sheet页内容
			setSheetContent(xWorkbook, xSheet);

			xWorkbook.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (null != xWorkbook) {
				try {
					xWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * set Sheet页头部
	 * 
	 * @param xWorkbook
	 * @param xSheet
	 */
	private void setSheetHeader(XSSFWorkbook xWorkbook, XSSFSheet xSheet) {
		xSheet.setColumnWidth(0, 10 * 256);
		xSheet.setColumnWidth(1, 10 * 256);
		xSheet.setColumnWidth(2, 10 * 256);
		xSheet.setColumnWidth(3, 10 * 256);
		xSheet.setColumnWidth(4, 10 * 256);
		xSheet.setColumnWidth(5, 15 * 256);
		

		CellStyle cs = xWorkbook.createCellStyle();
		// 设置水平垂直居中
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 设置字体
		Font headerFont = xWorkbook.createFont();
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontName("宋体");
		cs.setFont(headerFont);
		cs.setWrapText(true);// 是否自动换行

		XSSFRow xRow0 = xSheet.createRow(0);

		XSSFCell xCell0 = xRow0.createCell(0);
		xCell0.setCellStyle(cs);
		xCell0.setCellValue("课程编号");

		XSSFCell xCell1 = xRow0.createCell(1);
		xCell1.setCellStyle(cs);
		xCell1.setCellValue("课程名称");

		XSSFCell xCell2 = xRow0.createCell(2);
		xCell2.setCellStyle(cs);
		xCell2.setCellValue("分类编号");
		
		XSSFCell xCell3 = xRow0.createCell(3);
		xCell3.setCellStyle(cs);
		xCell3.setCellValue("学分");
		
		XSSFCell xCell4 = xRow0.createCell(4);
		xCell4.setCellStyle(cs);
		xCell4.setCellValue("学时");
		
		XSSFCell xCell5 = xRow0.createCell(5);
		xCell5.setCellStyle(cs);
		xCell5.setCellValue("附加说明");
		
		
		
	}

	/**
	 * set Sheet页内容
	 * 
	 * @param xWorkbook
	 * @param xSheet
	 */
	private void setSheetContent(XSSFWorkbook xWorkbook, XSSFSheet xSheet) {
		List<Course> courseList = courseDao.list();
		CellStyle cs = xWorkbook.createCellStyle();
		cs.setWrapText(true);

		if (null != courseList && courseList.size() > 0) {
			for (int i = 0; i < courseList.size(); i++) {
				XSSFRow xRow = xSheet.createRow(i + 1);
				Course course = courseList.get(i);
				for (int j = 0; j < 6; j++) {
					XSSFCell xCell = xRow.createCell(j);
					xCell.setCellStyle(cs);
					switch (j) {
					case 0:
						xCell.setCellValue(course.getCourseId());
						break;
					case 1:
						xCell.setCellValue(course.getCourseName());
						break;
					case 2:
						xCell.setCellValue(course.getCourseKindId());
						break;
						
					case 3:
						xCell.setCellValue(course.getCourseScore());
						break;
					case 4:
						xCell.setCellValue(course.getCourseHour());
						break;
					case 5:
						xCell.setCellValue(course.getCourseRemark());
						break;
						
						
					default:
						break;
					}
				}
			}
		}
	}
}
