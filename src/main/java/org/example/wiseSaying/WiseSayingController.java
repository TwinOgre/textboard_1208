package org.example.wiseSaying;

import org.example.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WiseSayingController {
    int lastId = 1;
    List<WiseSaying> wiseSayingList = new ArrayList<>();

    public void create() {
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine();

        WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
        wiseSayingList.add(wiseSaying);
        System.out.println(lastId + "번 명언이 등록되었습니다.");
        lastId++;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언\n" + "----------------------");

        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void delete() {
        System.out.println("삭제할 명언 번호를 입력해주세요");
        int deleteId = Integer.parseInt(Container.getSc().nextLine().trim());


        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == deleteId) {
                wiseSayingList.remove(wiseSayingList.get(i));
                System.out.println(deleteId + "번 명언이 삭제되었습니다.");
            }
        }
        if (deleteId > wiseSayingList.size()) {
            System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
        }
    }

    public void modify() {
        System.out.println("수정할 명언 번호를 입력해주세요");
        int modifyId = Integer.parseInt(Container.getSc().nextLine().trim());


        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == modifyId) {
                System.out.println("기존 명언 : " + wiseSayingList.get(i).getContent());
                String modifyContent = Container.getSc().nextLine().trim();
                System.out.println("기존 작가 : " + wiseSayingList.get(i).getAuthor());
                String modifyAuthor = Container.getSc().nextLine().trim();

                wiseSayingList.get(i).setContent(modifyContent);
                wiseSayingList.get(i).setAuthor(modifyAuthor);

                System.out.println(modifyId + "번 명언이 수정되었습니다.");
            }
        }
        if (modifyId > wiseSayingList.size()) {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
        }
    }
}
