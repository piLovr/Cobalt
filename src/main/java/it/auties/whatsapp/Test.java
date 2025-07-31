package it.auties.whatsapp;

import it.auties.whatsapp.api.QrHandler;
import it.auties.whatsapp.api.WebHistorySetting;
import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.info.MessageInfo;
import it.auties.whatsapp.model.node.Node;

public class Test {
    public static Whatsapp sock;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        sock = Whatsapp.webBuilder()
                .newConnection("bocki4_jbeta")
                .historySetting(WebHistorySetting.discard(false))
                .unregistered(QrHandler.toTerminal())
                .addNewMessageListener(Test::handleNode)
                .connect().join();
        new Thread(() -> sock.awaitDisconnection()).start();
        System.out.println("Connected to Whatsapp");
    }

    public static void handleNode(MessageInfo test){
        System.out.println(test);
    }
}
