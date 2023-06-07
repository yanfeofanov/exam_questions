package sky.pro.exam_question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.exam_question.localInterface.ExaminerService;
import sky.pro.exam_question.models.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> examinerRandomQuestion(@PathVariable int amount){
        return examinerService.getQuestion(amount);
    }
}
