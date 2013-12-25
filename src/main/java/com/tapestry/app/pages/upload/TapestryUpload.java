package com.tapestry.app.pages.upload;

import java.io.File;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.upload.services.UploadedFile;

public class TapestryUpload {

	@Property
	private UploadedFile file;

	void onSuccess() {
		// 上传文件到 d 盘
		File copied = new File("e:\\" + file.getFileName());
		file.write(copied);
	}
}
