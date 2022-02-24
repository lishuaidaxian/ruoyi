package com.ruoyi.web.controller.tool;

import com.ruoyi.attendance.domain.BnHrAttendance;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.UtilException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.salary.domain.BnHrSalary;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel相关处理
 *
 * @author ruoyi
 */
public class ExcelUtils
{
    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel


    /**
     * 工作薄对象
     */
    private Workbook workBook;


    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * @Description：获取IO流中的数据，组装成List<List<Object>>对象
     * @param in,fileName
     * @return
     * @throws IOException
     */
    public static List<List<Object>> getListByExcel(InputStream in, String fileName) throws Exception{
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work = getWorkbook(in,fileName);
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;  //页数
        Row row = null;  //行数
        Cell cell = null;  //列数

        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){continue;}

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if(row==null||row.getFirstCellNum()==j){continue;}

                //遍历所有的列
                List<Object> li = new ArrayList<Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(getValue(cell));
                }
                list.add(li);
            }
        }

        return list;

    }

    /**
     * @Description：根据文件后缀，自适应上传文件的版本
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public static  Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }


    /**
     * 工资表导出
     * @param response
     */
    public static void exportSalaryExcel(HttpServletResponse response){
//        OutputStream out = null;
        XSSFWorkbook workBook = null;
        OutputStream output = null;
        try{
            File file = ResourceUtils.getFile("classpath:static/excel/salary.xlsx");
            InputStream inputStream = new FileInputStream(file);
            workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheetAt(0);
//            Sheet sheet2 = workBook.createSheet("sheet1");
//            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//
//
//
//// XSSFRow 代表一行数据
//
//                HSSFRow row = sheet.getRow(rowIndex);
//
//                if (row == null) {
//
//                    continue;
//
//                }
//
//                HSSFCell nameCell = row.getCell(0); // 姓名列
//
//                HSSFCell genderCell = row.getCell(1); // 性别列
//
//                HSSFCell ageCell = row.getCell(2); // 年龄列
//
//                HSSFCell weightCell = row.getCell(3); // 体重列
//
//                HSSFCell salaryCell = row.getCell(4); // 收入列
//
//
//
//                StringBuilder employeeInfoBuilder = new StringBuilder();
//
////            employeeInfoBuilder.append("员工信息 --> ")
////
////                    .append("姓名 : ").append(nameCell.getStringCellValue())
////
////                    .append(" , 性别 : ").append(genderCell.getRawValue())
////
////                    .append(" , 年龄 : ").append(ageCell.getRawValue())
////
////                    .append(" , 体重(千克) : ").append(weightCell.getRawValue())
////
////                    .append(" , 月收入(元) : ").append(salaryCell.getRawValue());
//
//
//
//                System.out.println(employeeInfoBuilder.toString());
//
//            }

            // ------ 创建一行新的数据 ----------//

// 指定行索引，创建一行数据, 行索引为当前最后一行的行索引 + 1

//            int currentLastRowIndex = sheet.getLastRowNum();
//
//            int newRowIndex = currentLastRowIndex + 1;
//
//            HSSFRow newRow = sheet.createRow(newRowIndex);
//
//// 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
//
//            int cellIndex = 0;
//
//// 创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
//
//            HSSFCell newNameCell = newRow.createCell(cellIndex++, CellType.STRING);
//
//            newNameCell.setCellValue("钱七");
//
//            HSSFCell newGenderCell = newRow.createCell(cellIndex++, CellType.STRING);
//
//            newGenderCell.setCellValue("女");
//
//            HSSFCell newAgeCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newAgeCell.setCellValue(50);
//
//            HSSFCell newWeightCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newWeightCell.setCellValue(68);
//
//            HSSFCell newSalaryCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newSalaryCell.setCellValue(6000);

//            out = new FileOutputStream(file);
//            workBook.write(out);
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("application/x-download");
//            String filedisplay = file.getName();
//            filedisplay = URLEncoder.encode(filedisplay, "utf-8");
//            response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
            output=response.getOutputStream();

            response.reset();

//设置响应头，

            response.setHeader("Content-disposition", "attachment; filename="+file.getName());

//            response.setHeader("Content-Length", inputStream.available()+""); // 内容长度
            response.setContentType("application/octet-stream"); // 响应内容格式

//            response.setContentType("application/msexcel");

            workBook.write(output);


//            inputStream.close();

            output.close();
//            return AjaxResult.success(file.getName().toString());


        }catch (Exception e){
            e.printStackTrace();
//            log.error("导出Excel异常{}", e.getMessage());
            throw new UtilException("导出Excel失败，请联系网站管理员！");
        }
        finally
        {
            IOUtils.closeQuietly(workBook);
            IOUtils.closeQuietly(output);
        }

    }


    /**
     * 工资表导出
     * @param response
     */
    public static void exportAttendanceExcel(HttpServletResponse response, List<BnHrAttendance> bnHrAttendances){
//        OutputStream out = null;
        XSSFWorkbook workBook = null;
        OutputStream output = null;
        try{
            //获取考勤月天数标识
            String sign = bnHrAttendances.get(0).getSign();
            String url = "classpath:static/excel/attendance.xlsx";
            if("1".equals(sign)){
                url = "classpath:static/excel/attendance28.xlsx";
            }else if("2".equals(sign)){
                url = "classpath:static/excel/attendance29.xlsx";
            }else if("3".equals(sign)){
                url = "classpath:static/excel/attendance30.xlsx";
            }else if("4".equals(sign)){
                url = "classpath:static/excel/attendance.xlsx";
            }
            File file = ResourceUtils.getFile(url);
            InputStream inputStream = new FileInputStream(file);
            workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheetAt(0);
//            sheet.na
            //设置考勤日期
            String createDate = bnHrAttendances.get(0).getCreateDate();
            Cell dateCell = null;
            int totalCells = 53;
            if("1".equals(sign)){
                dateCell = sheet.getRow(2).getCell(30);
                totalCells = 50;
            }else if("2".equals(sign)){
                dateCell = sheet.getRow(2).getCell(31);
                totalCells = 51;
            }else if("3".equals(sign)){
                dateCell = sheet.getRow(2).getCell(32);
                totalCells = 52;
            }else if("4".equals(sign)){
                dateCell = sheet.getRow(2).getCell(33);
            }
//            Cell dateCell = sheet.getRow(2).getCell(33);
            dateCell.setCellValue(createDate);
            //设置sheet名称
            workBook.setSheetName(0, createDate+"考勤记录");
            for (int rowIndex = 5; rowIndex <= bnHrAttendances.size()+4; rowIndex++) {
                XSSFRow row = sheet.createRow(rowIndex);
                BnHrAttendance bnHrAttendance = bnHrAttendances.get(rowIndex - 5);
                for(int i = 0; i<totalCells; i++){
                    XSSFCell cell = row.createCell(i);
                    if(i==0){
                        cell.setCellValue(bnHrAttendance.getDeptName());
                    }else if(i==1){
                        cell.setCellValue(bnHrAttendance.getName());
                    }else if(i==2){
                        cell.setCellValue(bnHrAttendance.getDay1());
                    }else if(i==3){
                        cell.setCellValue(bnHrAttendance.getDay2());
                    }else if(i==4){
                        cell.setCellValue(bnHrAttendance.getDay3());
                    }else if(i==5){
                        cell.setCellValue(bnHrAttendance.getDay4());
                    }else if(i==6){
                        cell.setCellValue(bnHrAttendance.getDay5());
                    }else if(i==7){
                        cell.setCellValue(bnHrAttendance.getDay6());
                    }else if(i==8){
                        cell.setCellValue(bnHrAttendance.getDay7());
                    }else if(i==9){
                        cell.setCellValue(bnHrAttendance.getDay8());
                    }else if(i==10){
                        cell.setCellValue(bnHrAttendance.getDay9());
                    }else if(i==11){
                        cell.setCellValue(bnHrAttendance.getDay10());
                    }else if(i==12){
                        cell.setCellValue(bnHrAttendance.getDay11());
                    }else if(i==13){
                        cell.setCellValue(bnHrAttendance.getDay12());
                    }else if(i==14){
                        cell.setCellValue(bnHrAttendance.getDay13());
                    }else if(i==15){
                        cell.setCellValue(bnHrAttendance.getDay14());
                    }else if(i==16){
                        cell.setCellValue(bnHrAttendance.getDay15());
                    }else if(i==17){
                        cell.setCellValue(bnHrAttendance.getDay16());
                    }else if(i==18){
                        cell.setCellValue(bnHrAttendance.getDay17());
                    }else if(i==19){
                        cell.setCellValue(bnHrAttendance.getDay18());
                    }else if(i==20){
                        cell.setCellValue(bnHrAttendance.getDay19());
                    }else if(i==21){
                        cell.setCellValue(bnHrAttendance.getDay20());
                    }else if(i==22){
                        cell.setCellValue(bnHrAttendance.getDay21());
                    }else if(i==23){
                        cell.setCellValue(bnHrAttendance.getDay22());
                    }else if(i==24){
                        cell.setCellValue(bnHrAttendance.getDay23());
                    }else if(i==25){
                        cell.setCellValue(bnHrAttendance.getDay24());
                    }else if(i==26){
                        cell.setCellValue(bnHrAttendance.getDay25());
                    }else if(i==27){
                        cell.setCellValue(bnHrAttendance.getDay26());
                    }else if(i==28){
                        cell.setCellValue(bnHrAttendance.getDay27());
                    }else if(i==29){
                        cell.setCellValue(bnHrAttendance.getDay28());
                    }
                    if("1".equals(sign)){
                        if(i==30){
                            cell.setCellValue(bnHrAttendance.getHours());
                        }else if(i==31){
                            cell.setCellValue(bnHrAttendance.getDays());
                        }else if(i==32){
                            cell.setCellValue(bnHrAttendance.getJrjb());
                        }else if(i==33){
                            cell.setCellValue(bnHrAttendance.getJb());
                        }else if(i==34){
                            cell.setCellValue(bnHrAttendance.getCbb());
                        }else if(i==35){
                            cell.setCellValue(bnHrAttendance.getCyb());
                        }else if(i==36){
                            cell.setCellValue(bnHrAttendance.getTx());
                        }else if(i==37){
                            cell.setCellValue(bnHrAttendance.getGs());
                        }else if(i==38){
                            cell.setCellValue(bnHrAttendance.getPhj());
                        }else if(i==39){
                            cell.setCellValue(bnHrAttendance.getHj());
                        }else if(i==40){
                            cell.setCellValue(bnHrAttendance.getCc());
                        }else if(i==41){
                            cell.setCellValue(bnHrAttendance.getTqb());
                        }else if(i==42){
                            cell.setCellValue(bnHrAttendance.getXb());
                        }else if(i==43){
                            cell.setCellValue(bnHrAttendance.getSj());
                        }else if(i==44){
                            cell.setCellValue(bnHrAttendance.getKg());
                        }else if(i==45){
                            cell.setCellValue(bnHrAttendance.getCd());
                        }else if(i==46){
                            cell.setCellValue(bnHrAttendance.getZt());
                        }else if(i==47){
                            cell.setCellValue(bnHrAttendance.getWjdk());
                        }else if(i==48){
                            cell.setCellValue(bnHrAttendance.getBzdk());
                        }else if(i==49){
                            cell.setCellValue(bnHrAttendance.getRemark());
                        }

                    }else if("2".equals(sign)){
                        if(i==30){
                            cell.setCellValue(bnHrAttendance.getDay29());
                        }else if(i==31){
                            cell.setCellValue(bnHrAttendance.getHours());
                        }else if(i==32){
                            cell.setCellValue(bnHrAttendance.getDays());
                        }else if(i==33){
                            cell.setCellValue(bnHrAttendance.getJrjb());
                        }else if(i==34){
                            cell.setCellValue(bnHrAttendance.getJb());
                        }else if(i==35){
                            cell.setCellValue(bnHrAttendance.getCbb());
                        }else if(i==36){
                            cell.setCellValue(bnHrAttendance.getCyb());
                        }else if(i==37){
                            cell.setCellValue(bnHrAttendance.getTx());
                        }else if(i==38){
                            cell.setCellValue(bnHrAttendance.getGs());
                        }else if(i==39){
                            cell.setCellValue(bnHrAttendance.getPhj());
                        }else if(i==40){
                            cell.setCellValue(bnHrAttendance.getHj());
                        }else if(i==41){
                            cell.setCellValue(bnHrAttendance.getCc());
                        }else if(i==42){
                            cell.setCellValue(bnHrAttendance.getTqb());
                        }else if(i==43){
                            cell.setCellValue(bnHrAttendance.getXb());
                        }else if(i==44){
                            cell.setCellValue(bnHrAttendance.getSj());
                        }else if(i==45){
                            cell.setCellValue(bnHrAttendance.getKg());
                        }else if(i==46){
                            cell.setCellValue(bnHrAttendance.getCd());
                        }else if(i==47){
                            cell.setCellValue(bnHrAttendance.getZt());
                        }else if(i==48){
                            cell.setCellValue(bnHrAttendance.getWjdk());
                        }else if(i==49){
                            cell.setCellValue(bnHrAttendance.getBzdk());
                        }else if(i==50){
                            cell.setCellValue(bnHrAttendance.getRemark());
                        }

                    }else if("3".equals(sign)){
                        if(i==30){
                            cell.setCellValue(bnHrAttendance.getDay29());
                        }else if(i==31){
                            cell.setCellValue(bnHrAttendance.getDay30());
                        }else if(i==32){
                            cell.setCellValue(bnHrAttendance.getHours());
                        }else if(i==33){
                            cell.setCellValue(bnHrAttendance.getDays());
                        }else if(i==34){
                            cell.setCellValue(bnHrAttendance.getJrjb());
                        }else if(i==35){
                            cell.setCellValue(bnHrAttendance.getJb());
                        }else if(i==36){
                            cell.setCellValue(bnHrAttendance.getCbb());
                        }else if(i==37){
                            cell.setCellValue(bnHrAttendance.getCyb());
                        }else if(i==38){
                            cell.setCellValue(bnHrAttendance.getTx());
                        }else if(i==39){
                            cell.setCellValue(bnHrAttendance.getGs());
                        }else if(i==40){
                            cell.setCellValue(bnHrAttendance.getPhj());
                        }else if(i==41){
                            cell.setCellValue(bnHrAttendance.getHj());
                        }else if(i==42){
                            cell.setCellValue(bnHrAttendance.getCc());
                        }else if(i==43){
                            cell.setCellValue(bnHrAttendance.getTqb());
                        }else if(i==44){
                            cell.setCellValue(bnHrAttendance.getXb());
                        }else if(i==45){
                            cell.setCellValue(bnHrAttendance.getSj());
                        }else if(i==46){
                            cell.setCellValue(bnHrAttendance.getKg());
                        }else if(i==47){
                            cell.setCellValue(bnHrAttendance.getCd());
                        }else if(i==48){
                            cell.setCellValue(bnHrAttendance.getZt());
                        }else if(i==49){
                            cell.setCellValue(bnHrAttendance.getWjdk());
                        }else if(i==50){
                            cell.setCellValue(bnHrAttendance.getBzdk());
                        }else if(i==51){
                            cell.setCellValue(bnHrAttendance.getRemark());
                        }
                    }else if("4".equals(sign)){
                        if(i==30){
                            cell.setCellValue(bnHrAttendance.getDay29());
                        }else if(i==31){
                            cell.setCellValue(bnHrAttendance.getDay30());
                        }else if(i==32){
                            cell.setCellValue(bnHrAttendance.getDay31());
                        }else if(i==33){
                            cell.setCellValue(bnHrAttendance.getHours());
                        }else if(i==34){
                            cell.setCellValue(bnHrAttendance.getDays());
                        }else if(i==35){
                            cell.setCellValue(bnHrAttendance.getJrjb());
                        }else if(i==36){
                            cell.setCellValue(bnHrAttendance.getJb());
                        }else if(i==37){
                            cell.setCellValue(bnHrAttendance.getCbb());
                        }else if(i==38){
                            cell.setCellValue(bnHrAttendance.getCyb());
                        }else if(i==39){
                            cell.setCellValue(bnHrAttendance.getTx());
                        }else if(i==40){
                            cell.setCellValue(bnHrAttendance.getGs());
                        }else if(i==41){
                            cell.setCellValue(bnHrAttendance.getPhj());
                        }else if(i==42){
                            cell.setCellValue(bnHrAttendance.getHj());
                        }else if(i==43){
                            cell.setCellValue(bnHrAttendance.getCc());
                        }else if(i==44){
                            cell.setCellValue(bnHrAttendance.getTqb());
                        }else if(i==45){
                            cell.setCellValue(bnHrAttendance.getXb());
                        }else if(i==46){
                            cell.setCellValue(bnHrAttendance.getSj());
                        }else if(i==47){
                            cell.setCellValue(bnHrAttendance.getKg());
                        }else if(i==48){
                            cell.setCellValue(bnHrAttendance.getCd());
                        }else if(i==49){
                            cell.setCellValue(bnHrAttendance.getZt());
                        }else if(i==50){
                            cell.setCellValue(bnHrAttendance.getWjdk());
                        }else if(i==51){
                            cell.setCellValue(bnHrAttendance.getBzdk());
                        }else if(i==52){
                            cell.setCellValue(bnHrAttendance.getRemark());
                        }
                    }
                }


            }

            // ------ 创建一行新的数据 ----------//

// 指定行索引，创建一行数据, 行索引为当前最后一行的行索引 + 1

//            int currentLastRowIndex = sheet.getLastRowNum();
//
//            int newRowIndex = currentLastRowIndex + 1;
//
//            HSSFRow newRow = sheet.createRow(newRowIndex);
//
//// 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
//
//            int cellIndex = 0;
//
//// 创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
//
//            HSSFCell newNameCell = newRow.createCell(cellIndex++, CellType.STRING);
//
//            newNameCell.setCellValue("钱七");
//
//            HSSFCell newGenderCell = newRow.createCell(cellIndex++, CellType.STRING);
//
//            newGenderCell.setCellValue("女");
//
//            HSSFCell newAgeCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newAgeCell.setCellValue(50);
//
//            HSSFCell newWeightCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newWeightCell.setCellValue(68);
//
//            HSSFCell newSalaryCell = newRow.createCell(cellIndex++, CellType.NUMERIC);
//
//            newSalaryCell.setCellValue(6000);

//            out = new FileOutputStream(file);
//            workBook.write(out);
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("application/x-download");
//            String filedisplay = file.getName();
//            filedisplay = URLEncoder.encode(filedisplay, "utf-8");
//            response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
            output=response.getOutputStream();

            response.reset();

//设置响应头，

            response.setHeader("Content-disposition", "attachment; filename=attendance.xlsx");

//            response.setHeader("Content-Length", inputStream.available()+""); // 内容长度
            response.setContentType("application/octet-stream"); // 响应内容格式

//            response.setContentType("application/msexcel");

            workBook.write(output);


//            inputStream.close();

            output.close();
//            return AjaxResult.success(file.getName().toString());


        }catch (Exception e){
            e.printStackTrace();
//            log.error("导出Excel异常{}", e.getMessage());
            throw new UtilException("导出Excel失败，请联系网站管理员！");
        }
        finally
        {
            IOUtils.closeQuietly(workBook);
            IOUtils.closeQuietly(output);
        }

    }

    public static List<BnHrSalary> readExcel(MultipartFile file){

        //最终返回数据
        List<BnHrSalary> resultList = new ArrayList<BnHrSalary>();
        try{

            Workbook workbook = null;
            InputStream is = file.getInputStream();
            String name = file.getOriginalFilename().toLowerCase();
            // 创建excel操作对象
            if (name.contains(".xlsx") || name.contains(".xls")) {
                //使用工厂方法创建.
                workbook = WorkbookFactory.create(is);
            }
            //得到一个工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //获得总列数
            int cellLength = sheet.getRow(0).getPhysicalNumberOfCells();
            //获取表头
            Row firstRow = sheet.getRow(0);

//            for(int i=0;i<cellLength;i++) {
//                for (Field field:fields) {
//                    Cell  cell = firstRow.getCell(i);
//                    //按照excel中的存储存放数组,以便后面遍历excel表格,数据一一对应.
//                    if(m.invoke(ob,getXCellVal(cell)).equals(field.getName())){
//                        newFields[i] = field;
//                        continue;
//                    }
//                }
//            }

            //从第x行开始获取
            for(int x = 4 ; x <= totalRowNum ; x++){
                BnHrSalary bnHrSalary = new BnHrSalary();
                //获得第i行对象
                Row row = sheet.getRow(x);
                //如果一行里的所有单元格都为空则不放进list里面
                int a = 0;
                for(int y=0;y<cellLength;y++){
                    if (!(row==null)) {
                        Cell cell = row.getCell(y);
                        if (cell == null) {
                            a++;
                        } else {
                            String value = getValue(cell);
                            if(StringUtils.isNotBlank(value)) {
                                if(y==1){
                                    bnHrSalary.setName(value);
                                }else if(y==2){
                                    bnHrSalary.setCard(value);
                                }else if(y==3){
                                    bnHrSalary.setBankCard(value);
                                }else if(y==4){
                                    bnHrSalary.setBankName(value);
                                }else if(y==5){
                                    bnHrSalary.setBankLine(value);
                                }else if(y==6){
                                    bnHrSalary.setDeptName(value);
                                }else if(y==7){
                                    bnHrSalary.setCqDays(new BigDecimal(value));
                                }else if(y==8){
                                    bnHrSalary.setGwSal(new BigDecimal(value));
                                }else if(y==9){
                                    bnHrSalary.setBzjx(value);
                                }else if(y==10){
                                    bnHrSalary.setJxSal(new BigDecimal(value));
                                }else if(y==11){
                                    bnHrSalary.setCqSal(new BigDecimal(value));
                                }else if(y==12){
                                    bnHrSalary.setYearSal(new BigDecimal(value));
                                }else if(y==13){
//                                    bnHrSalary.setKq(new BigDecimal(value));
                                }else if(y==14){
                                    bnHrSalary.setKq(new BigDecimal(value));
                                }else if(y==15){
//                                    bnHrSalary.setGlbz(new BigDecimal(value));
                                }else if(y==16){
//                                    bnHrSalary.setJxSal(new BigDecimal(value));
                                }else if(y==17){
                                    bnHrSalary.setGlbz(new BigDecimal(value));
                                }else if(y==18){
                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==19){
                                    bnHrSalary.setXlbt(new BigDecimal(value));
                                }else if(y==20){
                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==21){
                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==22){
                                    bnHrSalary.setBjf(new BigDecimal(value));
                                }else if(y==23){
                                    bnHrSalary.setYcbz(new BigDecimal(value));
                                }else if(y==24){
//                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==25){
//                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==26){
//                                    bnHrSalary.setZcbt(new BigDecimal(value));
                                }else if(y==27){
                                    bnHrSalary.setSfbt(new BigDecimal(value));
                                }else if(y==28){
                                    bnHrSalary.setYfgz(new BigDecimal(value));
                                }else if(y==29){
                                    bnHrSalary.setYlbx(new BigDecimal(value));
                                }else if(y==30){
                                    bnHrSalary.setYlbx2(new BigDecimal(value));
                                }else if(y==31){
                                    bnHrSalary.setSybx(new BigDecimal(value));
                                }else if(y==32){
                                    bnHrSalary.setZfgjj(new BigDecimal(value));
                                }else if(y==33){
                                    bnHrSalary.setGs(new BigDecimal(value));
                                }else if(y==36){
                                    bnHrSalary.setSfgz(new BigDecimal(value));
                                }else if(y==37){
                                    bnHrSalary.setLkSign(value);
                                }
                            }
                        }
                    }
                }
                if(a!=cellLength && row!=null){
                    resultList.add(bnHrSalary);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;

    }

    public static List<BnHrAttendance> readBnHrAttendanceExcel(MultipartFile file){

        //最终返回数据
        List<BnHrAttendance> resultList = new ArrayList<BnHrAttendance>();
        try{
            Workbook workbook = null;
            InputStream is = file.getInputStream();
            String name = file.getOriginalFilename().toLowerCase();
            // 创建excel操作对象
            if (name.contains(".xlsx") || name.contains(".xls")) {
                //使用工厂方法创建.
                workbook = WorkbookFactory.create(is);
            }
            //得到一个工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取考勤月份
//            String createDate = convertDate(sheet.getRow(2).getCell(33));
            String createDate = getValue(sheet.getRow(2).getCell(33));
            if(StringUtils.isBlank(createDate)){
                createDate = getValue(sheet.getRow(2).getCell(32));
            }
            if(StringUtils.isBlank(createDate)){
                createDate = getValue(sheet.getRow(2).getCell(31));
            }
            if(StringUtils.isBlank(createDate)){
                createDate = getValue(sheet.getRow(2).getCell(30));
            }
            //获取考勤月份标识
            String sign = convertSign(createDate);
//            String createDate = getValue(sheet.getRow(2).getCell(33));
//            Date dateCellValue = sheet.getRow(2).getCell(33).getDateCellValue();
//            short dataFormat = sheet.getRow(2).getCell(33).getCellStyle().getDataFormat();
//            String dataFormatString = sheet.getRow(2).getCell(33).getCellStyle().getDataFormatString();
//            if("yyyy/mm;@".equals(dataFormatString) || "m/d/yy".equals(dataFormatString)
//                    || "yy/m/d".equals(dataFormatString) || "mm/dd/yy".equals(dataFormatString)
//                    || "dd-mmm-yy".equals(dataFormatString)|| "yyyy/m/d".equals(dataFormatString)){
//                String format = new SimpleDateFormat("yyyy/MM/dd").format(dateCellValue);
//            }
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //获得总列数
            int cellLength = sheet.getRow(4).getPhysicalNumberOfCells();
            //获取表头
            Row firstRow = sheet.getRow(0);

//            for(int i=0;i<cellLength;i++) {
//                for (Field field:fields) {
//                    Cell  cell = firstRow.getCell(i);
//                    //按照excel中的存储存放数组,以便后面遍历excel表格,数据一一对应.
//                    if(m.invoke(ob,getXCellVal(cell)).equals(field.getName())){
//                        newFields[i] = field;
//                        continue;
//                    }
//                }
//            }

            //从第x+1行开始获取
            for(int x = 5 ; x <= totalRowNum ; x++){
                BnHrAttendance bnHrAttendance = new BnHrAttendance();
                bnHrAttendance.setCreateDate(createDate);
                bnHrAttendance.setSign(sign);
                //获得第i行对象
                Row row = sheet.getRow(x);
                //如果一行里的所有单元格都为空则不放进list里面
                int a = 0;
                for(int y=0;y<cellLength;y++){
                    if (!(row==null)) {
                        Cell cell = row.getCell(y);
//                        if (cell == null) {
//                            a++;
//                        } else {
                        String value = null;
                        if (cell != null) {
                            value = getValue(cell);
                        }
//                            if(StringUtils.isNotBlank(value)) {
                                if(y==0){
                                    bnHrAttendance.setDeptName(value);
                                }else if(y==1){
                                    bnHrAttendance.setName(value);
                                }else if(y==2){
                                    bnHrAttendance.setDay1(nullToZore(value));
                                }else if(y==3){
                                    bnHrAttendance.setDay2(nullToZore(value));
                                }else if(y==4){
                                    bnHrAttendance.setDay3(nullToZore(value));
                                }else if(y==5){
                                    bnHrAttendance.setDay4(nullToZore(value));
                                }else if(y==6){
                                    bnHrAttendance.setDay5(nullToZore(value));
                                }else if(y==7){
                                    bnHrAttendance.setDay6(nullToZore(value));
                                }else if(y==8){
                                    bnHrAttendance.setDay7(nullToZore(value));
                                }else if(y==9){
                                    bnHrAttendance.setDay8(nullToZore(value));
                                }else if(y==10){
                                    bnHrAttendance.setDay9(nullToZore(value));
                                }else if(y==11){
                                    bnHrAttendance.setDay10(nullToZore(value));
                                }else if(y==12){
                                    bnHrAttendance.setDay11(nullToZore(value));
                                }else if(y==13){
                                    bnHrAttendance.setDay12(nullToZore(value));
                                }else if(y==14){
                                    bnHrAttendance.setDay13(nullToZore(value));
                                }else if(y==15){
                                    bnHrAttendance.setDay14(nullToZore(value));
                                }else if(y==16){
                                    bnHrAttendance.setDay15(nullToZore(value));
                                }else if(y==17){
                                    bnHrAttendance.setDay16(nullToZore(value));
                                }else if(y==18){
                                    bnHrAttendance.setDay17(nullToZore(value));
                                }else if(y==19){
                                    bnHrAttendance.setDay18(nullToZore(value));
                                }else if(y==20){
                                    bnHrAttendance.setDay19(nullToZore(value));
                                }else if(y==21){
                                    bnHrAttendance.setDay20(nullToZore(value));
                                }else if(y==22){
                                    bnHrAttendance.setDay21(nullToZore(value));
                                }else if(y==23){
                                    bnHrAttendance.setDay22(nullToZore(value));
                                }else if(y==24){
                                    bnHrAttendance.setDay23(nullToZore(value));
                                }else if(y==25){
                                    bnHrAttendance.setDay24(nullToZore(value));
                                }else if(y==26){
                                    bnHrAttendance.setDay25(nullToZore(value));
                                }else if(y==27){
                                    bnHrAttendance.setDay26(nullToZore(value));
                                }else if(y==28){
                                    bnHrAttendance.setDay27(nullToZore(value));
                                }else if(y==29){
                                    bnHrAttendance.setDay28(nullToZore(value));
                                }
                                //判断考勤月天数
                                if("1".equals(sign)){
                                    if(y==30){
                                        bnHrAttendance.setHours(nullToZore(value));
                                    }else if(y==31){
                                        bnHrAttendance.setDays(nullToZore(value));
                                    }else if(y==32){
                                        bnHrAttendance.setJrjb(nullToZore(value));
                                    }else if(y==33){
                                        bnHrAttendance.setJb(nullToZore(value));
                                    }else if(y==34){
                                        bnHrAttendance.setCbb(nullToZore(value));
                                    }else if(y==35){
                                        bnHrAttendance.setCyb(nullToZore(value));
                                    }else if(y==36){
                                        bnHrAttendance.setTx(nullToZore(value));
                                    }else if(y==37){
                                        bnHrAttendance.setGs(nullToZore(value));
                                    }else if(y==38){
                                        bnHrAttendance.setPhj(nullToZore(value));
                                    }else if(y==39){
                                        bnHrAttendance.setHj(nullToZore(value));
                                    }else if(y==40){
                                        bnHrAttendance.setCc(nullToZore(value));
                                    }else if(y==41){
                                        bnHrAttendance.setTqb(nullToZore(value));
                                    }else if(y==42){
                                        bnHrAttendance.setXb(nullToZore(value));
                                    }else if(y==43){
                                        bnHrAttendance.setSj(nullToZore(value));
                                    }else if(y==44){
                                        bnHrAttendance.setKg(nullToZore(value));
                                    }else if(y==45){
                                        bnHrAttendance.setCd(nullToZore(value));
                                    }else if(y==46){
                                        bnHrAttendance.setZt(nullToZore(value));
                                    }else if(y==47){
                                        bnHrAttendance.setWjdk(nullToZore(value));
                                    }else if(y==48){
                                        bnHrAttendance.setBzdk(nullToZore(value));
                                    }
                                }else if("2".equals(sign)){
                                    if(y==30){
                                        bnHrAttendance.setDay29(nullToZore(value));
                                    }else if(y==31){
                                        bnHrAttendance.setHours(nullToZore(value));
                                    }else if(y==32){
                                        bnHrAttendance.setDays(nullToZore(value));
                                    }else if(y==33){
                                        bnHrAttendance.setJrjb(nullToZore(value));
                                    }else if(y==34){
                                        bnHrAttendance.setJb(nullToZore(value));
                                    }else if(y==35){
                                        bnHrAttendance.setCbb(nullToZore(value));
                                    }else if(y==36){
                                        bnHrAttendance.setCyb(nullToZore(value));
                                    }else if(y==37){
                                        bnHrAttendance.setTx(nullToZore(value));
                                    }else if(y==38){
                                        bnHrAttendance.setGs(nullToZore(value));
                                    }else if(y==39){
                                        bnHrAttendance.setPhj(nullToZore(value));
                                    }else if(y==40){
                                        bnHrAttendance.setHj(nullToZore(value));
                                    }else if(y==41){
                                        bnHrAttendance.setCc(nullToZore(value));
                                    }else if(y==42){
                                        bnHrAttendance.setTqb(nullToZore(value));
                                    }else if(y==43){
                                        bnHrAttendance.setXb(nullToZore(value));
                                    }else if(y==44){
                                        bnHrAttendance.setSj(nullToZore(value));
                                    }else if(y==45){
                                        bnHrAttendance.setKg(nullToZore(value));
                                    }else if(y==46){
                                        bnHrAttendance.setCd(nullToZore(value));
                                    }else if(y==47){
                                        bnHrAttendance.setZt(nullToZore(value));
                                    }else if(y==48){
                                        bnHrAttendance.setWjdk(nullToZore(value));
                                    }else if(y==49){
                                        bnHrAttendance.setBzdk(nullToZore(value));
                                    }
                                }else if("3".equals(sign)){
                                    if(y==30){
                                        bnHrAttendance.setDay29(nullToZore(value));
                                    }else if(y==31){
                                        bnHrAttendance.setDay30(nullToZore(value));
                                    }else if(y==32){
                                        bnHrAttendance.setHours(nullToZore(value));
                                    }else if(y==33){
                                        bnHrAttendance.setDays(nullToZore(value));
                                    }else if(y==34){
                                        bnHrAttendance.setJrjb(nullToZore(value));
                                    }else if(y==35){
                                        bnHrAttendance.setJb(nullToZore(value));
                                    }else if(y==36){
                                        bnHrAttendance.setCbb(nullToZore(value));
                                    }else if(y==37){
                                        bnHrAttendance.setCyb(nullToZore(value));
                                    }else if(y==38){
                                        bnHrAttendance.setTx(nullToZore(value));
                                    }else if(y==39){
                                        bnHrAttendance.setGs(nullToZore(value));
                                    }else if(y==40){
                                        bnHrAttendance.setPhj(nullToZore(value));
                                    }else if(y==41){
                                        bnHrAttendance.setHj(nullToZore(value));
                                    }else if(y==42){
                                        bnHrAttendance.setCc(nullToZore(value));
                                    }else if(y==43){
                                        bnHrAttendance.setTqb(nullToZore(value));
                                    }else if(y==44){
                                        bnHrAttendance.setXb(nullToZore(value));
                                    }else if(y==45){
                                        bnHrAttendance.setSj(nullToZore(value));
                                    }else if(y==46){
                                        bnHrAttendance.setKg(nullToZore(value));
                                    }else if(y==47){
                                        bnHrAttendance.setCd(nullToZore(value));
                                    }else if(y==48){
                                        bnHrAttendance.setZt(nullToZore(value));
                                    }else if(y==49){
                                        bnHrAttendance.setWjdk(nullToZore(value));
                                    }else if(y==50){
                                        bnHrAttendance.setBzdk(nullToZore(value));
                                    }
                                }else if("4".equals(sign)){
                                    if(y==30){
                                        bnHrAttendance.setDay29(nullToZore(value));
                                    }else if(y==31){
                                        bnHrAttendance.setDay30(nullToZore(value));
                                    }else if(y==32){
                                        bnHrAttendance.setDay31(nullToZore(value));
                                    }else if(y==33){
                                        bnHrAttendance.setHours(nullToZore(value));
                                    }else if(y==34){
                                        bnHrAttendance.setDays(nullToZore(value));
                                    }else if(y==35){
                                        bnHrAttendance.setJrjb(nullToZore(value));
                                    }else if(y==36){
                                        bnHrAttendance.setJb(nullToZore(value));
                                    }else if(y==37){
                                        bnHrAttendance.setCbb(nullToZore(value));
                                    }else if(y==38){
                                        bnHrAttendance.setCyb(nullToZore(value));
                                    }else if(y==39){
                                        bnHrAttendance.setTx(nullToZore(value));
                                    }else if(y==40){
                                        bnHrAttendance.setGs(nullToZore(value));
                                    }else if(y==41){
                                        bnHrAttendance.setPhj(nullToZore(value));
                                    }else if(y==42){
                                        bnHrAttendance.setHj(nullToZore(value));
                                    }else if(y==43){
                                        bnHrAttendance.setCc(nullToZore(value));
                                    }else if(y==44){
                                        bnHrAttendance.setTqb(nullToZore(value));
                                    }else if(y==45){
                                        bnHrAttendance.setXb(nullToZore(value));
                                    }else if(y==46){
                                        bnHrAttendance.setSj(nullToZore(value));
                                    }else if(y==47){
                                        bnHrAttendance.setKg(nullToZore(value));
                                    }else if(y==48){
                                        bnHrAttendance.setCd(nullToZore(value));
                                    }else if(y==49){
                                        bnHrAttendance.setZt(nullToZore(value));
                                    }else if(y==50){
                                        bnHrAttendance.setWjdk(nullToZore(value));
                                    }else if(y==51){
                                        bnHrAttendance.setBzdk(nullToZore(value));
                                    }
                                }

//                            }
//                        }
                    }
                }
                resultList.add(bnHrAttendance);
//                if(!(row==null)){
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;

    }

    private static String convertDate(Cell cell){
        //1、判断是否是数值格式
//        if(cell.getCellType() == NUMERIC){
//
//        }
        String result = null;
        short format = cell.getCellStyle().getDataFormat();
        SimpleDateFormat sdf = null;
        if(format == 14 || format == 31 || format == 57 || format == 58){
            //日期
            sdf = new SimpleDateFormat("yyyy年M月");
        }else if (format == 20 || format == 32) {
            //时间
            sdf = new SimpleDateFormat("HH:mm");
        }
//        double value = cell.getStringCellValue();
        String value = getValue(cell);
        return value;

//        Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(stringCellValue);
//        result = sdf.format(date);
//        return result;
    }

    private static String convertSign(String createDate){
        String sign = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月");
        try {
            Date date = sdf.parse(createDate);
            sign = DateUtils.getDateSign(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sign;
    }

    /**
     * 给字段赋值,判断值的类型,然后转化成实体需要的类型值.
     * @param field  字段
     * @param value  值
     * @param object  对象
     */
    private static void setValue(Field field, String value, Object object) {
        try {
            field.setAccessible(true);
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            if (field.getGenericType().toString().contains("Integer")){
                field.set(object,Integer.valueOf(value));
            }else if(field.getGenericType().toString().contains("String")){
                field.set(object,value);
            }else
            if (field.getGenericType().toString().contains("Date")){
                field.set(object,fmt.parse(value));
            }
            field.setAccessible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param cell
     * @return String
     * 获取单元格中的值
     */

    private static String getValue(Cell cell) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("0.0000");
        String val = "";
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    val = fmt.format(cell.getDateCellValue()); //日期型
                } else {
                    val = df.format(cell.getNumericCellValue()); //数字型
                    // 去掉多余的0，如最后一位是.则去掉
                    val = val.replaceAll("0+?$", "").replaceAll("[.]$","");
                }
                break;
            case STRING: //文本类型
                val = cell.getStringCellValue();
                break;
            case BOOLEAN: //布尔型
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK: //空白
                val = cell.getStringCellValue();
                break;
            case ERROR: //错误
                val = "";
                break;
            case FORMULA: //公式
                try {
                    val = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    val = String.valueOf(cell.getNumericCellValue());
                }
                break;
            default:
                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
        }
        return val;
    }

    /**
     * @param value
     * @return String
     * 获取单元格中的值
     */

    private static String nullToZore(String value) {
        if(StringUtils.isBlank(value)){
            value = "0";
        }

        return value;
    }

    /**
     * @Description：对表格中数值进行格式化
     * @param
     * @return
     */
    //解决excel类型问题，获得数值
//    public static String getValue(Cell cell) {
////        String value = "";
////        if(cell!=null){
////            value = cell.getStringCellValue();
////        }
////        return value;
//        String value = "";
//        if(null==cell){
//            return value;
//        }
//        switch (cell.getCellType()) {
//            //数值型
//            case NUMERIC:
//                if (HSSFDateUtil.isCellDateFormatted(cell)) {
//                    //如果是date类型则 ，获取该cell的date值
//                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                    value = format.format(date);;
//                }else {// 纯数字
//                    BigDecimal big=new BigDecimal(cell.getNumericCellValue());
//                    value = big.toString();
//                    //解决1234.0  去掉后面的.0
//                    if(null!=value&&!"".equals(value.trim())){
//                        String[] item = value.split("[.]");
//                        if(1<item.length&&"0".equals(item[1])){
//                            value=item[0];
//                        }
//                    }
//                }
//                break;
//            //字符串类型
//            case Cell.CELL_TYPE_STRING:
//                value = cell.getStringCellValue().toString();
//                break;
//            // 公式类型
//            case Cell.CELL_TYPE_FORMULA:
//                //读公式计算值
//                value = String.valueOf(cell.getNumericCellValue());
//                if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
//                    value = cell.getStringCellValue().toString();
//                }
//                break;
//            // 布尔类型
//            case Cell.CELL_TYPE_BOOLEAN:
//                value = " "+ cell.getBooleanCellValue();
//                break;
//            default:
//                value = cell.getStringCellValue().toString();
//        }
//        if("null".endsWith(value.trim())){
//            value="";
//        }
//        return value;
//    }

    public static void main(String[] args) throws IOException {
        // 读取源文件
//        FileInputStream fis = new FileInputStream("D:/test.xlsx");
//        ClassPathResource classPathResource = new ClassPathResource("classpath:static/excel/salary.xlsx");
        File file = ResourceUtils.getFile("classpath:static/excel/salary.xlsx");
        InputStream inputStream = new FileInputStream(file);
        HSSFWorkbook workBook = new HSSFWorkbook(inputStream);
        inputStream.close();
        HSSFSheet sheet = workBook.getSheetAt(0);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {



// XSSFRow 代表一行数据

            HSSFRow row = sheet.getRow(rowIndex);

            if (row == null) {

                continue;

            }

            HSSFCell nameCell = row.getCell(0); // 姓名列

            HSSFCell genderCell = row.getCell(1); // 性别列

            HSSFCell ageCell = row.getCell(2); // 年龄列

            HSSFCell weightCell = row.getCell(3); // 体重列

            HSSFCell salaryCell = row.getCell(4); // 收入列



            StringBuilder employeeInfoBuilder = new StringBuilder();

//            employeeInfoBuilder.append("员工信息 --> ")
//
//                    .append("姓名 : ").append(nameCell.getStringCellValue())
//
//                    .append(" , 性别 : ").append(genderCell.getRawValue())
//
//                    .append(" , 年龄 : ").append(ageCell.getRawValue())
//
//                    .append(" , 体重(千克) : ").append(weightCell.getRawValue())
//
//                    .append(" , 月收入(元) : ").append(salaryCell.getRawValue());



            System.out.println(employeeInfoBuilder.toString());

        }

        // ------ 创建一行新的数据 ----------//

// 指定行索引，创建一行数据, 行索引为当前最后一行的行索引 + 1

        int currentLastRowIndex = sheet.getLastRowNum();

        int newRowIndex = currentLastRowIndex + 1;

        HSSFRow newRow = sheet.createRow(newRowIndex);

// 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始

        int cellIndex = 0;

// 创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同

        HSSFCell newNameCell = newRow.createCell(cellIndex++, CellType.STRING);

        newNameCell.setCellValue("钱七");

        HSSFCell newGenderCell = newRow.createCell(cellIndex++, CellType.STRING);

        newGenderCell.setCellValue("女");

        HSSFCell newAgeCell = newRow.createCell(cellIndex++, CellType.NUMERIC);

        newAgeCell.setCellValue(50);

        HSSFCell newWeightCell = newRow.createCell(cellIndex++, CellType.NUMERIC);

        newWeightCell.setCellValue(68);

        HSSFCell newSalaryCell = newRow.createCell(cellIndex++, CellType.NUMERIC);

        newSalaryCell.setCellValue(6000);

        // 将最新的 Excel 数据写回到原始 Excel 文件（就是D盘那个 Excel 文件）中

// 首先要创建一个原始Excel文件的输出流对象！

        FileOutputStream excelFileOutPutStream = new FileOutputStream("D:/test.xlsx");

// 将最新的 Excel 文件写入到文件输出流中，更新文件信息！

        workBook.write(excelFileOutPutStream);

        workBook.close();


        // 执行 flush 操作， 将缓存区内的信息更新到文件上

        excelFileOutPutStream.flush();

// 使用后，及时关闭这个输出流对象， 好习惯，再强调一遍！

        excelFileOutPutStream.close();



        // 进行模板的克隆(接下来的操作都是针对克隆后的sheet)
//        XSSFSheet sheet = workBook.cloneSheet(0);
//        workBook.setSheetName(0, "sheet-0"); // 给sheet命名
//
//        // 读取指定cell的内容
//        XSSFCell nameCell = sheet.getRow(1).getCell(0);
//        XSSFCell nameCell2 = sheet.getRow(1).getCell(1);
//        System.out.println(nameCell.getNumericCellValue());
//        System.out.println(nameCell2.getNumericCellValue());
//
//        // 替换单元格内容(注意获取的cell的下标是合并之前的下标)
//        replaceCellValue(sheet.getRow(1).getCell(2), "xxxxx时间");
//        replaceCellValue(sheet.getRow(2).getCell(2), "xxxxx人");
//
//        // 动态插入数据-增加行
//        List<Map<String, Object>> datas = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Map data = new HashMap<>();
//            data.put("name", "name" + i);
//            data.put("age", "age" + i);
//            data.put("sex", "sex" + i);
//            datas.add(data);
//        }
//        // 插入行
//        sheet.shiftRows(4, 4 + datas.size(), datas.size(), true, false);// 第1个参数是指要开始插入的行，第2个参数是结尾行数,第三个参数表示动态添加的行数
//        for (int i = 0; i < datas.size(); i++) {
//            XSSFRow creRow = sheet.createRow(4 + i);
//            creRow.setRowStyle(sheet.getRow(4).getRowStyle());
//            creRow.createCell(0).setCellValue(datas.get(i).get("name").toString());
//            creRow.createCell(1).setCellValue(datas.get(i).get("age").toString());
//            creRow.createCell(2).setCellValue(datas.get(i).get("sex").toString());
//        }
//
//        // 输出为一个新的Excel，也就是动态修改完之后的excel
//        String fileName = "test" + System.currentTimeMillis() + ".xlsx";
//        OutputStream out = new FileOutputStream("D:" + "/" + fileName);
//        workBook.removeSheetAt(0); // 移除workbook中的模板sheet
//        workBook.write(out);
//
//        fis.close();
//        out.flush();
//        out.close();
    }

    /**
     * 替换单元格的内容，单元格的获取位置是合并单元格之前的位置，也就是下标都是合并之前的下表
     *
     * @param cell
     *            单元格
     * @param value
     *            需要设置的值
     */
    public static void replaceCellValue(Cell cell, Object value) {
        String val = value != null ? String.valueOf(value) : "";
        cell.setCellValue(val);
    }

}
