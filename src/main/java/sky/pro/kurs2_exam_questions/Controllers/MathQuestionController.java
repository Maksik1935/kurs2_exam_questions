package sky.pro.kurs2_exam_questions.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.kurs2_exam_questions.Data.Question;

import sky.pro.kurs2_exam_questions.Services.MathQuestionService;
import sky.pro.kurs2_exam_questions.Services.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private QuestionService questionService;

    public MathQuestionController(MathQuestionService mqs) {
        questionService = mqs;
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
