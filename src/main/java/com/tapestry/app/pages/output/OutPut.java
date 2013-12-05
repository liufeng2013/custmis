package com.tapestry.app.pages.output;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tapestry5.annotations.Property;


public class OutPut {

	private Date outOne;
	
	//通过get方法在页面上读出当前时间
	public Date getOutOne(){
		return new Date();
	}
	
	//通过output转换时间输出格式
	public Format getDateFormat(){
		return new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
	}
	
	/**
	 * 设置变量outTwo为可读,@Property属性有2个就是分别对应get于set方法的read与write,
	 * 使用@Property好处是可以不用写get与set方法。
	 * 注意：不是任何地方都有效，当get或set方法被调用的时候，这样写就无效了，因为找不到get或set方法。
	 */
	@Property(read=true)
	private String outTwo;
	
	//通过setupRender方法给outTwo赋值输出
	void setupRender(){
		outTwo = "通过setupRender方法给outTwo赋值输出";
	}
	
	private String outThree;
	//通过get方法读出outThree值,这里可以看到outputraw是会解析html节点的<br/>
	public String getOutThree(){
		return "hello<br/>tapestry";
	}
}