package org.neojo.web.util;

import org.neojo.web.util.mail.MailInfo;
import org.neojo.web.util.mail.SimpleMail;

public class Email {
	public static void main(String title,String content) {  
        MailInfo mailInfo = new MailInfo();  
        mailInfo.setMailServerHost("smtp.qq.com");  
        mailInfo.setMailServerPort("465");  
        mailInfo.setValidate(true);  
        mailInfo.setUsername("");  
        mailInfo.setPassword(""); 
        mailInfo.setFromAddress("");  
        mailInfo.setToAddress("");  
        mailInfo.setSubject(title);
                  
        //附件  
//        String[] attachFileNames={"d:/Sunset.jpg"};  
//        mailInfo.setAttachFileNames(attachFileNames);  
          
        // 这个类主要来发送邮件  
        //mailInfo.setContent("设置邮箱内容");  
        //SimpleMail.sendTextMail(mailInfo);// 发送文体格式  
        StringBuffer demo = new StringBuffer();  
        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")  
        .append("<html>")  
        .append("<head>")  
        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")  
        .append("<title>"+title+"</title>") 
        .append("</head>")
        .append("<body>")
        .append(content)
        .append("</body>")
        .append("</html>"); 
        mailInfo.setContent(demo.toString());  
        SimpleMail.sendHtmlMail(mailInfo);// 发送html格式  
    }  
}
