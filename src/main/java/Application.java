import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import persistence.model.Question;
import service.PrintService;
import service.QuestionService;
import service.TestingService;

import java.util.List;

@ComponentScan(basePackages = "config,service")
@Component
public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);

        var printService = (PrintService) context.getBean("printService");
        var questionService = (QuestionService) context.getBean("questionService");
        var testingService = (TestingService) context.getBean("testingService");

        List<Question> allQuestion = questionService.getAllQuestion();
        printService.printList(allQuestion);
        testingService.startTest(allQuestion);
    }
}
