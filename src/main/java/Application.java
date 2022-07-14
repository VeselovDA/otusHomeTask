import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PrintService;
import service.QuestionService;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        var printService = (PrintService) context.getBean("printService");
        var questionService = (QuestionService) context.getBean("questionService");

        printService.printList(questionService.getAllQuestion());

    }
}
