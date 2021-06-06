package md.cd.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 2, max = 200, message = "The event name must be between 2 and 200 characters long")
    private String name;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @Size(min = 1, message = "The location can not be empty")
    private String location;
    @Size(min = 1, message = "The state can not be empty")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @Transient
    private boolean joined;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<User> users;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Message> messages;

    public Event() {
    }

    public Event(String name, Date date, String location, String state) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isJoined() {
        return this.joined;
    }

    public boolean getJoined() {
        return this.joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
