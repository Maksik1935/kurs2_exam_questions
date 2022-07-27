package sky.pro.kurs2_exam_questions.Services;

import org.springframework.stereotype.Service;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Exceptions.EmptyQuestionListException;
import sky.pro.kurs2_exam_questions.Exceptions.IncorrectMethodException;

import java.util.Random;
import java.util.Set;

@Service
public class MathQuestionService implements QuestionService{
    @Override
    public boolean add(String question, String answer) {
        throw new IncorrectMethodException();
    }

    @Override
    public boolean remove(String question) {
        throw new IncorrectMethodException();
    }

    @Override
    public Set<Question> getAll() {
        throw new IncorrectMethodException();
    }

    @Override
    public Question getRandomQuestion() {
        int num1 = new Random().nextInt(1000);
        int num2 = new Random().nextInt(1000);
        char op = 'X';
        switch (new Random().nextInt(4)){
            case 0: op = '+';
            case 1: op = '-';
            case 2: op = '*';
            case 3: op = '/';
        }
        StringBuilder sbr = new StringBuilder(num1 + op + num2 + " =");
        return new Question(sbr.toString(), null);
    }
}
