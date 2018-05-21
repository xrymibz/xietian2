package com.acquireData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.gacl.domain.ScoreRanking;
import me.gacl.service.ScoreRankingService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xietian
 * Date: 2018-05-21
 * Time: 7:41
 */
public class ExcelPoi {

  public static void main(String[] args) {

    ApplicationContext ac = new ClassPathXmlApplicationContext(
        new String[] { "spring.xml", "spring-mybatis.xml" });
    ScoreRankingService scoreRankingService = (ScoreRankingService) ac
        .getBean("scoreRankingService");

    Workbook wb =null;
    Sheet sheet = null;
    Row row = null;
    List<Map<String,String>> list = null;
    String cellData = null;
    String filePath = "C:\\Users\\xrymi\\Desktop\\GK\\score_ranking\\sc_2014.xlsx";
    String columns[] = {"score","rank_single","ranking"};
    wb = readExcel(filePath);
    if(wb != null){
      //用来存放表中数据
      list = new ArrayList<Map<String,String>>();
      //获取第一个sheet
      sheet = wb.getSheetAt(0);
      //获取最大行数
      int rownum = sheet.getPhysicalNumberOfRows();
      //获取第一行
      row = sheet.getRow(0);
      //获取最大列数
      int colnum = row.getPhysicalNumberOfCells();
      for (int i = 1; i<rownum; i++) {
        Map<String,String> map = new LinkedHashMap<String,String>();
        row = sheet.getRow(i);
        if(row !=null){
          for (int j=0;j<colnum;j++){
            cellData = (String) getCellFormatValue(row.getCell(j));
            map.put(columns[j], cellData);
          }
        }else{
          break;
        }
        list.add(map);
      }
    }
    //遍历解析出来的list
    for (Map<String,String> map : list) {
      String score = map.get("score");
      int start = score.lastIndexOf(" ");
      int end = score.indexOf("分");
      int score_int = Integer.parseInt(score.substring(start+1,end).trim());
      String ranking = map.get("ranking");
      int end2 = ranking.indexOf(".");
      int ranking_int = Integer.parseInt(ranking.substring(0,end2));
      System.out.println(score_int);
      System.out.println(ranking_int);

      ScoreRanking scoreRanking = new ScoreRanking();
      scoreRanking.setYear("2014");
      scoreRanking.setProvince("四川");
      scoreRanking.setRanking(ranking_int);
      scoreRanking.setScore(score_int);

//      scoreRankingService.insertScoreRanking(scoreRanking);


    }

  }
  //读取excel
  public static Workbook readExcel(String filePath){
    Workbook wb = null;
    if(filePath==null){
      return null;
    }
    String extString = filePath.substring(filePath.lastIndexOf("."));
    InputStream is = null;
    try {
      is = new FileInputStream(filePath);
      if(".xls".equals(extString)){
        return wb = new HSSFWorkbook(is);
      }else if(".xlsx".equals(extString)){
        return wb = new XSSFWorkbook(is);
      }else{
        return wb = null;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return wb;
  }
  public static Object getCellFormatValue(Cell cell){
    Object cellValue = null;
    if(cell!=null){
      //判断cell类型
      switch(cell.getCellType()){
        case Cell.CELL_TYPE_NUMERIC:{
          cellValue = String.valueOf(cell.getNumericCellValue());
          break;
        }
        case Cell.CELL_TYPE_FORMULA:{
          //判断cell是否为日期格式
          if(DateUtil.isCellDateFormatted(cell)){
            //转换为日期格式YYYY-mm-dd
            cellValue = cell.getDateCellValue();
          }else{
            //数字
            cellValue = String.valueOf(cell.getNumericCellValue());
          }
          break;
        }
        case Cell.CELL_TYPE_STRING:{
          cellValue = cell.getRichStringCellValue().getString();
          break;
        }
        default:
          cellValue = "";
      }
    }else{
      cellValue = "";
    }
    return cellValue;
  }

} 
