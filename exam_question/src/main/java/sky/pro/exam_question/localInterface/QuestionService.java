package sky.pro.exam_question.localInterface;

import sky.pro.exam_question.models.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String qustion,String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
