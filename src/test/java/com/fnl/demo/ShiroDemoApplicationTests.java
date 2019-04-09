package com.fnl.demo;

import com.fnl.demo.dao.domain.SysUser;
import com.fnl.demo.dao.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroDemoApplicationTests {

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1L);
        sysUser.setUserName("dc");
        sysUser.setFullName("邓承");
        sysUser.setPassword(BCrypt.hashpw("123",BCrypt.gensalt()));
        sysUserMapper.insert(sysUser);
    }

}
