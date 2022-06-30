package com.dz.springboard.controller;

import com.dz.springboard.controller.ex.*;
import com.dz.springboard.entity.User;
import com.dz.springboard.service.IUserService;
import com.dz.springboard.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** 处理用户相关请求的控制器类 */
@Slf4j
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Resource
    private IUserService userService;

    private static final Integer AVATAR_MAX_SIZE = 11534336;
    private static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/webp");
    }
    ArrayList<String> list = new ArrayList<>(AVATAR_TYPE);

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK, "OK");
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User data = userService.login(username,password);
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());
        log.info("getuidFromSession: {}",getuidFromSession(session));
        log.info("getUsernameFromSession: {}",getUsernameFromSession(session));

        return new JsonResult<>(OK,"登录成功",data);
    }

    @RequestMapping("updatepassword")
    public JsonResult<Void> updatePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.updatePasswordByUid(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK,"OK");
    }

    @RequestMapping("getbyuid")
    public JsonResult<User> getByUid(HttpSession session){
        User date = userService.getByUid(getuidFromSession(session));
        return new JsonResult<>(OK,"OK",date);

    }
    @RequestMapping("updateinfo")
    public JsonResult<Void> updateInfo(User user, HttpSession session){
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.updateInfoByUid(uid,username,user);
        return new JsonResult<>(OK,"OK");
    }

    /*@RequestMapping("updateavatar")
    public JsonResult<String> updateAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
        log.info("UpdateAvatarOK");
        if (file.isEmpty()){
            throw new FileEmptyException("FileNull");
        }
        if (file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("FileSizeMax");
        }
        if (!AVATAR_TYPE.contains(file.getContentType())){
            throw new FileTypeException("FileTypeNo");
        }
        log.info(file.getContentType());
        log.info(String.valueOf(file.getSize()));
        String str = "\"C:\\Users\\zhang\\Desktop\\FileUpload\"";
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if (!dir.exists()){
            dir.mkdirs();
        }
        log.info(String.valueOf(dir));
        String originalFilename = file.getOriginalFilename();
        log.info(originalFilename);
        String filename = UUID.randomUUID().toString().toUpperCase() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File dest = new File(dir,filename);
        try {
            file.transferTo(dest);
        } catch (FileStateException e){
            throw new FileStateException(e);
        } catch (IOException e) {
            throw new FileUploadIOException(e);
        }
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + filename;
        userService.updateAvatarByUid(uid,avatar,username);
        return new JsonResult<>(OK,avatar);
    }*/
    /*@RequestMapping("updateAvatar")
    public JsonResult<String> updateAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return new JsonResult<>(PARAM_ERROR, "文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            return new JsonResult<>(PARAM_ERROR, "文件大小超过限制");
        }
        if (!AVATAR_TYPE.contains(file.getContentType())) {
            return new JsonResult<>(PARAM_ERROR, "文件类型错误");
        }
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newFileName = UUID.randomUUID().toString() + "." + suffix;
        String path = "upload/" + newFileName;
        log.info(path);
        File dest = new File(path);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult<>(SERVER_ERROR, "服务器错误");
        }
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer integer = userService.updateAvatarByUid(uid, newFileName, username);
        log.info(String.valueOf(integer));
        return new JsonResult<>(OK);
    }*/
}
