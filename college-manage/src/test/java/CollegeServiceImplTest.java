import com.college.common.entity.College;
import com.college.common.service.CollegeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Hunter on 2020-01-10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
public class CollegeServiceImplTest {

    @Autowired
    private CollegeService collegeService;

    @Test
    public void test(){
        List<College> list = collegeService.getList();
        System.out.println(list);
    }

    @Test
    public void add(){
        College college = new College();
        college.setCname("aa");
        college.setCaddress("aa");
        college.setCreatetime(new Date());
        college.setCid(1);
        college.setCpic("#");

        System.out.println(collegeService.addCollege(college));
    }

}
