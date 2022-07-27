package sky.pro.kurs2_exam_questions.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Services.JavaQuestionService;
import sky.pro.kurs2_exam_questions.Services.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;

    public JavaQuestionController(JavaQuestionService jcs) {
        questionService = jcs;
    }

    @GetMapping("/add")
    public boolean add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public boolean remove(String question) {
        return questionService.remove(question);
    }

    @GetMapping("")
    public Set<Question> getAll() {
        return questionService.getAll();
    }

}
