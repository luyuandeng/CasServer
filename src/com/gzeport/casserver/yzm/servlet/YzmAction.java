package com.gzeport.casserver.yzm.servlet;

import com.ivan.zhang.CaptchaServiceSingleton;
import com.octo.captcha.service.image.ImageCaptchaService;
import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.webflow.core.collection.ParameterMap;
import org.springframework.webflow.execution.RequestContext;

public class YzmAction {

	public YzmAction() {
	}

	public final String submit(RequestContext context) throws Exception {
		Boolean flag = Boolean.valueOf(false);
		System.out.println("YzmAction is submiting....................");
		String yzm = context.getRequestParameters().get("yzm");
		String captchaId = WebUtils.getHttpServletRequest(context).getSession()
				.getId();
		flag = CaptchaServiceSingleton.getInstance().validateResponseForID(
				captchaId, yzm);
		if (flag.booleanValue()){
			return "success";
		}else{
			context.getMessageContext().addMessage(new MessageBuilder().error().code("verification.code.error").defaultText("verification.code.error").build());
			return "error";
		}
	}
}

