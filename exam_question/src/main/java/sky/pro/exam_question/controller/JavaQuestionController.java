package sky.pro.exam_question.controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.exam_question.localInterface.QuestionService;
import sky.pro.exam_question.models.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public Question javaQuestionAdd(@RequestParam(required = false, value = "question") String question,@RequestParam(required = false,value = "answer") String answer){
        return javaQuestionService.add(question,answer);
    }

    @GetMapping(path = "/remove")
    public Question javaQuestionRemove(@RequestParam(required = false,value = "question") String question,@RequestParam(required = false,value = "answer")String answer){
        return javaQuestionService.remove(new Question(question,answer));
    }

    @GetMapping(path = "/exam/java")
    public Collection<Question> javaQuestionPrint(){
        return javaQuestionService.getAll();
    }


}
