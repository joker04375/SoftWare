package com.example.ruangong.controller;

import com.example.ruangong.Utils.UserHolder;
import com.example.ruangong.dao.GoodsDao;
import com.example.ruangong.pojo.Goods;
import com.example.ruangong.pojo.Result;
import com.example.ruangong.pojo.User;
import com.example.ruangong.service.CartService;
import com.example.ruangong.service.GoodsService;
import com.example.ruangong.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Value("${path.upload}")
    private String upLoadPath;

    @Value("${path.domain}")
    private String domain;

    //展示商品
    @GetMapping("/showGoods")
    public Result showGoods(){
        List<Goods> goods = goodsService.selectGoods(null);
        return Result.ok(goods);
    }

    //展示某个商品
    @GetMapping("/showGoods/{id}")
    public Result GoodsInfo(@PathVariable("id") Long id){
        List<Goods> goods = goodsService.selectGoods(id);
        return Result.ok(goods);
    }

    @PostMapping("/upload/{id}")
    public String uploadHeader(@PathVariable("id") Long id,MultipartFile ImageFile, Model model){
        String filename = ImageFile.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if(StringUtils.isBlank(suffix)){
            model.addAttribute("error","文件格式不正确");
            return "/site/setting";
        }

        // 生成随机文件名
        filename = generateUUID() + suffix;

        // 确定文件存放的路径
        File file = new File(upLoadPath + "/" + filename);
        try {
            // 存储文件
            ImageFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("上传文件失败，服务器发生异常");
        }

        // 更新当前用户头像的路径(web访问路径)
        // http://localhost:8080/community/user/header/xxx.png
        User user = UserHolder.getUser();
        String headerUrl = domain +  "/image/" + filename;
        goodsService.updateImage(id,headerUrl);

        return "redirect:/index";
    }

    @GetMapping("/image/{fileName}")
    public void getHeader(@PathVariable("fileName") String fileName, HttpServletResponse response){
        // 服务器存放路径
        fileName = upLoadPath + "/" + fileName;

        // 解析文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        // 响应图片
        response.setContentType("image/" + suffix);
        try(
                ServletOutputStream os = response.getOutputStream();
                FileInputStream fis = new FileInputStream(fileName);
        ) {
            byte[] buffer = new byte[1024];
            int b = 0;
            while((b = fis.read(buffer)) != -1){
                os.write(buffer,0,b);
            }
        } catch (IOException e) {
            throw new RuntimeException("读取图片失败");
        }
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
