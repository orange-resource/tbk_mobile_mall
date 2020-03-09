package com.orange.tbk.adminweb.controller;

import com.aliyun.oss.OSSClient;
import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.AliyunOss;
import com.orange.tbk.api.service.AliyunOssService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "aliyunOss")
public class AliyunOssController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOssController.class);

    @Reference(version = "${admin.version}", check = false)
    private AliyunOssService aliyunOssService;

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single() {

        List<AliyunOss> list = aliyunOssService.list();
        if (list == null || list.size() == 0) {
            return Response.build(ResponseCode.EMPTY);
        }

        return Response.build(ResponseCode.QUERY_SUCCESS,list.get(0));
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(AliyunOss aliyunOss) {

        aliyunOssService.create(aliyunOss);

        return Response.build(ResponseCode.SUCCESS);
    }

    /**
     * 上传图片
     */
    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public Response uploadImage(MultipartFile image) {

        try {
            String upload = this.upload(image);
            return Response.build(ResponseCode.SUCCESS,ResponseCode.SUCCESS.getDesc(),upload);
        } catch (Exception e) {
            return Response.error();
        }
    }

    private String upload(MultipartFile multipartFile) throws Exception {

        logger.info(">>>>>>>>上传文件开始");

        AliyunOss aliyunOss = aliyunOssService.single();

        OSSClient ossClient = new OSSClient(
                aliyunOss.getEndpoint(),
                aliyunOss.getKeyId(),
                aliyunOss.getKeySecret());

        String fineUrl = "";
        try {
            InputStream inputStream = multipartFile.getInputStream();

            String originalFilename = multipartFile.getOriginalFilename();
            String[] originalFilenameSplit = originalFilename.split("\\.");
            String name = originalFilenameSplit[0];
            String fileType = originalFilenameSplit[1];

            fineUrl = aliyunOss.getCatalogue() + "/" + UUID.randomUUID().toString().replaceAll("-","");
            fineUrl += "." + fileType;

            ossClient.putObject(aliyunOss.getBucketName(), fineUrl , inputStream);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }finally {
            ossClient.shutdown();
        }

        logger.info(">>>>>>>>文件类型：" + multipartFile.getContentType());
        logger.info(">>>>>>>>文件路径：" + fineUrl);
        logger.info(">>>>>>>>上传文件结束");

        return aliyunOss.getDomainName() + "/" + fineUrl + aliyunOss.getStyle();
    }

}
