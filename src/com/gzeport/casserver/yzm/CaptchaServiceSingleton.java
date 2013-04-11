package com.gzeport.casserver.yzm;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;


public class CaptchaServiceSingleton {

	public CaptchaServiceSingleton() {
	}

	public static ImageCaptchaService getInstance() {
		return instance;
	}

	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService(
			new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000,
			75000);

}


