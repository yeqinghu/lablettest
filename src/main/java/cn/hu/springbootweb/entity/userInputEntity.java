package cn.hu.springbootweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
@TableName("ums")
public class userInputEntity {
	@TableId(value="number",type=IdType.AUTO)
	 @Excel(name="序号")
	 private String number;	
	 @Excel(name = "姓名")
	 private String name;
	 @Excel(name = "岗位")
	 private String jobsName;
	 @Excel(name = "身份证号")
	  private String id;
	  @Excel(name = "厂址")
	  private String address;
	 

}
