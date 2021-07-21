package com.github.guaracyalima.poc.simil.robots.bean;

import com.captcha.botdetect.web.jsf.JsfCaptcha;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "faceletsCaptcha")
@RequestScoped
public class FaceletsCaptcha {

	private String captchaCode;
	private JsfCaptcha captcha;
	private boolean correctLabelVisible, incorrectLabelVisible;

	public FaceletsCaptcha() {
	}

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}

	public JsfCaptcha getCaptcha() {
		return captcha;
	}

	public void setCaptcha(JsfCaptcha captcha) {
		this.captcha = captcha;
	}

	public boolean isCorrectLabelVisible() {
		return correctLabelVisible;
	}

	public boolean isIncorrectLabelVisible() {
		return incorrectLabelVisible;
	}

	public void validate() {
		boolean isHuman = captcha.validate(captchaCode);

		if (isHuman) {
			correctLabelVisible = true;
			incorrectLabelVisible = false;
		} else {
			correctLabelVisible = false;
			incorrectLabelVisible = true;
		}
		this.captchaCode = "";
	}
}
