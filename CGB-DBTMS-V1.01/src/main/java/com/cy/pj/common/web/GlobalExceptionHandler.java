package com.cy.pj.common.web;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cy.pj.common.vo.JsonResult;

import lombok.extern.slf4j.Slf4j;
/**
 *  Spring MVC 全局异常处理
 *  @ControllerAdvice 描述的类为全局异常处理类,
 *  此类内部可以定义很多异常处理方法
 */
//@ControllerAdvice
@RestControllerAdvice //此类也会交给spring管理
@Slf4j
public class GlobalExceptionHandler {
	 @ExceptionHandler(BindException.class)
	 public JsonResult doHandleBindException(
			 BindException e) {
		 log.error(e.getMessage(),e);
		 FieldError fr=
		 e.getBindingResult().getFieldError();
		 JsonResult r=new JsonResult();
		 r.setState(0);
		 r.setMessage(fr.getDefaultMessage());
		 return r;
	 }
	 /**
	  * @ExceptionHandler 注解描述的方法为异常处理方法
	  */
	   @ExceptionHandler(RuntimeException.class)
	   //@ResponseBody
	   public JsonResult doHandleRuntimeException(
			   RuntimeException e) {
		   e.printStackTrace();
		   return new JsonResult(e);
	   }
}
