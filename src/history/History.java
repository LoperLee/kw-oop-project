package history;

// 계산기의 히스토리를 저장하는 인터페이스
public interface History {
    // 계산기 동작의 내역을 저장하는 메소드
    void addHistory(String command);

    // 지금까지 계산된 동작을 나타내는 메소드
    void printHistory();
    
}
