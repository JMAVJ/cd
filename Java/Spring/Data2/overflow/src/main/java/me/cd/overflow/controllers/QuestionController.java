package me.cd.overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.cd.overflow.models.Answer;
import me.cd.overflow.models.Question;
import me.cd.overflow.models.Tag;
import me.cd.overflow.services.AnswerService;
import me.cd.overflow.services.QuestionService;
import me.cd.overflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dashboard(Model model) {
        model.addAttribute("questions", questionService.getAll());
        return "dashboard.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newQuestion() {
        return "newQuestion.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addQuestion(@RequestParam("question") String question, @RequestParam("tags") String subjects, RedirectAttributes redirectAttributes) {
        boolean error = false;
        List<String> errors = new ArrayList<>();
        if (question.length() < 5 || question.length() > 500) {
            errors.add("The question must be between 5 and 500 characters");
            error = true;
        }
        List<String> newSubjects = new ArrayList<>(Arrays.asList(subjects.toLowerCase().split(",")));
        if (newSubjects.size() > 3) {
            errors.add("You can add 3 tags maximum");
            error = true;
        }
        if (error) {
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:/questions/new";
        }
        List<Tag> tags = tagService.addTags(newSubjects);
        Question q = new Question(question);
        q.setTags(tags);
        q = questionService.add(q);
        return "redirect:/questions/" + q.getId();
    }

    @RequestMapping("/{id}")
    public String question(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.getById(id));
        return "question.jsp";
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public String answer(@RequestParam("answer") String answer, @RequestParam("questionId") Long questionId, RedirectAttributes redirectAttributes) {
        if (answer.length() < 5 || answer.length() > 500) {
            redirectAttributes.addFlashAttribute("error", "The anwer must be between 5 and 500 characters long");
            return "redirect:/questions/" + questionId;
        }
        Answer newAnswer = answerService.add(answer, questionService.getById(questionId));
        return "redirect:/questions/" + newAnswer.getQuestion().getId();
    }
}
