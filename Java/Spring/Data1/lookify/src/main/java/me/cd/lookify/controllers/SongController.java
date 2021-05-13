package me.cd.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.lookify.models.Song;
import me.cd.lookify.services.SongService;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("songs", songService.getAll());
        return "dashboard.jsp";
    }

    @RequestMapping("/songs/{id}")
    public String song(@PathVariable("id") Long id,Model model) {
        model.addAttribute("song", songService.findSong(id));
        return "song.jsp";
    }

    @RequestMapping("/songs/new")
    public String newSong() {
        return "new.jsp";
    }

    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String addSong(@Valid @ModelAttribute("song") Song song) {
        songService.addSong(song);
        return "redirect:/dashboard";
    }

    @RequestMapping(value="/songs/delete/{id}", method=RequestMethod.DELETE)
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteById(id);
        return "redirect:/dashboard";
    }

    @RequestMapping("/search/topTen")
    public String topTen(Model model) {
        model.addAttribute("songs", songService.getTopTen());
        return "topTen.jsp";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("artist") String artist) {
        return "redirect:/search/" + artist;
    }

    @RequestMapping("/search/{artist}")
    public String searchArtist(@PathVariable("artist") String artist, Model model) {
        model.addAttribute("artist", artist);
        model.addAttribute("songs", songService.findByArtist(artist));
        return "search.jsp";
    }
}
