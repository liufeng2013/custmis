package com.tapestry.app.pages.upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.upload.services.MultipartDecoder;
import org.apache.tapestry5.upload.services.UploadedFile;

import com.tapestry.app.util.UiUtils;

public class SWFUploadHander {

	@Inject
	private ApplicationGlobals applicationGlobals;
	@Inject
	private RequestGlobals requestGlobals;
	@Property
	private UploadedFile file;
	@Inject
	private MultipartDecoder decoder;

	void onActivate() throws Exception {
		UploadedFile file = decoder.getFileUpload("Filedata");
		// 文件保存目录路径
		String savePath = applicationGlobals.getServletContext().getRealPath(
				"/uploadImages/")
				+ "\\";
		// 文件保存目录 UR
		// String saveUrl = getRequest().getContextPath() + "/uploadImages/";
		// 最大文件大小
		long maxSize = 1048576;
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			System.out.println("上传目录没有写权限。");
			return;
		}
		// 文件夹名字
		String dirName = "swfData";
		// 创建文件夹
		savePath += dirName + "/";
		// saveUrl += dirName + "/";
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
			System.out.println("上传文件大小超过限制。");
			return;
		}
		file.write(copied);
	}

	protected final HttpServletRequest getRequest() {
		return requestGlobals.getHTTPServletRequest();
	}
}
