package com.manitech.bubbleup.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manitech.bubbleup.util.PathUtil;

/**
 * @description A file servlet supporting client-side caching. This servlet can
 *              also be used for images, client-side caching would become more
 *              efficient.
 * @file ImageServlet.java
 * @author jakki
 * @email jithendra@trisysit.com
 * @date Mar 21, 2016
 * @version 1.0 Mar 21, 2016
 */
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = -224126631958520053L;
	private static final int DEFAULT_BUFFER_SIZE = 10240; //
	private static final long DEFAULT_EXPIRE_TIME = 31536000000L;

	private String basePath;

	/**
	 * Initialize the servlet.
	 * 
	 * @see HttpServlet#init().
	 */
	public void init() throws ServletException {

		// Get base path (path to get all resources from) as init parameter.
		this.basePath = PathUtil.getFilePath();

		// Validate base path.
		if (this.basePath == null) {
			throw new ServletException("FileServlet init param 'basePath' is required.");
		} else {
			
			File path = new File(this.basePath);
			if (!path.exists()) {
				throw new ServletException("FileServlet init param 'basePath' value '" + this.basePath + "' does actually not exist in file system.");
			} else if (!path.isDirectory()) {
				throw new ServletException("FileServlet init param 'basePath' value '" + this.basePath + "' is actually not a directory in file system.");
			} else if (!path.canRead()) {
				throw new ServletException("FileServlet init param 'basePath' value '" + this.basePath + "' is actually not readable in file system.");
			}
		}
	}

	/**
	 * Process GET request.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Process request with content.
		
		processRequest(request, response, true);
	}

	/**
	 * Process the actual request.
	 * 
	 * @param request
	 *            The request to be processed.
	 * @param response
	 *            The response to be created.
	 * @param content
	 *            Whether the request body should be written (GET) or not
	 *            (HEAD).
	 * @throws IOException
	 *             If something fails at I/O level.
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response, boolean content) throws IOException {

		
		String requestedFile = request.getPathInfo();

		if (requestedFile == null) {
			/*
			 * Do your thing if the file is not supplied to the request URL.Throw an exception, or send 404, or show
			 * default/warning page, or just ignore it.
			 */
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		/*
		 * URL-decode the file name (might contain spaces and on) and prepare file object.
		 */
		File file = new File(basePath, URLDecoder.decode(requestedFile, "UTF-8"));

		/* Check if file actually exists in filesystem. */
		if (!file.exists()) {
			/*
			 * Do your thing if the file appears to be non-existing. Throw an exception, or send 404, or show
			 * default/warning page, or just ignore it.
			 */
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		/* Prepare some variables. The ETag is an unique identifier of the file. */
		String fileName = file.getName();
		long length = file.length();
		long lastModified = file.lastModified();
		String eTag = fileName + "_" + length + "_" + lastModified;
		long expires = System.currentTimeMillis() + DEFAULT_EXPIRE_TIME;

		/* Validate request headers for caching */

		/*
		 * If-None-Match header should contain "*" or ETag. If so, then return304.
		 */
		String ifNoneMatch = request.getHeader("If-None-Match");
		if (ifNoneMatch != null && matches(ifNoneMatch, eTag)) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			response.setHeader("ETag", eTag); // Required in 304.
			response.setDateHeader("Expires", expires); // Postpone cache with 1
														// week.
			return;
		}

		/*
		 * If-Modified-Since header should be greater than LastModified. If so, then return 304. This header is ignored
		 * if any If-None-Match header is specified.
		 */
		long ifModifiedSince = request.getDateHeader("If-Modified-Since");
		if (ifNoneMatch == null && ifModifiedSince != -1 && ifModifiedSince + 1000 > lastModified) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			response.setHeader("ETag", eTag); // Required in 304.
			response.setDateHeader("Expires", expires); // Postpone cache with 1
														// week.
			return;
		}

		/* Validate request headers for resume */

		/* If-Match header should contain "*" or ETag. If not, then return 412. */
		String ifMatch = request.getHeader("If-Match");
		if (ifMatch != null && !matches(ifMatch, eTag)) {
			response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
			return;
		}

		/*
		 * If-Unmodified-Since header should be greater than LastModified. If not, then return 412.
		 */
		long ifUnmodifiedSince = request.getDateHeader("If-Unmodified-Since");
		if (ifUnmodifiedSince != -1 && ifUnmodifiedSince + 1000 <= lastModified) {
			response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
			return;
		}

		/* Prepare and initialize response */

		/*
		 * Get content type by file name and set default GZIP support an content disposition.
		 */
		String contentType = getServletContext().getMimeType(fileName);

		/* Initialize response. */
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("ETag", eTag);
		response.setDateHeader("Last-Modified", lastModified);
		response.setDateHeader("Expires", expires);
		/* give the file to the outputstream. */
		Files.copy(file.toPath(), response.getOutputStream());

	}

	/* Helpers (can be refactored to public utility class) */

	/**
	 * Returns true if the given match header matches the given value.
	 * 
	 * @param matchHeader
	 *            The match header.
	 * @param toMatch
	 *            The value to be matched.
	 * @return True if the given match header matches the given value.
	 */
	private static boolean matches(String matchHeader, String toMatch) {
		String[] matchValues = matchHeader.split("\\s*,\\s*");
		Arrays.sort(matchValues);
		return Arrays.binarySearch(matchValues, toMatch) > -1 || Arrays.binarySearch(matchValues, "*") > -1;
	}

}