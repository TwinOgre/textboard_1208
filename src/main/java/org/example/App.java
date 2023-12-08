package org.example;

import org.example.system.SystemController;
import org.example.wiseSaying.WiseSaying;
import org.example.wiseSaying.WiseSayingController;

public class App {
    WiseSayingController wiseSayingController;

    public App() {
        wiseSayingController = new WiseSayingController();
    }

    void run() {
        System.out.println("== 명언 앱== ");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            if (command.equals("종료")) {
                SystemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.create();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.equals("삭제")) {
                wiseSayingController.delete();
            } else if (command.equals("수정")) {
                wiseSayingController.modify();
            }
        }


    }
}
