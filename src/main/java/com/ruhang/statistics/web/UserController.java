package com.ruhang.statistics.web;

import com.ruhang.statistics.orm.User;
import com.ruhang.statistics.orm.UserLecture;
import com.ruhang.statistics.service.UserLectureService;
import com.ruhang.statistics.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhenghui on 2017/4/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLectureService userLectureService;

    @PostMapping("/search")
    public Page<User> search(Long id) {
        return userRepository.findByIdNotNull(new PageRequest(0,10));
    }

    @PostMapping("/save")
    public void save(UserLecture userLecture) {
        userLectureService.insert(userLecture);
    }

    @PostMapping("/search/lecture")
    public void searchByUserLecture(UserLecture userLecture) {
    }
}
