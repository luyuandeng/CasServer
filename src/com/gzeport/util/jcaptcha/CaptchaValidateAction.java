package com.gzeport.util.jcaptcha;

import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

public final class CaptchaValidateAction extends AbstractAction {
   private ImageCaptchaService jcaptchaService;
   private String captchaValidationParameter = "_captcha_parameter";
   protected Event doExecute(final RequestContext context) {
      String captcha_response = context.getRequestParameters().get(captchaValidationParameter);
      boolean valid = false;

      if(captcha_response != null){
         String id = WebUtils.getHttpServletRequest(context).getSession().getId();
         if(id != null){
            try {
               valid = jcaptchaService.validateResponseForID(id,captcha_response).booleanValue();
            } catch (CaptchaServiceException cse) {
            }
         }
      }

      if(valid){
         return success();
      }
      return error();
   }

   public void setCaptchaService(ImageCaptchaService captchaService) {
      this.jcaptchaService = captchaService;
   }

   public void setCaptchaValidationParameter(String captchaValidationParameter) {
      this.captchaValidationParameter = captchaValidationParameter;
   }
}

