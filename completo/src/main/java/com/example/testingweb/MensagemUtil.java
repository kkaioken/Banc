package com.example.testingweb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {
	public static void mensagemInfo(String mensagem) {
		FacesMessage mensagemJSF = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagemJSF);
	}
	
	public static void mensagemErro(String mensagem) {
		FacesMessage mensagemJSF = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagemJSF);
	}
	
	public static void mensagemAviso(String mensagem) {
		FacesMessage mensagemJSF = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagemJSF);
	}
}
