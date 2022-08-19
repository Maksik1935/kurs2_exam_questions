package sky.pro.kurs2_exam_questions.Exceptions;

import sky.pro.kurs2_exam_questions.Data.Question;

public class QuestionAlreadyAddedException extends RuntimeException{
    public QuestionAlreadyAddedException() {
        super();
    }
    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
