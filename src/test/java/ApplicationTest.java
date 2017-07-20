import com.ruhang.statistics.Application;
import com.ruhang.statistics.orm.*;
import com.ruhang.statistics.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhenghui on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {
    @Resource
    private UserRepository repository;

    @Test
    public void test(){
        //查询所有
        List<User> userList = repository.findAll();
        User user = userList.get(0);
        System.out.println("user->"+user.getId());

        //分页 注意：页码在mongodb中是从0开始的。

        List<Order> orders = new ArrayList<Order>();

        PageRequest pageRequest = new PageRequest(0,10);
        Page<User> pageList = repository.findAll(pageRequest);

        pageList = repository.findByNameLike("郑辉",pageRequest);

        pageList = repository.findByAgeGreaterThan(10,pageRequest);

//        pageList = repository.findByIdNotNull(pageRequest);
//
//        pageList = repository.findByAgeBetween(9,31,pageRequest);

        System.out.println("Total->"+pageList.getTotalElements());
        System.out.println("Total page->"+pageList.getTotalPages());
        System.out.println("Content->"+pageList.getContent());
        for(User puser : pageList){
            System.out.println("puser->"+puser.getName());
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void testTemplet(){
        User user = userService.findById("58eca4385a98cd3d40e526ac");
        System.out.println("查询某个值:"+user.getName());
//        user = new User(null,"测试郑",12);
//        userService.insert(user);

        User criteriaUser = new User(null, null, 10);
        List<User> list = userService.find(criteriaUser, 1, 10);
        if(!CollectionUtils.isEmpty(list)){
            for(User tuser : list){
                System.out.println(tuser.getName()+":"+tuser.getAge());
            }
        }
    }

    @Autowired
    private UserVisitService userVisitService;
    @Test
    public void testUserVisit(){
        UserVisit userVisit = new UserVisit();
        String url = "http://baidu.com/";
        userVisit.setCurrentUrl(url);
        userVisit.setRefererUrl(url);
        userVisit.setUserId(-1);
        userVisit.setVisitTime(new Date());
        userVisit.setStayTime(new Date());
        userVisit.setIp("127.0.0.1");
        userVisit.setGid("AAAAAAAAA");
        userVisitService.insert(userVisit);
    }

    @Autowired
    private UserLectureService userLectureService;

    @Test
    public void testLecture(){
        UserLecture userLecture = new UserLecture();
        userLecture.setUserId(1);
        userLecture.setCourseId(2);
        userLecture.setLectureId(3);
        userLecture.setLastProgress(10);
        userLecture.setStayTime(12);
        userLecture.setProgress(13);
        userLecture.setCtime(new Date());
        userLectureService.insert(userLecture);
    }

    @Autowired
    private UserLectureHandoutService handoutService;

    @Test
    public void testLectureHandout(){
        UserLectureHandout handout = new UserLectureHandout();
        handout.setUserId(1);
        handout.setCourseId(2);
        handout.setLectureId(3);
        handout.setIp("127.0.0.1");
        handout.setGid("BBBBBBBBBBBBBBBBBBBBB");
        handout.setCtime(new Date());
        handoutService.insert(handout);
    }

    @Autowired
    private UserLectureRecordService recordService;

    @Test
    public void  testUserLectureRecord(){
        UserLectureRecord record = new UserLectureRecord();
        record.setUserId(1);
        record.setCourseId(2);
        record.setLectureId(3);
        record.setStayTime(4);
        record.setProgress(10);
        record.setIp("127.0.0.1");
        record.setGid("CCCCCCCCCCCCCCCCCCCC");
        recordService.insert(record);
    }

    @Autowired
    private UserLectureScoreService scoreService;

    @Test
    public void testUserLectureScore(){
        UserLectureScore score = new UserLectureScore();
        score.setUserId(1);
        score.setCourseId(2);
        score.setLectureId(3);
        score.setClarity(4);
        score.setFluency(true);
        score.setWittySpeech(5);
        score.setSuggest("建议");
        score.setIp("127.0.0.1");
        score.setGid("DDDDDDDDDDDDDDDDDDDDDDDD");
        score.setCtime(new Date());
        scoreService.insert(score);
    }

}
