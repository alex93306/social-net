package org.mycompany.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Chat {

    @Id
    @GeneratedValue
    private Long chatID;
    private String name;
//    private String pictureUrl
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<AppUser> chatMembers = new HashSet<>();

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Set<AppUser> getChatMembers() {
        return chatMembers;
    }

    protected void setChatMembers(Set<AppUser> chatMembers) {
        this.chatMembers = chatMembers;
    }

    public void addChatMember(AppUser appUser) {
        this.chatMembers.add(appUser);
    }
}
