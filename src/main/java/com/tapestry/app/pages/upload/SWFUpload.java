package com.tapestry.app.pages.upload;

import org.apache.tapestry5.annotations.Import;

@Import(library={"context:assets/js/swfupload/swfupload.js", 
"context:assets/js/swfupload/swfupload.queue.js", 
"context:assets/js/swfupload/fileprogress.js", 
"context:assets/js/swfupload/handlers.js"}, 
stylesheet="context:assets/style/default.css")
public class SWFUpload {
}
