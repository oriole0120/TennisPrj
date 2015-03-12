package com.htmtennis.prj.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport{
	private int index = 0;
	private int count = 0;
	private String var = null;
	
	
	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doStartTag() throws JspException {
		if(var != null)
		pageContext.setAttribute("var", index);
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		if(var != null)
		pageContext.removeAttribute("var");
		
		return EVAL_PAGE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		index++;
		if(var != null)
		pageContext.setAttribute("var", index);
		if (index < count)
			return EVAL_BODY_AGAIN;
		else
			return SKIP_BODY;
	}

}