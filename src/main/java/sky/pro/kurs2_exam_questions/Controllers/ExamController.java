package sky.pro.kurs2_exam_questions.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Services.ExaminerService;
import sky.pro.kurs2_exam_questions.Services.ExaminerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/getQuestions")
    public Set<Question> getQuestions(Integer amount) {
        return examinerService.getQuestions(amount);
    }


}
