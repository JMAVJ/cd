package md.cd.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import md.cd.events.models.Event;
import md.cd.events.models.Message;
import md.cd.events.models.User;
import md.cd.events.services.EventService;
import md.cd.events.services.MessageService;
import md.cd.events.services.UserService;
import md.cd.events.validators.EventValidator;

@Controller
@RequestMapping("/events")
public class EventController {
    private final UserService userService;
    private final EventService eventService;
    private final MessageService messageService;
    private final EventValidator eventValidator;

    public EventController(UserService userService, EventService eventService, MessageService messageService, EventValidator eventValidator) {
        this.userService = userService;
        this.eventService = eventService;
        this.messageService = messageService;
        this.eventValidator = eventValidator;
    }
    
    @RequestMapping("")
    public String events(Model model, HttpSession session) {
        User u = userService.findById((Long) session.getAttribute("userId"));
        model.addAttribute("user", u);
        model.addAttribute("event", new Event());
        List<Event> stateEvents = eventService.findByState(u.getState());
        for (Event event : stateEvents) {
            if (u.getJoinedEvents().contains(event)) {
                event.setJoined(true);
            }
        }
        List<Event> eventsInOtherStates = eventService.findByStateNot(u.getState());
        for (Event event : eventsInOtherStates) {
            if (u.getJoinedEvents().contains(event)) {
                event.setJoined(true);
            }
        }
        model.addAttribute("stateEvents", stateEvents);
        model.addAttribute("eventsInOtherStates", eventsInOtherStates);
        return "events.jsp"; 
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
        eventValidator.validate(event, result);
        if (result.hasErrors()) {
            User u = userService.findById((Long) session.getAttribute("userId"));
            model.addAttribute("user", u);
            return "events.jsp";
        }
        User u = userService.findById((Long) session.getAttribute("userId"));
        event.setAuthor(u);
        eventService.create(event);
        return "redirect:/events/" + event.getAuthor().getId();
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinEvent(@RequestParam("eventId") Long eventId, HttpSession session) {
        Event event = eventService.findById(eventId);
        User user = userService.findById((Long) session.getAttribute("userId"));
        userService.joinEvent(user, event);
        return "redirect:/events";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String leaveEvent(@RequestParam("eventId") Long eventId, HttpSession session) {
        Event event = eventService.findById(eventId);
        User user = userService.findById((Long) session.getAttribute("userId"));
        userService.leaveEvent(user, event);
        return "redirect:/events";
    }

    @RequestMapping("/{id}")
    public String event(@PathVariable("id") Long id, Model model) {
        model.addAttribute("e", eventService.findById(id));
        return "event.jsp";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String addMessage(@RequestParam("eventId") Long eventId, @RequestParam("message") String content,HttpSession session) {
        Event event = eventService.findById(eventId);
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        User user = userService.findById(userId);
        Message m = new Message(content, event, user);
        messageService.add(m);
        return "redirect:/events/" + eventId;
    }

    @RequestMapping("/edit/{id}")
    public String editMessageView(@PathVariable("id") Long id, Model model, HttpSession session) {
        Event e = eventService.findById(id);
        if (!session.getAttribute("userId").equals(e.getAuthor().getId())) {
            return "redirect:/events";
        }
        model.addAttribute("e", e);
        String eventDate = e.getDate().toString().split(" ")[0];
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("editedEvent", new Event());
        return "editEvent.jsp";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editMessage(@RequestParam("eventId") Long eventId, @ModelAttribute("editedEvent") Event editedEvent) {
        Event e = eventService.findById(eventId);
        eventService.editEvent(editedEvent, e);
        return "redirect:/events/" + eventId;
    }
}
