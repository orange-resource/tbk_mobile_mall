package com.orange.tbk.adminweb.config;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@Slf4j
@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public Response httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e) {
        return Response.build(ResponseCode.SUBMISSION_AGREEMENT_ERROR);
    }

    @ExceptionHandler(value = MultipartException.class)
    public Response multipartExceptionHandler(MultipartException e) {
        return Response.build(ResponseCode.CONTENT_IS_TOO_LARGE);
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public Response maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        return Response.build(ResponseCode.CONTENT_IS_TOO_LARGE);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Response httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        return Response.build(ResponseCode.PARAMETER_ERROR);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Response httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return Response.build(ResponseCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED);
    }

    @ExceptionHandler(value = ServletRequestBindingException.class)
    public Response servletRequestBindingExceptionHandler(ServletRequestBindingException e) {
        return Response.build(ResponseCode.PARAMETER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return Response.build(ResponseCode.PARAMETER_ERROR, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(Exception ex) {
        String name = ex.getClass().getName();
        log.error("\n项目异常：class: {} - {}", name, ExceptionUtil.stacktraceToString(ex));
        return Response.build(ResponseCode.UNKNOWN);
    }

    @ExceptionHandler(value = Throwable.class)
    public Response throwableHandler(Throwable t) {
        String name = t.getClass().getName();
        log.error("\n项目异常：class: {} - {}", name, ExceptionUtil.stacktraceToString(t));
        return Response.build(ResponseCode.UNKNOWN);
    }

}
