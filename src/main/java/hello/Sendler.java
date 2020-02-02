package hello;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sendler {
    String name;
    String email;
    String content;

    public void send(String name, String email, String content) throws MessagingException {
        this.name = name;
        this.email = email;
        this.content = content;


        Properties properties = new Properties();
        //Хост или IP-адрес почтового сервера
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        //Требуется ли аутентификация для отправки сообщения
        properties.put("mail.smtp.auth", "true");
        //Порт для установки соединения
        properties.put("mail.smtp.socketFactory.port", "465");
//        //Фабрика сокетов, так как при отправке сообщения Yandex требует SSL-соединения
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //Создаем соединение для отправки почтового сообщения
        Session session = Session.getDefaultInstance(properties,
                //Аутентификатор - объект, который передает логин и пароль
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("cap0neal@yandex.ru", "KaTe120892");
                    }
                });

        //Создаем новое почтовое сообщение
        Message message = new MimeMessage(session);
        //От кого
        message.setFrom(new InternetAddress("cap0neal@yandex.ru"));
        //Кому
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("fboom-ekb@yandex.ru"));
        //Тема письма
        message.setSubject("Очень важное письмо от " + name);
        //Текст письма
        message.setText("Email: " + email + "\n" + content);
        //Поехали!!!
        Transport.send(message);
    }
}


