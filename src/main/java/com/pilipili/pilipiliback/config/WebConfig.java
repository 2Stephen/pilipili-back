package com.pilipili.pilipiliback.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${app.avatar.upload-dir}")
    private String avatarUploadDir;
    @Value("${app.cover.upload-dir}")
    private String coverUploadDir;
    @Value("${app.video.upload-dir}")
    private String videoUploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/avatars/**")
                .addResourceLocations("file:" + avatarUploadDir);
        registry.addResourceHandler("/covers/**")
                .addResourceLocations("file:" + coverUploadDir);
        registry.addResourceHandler("/videos/**")
                .addResourceLocations("file:" + videoUploadDir);
    }
}
