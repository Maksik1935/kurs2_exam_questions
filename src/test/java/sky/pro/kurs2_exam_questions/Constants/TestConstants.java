package sky.pro.kurs2_exam_questions.Constants;
import sky.pro.kurs2_exam_questions.Data.Question;

import java.util.HashSet;
import java.util.Set;

public class TestConstants {
    public static final Question question1 = new Question("2+2", "4");
    public static final Question question2 = new Question("3+3", "6");
    public static final Question question3 = new Question("4+4", "Unknown Answer");
    public static final Question question4 = new Question("5+5", "Unknown Answer");

    public static final Set<Question> EMPTY_SET = new HashSet<>();
    public static final Set<Question> DEFAULT_SET = new HashSet<>(Set.of(question1, question2, question3));
    public static final Set<Question> DEFAULT_SET_4 = new HashSet<>(Set.of(question1, question2, question3, question4));

    public static final String EMPTY_STRING = "";
    public static final String UNKNOWN_STRING = "Unknown Answer";
    public static final String STRING2 = "2+2";
    public static final String STRING3 = "3+3";
    public static final String STRING4 = "4+4";

    public static final Set<Question> RND_SET_1 = new HashSet<>(Set.of(question1, question2));
    public static final Set<Question> RND_SET_2 = new HashSet<>(Set.of(question1, new Question("5+5", null)));
    public static final Set<Question> RND_SET_3 = new HashSet<>(Set.of(new Question("5+5", null),
            new Question("6+6", null)));
}
