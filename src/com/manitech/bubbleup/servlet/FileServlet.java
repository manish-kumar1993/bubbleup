package  com.manitech.bubbleup.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.Constants;

public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = -1939140432219192171L;

	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	private String filePath;

	public void init() throws ServletException {
		this.filePath = Constants.getFilePath();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestedFile = request.getPathInfo();
		//System.out.println("requestedFile="+requestedFile);
		if (requestedFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		File pdfFile = new File(filePath, URLDecoder.decode(requestedFile, "UTF-8"));

		if (!pdfFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}
		// String contentType =
		// getServletContext().getMimeType(image.getName());
		// if (contentType == null ) {
		// response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
		// return;
		// }
		
		
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		//response.setContentType("application/x-download");
		response.setHeader("Content-Length", String.valueOf(pdfFile.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + pdfFile.getName() + "\"");
		Files.copy(pdfFile.toPath(), response.getOutputStream());
		
	}

}
