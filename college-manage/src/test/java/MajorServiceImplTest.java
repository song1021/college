import com.college.common.entity.Major;
import com.college.common.entity.Page;
import com.college.common.service.MajorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Hunter on 2020-01-10.
 */
// @RunWith注解表示运行在Spring容器中，包括controller，service，dao等
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
public class MajorServiceImplTest {

    @Autowired
    private MajorService majorService;

    @Test
    public void test(){
        List<Major> list = majorService.getList(1);
        System.out.println(list);
    }

    @Test
    public void add(){
        Major major = new Major();
        for (int i = 0; i<20;i++){
            major.setCid(1);
            major.setMname("测试"+i);
            major.setCredit(20);
            System.out.println(majorService.add(major));
        }
    }

    @Test
    public void update(){
        Major major = majorService.getById(1);
        major.setIntroduction("自我介绍哈哈");
        System.out.println(majorService.update(major));
    }

    @Test
    public void delete(){
        System.out.println(majorService.delete(1));
    }

    @Test
    public void getAll(){
        List<Major> list = majorService.getAll();
        for(Major major:list){
            System.out.println(major);
        }
    }

    @Test
    public void getAll2(){
        Major major = new Major();
        Page<Major> pageInfo = majorService.getAll(major, 1, 2);
        System.out.println("当前页："+pageInfo.getPageNo());
        System.out.println("每页条数："+pageInfo.getPageSize());
        System.out.println("总页数："+pageInfo.getPageCount());
        for(Major item : pageInfo.getList()){
            System.out.println(item);
        }
    }
}
