package me.cd.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.lookify.models.Song;
import me.cd.lookify.repositories.SongRepository;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAll() {
        return songRepository.findAll();
    }
    
    public Song findSong(Long id) {
        Optional<Song> song = songRepository.findById(id); 
        if (!song.isPresent()) {
            return null;
        }
        return song.get();
    }

    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> findByArtist(String artist) {
        return songRepository.findByArtistLike(artist);
    }

    public List<Song> getTopTen() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }
}
