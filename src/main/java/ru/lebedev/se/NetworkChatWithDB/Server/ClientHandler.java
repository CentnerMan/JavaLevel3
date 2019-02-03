package ru.lebedev.se.NetworkChatWithDB.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler {

    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;
    Server server;
    private int counterActivity; //счетчик активности
    ArrayList<String> blackList;

    public String getNick() {
        return nick;
    }

    String nick;
    boolean blackInList; // наличие в черном списке

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.counterActivity = 0;
            this.blackList = new ArrayList<>();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    if (!server.isNickBusy(newNick)) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        blackList = AuthService.getBlackList(nick);
                                        break;
                                    } else {
                                        sendMsg("Учетная запись уже используется!");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        /* Запуск счетчика активности */
                        counterActivity();

                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverClosed");
                                }
                                if (str.equals("/bl")) {
                                    sendMsg("В вашем черном списке:");
                                    for (String s : blackList) {
                                        sendMsg(s);
                                    }
                                    sendMsg("-------------------");
                                }
                                if (str.startsWith("/w ")) {
                                    counterActivity = 0;
                                    String[] tokens = str.split(" ", 3);
                                    server.sendPersonalMsg(ClientHandler.this, tokens[1], tokens[2]);
                                }
                                if (str.startsWith("/blacklist ")) {
                                    counterActivity = 0;
                                    String[] tokens = str.split(" ");
                                    String blackCandidate = tokens[1];
                                    for (int i = 0; i < blackList.size(); i++) { // проверяем наличие в списке
                                        if (blackList.get(i).equals(blackCandidate)) {
                                            blackInList = true;
                                            break;
                                        } else blackInList = false;
                                    }
                                    if (!blackInList) {
                                        blackList.add(blackCandidate); // добавляем в локальный список
                                        AuthService.addToBlackList(nick, blackCandidate); // добавляем в бд
                                        sendMsg("Вы добавили пользователя " + blackCandidate + " в черный список");
                                    } else sendMsg("" + blackCandidate + " уже есть в черном списке");
                                }
                            } else {
                                counterActivity = 0;
                                server.broadcastMsg(ClientHandler.this, nick + ": " + str);
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void counterActivity() {
        Thread activity = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000); // 1 минута = 60000 мс - 10 секунд
                    ++counterActivity;
                    if (counterActivity > 12) { // 6 - 1 мин, если больше 2 мин, то выкидываем из чата
                        sendMsg("Отключение из-за неактивности в чате");
                        Thread.sleep(1000);
                        out.writeUTF("/serverClosed");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        activity.start();
    }
}
