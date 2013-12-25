package com.tapestry.app.pages.kissyeditor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.Context;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.upload.services.MultipartDecoder;
import org.apache.tapestry5.upload.services.UploadedFile;

import com.tapestry.app.util.UiUtils;

public class KissyEditorUploadHander {

	@Inject
	private Context context;
	private String outUrl;
	@Inject
	private ApplicationGlobals applicationGlobals;
	@Inject
	private RequestGlobals requestGlobals;
	@Property
	private UploadedFile file;
	@Inject
	private MultipartDecoder decoder;

	void onActivate(String eid) throws Exception {
		UploadedFile file = decoder.getFileUpload("Filedata");
		// 文件保存目录路径
		String savePath = applicationGlobals.getServletContext().getRealPath(
				"/uploadImages/")
				+ "\\";
		// 文件保存目录 UR
		String saveUrl = getRequest().getContextPath() + "/uploadImages/";
		// 最大文件大小
		long maxSize = 1048576;// 1M
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			System.out.println(getError("上传目录没有写权限。"));
			return;
		}
		String dirName = eid;
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		String fileName = file.getFileName();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_"
				+ UiUtils.createFileName(fileName);
		File copied = new File(savePath + newFileName);
		long fileSize = file.getSize();
		if (fileSize > maxSize) {
			System.out.println(getError("上传文件大小超过限制。"));
			return;
		}
		file.write(copied);
		System.out.println(saveUrl);
		try {
			String url = saveUrl + newFileName;
			setOutUrl("{\"status\":\"0\" , \"imgUrl\" :\"" + url + "\"}");
		} catch (Exception e) {
			setOutUrl("{\"status\":\"1\" , \"error\" :\" error \"}");
		}
	}

	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}

	protected final HttpServletRequest getRequest() {
		return requestGlobals.getHTTPServletRequest();
	}

	public String getOutUrl() {
		return outUrl;
	}

	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}
}
