package com.tapestry.app.pages.upload;

import java.io.File;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.MultipartDecoder;
import org.apache.tapestry5.upload.services.UploadedFile;

public class UploadTypeFile {

	@Property
	private UploadedFile file;
	@Inject
	private MultipartDecoder decoder;

	void onActivate(String to) {
		file = decoder.getFileUpload("filename");
		File copied = new File("e:\\", file.getFileName());
		file.write(copied);
	}
}
