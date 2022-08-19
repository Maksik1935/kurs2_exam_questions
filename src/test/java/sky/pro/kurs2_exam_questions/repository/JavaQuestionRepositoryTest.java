package sky.pro.kurs2_exam_questions.Repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Exceptions.EmptyQuestionListException;
import sky.pro.kurs2_exam_questions.Exceptions.QuestionAlreadyAddedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.kurs2_exam_questions.Constants.TestConstants.*;

class JavaQuestionRepositoryTest {

    QuestionRepository out;

    @BeforeEach
    public void init() {
        out = new JavaQuestionRepository();
        out.add(question1.getQuestion(), question1.getAnswer());
        out.add(question2.getQuestion(), question2.getAnswer());
        out.add(question3.getQuestion(), question3.getAnswer());
    }

    @AfterEach
    public void crushOut() {
        ReflectionTestUtils.setField(out, "javaQuestions", new HashSet<>());
    }

    @Test
    public void addTest() {
        assertThrows(IllegalArgumentException.class, () ->out.add(null, null));
        assertThrows(IllegalArgumentException.class, () -> out.add(EMPTY_STRING, EMPTY_STRING));
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add("4+4", ""));
        out.add("5+5", "");
        assertEquals(out.getAll(), DEFAULT_SET_4);
    }

    @Test
    public void removeTest() {
        assertThrows(IllegalArgumentException.class, () ->out.add(null, null));
        assertThrows(IllegalArgumentException.class, () -> out.add(EMPTY_STRING, EMPTY_STRING));
        assertThrows(IllegalArgumentException.class, () -> out.remove("5+5"));
        out.remove("4+4");
        assertEquals(out.getAll(), new HashSet<Question>(Set.of(question1, question2)));
    }

    @Test
    public void getAllTest() {
        assertEquals(out.getAll(), DEFAULT_SET);
        out.remove("2+2");
        out.remove("3+3");
        out.remove("4+4");
        assertThrows(EmptyQuestionListException.class, () -> out.getAll());
    }
}