package sky.pro.exam_question.localInterface;

import sky.pro.exam_question.models.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
