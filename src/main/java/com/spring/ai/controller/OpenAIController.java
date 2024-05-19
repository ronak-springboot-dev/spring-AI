package com.spring.ai.controller;

import com.spring.ai.model.Book;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/openai")
@RestController
public class OpenAIController {


    private final ChatClient chatClient;

    public OpenAIController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public Book getResponse(@RequestParam String query) {

        //output parser to parse any type
        BeanOutputParser<Book> beanOutputParser = new BeanOutputParser<>(Book.class);

        String format = beanOutputParser.getFormat();

        String message = """
                you are a chatbot who is handling library  
                give me all author's book name based on author's name as input {input}
                if, you don't have data then return data is unavailable    
                {format}    
                """;

        //creates new optimized prompt  to send to the chat-based AI service
        PromptTemplate promptTemplate = new PromptTemplate(message);


        //Representation of the dynamic question based on parameter
        Prompt prompt = promptTemplate.create(Map.of("input", query,
                "format", format));


        Generation generation = chatClient.call(prompt).getResult();

        return beanOutputParser.parse(generation.getOutput().getContent());

    }

}
