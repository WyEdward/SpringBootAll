package cn.wyedward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private JavaMailSender jms;
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 发送一封简单的邮箱
     * @return
     */
    @RequestMapping("/sendSimpleEmail")
    @ResponseBody
    public String sendSimpleEmail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("****.***"); //接收地址
            message.setSubject("一封简单的邮箱"); //标题
            message.setText("使用Spring boot发送简单邮箱");  //内容
            jms.send(message);
            return "发送成功";
        } catch (MailException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 发送html邮箱
     * @return
     */
    @RequestMapping("/sendHtmlEmail")
    @ResponseBody
    public String sendHtmlEmail(){
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("****.***");   //接收地址
            helper.setSubject("一封Html格式的邮件"); //标题
            // 带HTML格式的内容
            StringBuffer sb = new StringBuffer("<p style='color:#6db33f'>使用Spring Boot发送HTML格式邮件。</p>");
            helper.setText(sb.toString(), true);
            jms.send(message);
            return "发送成功";
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("sendAttachmentsMail")
    @ResponseBody
    public String sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("****.***"); // 接收地址
            helper.setSubject("一封带附件的邮件"); // 标题
            helper.setText("详情参见附件内容！"); // 内容
            // 传入附件
            FileSystemResource file = new FileSystemResource(new File("E:\\ideawork\\SpringBootAll\\springboot_email\\src\\main\\resources\\static\\file\\文档.txt"));
            helper.addAttachment("文档.txt", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 发送带有静态资源的邮件
     * @return
     */
    @RequestMapping("/sendInlineMail")
    @ResponseBody
    public String sendInlineMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("****.***"); // 接收地址
            helper.setSubject("一封带静态资源的邮件"); // 标题
            helper.setText("<html><body>博客图：<img src='cid:img'/></body></html>", true); // 内容
            // 传入附件
            FileSystemResource file = new FileSystemResource(new File("E:\\ideawork\\SpringBootAll\\springboot_email\\src\\main\\resources\\static\\img\\sun.jpg"));
            helper.addInline("img", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/sendTemplateEmail")
    @ResponseBody
    public String sendTemplateEmail(String code) {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("****.***"); // 接收地址
            helper.setSubject("邮件摸板测试"); // 标题
            // 处理邮件模板
            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
