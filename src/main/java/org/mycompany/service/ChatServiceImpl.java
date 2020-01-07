package org.mycompany.service;

import org.mycompany.entity.Chat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public void save(Chat chat) {

    }

    @Override
    public List<Chat> findForCurrentUser() {
        return null;
    }
}
