package com.gzeport.casserver.yzm.servlet;

import com.ivan.zhang.CaptchaServiceSingleton;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

public class ImageCaptchaServlet extends HttpServlet {

	public ImageCaptchaServlet() {
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		byte captchaChallengeAsJpeg[] = (byte[]) null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			String captchaId = request.getSession().getId();
			java.awt.image.BufferedImage challenge = CaptchaServiceSingleton
					.getInstance().getImageChallengeForID(captchaId,
							request.getLocale());
			JPEGImageEncoder jpegEncoder = JPEGCodec
					.createJPEGEncoder(jpegOutputStream);
			jpegEncoder.encode(challenge);
		} catch (IllegalArgumentException e) {
			response.sendError(404);
			return;
		} catch (CaptchaServiceException e) {
			response.sendError(500);
			return;
		}
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0L);
		response.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = response.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	public void init() throws ServletException {
	}
}

