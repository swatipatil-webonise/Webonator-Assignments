import com.webonise.controller.StudentController;
import com.webonise.entity.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJPAStudentCrudApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:myapp.xml");
        StudentController controller = (StudentController) applicationContext.getBean("studentController");
        System.out.println(controller.listStudents());
    }
}
