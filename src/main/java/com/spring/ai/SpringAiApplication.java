package com.spring.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiApplication.class, args);
    }

}

/*
 *
 *  LLM: large language model , Usage :- image to text , text to image , chatbot etc...
 *
 *  RAG : retrieval augmented generation (used to creat personal chatbot)
 *
 *  1. Ingest(any pdf parser and embedding model) -> all kind of document e.g. csv, xlsx, pdf
 *      1.1 split doc
 *      1.2 chunks created automatically in embedding form e.g. dog = 0.6, 0.7, 0.8, 0.3
 *      1.3
 *
 *  2. Retrieval i.e. query -> any LLM , in this case openAI
 *
 *
 * */