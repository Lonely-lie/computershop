package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.User;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public PagingResult<User> list(@RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<User> result = new PagingResult<>();
        List<User> items = userMapper.listUser(offset,size);
        int count = userMapper.listCount();
        result.setTotalCount(count);
        result.setItems(items);
        return result;
    }
}
