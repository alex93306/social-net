package org.mycompany.controller;

import org.mycompany.entity.AppUser;
import org.mycompany.entity.Chat;
import org.mycompany.form.CreateChatForm;
import org.mycompany.service.AppUserService;
import org.mycompany.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChatController {

    //todo: autowird warning
    @Autowired protected ChatService chatService;
    @Autowired protected AppUserService appUserService;

    @GetMapping("/createChat")
    public ModelAndView showCreateChatPage() {
        List<AppUser> userList = appUserService.findAll();

        ModelAndView modelAndView = new ModelAndView("createChat");
        modelAndView.addObject(new CreateChatForm());
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }

    @PostMapping("/createChat")
    public String createNewChat(CreateChatForm createChatForm) {

        //todo: validate
        //todo: if chat exist, then don't create a new one, but just redirect there
        //todo: maybe move to separate class e. g. ChatTranslator
        Chat chat = buildChat(createChatForm);
        chatService.save(chat);
//        todo: save appUser

        return "redirect://chats";
//                todo:
//        return "redirect://chats/" + chat.getChatID();
    }

    protected Chat buildChat(CreateChatForm createChatForm) {
        Chat chat = new Chat();
        chat.setName(createChatForm.getName());

        AppUser interlocutorAppUser = appUserService.find(createChatForm.getMemberAppUserID());
        interlocutorAppUser.addChat(chat);

        AppUser currentAppUser = appUserService.getCurrentAppUser();
        currentAppUser.addChat(chat);

        //todo: maybe add feature when add to one side other sync auto
        chat.addChatMember(interlocutorAppUser);
        chat.addChatMember(currentAppUser);

        return chat;
    }

    @GetMapping("/chats")
    public String showAllChats() {
        List<Chat> chatList = chatService.findForCurrentUser();

        return "chatList";
    }

    @GetMapping("/chats/{chatID}")
    public String showChatMessages(@PathVariable long chatID) {
        return "chatMessageList";
    }
}
