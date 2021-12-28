package com.jaikar.solution.stringencoder.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class Word {
    WordService ws = new WordService();

    @GetMapping("/api/encode")
    @NotNull("The word is required.")
    @ResponseBody
    public String getEncode(@RequestParam String word) {
        return ws.encodeString(word);
    }

    @GetMapping("/api/decode")
    @NotNull("The word is required.")
    @ResponseBody
    public String getDecode(@RequestParam String word) {
        return ws.decodeString(word);
    }
}
