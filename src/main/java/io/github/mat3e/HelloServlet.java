package io.github.mat3e;

import java.util.Optional;

public class HelloServlet
{
    String FallBack_name = "World";
    Lang FallBack_lang = new Lang(1,"Hello","en");

    LangRepository repository;

    public HelloServlet()
    {
        this(new LangRepository());
    }

    public HelloServlet (LangRepository repository)
    {
        this.repository = repository;
    }

    String preaperGreetings(String name, String lang)
    {
        String message_name = Optional.ofNullable(name).orElse(FallBack_name);
        Integer iD = Optional.ofNullable(lang).map(Integer::valueOf).orElse(FallBack_lang.getiD());
        String message_greetings = repository.findById(iD).orElse(FallBack_lang).getMessage();

        return  message_greetings+" "+message_name+"!";
    }

}
