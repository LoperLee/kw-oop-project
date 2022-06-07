package history.impl;

import java.util.ArrayList;
import java.util.List;

import history.History;

public class HistoryImpl implements History {
    // 계산의 로그를 저장할 리스트
    private final List<String> history;

    // 리스트 초기화를 생성자에서 함
    public HistoryImpl() {
        this.history = new ArrayList<>();
    }

    @Override
    public void addHistory(String command) {
        // TODO Auto-generated method stub
        // 전달받은 line을 리스트에 저장!
        history.add(command);
    }

    @Override
    public void printHistory() {
        // TODO Auto-generated method stub
        // 가지고있는 모든 List를 처음부터 출력 오래된->최신 순으로!
        for (String his : this.history) {
            System.out.println(his);
        }
    }

}
