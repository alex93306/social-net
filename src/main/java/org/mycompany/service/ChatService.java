package org.mycompany.service;

import org.mycompany.entity.Chat;

import java.util.List;

public interface ChatService {
    void save(Chat chat);
    List<Chat> findForCurrentUser();
}
