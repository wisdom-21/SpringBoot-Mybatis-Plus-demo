package demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import demo.entity.UserEntity;
import demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("test")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        List<UserEntity> userEntities = userMapper.selectList(wrapper);
        return userEntities.toString();
    }

    @GetMapping(value = "callback")
    public void analyzeQRCode(HttpServletRequest request) {
        String appType = request.getHeader("user-agent");
        System.out.println(appType);
        if (appType.indexOf("AlipayClient") != -1) {
            System.out.println("支付宝");
        } else if (appType.indexOf("MicroMessenger") != -1) {
            System.out.println("微信");
        } else {
            System.out.println("其他");
        }


    }

}
