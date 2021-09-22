package cn.tedu.springbootweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hu.mybatis.POIUtil.POIUtils;
import cn.hu.springbootweb.entity.userInputEntity;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/excel") 
@Slf4j
public class ExcelController {
	@RequestMapping("/web#/login")
    @ResponseBody
    public String demo(){
        log.debug("Hello World!");
        return "OK";
    }
	@RequestMapping("/demo")
    @ResponseBody
    public String demo1(){
        log.debug("Hello World!");
        return "OK";
    }
	@Test
	void fileupload() {
		MultipartFile f=(MultipartFile) new File("C:\\Users\\Jinsheng Tian\\Desktop\\20");
		look(f);
}
	  //用POI导入excel
  @RequestMapping("/look")
  public void look(@RequestParam("excelFile") MultipartFile excelFile){
    try {
    	System.out.println(111111+"进入");
      List<String> list = POIUtils.readExcel(excelFile);
      // list.removeIf(Objects::isNull);去掉null值
      //去掉空字符串
      Iterator<String> iterator = list.iterator();
      while (iterator.hasNext()){
        if (iterator.next() == ""){
          iterator.remove();
        }
      }
      //遍历list,查看数据
      for (String s : list) {
        System.out.println(s);
      }
      //创建map对象或者pojo类存入所需的数据，
      Map<String,Object> map = new HashMap<>();
      map.put("plan",list.get(0));
      map.put("er",list.get(2));
      map.put("date",list.get(4));
      System.out.println(map);
 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //用easyPOI导入excel
  @PostMapping("/upload")
  public Boolean upload(@RequestParam("file") MultipartFile multipartFile) throws Exception{
	  ImportParams params = new ImportParams();
	  params.setTitleRows(1);
	  params.setHeadRows(1);
	  final List<userInputEntity> result = ExcelImportUtil.importExcel(multipartFile.getInputStream(), userInputEntity.class, params);
	  
	  return true;
  }
  //用easyPOI导入excel
  @PostMapping("/upload1")
  public Boolean upload1(@RequestParam("file") MultipartFile multipartFile) throws Exception{
	  ImportParams params = new ImportParams();
	  params.setTitleRows(1);
	  params.setHeadRows(1);
	  List<userInputEntity> result = ExcelImportUtil.importExcel(multipartFile.getInputStream(),userInputEntity.class, params);
	  System.out.println(JSON.toJSONString(result));
	   return true;
	   
  }
}