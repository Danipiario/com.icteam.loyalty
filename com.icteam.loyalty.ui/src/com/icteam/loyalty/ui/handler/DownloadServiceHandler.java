package com.icteam.loyalty.ui.handler;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rap.rwt.service.ServiceHandler;

public class DownloadServiceHandler implements ServiceHandler {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Which file to download?
        String fileName = request.getParameter("filename");

        // Get the file content

        try {
            File file = new File(new File(Platform.getInstanceLocation().getDefault().toURI()), fileName);
            byte[] download = FileUtils.readFileToByteArray(file);

            // Send the file in the response
            response.setContentType("application/octet-stream");
            response.setContentLength(download.length);

            String contentDisposition = "attachment; filename=\"" + fileName + "\"";
            response.setHeader("Content-Disposition", contentDisposition);
            response.getOutputStream().write(download);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}